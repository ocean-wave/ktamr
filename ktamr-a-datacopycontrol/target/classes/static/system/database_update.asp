<%
'数据库版本更新
'删除数据库表字段 例如：ALTER TABLE hat_price DROP COLUMN billIdStr,COLUMN up1,COLUMN up2'
Class DBUpdate
	Public m_sqlStr
	Public m_db
		Sub SetDBConnect(dbconn)
		Set m_db = dbconn
	End Sub

	Private Function isReleaseDbVerUpdate(sysCurrentDbVer, releaseDbVer)
		Dim r
		'response.write sysCurrentDbVer&"<br/>"
		Ver1Array = split(sysCurrentDbVer, ".")
		Ver2Array = split(releaseDbVer, ".")
		
		If Cint(Ver1Array(0)) < Cint(Ver2Array(0)) Then
			'response.write Ver1Array(i)&","&Ver2Array(i)&"</br>"
			r = true
		ElseIf Cint(Ver1Array(0))=Cint(Ver2Array(0)) Then
			If Cint(Ver1Array(1)) < Cint(Ver2Array(1)) Then
				r = true
			ElseIf Cint(Ver1Array(1)) = Cint(Ver2Array(1)) Then
				If Cint(Ver1Array(2)) < Cint(Ver2Array(2)) Then
					r = true
				Else
					r = false
				End If
			Else
				r = false
			End If
		Else
			r = false
		End If

		isReleaseDbVerUpdate = r
	End Function

	Private Function sysConfigUpdate(k, v)
		m_db.DirectExecute "UPDATE ha_config SET v='"&v&"',lastTime=now(),uid='sys' WHERE s='系统参数' AND k='"&k&"'"
	End Function

	Function ChkTable(mytable)
		on error resume next
		Dim rs
		set rs = server.CreateObject("adodb.recordset")
		rs.open "SELECT TOP 1 * FROM "&mytable, m_db.m_c, 1, 1
		if not Err.number=0 Then
			'response.write Err.number
			Err.Clear '清除该错误
			ChkTable = False '"不存在"
		else
			ChkTable = True '"存在"
		end If
		rs.close
		Set rs=Nothing 
	End Function

	Private Function ChkCol(mytable, mycol)
		on error resume next
		Dim rs
		set rs = server.CreateObject("adodb.recordset")
		rs.open "SELECT TOP 1 "&mycol&" FROM "&mytable, m_db.m_c, 1, 1
		if not Err.number=0 Then
			'response.write Err.number
			Err.Clear '清除该错误
			ChkCol = False '"不存在"
		else
			ChkCol = True '"存在"
		end If
		rs.close
		Set rs=Nothing 
	End Function

	Public Function dataBaseUpdateByVersion(sysDbVer)
		Dim releaseDbVer, r

		If sysDbVer="" Then
			dataBaseUpdateByVersion = false
			Exit Function
		End If

		releaseDbVer = "2.1.0"
		If isReleaseDbVerUpdate(sysDbVer, releaseDbVer) Then
		
			'账单id, 用户ID, 操作（收费、扣费、退费、恢复收费、减免）, 金额, 当前余额, 操作时间, 操作人员'
			m_sqlStr = "CREATE TABLE ha_billRecords(" &_
			"	bId AUTOINCREMENT PRIMARY KEY," &_
			"	custId  INT," &_
			"	operation VARCHAR(6)," &_
			"	charge  Single," &_
			"	currentBalance  Single," &_
			"	optTime  DATETIME," &_
			"	optMan VARCHAR(32)" &_
			")"
			m_db.DirectExecute m_sqlStr

			'费用id,价格类型id,费用名称,单价1,单价2,单价3'
			m_sqlStr = "CREATE TABLE ha_feeStandard(" &_
			"	feeId AUTOINCREMENT PRIMARY KEY," &_
			"	priceStandId INT," &_
			"	name  VARCHAR(16)," &_
			"	price1  Single," &_
			"	price2  Single," &_
			"	price3  Single" &_
			")"
			m_db.DirectExecute m_sqlStr

			'分界点1，分界点2，收费方式'
			m_sqlStr = "ALTER TABLE ha_priceStandard ADD usagePoint1 INT, usagePoint2 INT, chargingMethods VARCHAR(16)"
			m_db.DirectExecute m_sqlStr

			'费用合计零时表'
			m_sqlStr = "CREATE TABLE hat_price(" &_
			"	billIdStr VARCHAR(16)," &_
			"	psId INT," &_
			"	up1 INT," &_
			"	up2 INT," &_
			"	p1 Single," &_
			"	p2 Single," &_
			"	p3 Single" &_ 
			")"
			m_db.DirectExecute m_sqlStr

			sysConfigUpdate "dbver", releaseDbVer
		End If

		releaseDbVer = "2.1.1"
		If isReleaseDbVerUpdate(sysDbVer, releaseDbVer) Then
			'用户余额'
			m_sqlStr = "ALTER TABLE [ha_custom] ADD [balance] Single 0"
			m_db.DirectExecute m_sqlStr

			sysConfigUpdate "dbver", releaseDbVer
		End If

		releaseDbVer = "2.2.1"
		If isReleaseDbVerUpdate(sysDbVer, releaseDbVer) Then
			'/* 放码记录
			'*
			'* 包含字段名称：
			'*     ID，批次号id，
			'*     设备编码: 如果重号，则在编号上加 + 
			'*     扫码时间: 系统填写
			'*     写码状态: 发送/成功/失败
			'*     读码状态: 发送/收到的编码/失败
			'*     总体状态: 待执行/成功/失败
			'*     详细说明: 详细提示
			'*/
			m_sqlStr = "CREATE TABLE pm_kt3nb" &_
			"(" &_
			"	id          COUNTER PRIMARY KEY," &_
			"	batch_id    INTEGER," &_
			"	device_code VARCHAR (16)," &_
			"	create_time DATETIME," &_
			"	set_state   VARCHAR (16)," &_
			"	get_state   VARCHAR (16)," &_
			"	state	    VARCHAR (16)," &_
			"	description VARCHAR (64)" &_
			");"
			m_db.DirectExecute m_sqlStr
	   
			'/* 放码批次
			'*
			'* 包含字段名称：
			'*     ID，
			'*	  设备类型: 集采器(CT)、表(MT)
			'*     公司名称: 设备归属公司
			'*     扫码日期: 系统填写
			'*     前缀码　: 设备码前3位(YMM)
			'*     计划数量: 预设本批次扫码数量
			'*     实际数量: 实际放码数量
			'*     成功数量，重号次数
			'*/
			m_sqlStr = "CREATE TABLE pm_kt3nb_batch" &_
			"(" &_
			"	id          COUNTER PRIMARY KEY," &_
			"	device_type VARCHAR (10)," &_
			"	company     VARCHAR (32)," &_
			"	work_day    DATETIME," &_
			"	precode     VARCHAR (10)," &_
			"	plan_amount INTEGER," &_
			"	real_amount INTEGER," &_
			"	ok_amount   INTEGER," &_
			"	dup_amount  INTEGER" &_
			");"
			m_db.DirectExecute m_sqlStr

			sysConfigUpdate "dbver", releaseDbVer
		End If

		releaseDbVer = "2.2.2"
		If isReleaseDbVerUpdate(sysDbVer, releaseDbVer) Then
			'费用合计'
			m_sqlStr = "ALTER TABLE [ha_priceStandard] ADD price1  Single, price2  Single, price3  Single"
			m_db.DirectExecute m_sqlStr

			m_sqlStr = "DROP TABLE hat_price"
			m_db.DirectExecute m_sqlStr

			'费用合计零时表'
			m_sqlStr = "CREATE TABLE hat_price(" &_
			"	priceStandId INT," &_
			"	price1 Single," &_
			"	price2 Single," &_
			"	price3 Single" &_ 
			")"
			m_db.DirectExecute m_sqlStr

			sysConfigUpdate "dbver", releaseDbVer
		End If

		releaseDbVer = "2.2.3"
		If isReleaseDbVerUpdate(sysDbVer, releaseDbVer) Then
			'用于预付费自动扣费：费用、扣费时间'
			m_sqlStr = "ALTER TABLE [ha_custom] ADD expense Single, paidTime DATETIME"
			m_db.DirectExecute m_sqlStr

			sysConfigUpdate "dbver", releaseDbVer
		End If

		releaseDbVer = "2.2.4"
		If isReleaseDbVerUpdate(sysDbVer, releaseDbVer) Then
			'最近缴费，最近缴费时间，接口上传时间'
			m_sqlStr = "ALTER TABLE [ha_custom] ADD recharge Single, rechargeTime DATETIME, postTime DATETIME"
			m_db.DirectExecute m_sqlStr

			sysConfigUpdate "dbver", releaseDbVer
		End If

		releaseDbVer = "2.2.5"
		If isReleaseDbVerUpdate(sysDbVer, releaseDbVer) Then
			'最近缴费，最近缴费时间，接口上传时间'
			m_sqlStr = "ALTER TABLE [ha_area] ADD registeredNo VarChar(32)"
			m_db.DirectExecute m_sqlStr

			sysConfigUpdate "dbver", releaseDbVer
		End If

		releaseDbVer = "2.2.6"
		If isReleaseDbVerUpdate(sysDbVer, releaseDbVer) Then
			'关阀余额'
			m_sqlStr = "ALTER TABLE [ha_priceStandard] ADD A1 Single"
			m_db.DirectExecute m_sqlStr

			sysConfigUpdate "dbver", releaseDbVer
		End If

		releaseDbVer = "2.3.0"
		If isReleaseDbVerUpdate(sysDbVer, releaseDbVer) Then
			'句容水司中间表'
			m_sqlStr = "CREATE TABLE hti_jr_job(" &_
				"ID  COUNTER PRIMARY KEY," &_
				"UserID      VARCHAR(64)," &_
				"UserName    VARCHAR(64)," &_
				"Address     VARCHAR(64)," &_
				"Tel         VARCHAR(32)," &_
				"WaterTagID  VARCHAR(32)," &_
				"LINENO      VARCHAR(32)," &_
				"AreaID      VARCHAR(32)," &_
				"InTabManID  VARCHAR(32)," &_
				"AMTabNum    Single," &_
				"NMTabNum    Single," &_
				"WaterMete   Single," &_
				"WaterPrice  Single," &_
				"CBtDate     DATETIME," &_
				"MeterState  VARCHAR(32)," &_
				"CustID      INT," &_
				"importTime  DATETIME" &_
			")"
			m_db.DirectExecute m_sqlStr

			sysConfigUpdate "dbver", releaseDbVer
		End If

		releaseDbVer = "2.4.0"
		If isReleaseDbVerUpdate(sysDbVer, releaseDbVer) Then
			'批量换表临时表'
			m_sqlStr = "CREATE TABLE hat_metersReplace(" &_
				"ID  COUNTER PRIMARY KEY," &_
				"oriMeterNumber  FLOAT," &_
				"oriMeterId      INT," &_
				"oriMeterRead    INT," &_
				"newMeterNumber  FLOAT," &_
				"newMeterRead    INT," &_
				"replaceTime     DATETIME," &_
				"replaceMan      VARCHAR(32)," &_
				"remark          VARCHAR(32)," &_
				"check           VARCHAR(32)," &_
				"hasDayFreeze	 SMALLINT," &_
				"hasMonFreeze	 SMALLINT," &_
				"importTime      DATETIME" &_
			")"
			m_db.DirectExecute m_sqlStr

			sysConfigUpdate "dbver", releaseDbVer
		End If

		releaseDbVer = "2.4.1"
		If isReleaseDbVerUpdate(sysDbVer, releaseDbVer) Then
			'批量换表临时表'
			m_sqlStr = "ALTER TABLE [pm_kt3nb] ADD" &_
				" RSSI		INT," &_
				" Vol		INT," &_
				" IMSI VarChar(16)," &_
				" IMEI VarChar(16)"
			m_db.DirectExecute m_sqlStr

			sysConfigUpdate "dbver", releaseDbVer
		End If

		releaseDbVer = "2.5.0"
		If isReleaseDbVerUpdate(sysDbVer, releaseDbVer) Then
			'新增字段:设备描述'
			m_sqlStr = "ALTER TABLE [ha_centor] ADD remark VarChar(64)"
			m_db.DirectExecute m_sqlStr
			'设备档案临时表'
			m_sqlStr = "CREATE TABLE hat_devicesImport(" &_
				"ID COUNTER PRIMARY KEY," &_
				"deviceID    VARCHAR(16)," &_
				"deviceName  VARCHAR(32)," &_
				"description VARCHAR(16)," &_
				"areaName    VARCHAR(32)," &_
				"areaNo      VARCHAR(16)," &_
				"areaId      INT," &_
				"setupTime   DATETIME," &_
				"tel         VARCHAR(16)," &_
				"remark      VARCHAR(64)," &_
				"check       VARCHAR(16)," &_
				"importTime  DATETIME" &_
			")"
			m_db.DirectExecute m_sqlStr

			sysConfigUpdate "dbver", releaseDbVer
		End If
		'response.write ChkTable("ha_meters")
		'response.write ChkCol("ha_meter", "meterNumber")

		releaseDbVer = "2.5.1"
		If isReleaseDbVerUpdate(sysDbVer, releaseDbVer) Then
			'新增字段:抄表调整数'
			If ChkCol("ha_meter", "offset_n")=False Then
				m_sqlStr = "ALTER TABLE [ha_meter] ADD offset_n INT"
				m_db.DirectExecute m_sqlStr
			End If

			sysConfigUpdate "dbver", releaseDbVer
		End If

		releaseDbVer = "2.6.0"
		If isReleaseDbVerUpdate(sysDbVer, releaseDbVer) Then
			'新增字段:用户编号'
			If ChkCol("hat_metersReplace", "userCode")=False Then
				m_sqlStr = "ALTER TABLE [hat_metersReplace] ADD userCode VARCHAR(32)"
				m_db.DirectExecute m_sqlStr
			End If

			sysConfigUpdate "dbver", releaseDbVer
		End If

		releaseDbVer = "2.6.1"
		If isReleaseDbVerUpdate(sysDbVer, releaseDbVer) Then
			'新增字段:是否使用表序号'
			If ChkCol("ha_importCustom", "use_meter_sequence")=False Then
				m_sqlStr = "ALTER TABLE [ha_importCustom] ADD use_meter_sequence SMALLINT"
				m_db.DirectExecute m_sqlStr
			End If

			sysConfigUpdate "dbver", releaseDbVer
		End If
	End function

End Class

%>
