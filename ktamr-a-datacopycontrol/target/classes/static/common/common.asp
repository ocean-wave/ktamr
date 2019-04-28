<%
'取得项目的子项目数，需要先建立有connection对象
'参数说明：id为项目id，tablename为需要查询的数据表名字
function childcount(id,tablename)
	Dim rs, strQ
	Set rs = Server.CreateObject("ADODB.Recordset")
	Set rs.ActiveConnection = conn
	strQ = "select id from " & tablename & " where upid=" & id
	rs.Open strQ, conn
	If rs.BOF or rs.EOF then
		childcount = 0
	else
		count = 0
		while not rs.eof
			count = count+1
			rs.movenext
		wend
		childcount = count
	end if
	rs.close
End function


'将0、1数字转换成空白或线条图片
function changeIndent(indent)
	dim s, i, m, webRoot
	webRoot = Application("webRoot")
	for i = 1 to len(indent)
		m = mid(indent,i,1)
		if cint(m) = 0 then
			s = s & "<td><img src=" & webRoot & "images/spacer.gif></td>"
		else
			s = s & "<td><img src=" & webRoot & "images/line1.gif></td>"
		end if
	next
	changeIndent = s
end function

'根据id取得名字
'参数说明：id为项目id，tablename为需要查询的数据表名字
function getNameByID(id,tablename)
	set conn = server.createobject("adodb.connection")
	conn.open Application("ConnectionString")

	set rs = server.createobject("adodb.recordset")
	sql = "select name from " & tablename & " where id=" & id
	rs.open sql,conn

	if rs.eof then
		getNameByID = "未知名称"
	else
		getNameByID = rs("name")
	end if
	rs.close
	set rs = nothing
	conn.close
	set conn = nothing
end function

'根据id取得上级id
'参数说明：id为项目id，tablename为需要查询的数据表名字
function getupidByID(id,tablename)
	set conn = server.createobject("adodb.connection")
	conn.open Application("ConnectionString")

	set rs = server.createobject("adodb.recordset")
	sql = "select upid from " & tablename & " where id=" & id
	rs.open sql,conn

	if rs.eof then
		getupidByID = "未知名称"
	else
		getupidByID = rs("upid")
	end if
	rs.close
	set rs = nothing
	conn.close
	set conn = nothing
end function

'根据id取得名字（不连数据库）
'参数说明：id为项目id，tablename为需要查询的数据表名字
function getname(id,tablename,nam,conn)
	Dim rsn,sql
	set rsn = server.createobject("adodb.recordset")
	sql = "select " & nam & " from " & tablename & " where id=" & id
	rsn.open sql,conn

	if rsn.eof then
		getname = "未知名称"
	else
		getname = rsn(nam)
	end if
	rsn.close
	set rsn = nothing
end function

'根据id取得上级id（不连数据库）
'参数说明：id为项目id，tablename为需要查询的数据表名字
function getupid(id,tablename,conn)
	Dim rsd,sql
	set rsd = server.createobject("adodb.recordset")
	sql = "select upid from " & tablename & " where id=" & id
	rsd.open sql,conn

	if rsd.eof then
		getupid = "未知名称"
	else
		getupid = rsd("upid")
	end if
	rsd.close
	set rsd = nothing
end function

'以导航条方式显示，数据表中需要包含id,name字段
'参数说明：id为项目id，tablename为需要查询的数据表名字
sub view_daohangtiao(id,tablename)
	set conn = server.createobject("adodb.connection")
	conn.open Application("ConnectionString")

	set rs = server.createobject("adodb.recordset")
	sql = "select id,name from " & tablename & " where upid=" & id
	rs.open sql,conn

	response.write "<table width=100% border=1 cellspacing=0 cellpadding=2 frame=void bordercolor=white style='border-collapse:collapse;background-color:#6d82d1;'>"
	response.write "<tr>"
	if rs.eof then
		response.write "<td>没有项目可以显示</td>"
	else
		response.write "<td nowrap width=50>&nbsp;</td>"
		while not rs.eof
			response.write "<td align=center nowrap width=100>"
			response.write "<a href=index.asp?item=" & rs("id") & ">" & rs("name") & "</a>"
			response.write "</td>"
			rs.movenext
		wend
		response.write "<td>&nbsp;</td>"
	end if
	response.write "</tr>"
	response.write "</table>"
	rs.close
	set rs = nothing
	conn.close
	set conn = nothing
end sub

'以新闻列表方式显示，数据表需要包含id,name,subdate
'参数说明：id为父id，max为列表显示的项目数，tablename为需要查询的数据表名字，url为点击后执行的程序
sub view_news(id,max,tablename,url)
	set conn = server.createobject("adodb.connection")
	conn.open Application("ConnectionString")

	set rs = server.createobject("adodb.recordset")
	sql = "select * from " & tablename & " where upid=" & id
	rs.open sql,conn

	response.write "<table border=1 width=100% cellspacing=0 cellpadding=2 frame=void bordercolor=white style='border-collapse:collapse;background-color:#F2F4FB;'>"
	if rs.eof then
		response.write "<tr>"
		response.write "<td>没有项目可以显示</td>"
		response.write "</tr>"
	else
		a = 0
		while (not rs.eof) and a < max
			response.write "<tr>"
			response.write "<td nowrap><span class=F7> ● </span>"
			response.write "<a href=" & url & "?id=" & rs("id") & " target=_blank>" & rs("name") & "</a>"
			subdate = rs("subdate")
			if cdate(year(subdate) & "-" & month(subdate) & "-" & day(subdate)) = date then
				response.write " <img src=" & Application("webRoot") & "images/new.gif>"
			end if
			response.write "</td>"
			response.write "</tr>"
			rs.movenext
			a = a + 1
		wend
		if not rs.eof then
			response.write "<tr>"
			response.write "<td nowrap align=right>"
			response.write "<a href=" & url & "?upid=" & id & ">更多&gt;&gt;</a>"
			response.write "</td>"
			response.write "</tr>"
		end if
		a = 0
	end if
	response.write "</table>"
	rs.close
	set rs = nothing
	conn.close
	set conn = nothing
end sub

'上级类别显示
'参数说明：id为父id，max为列表显示的项目数，tablename为需要查询的数据表名字
sub view_parentkinds(id,max,tablename,url)
	set conn = server.createobject("adodb.connection")
	conn.open Application("ConnectionString")

	set rs = server.createobject("adodb.recordset")
	sql = "select upid from " & tablename & " where id=" & id
	rs.open sql,conn

	upid = rs("upid")
	rs.close
	set rs = nothing

	set rs = server.createobject("adodb.recordset")
	sql = "select * from " & tablename & " where upid=" & upid
	rs.open sql,conn

	if rs.eof then
		response.write "没有项目可以显示"
	else
		a = 0
		while (not rs.eof) and a < max
			if a > 0 then response.write "<br>"
			response.write "<a href=" & url & "?upid=" & rs("id") & " target=_blank class=a14>" & rs("name") & "</a>"
			rs.movenext
			a = a + 1
		wend
		if not rs.eof then
			response.write "<br><div align=right><a href=" & url & "?upid=" & upid & " class=a14>更多&gt;&gt;</a></div>"
		end if
		a = 0
	end if
	rs.close
	set rs = nothing
	conn.close
	set conn = nothing
end sub

'函数名称：取得recordset对象
'参数说明：sqlstr（参数为SQL字串）、paras（参数名字串）、requests（request对象）
function getRecordset(sqlstr, paras, conn)
	Dim cmd
    Set cmd = Server.CreateObject("ADODB.Command")
    Set cmd.ActiveConnection = conn
	conn.commandTimeout = 600
    cmd.CommandText = sqlstr
	'response.write paras:Response.end
	Dim parmName
	if not isNull(paras) then
		paraArray = split(paras,",",-1)
		for i = 0 to ubound(paraArray)
			' get parameter value from request
			parmName = paraArray(i)
			If request.querystring(parmName).count > 0 Then
				'paraArray(i) = request(parmName)
				paraArray(i) = request.querystring(parmName)
				'response.write paraArray(i) & "=" & request(parmName)
			ElseIf parmName = "date" Then
				paraArray(i) = Cstr(date())
			ElseIf parmName = "now" Then
				paraArray(i) = Cstr(now)
			ElseIf left(parmName,7) = "SESSION" Then
				sessionName = right(parmName,len(parmName)-7)
				paraArray(i) = Session(sessionName)
				' response.write sessionName & " = " & paraArray(i) & "<br>"
				If sessionName = "userid" Then
					paraArray(i) = "M" & paraArray(i)
				End If
			Else
				paraArray(i) = ""
			End If
			
			Dim l
			If vartype(paraArray(i)) = 8 Then
				l = stringLen(paraArray(i))
			Else
				l = Len(paraArray(i))
			End If
			Set p  = cmd.CreateParameter(, vartype(paraArray(i)), 1, l, paraArray(i))
			cmd.Parameters.Append p
		next
	end if
	'response.write  cmd.CommandText:response.end
	Set getRecordset = cmd.Execute
end function

function getSubRecord(sqlstr, paras)
	Dim conn
    Set conn = Server.CreateObject("ADODB.Connection")
    conn.Open Application("ConnectionString")

	getSubRecord = getRecordset(sqlstr, paras, conn)
end function

function getrscount(rs)
	count = 0
	while not rs.eof
		count = count+1
		rs.movenext
	wend
	rs.movefirst
	getrscount = count
end function

Function stringLen(s)
	Dim l, ls, i
	l0 = 0
	ls = len(s)
	for i = 1 to len(s)
		if asc(mid(s,i,1)) < 0 then
			l = l + 2
		else
			l = l + 1
		end if
	next
	stringLen = l
End Function

' (全局)
' 在相关数据集合中查找name的值
' 如果没有查到,返回空值 +
Function getRelevantValue(rvs, name)
	Dim i, data
	i = rvs.FindByID(name)
	If i >= 0 Then
		Set data = rvs(i)
		getRelevantValue = data("value")
		Set data = Nothing
		Exit Function
	End If
	getRelevantValue = ""
End Function

'转换时间，接受格式：[n天n小时n分钟]
Function changeTime(strTime)
	Dim a, b, lens, intDay, intHour, intMinute
	lens = Len(strTime)
	
	a = Instr(strTime, "天")
	if a > 0 Then
		intDay = kp2(Left(strTime, a-1))
		strTime = right(strTime, lens-a)
		lens = Len(strTime)
	Else
		intDay = "00"
	End If

	a = Instr(strTime, "小时")
	if a > 0 Then
		intHour = kp2(Left(strTime, a-1))
		strTime = right(strTime, lens-a-1)
	Else
		intHour = "00"
	End If

	a = Instr(strTime, "分钟")
	if a > 0 Then
		intMinute = kp2(Left(strTime, a-1))
	Else
		intMinute = "00"
	End If

	changeTime = "0000-00-" & intDay & " " & intHour & ":" & intMinute & ":00"
End Function

'group显示
Function viewGroup(name, old_name)
	If cstr(name) <> cstr(old_name) Then
		viewGroup = Cstr(name)
		old_name = Cstr(name)
	Else
		viewGroup = "&nbsp;"
	End If
End Function

'时间格式转换
Function dateConvert(d)
	Dim aryTime
	aryTime = Split(d, "-")
	if Len(aryTime(1)) = 1 Then aryTime(1) = "0" & aryTime(1)
	if Len(aryTime(2)) = 1 Then aryTime(2) = "0" & aryTime(2)
	dateConvert = aryTime(0) & "-" & aryTime(1) & "-" & aryTime(2)
End Function

'从工单号中取得年月字符串
Function getYearMonth(itemid, strYear, strMonth)
	Dim a

	If itemid <> "" Then
		a = Instr(itemid, "-")
		strYear = Mid(itemid, a+1, 4)
		strMonth = Mid(itemid, a+5, 2)
		getYearMonth = true
	Else
		getYearMonth = false
	End If
End Function

'替换特殊字符
Function repsw(filename)
	Dim s
	s = filename
	s = Replace(s, "#", "%23")
	's = Replace(s, "%", "%25")
	s = Replace(s, "&", "%26")
	s = Replace(s, "+", "%2B")
	s = Replace(s, "=", "%3D")
	s = Replace(s, "'", "%27")
	's = Replace(s, " ", "%20")
	repsw = s
End Function

'创建目录，返回值可显示创建成功或目录存在
Function createDir(path)
	Dim FSO
	Set FSO = Server.CreateObject("Scripting.FileSystemObject") 
	If FSO.FolderExists(path) = false then
		FSO.CreateFolder(path)
		createDir = "ok"
	Else
		createDir = "exists"
	End If
	Set FSO = Nothing
End Function

Function k2(num)
	if num < 1 Then
		k2 = "0" & cstr(num)
	Else
		k2 = Cstr(num)
	End If
End Function

'生成LC列表
'参数：listname:列表定义, itemid:工单编号, proDisp:显示
Sub genLC(listname, projectID, addlink, disp, dbconn)
	Dim s, rs, sqlstr, paras, sqlparas, conn, r

	Response.Write "<SCRIPT LANGUAGE=JavaScript>showhidecontent11('" & listname & "','" & listname & "','','','" & disp & "');</SCRIPT>"

	s = "SELECT sqlstr, paras, sqlparas FROM mw_lc_list_def WHERE name = '" & listname & "'"
	Set rs = dbconn.OpenSQL(s)

	If Not rs.Eof Then
		sqlstr = rs(0)
		paras = rs(1)
		sqlparas = rs(2)

		Set conn = Server.CreateObject("ADODB.Connection")
		conn.Open Application("ConnectionString")
		Session("projectID") = projectID
		'Session("instid") = instid
		Set r = getRecordset(sqlstr, paras, conn)
		Session("projectID") = ""
		'Session("instid") = ""

		Call genGrid(r, sqlparas)

		Response.write addlink
	Else
		Response.write "未定义LC类别[<font color=red>" & listname & "</font>]!"
	End If

	rs.close
	Set rs = nothing

	Response.Write "<SCRIPT LANGUAGE=JavaScript>showhidecontent2();</SCRIPT><br>"
End Sub

Sub genForm(titlename, formid, itemid, disp, dbconn)
	Dim m_form,i
	Set m_form = New mw_form
	m_form.setDBConnection dbconn.m_c

	i = m_form.init(formid, itemid)
	If i <> 0 Then
		Exit Sub
	End If	
	Response.Write "<tr><td>"
	Response.Write "<SCRIPT LANGUAGE=JavaScript>showhidecontent11('itemContent" & formid & "','"&titlename&"内容','','','" & disp & "');</SCRIPT>"
	m_form.show 
	Response.Write "<SCRIPT LANGUAGE=JavaScript>showhidecontent2();</SCRIPT><br>"
	Response.Write"</td> </tr> <tr> <td height='4'></td> </tr>"
End Sub

'根据表单编号取得表单名称
Function getItemName(formid,dbconn)
	Set r = dbconn.OpenSQL("SELECT name FROM mw_formdef WHERE formid='" & CStr(formid) & "'")
	If r.eof Then
		getItemName = -1
	Else
		getItemName = r(0)
	End If
	r.close
	Set r = Nothing
End Function

'根据表单名称取得表单编号
Function getFormID(itemName,dbconn)
	Set r = dbconn.OpenSQL("SELECT formid FROM mw_formdef WHERE name='" & itemName & "'")
	If r.eof Then
		getFormID = -1
	Else
		getFormID = r(0)
	End If
	r.close
	Set r = Nothing
End Function

Function strFormat(str, ilen)
	If Len(str) > ilen Then
		strFormat = Left(str, ilen) & "..."
	Else
		strFormat = str
	End If
End Function

Function urlFormat(url, ilen)
	Dim sname, head, urlHead, urlTail, tempstr, i, t
	i = 0
	t = 0

	Trim(url)
	If Left(url, 2) <> "<a" Then
		i = InStr(url, "<a")
		If i > 0 Then
			head = Left(url, i)
			tempstr = Mid(url, i+1)
			i = InStr(tempstr, ">")
			t = InStr(tempstr, "</a>")
			If i > 0 And t > 0 And t > i Then
				urlHead = Left(tempstr, i)
				sname = Mid(tempstr, i+1, t-i-1)
				urlTail = Mid(tempstr, t)
				'response.write "i="&i&";name=" & sname
			Else
				urlFormat = url
				Exit Function
			End If
		Else
			urlFormat = url
			Exit Function
		End If
	Else
		head = ""
		i = InStr(url, ">")
		t = InStr(url, "</a>")
		If i > 0 And t > 0 And t > i Then
			urlHead = Left(url, i)
			sname = Mid(url, i+1, t-i-1)
			urlTail = Mid(url, t)
			'response.write "i="&i&";name=" & sname
		Else
			urlFormat = url
			Exit Function
		End If		
	End If
	
	urlFormat = head & urlHead & strFormat(sname, ilen) & urlTail
End Function

Function FTCurrency(iValue)
	Dim retValue

	retValue = iValue 
	If IsNull(retValue) Or retValue = "" Then
		retValue = 0.00
	End If
	FTCurrency = FormatCurrency(retValue)
End Function

'取得级联菜单数据
function getListStr(s, c)
	Dim oldppid, oldupid, first1, first2, first3, id, name, upid, ppid, namval, str,strary,strsubary,strsubary1,strsubary2,strsubary3,strsubary4
	oldppid = "" : oldupid = "" : first1 = true : first2 = true : first3 = true : str = ""
	If instr(s,"select")>0 or instr(s,"SELECT")>0 THEN
		Set r = dbconn.OpenSQL(s)
		While Not r.Eof
			id = Cstr(r(0)) : name = r(1) : upid = Cstr(r(2)) : ppid = Cstr(r(3))
			namval = name & "^" & name & "(" & id & ")"

			If upid = 0 Then
				If first1 Then
					str = "请选择...^!2!" & namval
					first1 = false
				Else
					str = str & "!2!" & namval
				End If
			ElseIf ppid = 0 Then
				If first2 Then
					str = str & "!1!!2!请选择...^!3!" & namval
					first2 = false
				Else
					If oldupid <> upid Then
						str = str & "!2!请选择...^!3!" & namval
					Else
						str = str & "!3!" & namval
					End If
				End If
			Else
				If first3 Then
					str = str & "!1!!2!!3!请选择...^!4!" & namval
					first3 = false
				Else
					If oldppid <> ppid then
						str = str & "!2!!3!请选择...^!4!" & namval
					Else
						If oldupid <> upid then
							str = str & "!3!请选择...^!4!" & namval
						Else
							str = str & "!4!" & namval
						End If
					End If
				End If

			End If

			oldppid = ppid : oldupid = upid
			r.moveNext
		Wend
	Else
		strary=split(s,"|")
		If ubound(strary)<2 and ubound(strary)>0 Then
				strsubary=split(strary(0),",")
				strsubary1=split(strary(1),";")
				
				For I=0 TO Ubound(strsubary)
					namval=strsubary(i) & "^" & strsubary(i) & "(" & strsubary(i) & ")"
						If first1 Then
							str = "请选择...^!2!" & namval
							first1 = false
						Else
							str = str & "!2!" & namval
						End If
				Next
				For I=0 TO Ubound(strsubary1)
					strsubary3=split(strsubary1(i),",")
					For J=0 To Ubound(strsubary3)
						namval=strsubary3(j) & "^" & strsubary3(j) & "(" & strsubary3(j) & ")"
						If first2 Then
							str = str & "!1!!2!请选择...^!3!" & namval
							first2 = false
						Else
								If J=0 Then
									str = str & "!2!请选择...^!3!" & namval
								Else
									str = str & "!3!" & namval
								End If
						End If
					NEXT
				Next
		End If
	
End If
	getListStr = str
End Function
'日期转中文
Function date_w(myDate)
    Dim eDate
    Dim intY, intM, intD 
    Dim intD2 
    Dim I 
	myDate=cdate(myDate)
    intY = Year(myDate)
    intM = Month(myDate)
    intD = Day(myDate)

    For I = 1 To Len(intY)
        eDate = eDate & number_w(Mid(intY, I, 1))
    Next
    eDate = eDate & "年"

    eDate = eDate & number_w(intM)
    eDate = eDate & "月"

    Select Case intD
    Case 1,2,3,4,5,6,7,8, 9, 10, 20, 30
        eDate = eDate & number_w(intD)
    Case 11,12,13,14,15,16,17,18,19
        eDate = eDate & number_w(10) & number_w(Mid(intD, 2, 1))
    Case 21,22,23,24,25,26,27,28,29
        eDate = eDate & number_w(20) & number_w(Mid(intD, 2, 1))
    Case 31
        eDate = eDate & number_w(30) & number_w(1)
    End Select
    eDate = eDate & "日"

    date_w = eDate
End Function
Function number_w(I)
    Select Case I
    Case 0
        number_w = "〇"
    Case 1
        number_w = "一"
    Case 2
        number_w = "二"
    Case 3
        number_w = "三"
    Case 4
        number_w = "四"
    Case 5
        number_w = "五"
    Case 6
        number_w = "六"
    Case 7
        number_w = "七"
    Case 8
        number_w = "八"
    Case 9
        number_w = "九"
    Case 10
        number_w = "十"
    Case 11
        number_w = "十一"
    Case 12
        number_w = "十二"
    Case 20
        number_w = "二十"
    Case 30
        number_w = "三十"
    End Select
End Function
'不简化
Function changeMoney(thenumber)
	Dim one(),onestr()'定义数组
	Dim String1, String2, checkp
	Dim l, i

	String1 = "零壹贰叁肆伍陆柒捌玖"
	String2 = "万仟佰拾亿仟佰拾万仟佰拾元角分厘毫"

	checkp=instr(thenumber,".")'判断是否含有小数位
	If checkp<>0 Then
		thenumber=replace(thenumber,".","")'去除小数位
	End If

	l=len(thenumber) '取得数据长度
	Redim one(l-1)'重新定义数组大小
	Redim onestr(l-1)'重新定义数组大小

	For i=0 To l-1 
		one(i)=mid(thenumber,i+1,1) '循环取得每一位的数字
		one(i)=mid(string1,one(i)+1,1)'循环取得数字对应的大写   
        If checkp=0 Then  '不含有小数的数据其数字对应的单位
           onestr(i)=mid(string2,14-l+i,1) 
        Else   '含有小数的数据其数字对应的单位
           onestr(i)=mid(string2,15-l+i+len(thenumber)-checkp,1)
        End If
  
		one(i)=one(i)&onestr(i)'将数字与单位组合
	Next

    Money=replace(join(one)," ","") '取得数组中所有的元素，并连接起来
    Money=replace(Money,"零元","元") 
    Money=replace(Money,"零万","万") 
	Money=replace(Money,"零亿","亿")
	Money=replace(Money,"零仟","零")
    Money=replace(Money,"零佰","零") 
    Money=replace(Money,"零拾","零")

	Do While Not instr(Money,"零零")=0 
		Money=replace(Money,"零零","零")
	Loop
	'Money=replace(Money,"零元","元") 
	If Money="元" Then
		Money="零元"
	Else
		Money=Money&"整"
	End If 
	changeMoney=Money
End Function

Function Getorgname(personid,con)
	Dim sql, orgname, rs

	sql = "SELECT DISTINCT CASE WHEN a.typeid='T0000000075' THEN a.orgname WHEN a.typeid='T0000000076' THEN (SELECT orgname FROM ta_organization WHERE orgid=a.uporgid) ELSE '' END orgname FROM ta_organization a WHERE a.orgid IN (SELECT orgid FROM ta_person_roles WHERE personid='" & personid & "')"	
	Set rs = Server.CreateObject("ADODB.RecordSet")
	rs.Open sql, con
	If Not rs.eof Then 
		orgname=rs("orgname")
	Else
		orgname = ""		
	End If 
	rs.close
	Getorgname=orgname
End Function

Function changeMoney(thenumber)
	Dim one(),onestr()'定义数组
	Dim String1, String2, checkp
	Dim l, i

	String1 = "零壹贰叁肆伍陆柒捌玖"
	String2 = "万仟佰拾亿仟佰拾万仟佰拾元角分厘毫"

	checkp=instr(thenumber,".")'判断是否含有小数位
	If checkp<>0 Then
		thenumber=replace(thenumber,".","")'去除小数位
	End If

	l=len(thenumber) '取得数据长度
	Redim one(l-1)'重新定义数组大小
	Redim onestr(l-1)'重新定义数组大小

	For i=0 To l-1 
		one(i)=mid(thenumber,i+1,1) '循环取得每一位的数字
		one(i)=mid(string1,one(i)+1,1)'循环取得数字对应的大写   
        If checkp=0 Then  '不含有小数的数据其数字对应的单位
           onestr(i)=mid(string2,14-l+i,1) 
        Else   '含有小数的数据其数字对应的单位
           onestr(i)=mid(string2,15-l+i+len(thenumber)-checkp,1)
        End If
  
		one(i)=one(i)&onestr(i)'将数字与单位组合
	Next

    Money=replace(join(one)," ","") '取得数组中所有的元素，并连接起来
    'Money=replace(Money,"零元","元") 
   ' Money=replace(Money,"零万","万") 
	'Money=replace(Money,"零亿","亿")
	'Money=replace(Money,"零仟","零")
    'Money=replace(Money,"零佰","零") 
    'Money=replace(Money,"零拾","零")

	Do While Not instr(Money,"零零")=0 
		Money=replace(Money,"零零","零")
	Loop
	Money=replace(Money,"零元","元") 
	If Money="元" Then
		Money="零元"
	Else
		Money=Money&"整"
	End If 
	changeMoney=Money
End Function
'实例在数据库中的位置（运行表ta_procinst或历史表ta_his_procinst）
Function tablepos(instid, itemid, dbconn)
	Dim s, rs

	If instid <> "" Then '提供实例ID查询
		s = "select count(*) from ta_procinst where procinstid='" & instid & "'"
	ElseIf itemid <> "" Then '提供工单号查询
		s = "select count(*) from ta_procinst where defname='" & itemid & "'"
	Else
		tablepos = "" : Exit Function
	End If

	Set rs = dbconn.OpenSQL(s)

	If rs(0) < 1 Then
		tablepos = "ta_his_procinst"
	Else
		tablepos = "ta_procinst"
	end If

	rs.close
	set rs = nothing
End Function

Sub GenStringOption(s, selectedValue)
	Dim items, i
	items = split(s,",",-1)
		Response.Write "<option value=''>未选择</option>"
	For i = 0 to ubound(items)
		If items(i) = selectedValue And selectedValue <> "" Then
			Response.Write "<option value='" & items(i) & "' selected>" & items(i) & "</option>" & vbcrlf
		Else
			Response.Write "<option value='" & items(i) & "' >" & items(i) & "</option>" & vbcrlf
		End If
	Next
End Sub

Sub GenCmdTypeOption(selectedValue)
	'KT300
'	GenStringOption "多表数据抄收,注册,单表抄表,单表数据抄收,读设备地址,读表具总数,搜寻表具,搜寻集采器,系统检修,刷新数据,设机电参数,设置节点ID,修改地址,增加节点,删除节点,读集采器总数,抄收全部,抄收小区,刷新全部数据,刷新小区数据,抄收GPRSDTU,刷新GPRSDTU,关阀,开阀", selectedValue
	'KT410
	GenStringOption "KT410设备资料同步,加采集器,读采集中继表,读采集器状态,采集器寻表,刷新采集器,集中器加表,采集器加表,读IP端口,设IP端口,读集中器地址,设集中器地址,读工作时段,读网络时段,读采集器列表,读表地址,集中器校时,读集中器时钟,设工作时段,设网络时段,多表数据抄收,单表数据抄收,删除表,重启集中器,初始化集中器,格式化集中器,初始化采集器", selectedValue
End Sub

Sub GenCmdStateOption(ByVAL selectedValue)
	GenStringOption "待执行,完成,失败", selectedValue
End Sub

'转换日期格式
Function formatDate(Byval t,Byval ftype) 
	dim y, m, d, h, mi, s 
	formatDate="" 
	If IsDate(t)=False Then Exit Function 
	y=cstr(year(t)) 
	m=cstr(month(t)) 
	If len(m)=1 Then m="0" & m 
	d=cstr(day(t)) 
	If len(d)=1 Then d="0" & d 
	h = cstr(hour(t)) 
	If len(h)=1 Then h="0" & h 
	mi = cstr(minute(t)) 
	If len(mi)=1 Then mi="0" & mi 
	s = cstr(second(t)) 
	If len(s)=1 Then s="0" & s 
	select case cint(ftype) 
	case 1 
	' yyyy-mm-dd 
	formatDate=y & "-" & m & "-" & d 
	case 2 
	' yy-mm-dd 
	formatDate=right(y,2) & "-" & m & "-" & d 
	case 3 
	' mm-dd 
	formatDate=m & "-" & d 
	case 4 
	' yyyy-mm-dd hh:mm:ss 
	formatDate=y & "-" & m & "-" & d & " " & h & ":" & mi & ":" & s 
	case 5 
	' hh:mm:ss 
	formatDate=h & ":" & mi & ":" & s 
	case 6 
	' yyyy年mm月dd日 
	formatDate=y & "年" & m & "月" & d & "日" 
	case 7 
	' yyyymmdd 
	formatDate=y & m & d 
	case 8 
	'yyyymmddhhmmss 
	formatDate=y & m & d & h & mi & s 
	case 9
	'yyyymm
	formatDate=y & m 
	case 10 
	' yyyy-mm 
	formatDate=y & "-" & m
	end select 
End Function



'判断系统是否支持strClassString组件
Function IsObjInstalled(strClassString)
	On Error Resume Next
	IsObjInstalled = False
	Err = 0
	Dim xTestObj
	Set xTestObj = Server.CreateObject(strClassString)
	If Err = 0 Then IsObjInstalled = True
	Set xTestObj = Nothing
	Err = 0
End Function

'功能：打开文档，并读取所有内容
'参数：addr=文件地址
'返回：文档内容字符串
Function TextStreamTest(addr)
	Dim fso, ts
	Const ForReading = 1, ForWriting = 2, ForAppending = 8
	Const TristateUseDefault = -2, TristateTrue = -1, TristateFalse = 0

	Set fso = CreateObject("Scripting.FileSystemObject")
	set ts = fso.opentextfile(addr, forreading)   
	TextStreamTest = ts.ReadAll
	ts.Close
End Function

' @取得节字符子串
' @param
'    s : 包含节的串
'    sectionName : 节名称
Public Function getSectionString(s, sectionName)
	Dim b, e, l, t
	
	b = InStr(s, "[" + sectionName + "]")

	If b <= 0 Then
		getSectionString = "" : Exit Function
	End If

	l = Len(sectionName) + 2
	e = InStr(b + l, s, vbCrLf + "[")

	If e <= 0 Then
		t = Mid(s, b + l + 2)
	Else
		t = Mid(s, b + l + 2, e - b - l - 2)
	End If

	getSectionString = Trim(t)
End Function

'解释字串为参数集合
'strPara的格式：paraname1=paravalue1;paraname2=paravalue2
Function getParas(strPara)
	Dim i, paras, para
	Set getParas = Server.CreateObject("Scripting.Dictionary")
	If IsNull(strPara) Then strPara = ""
	paras = Split(strPara, ";")
	For i = 0 To Ubound(paras)
		If Instr(paras(i), "=") > 0 Then
			para = Split(paras(i), "=")
			getParas.Add para(0), para(1)
		End If
	Next
End Function

'解释字串为参数集合2
'strPara的格式：paraname1=paravalue1 vbcrlf paraname2=paravalue2
Function getParas2(strPara)
	Dim i, paras, para
	Set getParas2 = CreateObject("Scripting.Dictionary")
	If IsNull(strPara) Then strPara = ""
	paras = Split(strPara, vbcrlf)
	For i = 0 To Ubound(paras)
		If Left(paras(i), 1)<>"#" and Instr(paras(i), "=") > 0 Then
			para = Instr(paras(i), "=")
			getParas2.Add Left(paras(i), para-1), Mid(paras(i), para+1)
		End If
	Next
End Function

'在参数集合里查找特定名称对应的参数值
Function findParaByName(paras, paraName)
	Dim i, names
	names = paras.keys
	For i = 0 To UBound(names)
		If names(i) = paraName Then
			findParaByName = paras(names(i))
			Exit Function
		End If
	Next
	findParaByName = ""
End Function

'功能：从配置文档中取得工作时间
'参数：allcontent=配置文档全部内容
'返回：时间串数组（09:00:00,12:00:00,13:30:00,17:30:00）
Function getworktimes(allcontent)
	Dim s, s1, s11, s2, s22, worktimes(3)

	s = getSectionString(allcontent, "time_day")
	s = Split(s, vbcrlf)
	s1 = Split(s(0), "=")
	s11 = Split(s1(1), "~")
	s2 = Split(s(1), "=")
	s22 = Split(s2(1), "~")

	If s1(0) = "morning" Then
		worktimes(0) = s11(0) : worktimes(1) = s11(1)
	ElseIf s1(0) = "afernoon" Then
		worktimes(2) = s11(0) : worktimes(3) = s11(1)
	End If

	If s2(0) = "morning" Then
		worktimes(0) = s22(0) : worktimes(1) = s22(1)
	ElseIf s2(0) = "afernoon" Then
		worktimes(2) = s22(0) : worktimes(3) = s22(1)
	End If

	getworktimes = worktimes
End Function

'功能：从配置文档中取得日期（法定节假日和工作日）
'参数：allcontent=配置文档全部内容，stype=日期类别（time_workday、time_freeday）
'返回：日期数组（2006-12-30~2006-12-31,2007-04-28~2007-04-29）
Function getdays(allcontent, stype)
	Dim s, s1, s11, s2, s22, days

	s = getSectionString(allcontent, stype)
	'document.all("t").value = s
	'Exit function
	s = Split(s, vbcrlf)

	For i = 0 To Ubound(s)
		s1 = Split(s(i), "=")
		days = days & "," & s1(1)
	Next

	getdays = Split(Mid(days, 2), ",")
End Function

'读取bin目录下的INI文件内容'
Function loadKTAMRini(iniFilePath)
	Dim  allcontent, s
	allcontent = TextStreamTest(iniFilePath)
	loadKTAMRini = allcontent
End Function
'在INI文件内容中按照节、键取值'
Function getKTAMRiniProperValByKey(iniProperties, section, key)
	Dim s, paras
	s = getSectionString(iniProperties, section) '获取odbc内容
	set paras = getParas2(s) '解析成字典对象
	getKTAMRiniProperValByKey = findParaByName(paras, key)		
End Function

'从数据库中取配置参数
Function getINIParms(s, k)
	Set dbcon = New DBConnect
	s = "SELECT v FROM ha_config WHERE s='"&s&"' AND k='"&k&"'"
	re = dbcon.geta(s)
	'response.write re
	getINIParms = re
End Function

'调用语言properties文件 获取对应的值'
Function loadLanguageProperties(lanFilePath)
	Dim allcontent, s
	allcontent = TextStreamTest(lanFilePath)
	loadLanguageProperties = Array(getParas2(allcontent)) '解析成字典对象
End Function

'在properties文件内容缓存里获取特定名称对应的参数值
Function getProperValByKey(key)
	getProperValByKey = Application("language_properties")(0).Item(key)
End Function
%>
