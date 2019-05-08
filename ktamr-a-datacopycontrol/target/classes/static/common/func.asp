<%
'Functions For ASP

Function Number2Cap(s)
	dim temps
	tempS = Trim(s)
	dim u(8)
	for i=1 to 8
		u(i) = "零"
	next
	dim k
	k = len(temps)
	for i=1 to k
		select case mid(temps,k-i+1,1) 
		case "1"
			u(i)="壹" 
		case "2"
			u(i)="贰"
		case "3"	
			u(i)="叁"		
		case "4"
			u(i)="肆"		
		case "5"
			u(i)="伍"		
		case "6"
			u(i)="陆"		
		case "7"
			u(i)="柒"		
		case "8"
			u(i)="捌"		
		case "9"
			u(i)="玖"		
		case "0"
			u(i)="零"
		end select	
	next
	s = ""
	s="零" & "拾" & u(7) & "万" & u(6) & "仟" & u(5) & "佰" & u(4) & "拾" & u(3) & "元" & u(2) & "角" & u(1) & "分"
	Number2Cap = s
end function

Function writeCursor( c, s )
   'Create the Cursor object.
   Set custs = Server.CreateObject("ADODB.RecordSet")
   custs.Open s, c

   ' Before continuing, make sure a real cursor was returned
   ' and there was no database error.
   If NOT custs.Eof Then
      Response.Write "<table border=1  width=100% cellspacing=0 cellpadding=0 bordercolorlight=#000000 bordercolordark=#ffffff bgcolor=#AEDBBB bgcolor=#FFFFFF>"
      ' Display column names as headers.
      Response.write "<tr bgcolor='#f0f0f0'>"
      For i = 0 To custs.Fields.Count - 1
         Response.write "<th><font size='2'>" & custs(i).Name & "</font></th>"
      Next
      Response.write "</tr>"

      ' Display each row in the virtual table.
      kk = 0
      While NOT custs.EOF
         if (kk mod 2) = 0 then
         Response.write "<tr bgcolor='#C9E2EF' onclick=SelectFile('" & Trim(CStr(custs(0))) & "') id='file_" & Trim(CStr(custs(0))) & "'>"
         else
         Response.write "<tr bgcolor='#EAFAFB' onclick=SelectFile('" & Trim(CStr(custs(0))) & "') id='file_" & Trim(CStr(custs(0))) & "'>"        
         end if
         For i = 0 To custs.Fields.Count - 1
            If IsNull(custs(i)) Then                
               Response.write "<td><font size='2'>.</font></td>"
            Else
               if Len(Trim(CStr(custs(i)))) = 0 then
               Response.write "<td><font size='2'>.</font></td>"
               else
               Response.write "<td><font size='2'>" & Trim(CStr(custs(i))) & "</font></td>"
               end if
            End If
         Next
         Response.write "</tr>"
         custs.MoveNext
         kk =kk + 1
      Wend
      Response.Write "</table>"
      writeCursor = 0
   Else
      'Response.write "<p>无数据"
      writeCursor = 1
   End If
   custs.Close
End Function

Function genGrid(strSQL)
   'Create the Cursor object.
    Set ccc = Server.CreateObject("ADODB.Connection")
    ccc.Open Application("ConnectionString")

    genfird = writeCursor(ccc, strSQL)
    ccc.Close
End Function

Function genGridPrint(strSQL)
   'Create the Cursor object.
    Set c = Server.CreateObject("ADODB.Connection")
    c.Open Application("ConnectionString")

    genfird = writeCursorPrint(c, strSQL)
    c.Close
End Function

Function writeCursorPrint( c, s )
   'Create the Cursor object.
   Set custs = Server.CreateObject("ADODB.RecordSet")
   custs.Open s, c

   ' Before continuing, make sure a real cursor was returned
   ' and there was no database error.
   If NOT custs.Eof Then
      Response.Write "<table border=0 style='border-bottom-style: solid; border-bottom-width: 1' cellspacing='0' cellpadding='0' bordercolor='#000000' bordercolorlight='#FFFFFF' bordercolordark='#000000' width='650'" + ">"
      ' Display column names as headers.
      Response.write "<tr>"
      For i = 0 To custs.Fields.Count - 1
         Response.write "<th height='22'><h4 align='left'>" & custs(i).Name & "</h4></th>"
      Next
      Response.write "</tr>"

      ' Display each row in the virtual table.
      While NOT custs.EOF
         Response.write "<tr>"
         For i = 0 To custs.Fields.Count - 1
            If IsNull(custs(i)) Then                
               Response.write "<td height='18'><pre style='margin-top: 0; margin-bottom: 0'><font size='2'>　</pre></td>"
            Else
               if Len(Trim(CStr(custs(i)))) = 0 then
               Response.write "<td height='18'><pre style='margin-top: 0; margin-bottom: 0'><font size='2'>　</pre></td>"
               else
               Response.write "<td height='18'><pre style='margin-top: 0; margin-bottom: 0'><font size='2'>" & Trim(CStr(custs(i))) & "</pre></td>"
               end if
            End If
         Next
         Response.write "</tr>"
         custs.MoveNext
      Wend
      Response.Write "</table>"
      writeCursorPrint = 0
   Else
      Response.write "<h4>无数据</h4>"
      writeCursorPrint = 1
   End If
   custs.Close
End Function

Sub executSQL(strSQL)
   s = strSQL
   semic = inStrB(s, ";")
   If semic > 0 Then s = Mid(s, 1, semic)

   s = Trim(s)

   Set c = Server.CreateObject("ADODB.Connection")
   c.Open strDBParam

   'Response.Write "<p>" + s + "<p>" + strSQL + strDBParam
   If UCase(Left(s,6)) = "SELECT" Then
      Session("status") = writeCursor(c,s)
   Else
      c.Execute s
   End If

   c.Close
End Sub

Sub SQL_DirectExecute(sql)
    Dim c
    Set c = Server.CreateObject("ADODB.Connection")
    c.Open strDBParam
    c.Execute sql
    c.Close
End Sub

Sub getSQLWithDBParam(strSQL, strDBParam)
   s = strSQL
   semic = inStrB(s, ";")
   If semic > 0 Then s = Mid(s, 1, semic)

   s = Trim(s)

   Set c = Server.CreateObject("ADODB.Connection")
   c.Open strDBParam

   'Response.Write "<p>" + s + "<p>" + strSQL + strDBParam
   If UCase(Left(s,6)) = "SELECT" Then
      Session("status") = getSQLData(s,c)
   Else
      c.Execute s
   End If

   c.Close
End Sub

' 以sql生成下拉式选择菜单
Function writeoptions(strsql)
   Set c = Server.CreateObject("ADODB.Connection")
   c.Open Application("ConnectionString")
   Set r = Server.CreateObject("ADODB.RecordSet")
   r.Open strsql, c

   i = 0

   If r.Eof Then
      Response.Write "<option selected value='-1'>现无数据可选</option>"
   Else
      Response.Write "<option value='" & CStr(r(0)) & "' >"
  		 If r.Fields.Count > 1 Then
		    Response.Write CStr(r(1))
		 Else
		    Response.Write CStr(r(0))
		 End If
      Response.Write "</option>" & Chr(13) & Chr(10)
      r.MoveNext
      While Not r.Eof
         Response.Write "<option value='" & CStr(r(0)) & "'>"
		 If r.Fields.Count > 1 Then
		    Response.Write CStr(r(1))
		 Else
		    Response.Write CStr(r(0))
		 End If
		 Response.Write "</option>" & Chr(13) & Chr(10)
         i = i + 1
         r.MoveNext
      Wend
   End If
   r.Close
   c.Close
   writeoptions = i
End Function

Function createselect(strsql, strname, nsize)
   Response.Write "<select size=" & CStr(nsize) & " name='" & strname & "'>"
   n = writeoptions(strsql)
   Response.Write "</select>"
   createselect = n
End Function

Function logon(wdh, czybh, mm)
   Session.Timeout = 120
   Session("wdh") = CLng(wdh)
   s = "select z4xm, z4xb, z4qx from cz4 where z4bh=" & CStr(czybh) & " and z4mm='" & CStr(mm) & "'"
   Set c = Server.CreateObject("ADODB.Connection")
   c.Open Application("ConnectionString")
   Set r = Server.CreateObject("ADODB.RecordSet")
   r.Open s, c
   If r.Eof Then
      Session("czybh") = 0
      Session("czych") = ""
      Session("czyqx") = ""
      logon = -1
   Else
      Session("czybh") = CLng(czybh)
      s = r(0)
      If r(1) = "1" Then
         Session("czych") = s 
      Else
         Session("czych") = s 
      End If
      Session("czyqx") = CStr(r(2))
      logon = 0
   End If
End Function

Function verifyright(nn)
   s = Mid(Session("czyqx"), nn, 1)
   If s = "1" Then
      verifyright = 1
   Else
      verifyright = 0
   End If
End Function

Sub islogon(tourl)
    n = 0
    If isNull(tourl) or Len(tourl) = 0 Then
        s = "..\login.asp"
    Else
        s = "..\login.asp?to=" & tourl
    End If
    If Request("bm").count > 0 And Request("wdh").count > 0 Then
        n = logon(Request("wdh"), Request("bm"), Request("kl"))
    End If
    If Len(Session("czych")) = 0 Or Session("czybh") = 0 Then
        Response.Redirect s
    End If
End Sub
Function Getmuloptiondiv(sql,id,dbconn,defaultids)
		 Response.Write "<div class='multiop' ><input type=hidden id='" & id & "' name='" & id & "' value='" & defaultids & "'/><img style='display:none;' id='multiopimg' src='/images/arrow_on1.gif' title='点击选择数据'/><div class='mullistview'>"
		 r=dbconn.GenmulOptiondivSelected(sql,defaultids)	
		 Response.Write "</div></div>"	
		 
End function

%>