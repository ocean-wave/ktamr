<%
Sub Building_GenOptionSelected(dbconn, id)
	Dim s
	s = "SELECT buildingid,'['||a.name||'] - '||b.name FROM ha_building b,ha_area a WHERE b.areaid=a.areaid ORDER BY a.areaid"
	dbconn.GenOptionSelected s, id
End Sub

Sub Building_GenOptionSelectedByWhere(dbconn,where,id)
	Dim s
	s = "SELECT buildingid,'['||a.name||'] - '||b.name FROM ha_building b,ha_area a WHERE b.areaid=a.areaid AND "&where&" ORDER BY a.areaid"
	dbconn.GenOptionSelected s, id
End Sub

Sub Building_GenOptionSelected_Has_FreeRoom(dbconn, id)
	Dim s
	s = "SELECT DISTINCT b.buildingid, ('['||a.name||'] - '||b.name) AS bname " &_
		"FROM ha_building b,ha_area a,ha_room r " &_
		"WHERE b.areaid=a.areaid AND b.buildingid=r.buildingid AND r.custid IS NULL"
	dbconn.GenOptionSelected s, id
End Sub

Sub MeterType_GenOptionSelected(dbconn, id)
	Dim s
	s = "select metertypeid,name from ha_metertype order by metertypeid"
	dbconn.GenOptionSelected s, id
End Sub

Sub PriceStandard_GenOptionSelected(dbconn, id)
	Dim s
	s = "select pricestand_id,name from ha_pricestandard where endtime is null or endtime>{fn Now()} order by pricestand_id"
	dbconn.GenOptionSelected s, id
End Sub

Sub Centor(dbconn, id)
	Dim s
	s = "select id, centorNo||':'||addr from ha_centor ORDER BY centorNo,description"
	dbconn.GenOptionSelected s,id
End Sub

Sub CentorByWhere(dbconn,where,id)
	Dim s
	s = "SELECT id,centorNo||':'||addr FROM ha_centor WHERE " & where &" ORDER BY centorNo,description"
	dbconn.GenOptionSelected s,id
End Sub

'deviceType centor/ccentor/handDevice
Sub DeviceByWhere(dbconn,where,id, deviceType)
	Dim s
	s = "SELECT id,centorNo||':'||addr FROM ha_centor WHERE"
	if deviceType = "centor" then
		s = s & " Left(description,3)='KT4'" 
	elseif deviceType = "ccentor" then
		s = s & " Left(description, 4)='GPRS' OR Left(description, 3)='COM' OR Left(description, 3)='KT3'"
	elseif deviceType = "handDevice" then
		s = s & " description='HAND'"
	else
		s = a & " id is not NULL"
	end if
    If Len(where)>0 Then
        s = s &" AND "& where
    End If
    s = s &" ORDER BY centorNo,description"
	dbconn.GenOptionSelected s,id
End Sub

Sub CollectorByWhere(dbconn,where,id)
	Dim s
	s = "SELECT collectorid,Hex(nconf)||':'||addr FROM ha_collector"
	If Len(where)>0 Then
        s = s &" WHERE "& where
    End If
	s = s & " ORDER BY Hex(nconf),addr"
	if IsNull(id) then
		id = ""
	end if
	dbconn.GenOptionSelected s,id
End Sub

sub rgnByWhere(dbconn, where,  id)
	Dim s
    s = "SELECT id, name FROM ha_rgn"
    If Len(where)>0 Then
        s = s& " WHERE "& where
    End If
    s = s& " ORDER BY id"
    dbconn.GenOptionSelected s,id
End Sub


Sub AreaByWhere(dbconn, where, typeName, id)
    Dim s
	If typeName="id" Then
		s = "select areaid, Right(areaNo, 4)||':'||name from ha_area"
	ElseIf typeName="name" Then
		s = "select name, Right(areaNo, 4)||':'||name from ha_area"
	ElseIf typeName="code" Then
		s = "select areaNo, Right(areaNo, 4)||':'||name from ha_area"
	End If
    If Len(where)>0 Then
        s = s& " WHERE "& where
    End If
    s = s& " ORDER BY areaNo"
    dbconn.GenOptionSelected s,id
End Sub


Sub BuildingByArea(dbconn, areaid, typeName, id)
	Dim s
	if isNull(areaid) Or Len(areaid)=0 then
		exit sub
	end if
	If typeName="id" Then
		s = "select buildingid, buildingNo||':'||name from ha_building b"
	ElseIf typeName="name" Then
		s = "select name, buildingNo||':'||name from ha_building"
	ElseIf typeName="code" Then
		s = "select buildingNo, buildingNo||':'||name from ha_building"
	End If
	
	s = s& " WHERE areaid="& areaid
	s = s& " ORDER BY name"
	dbconn.GenOptionSelected s,id
End Sub

Sub RoomByBuilding(dbconn, buildingid, typeName, id)
	Dim s
	if isNull(buildingid) Or Len(buildingid)=0 then
		exit sub
	end if
	If typeName="id" Then
		s = "select roomid, name from ha_room"
	ElseIf typeName="name" Then
		s = "select name, name from ha_room"
	End If
	s = s& " WHERE buildingid="& buildingid
	s = s& " ORDER BY name"
	dbconn.GenOptionSelected s,id
End Sub

Sub DTUByWhere(dbconn, where, id)
    Dim s
    s = "select uid, uid||':'||addr from ha_gprsDTU ORDER BY uid,addr"
    If Len(where)>0 Then
        s = "SELECT d.uid, d.uid||':'||d.addr FROM ha_gprsDTU d LEFT JOIN ha_centor c ON d.uid=c.telnumber WHERE "& where &"GROUP BY  d.uid,d.addr ORDER BY d.uid,d.addr"
    End If
    dbconn.GenOptionSelected s,id
End Sub
%>