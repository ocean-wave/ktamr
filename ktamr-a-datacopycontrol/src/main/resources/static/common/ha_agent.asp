<%
' 目的:	使用com接口,和后台实际执行抄表任务的服务联系,以在client端
'		完成实际的抄表任务
'
' 方式:	提供一个HA_COM组件的VBScript封装类
'		所有函数接口以HA_为前缀
'
' 功能:
'	会话控制:
'		HA_Init(url)	' 连接服务
'		HA_Down()		' 断开连接
'
'	命令执行及记录集操作:
'		HA_Exec(cmd)	' 发送并执行命令,返回0为正确
'		HA_Fields()		' 取结果集中的字段数目
'		HA_Count()		' 取结果集记录数
'		HA_GetField(i)	' 取第i个字段的值,是0~255的整数值
'		HA_MoveNext		' 移到下一记录
'		HA_Eof			' 判断是否达到记录集的末尾
'
'	辅助计算(!!通用函数,可不在会话中使用!!):
'		HA_add_meter_conf(old_conf, meter_id)	'计算返回old_conf中加入meter_id的配置字
'		HA_del_meter_conf(old_conf, meter_id)	'计算返回old_conf中减少meter_id的配置字
'		HA_get_conf(conf)	'返回配置字对应的字符串,格式为z1,z2,z3,z4
'
'	应用功能:
'	  '集中器命令
'		' 读集中器(T)的时间(centortime)、版本(ver)、月冻结时间(freezetime)命令
'		  HA_Centor_State(T, centortime, ver, freezetime)
'
'		' 校准集中器(T)时间命令(用系统当前时间)
'		  HA_Centor_SetTime(T)
'
'		' 置固定月抄表时间(时间格式: dd hh:mm)
'		  HA_Centor_SetFreezeTime(T, freezetime)
'
'		' 刷新抄表数据命令
'		  HA_Centor_Refresh(T)
'
'	  ' 采集器命令
'		' 修改配置字
'		  HA_Collector_SetConf(X, conf)
'
'		' 减配置(meter_id是表的偏移地址)
'		  HA_Collector_DelMeter(X, oldconf, meter_id)
'
'		' 增配置(meter_id是表的偏移地址)
'		  HA_Collector_AddMeter(X, oldconf, meter_id)
'
'	  '抄表命令(可以是针对T,X,Y)
'		' 读抄表数据命令(瞬时)
'		  HA_Record(addr)
'
'		' 读抄表数据集中的当前抄表记录(地址,状态,度数)
'		  GetMeterState(addr, state, meter_number)
'
'		' 拉闸
'		  HA_TurnOff(meter_addr)
'
'		' 合闸
'		  HA_TurnOn(meter_addr)
'
' 使用例子
'
'	读集中器状态
'		Dim h, T, c, ver, freezetime
'		T = 1
'		Set h = New ha_agent
'		n = h.HA_Init("!:2499")
'		n = h.HA_Centor_State(T, c, ver, freezetime)
'		Response.Write "当前时间：" & c
'		h.Down
'		Set h = Nothing
'
'	抄表
'		Dim h
'
'		Dim a, s, m
'		Set h = New ha_agent
'		n = h.HA_Init("!:2499")
'		a = "1,0"
'		h.HA_Record (a)
'
'		While Not h.HA_Eof
'			n = h.GetMeterState(a, s, m)
'			WScript.Echo a & ": " & CStr(s) & ", " & CStr(m)
'			h.HA_MoveNext
'		Wend
'		
'		h.HA_Down
'		Set h = Nothing
'
'	置固定月抄表时间
'		freezetime = "02 03:30"
'		h.HA_Centor_SetFreezeTime(1, freezetime)
'


Class ha_agent

public m_com
public m_bInitialized

Private Sub Class_Initialize()
	Set m_com = CreateObject("HA_COM.clientagent")
	m_bInitialized = False
End Sub

Private Sub Class_Terminate()
	Set m_com = Nothing
End Sub

Public Function HA_Init(url)
	HA_Init = m_com.ha_init(url)
End Function

Public Sub HA_Down()
	m_com.ha_down
End Sub

Public Function HA_Exec(byval cmd)
	HA_Exec = m_com.ha_exec(cmd)
End Function

Public Function HA_Fields()
	HA_fields = m_com.ha_fields
End Function

Public Function HA_Count()
	HA_Count = m_com.ha_count
End Function

Public Function HA_GetField(byval i)
	HA_getfield = m_com.ha_getfield(i)
End Function

Public Function HA_Eof()
	HA_Eof = (m_com.ha_eof() <> 0)
End Function

Public Sub HA_MoveNext()
	m_com.ha_movenext
End Sub

Public Function HA_add_meter_conf(old_conf, meter_id)
	HA_add_meter_conf = m_com.ha_add_meter_conf(old_conf, meter_id)
End Function

Public Function HA_del_meter_conf(old_conf, meter_id)
	HA_del_meter_conf = m_com.ha_del_meter_conf(old_conf, meter_id)
End Function

Public Function HA_get_conf(conf)
	c = CLng(conf)
	HA_get_conf = m_com.ha_get_confstring(c)
End Function

' 读集中器时间、版本、月冻结时间命令
Public Function HA_Centor_State(byval T, byref centortime, byref ver, byref freezetime)
	r = HA_Exec("3:" & CStr(T) & ",0,0;")

	If r = 0 Then
		ha_year = 2000 + ha_getfield(4)
		ha_month = m_com.ha_getfield(5)
		ha_day   = m_com.ha_getfield(6)
		ha_hour  = m_com.ha_getfield(7)
		ha_min   = m_com.ha_getfield(8)
		ha_second= m_com.ha_getfield(9)

		centortime = CStr(ha_year) & "-" & CStr(ha_month) & "-" & CStr(ha_day) & " " &_
					 CStr(ha_hour) & ":" & CStr(ha_min) & ":" & CStr(ha_second)

		ver = CStr(ha_getfield(10)) & "." & CStr(ha_getfield(11))

		ha_freeze_day = m_com.ha_getfield(12)
		ha_freeze_hour= m_com.ha_getfield(13)
		ha_freeze_min = ha_getfield(14)
		freezetime = Right("00" & CStr(ha_freeze_day), 2) & " " & Right("00" & CStr(ha_freeze_hour), 2) & ":" & Right("00" & CStr(ha_freeze_min), 2)
	End If
	HA_Centor_State = r
End Function

' 设置集中器时间
Public Function HA_Centor_SetTime(T)
	d = Now
	ha_year = Year(d) - 2000
	ha_month= Month(d)
	ha_day  = Day(d)
	ha_hour = Hour(d)
	ha_min  = Minute(d)
	ha_sec  = Second(d)

	'2:1,0,0;3,7,12,16,10,20
	cmd = "2:" & CStr(T) & ",0,0;" & CStr(ha_year) & "," & CStr(ha_month) & "," & CStr(ha_day) & "," & CStr(ha_hour) & "," & CStr(ha_min) & "," & CStr(ha_sec)

	r = HA_Exec(cmd)

	If r = 0 Then
		HA_Centor_SetTime = CStr(d)
	Else
		HA_Centor_SetTime = "error"
	End If
End Function

' 置固定月抄表时间(时间格式: dd hh:mm)
Public Function HA_Centor_SetFreezeTime(T, freezetime)
	cmd = "14:" & CStr(T) & ",0;" & Left(freezetime, 2) & "," & Mid(freezetime, 4, 2) & "," & Right(freezetime, 2)
	r = HA_Exec(cmd)

	HA_Centor_SetFreezeTime = r
End Function

' 刷新抄表数据命令
Public Function HA_Centor_Refresh(addr)
	cmd = "8:" & CStr(addr) & ",0;"
	r = HA_Exec(cmd)

	HA_Centor_Refresh = r
End Function

' 修改配置字
Public Function HA_Collector_SetConf(Xaddr, conf)
	confstr = HA_get_conf(conf)

	cmd = "4:" & CStr(Xaddr) & ",0;" & confstr
	r = HA_Exec(cmd)

	HA_Collector_SetConf = r
End Function

' 减配置(meter_id是表的偏移地址)
Public Function HA_Collector_DelMeter(X, oldconf, meter_id)
	conf = HA_del_meter_conf(oldconf, meter_id)
	HA_Collector_DelMeter = HA_Collector_SetConf(X, conf)
End Function

' 增配置(meter_id是表的偏移地址)
Public Function HA_Collector_AddMeter(X, oldconf, meter_id)
	conf = HA_add_meter_conf(oldconf, meter_id)
	HA_Collector_AddMeter = HA_Collector_SetConf(X, conf)
End Function

' 读抄表数据命令(瞬时)
Public Function HA_Record(addr)
	cmd = "9:" & CStr(addr) & ";0"
	r = HA_Exec(cmd)

	HA_Record = r
End Function

Public Function GetMeterState(byref addr, byref state, byref meter_number)
    n = InStr(addr, ",")
    If n < 2 Then
        T = addr
    Else
        T = Left(addr, n - 1)
    End If

	If HA_Eof() Then
		GetMeterState = -1
		Exit Function
	End If
	addr_x = m_com.ha_getfield(0)
	addr_y = m_com.ha_getfield(1)
	addr   = CStr(T) & "," & CStr(addr_x) & "," & CStr(addr_y)
	state  = m_com.ha_getfield(2)
	p      = (m_com.ha_getfield(3) * 256 + ha_getfield(4)) + ha_getfield(5) / 100
	If state > 128 Then
		p = p + 50000
	End If
	meter_number = p

	GetMeterState = 0
End Function

Public Function HA_TurnOn(meter_addr)
	s = Left(meter_addr, 1)
	If Len(s) > 0 And s >= "0" And s <= "9" Then
		cmd = "19:" & meter_addr & ";"
		r = HA_Exec(cmd)
	Else
		r = 0
	End If

	HA_TurnOn = r
End Function

Public Function HA_TurnOff(meter_addr)
	s = Left(meter_addr, 1)
	If Len(s) > 0 And s >= "0" And s <= "9" Then
		cmd = "20:" & meter_addr & ";"
		r = HA_Exec(cmd)
	Else
		r = 0
	End If

	HA_TurnOff = r
End Function

End Class
%>