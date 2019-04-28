<%
function haveChildren(tableName, idName, id)
	Dim rs, strQ
	Set rs = Server.CreateObject("ADODB.Recordset")
	if id <> "" then
		strQ = "select count(*) from " & tableName & " where " & idName & "=" & id
	else
		strQ = "select count(*) from " & tableName
	end if
	'response.write strQ
	rs.Open strQ, cnn
	If rs.BOF or rs.EOF then
		haveChildren = 0
	else
		haveChildren = rs(0)
	end if
	rs.close
End function

function haveChildrenByWhere(tableName, where)
	Dim rs, strQ
	Set rs = Server.CreateObject("ADODB.Recordset")
	if where <> "" then
		strQ = "select count(*) from " & tableName & " where " & where
	else
		strQ = "select count(*) from " & tableName
	end if
    'response.write strQ
	rs.Open strQ, cnn
	If rs.BOF or rs.EOF then
		haveChildrenByWhere = 0
	else
		haveChildrenByWhere = rs(0)
	end if
	rs.close
End function

function haveChildrenforcentor(id)
	Dim rs, strQ
	Set rs = Server.CreateObject("ADODB.Recordset")
	'strQ = "select count(*) from ha_collector where addr like '" & id & ",%'"
	strQ = "select count(*) from ha_meter where centorid="&id
	rs.Open strQ, cnn
	If rs.BOF or rs.EOF then
		haveChildrenforcentor = 0
	else
		haveChildrenforcentor = rs(0)
	end if
	rs.close
End function

function changeIndent(indent)
	dim s, i, m
	for i = 1 to len(indent)
		m = mid(indent,i,1)
		if m = 0 then
			s = s & "<td><img src=images/spacer.gif width=16 height=16></td>"
		else
			s = s & "<td><img src=images/line01.gif></td>"
		end if
	next
	changeIndent = s
end function

'转换状态数为二进制显示，需小于256
function changebinary(num)
	changebinary = 0
	if num >= 128 then
		changebinary = 10000000
		num = num - 128
	end if
	if num >= 64 then
		changebinary = changebinary + 1000000
		num = num - 64
	end if
	if num >= 32 then
		changebinary = changebinary + 100000
		num = num - 32
	end if
	if num >= 16 then
		changebinary = changebinary + 10000
		num = num - 16
	end if
	if num >= 8 then
		changebinary = changebinary + 1000
		num = num - 8
	end if
	if num >= 4 then
		changebinary = changebinary + 100
		num = num - 4
	end if
	if num >= 2 then
		changebinary = changebinary + 10
		num = num - 2
	end if
	changebinary = changebinary + num
	while len(changebinary) < 8
		changebinary = "0" & changebinary
	wend
end function

Function getUnicode(hanzi)
	Dim str
	str = Left(hanzi,1)
	if Len(str)>0 then
	   getUnicode = Hex(AscW(str))
	else
	   getUnicode = ""
	end if
End Function

'把普通字符串转成二进制字符串函数
Function Str2Base(varstr)
	Dim str2bin
	Dim varchar
	Dim varasc
	Dim varlow, varhigh
	Dim i
	
	str2bin = ""
	For i = 1 To Len(varstr)
		varchar = Mid(varstr, i, 1)
		varasc = Asc(varchar)
		If varasc < 0 Then
			varasc = varasc + 65535
		End If
		If varasc > 255 Then
			varlow = Left(Hex(Asc(varchar)), 2)
			varhigh = Right(Hex(Asc(varchar)), 2)
			str2bin = str2bin & ChrB("&H" & varlow) & ChrB("&H" & varhigh)
		Else
			str2bin = str2bin & ChrB(AscB(varchar))
		End If
	Next
	Str2Base = str2bin
End Function

'- ------------------------------------------- -
'  函数说明：GB2312转换为UTF8
'- ------------------------------------------- -
Public Function GB2312ToUTF8(strIn)
    Dim adoStream

    Set adoStream = Server.CreateObject("ADODB.Stream")
    adoStream.Charset = "utf-8"
    adoStream.Type = 2 'adTypeText
    adoStream.Open
    adoStream.WriteText strIn
    adoStream.Position = 0
    adoStream.Type = 1 'adTypeBinary
    GB2312ToUTF8 = adoStream.Read()
    adoStream.Close

    'GB2312ToUTF8 = Mid(GB2312ToUTF8, 1)
End Function

'- ------------------------------------------- -
'  函数说明：UTF8转换为GB2312
'- ------------------------------------------- -
Public Function UTF8ToGB2312(varIn)
    Dim bytesData()
    Dim adoStream

    bytesData = varIn
    Set adoStream = Server.CreateObject("ADODB.Stream")
    adoStream.Charset = "utf-8"
    adoStream.Type = 1 'adTypeBinary
    adoStream.Open
    adoStream.Write bytesData
    adoStream.Position = 0
    adoStream.Type = 2 'adTypeText
    UTF8ToGB2312 = adoStream.ReadText()
    adoStream.Close
End Function

Function EscapeCode(p_Message)
  Dim m_char,m_asc,m_hex '字符，ASC码，16进制ASCII码
  Dim m_temp '临时字符
  Dim a_arc() 'ASC码数组
  Dim i
  ReDim a_arc(Len(p_Message))
  For i = 0 To Len(p_Message) -1
    m_char = Mid(p_Message,i+1,1)
    m_asc = AscW(m_char)
    If m_asc < 255 Then
      If  (m_char = "*") Or(m_char = "+") _
        Or(m_char >= "-" And m_char <= "9" ) _
        Or(m_char >= "@" And m_char <= "Z" ) _
        Or(m_char = "_") _
        Or(m_char >= "a" And m_char <= "z" )  Then 
  a_arc(i) = m_char
   Else
   m_temp = Hex(m_asc)
   If Len(m_temp) = 1 Then
     a_arc(i) = "%0" & m_temp
   ElseIf Len(m_temp) = 2 Then
     a_arc(i) = "%" & m_temp
   Else
     a_arc(i) = "%u" & m_temp
   End If
   End If
    Else
        m_temp = Hex(m_asc)
     If Len(m_temp) = 1 Then
       a_arc(i) = "%u000" & m_temp
     ElseIf Len(m_temp) = 2 Then
       a_arc(i) = "%u00" & m_temp
     ElseIf Len(m_temp) = 3 Then
       a_arc(i) = "%u0" & m_temp
     Else
          a_arc(i) = "%u" & m_temp
        End If
    End If
  Next
  EscapeCode = Join(a_arc,"")
End Function

'---------------------------------------
'编码转换函数
'iconv("UTF-8", "GB2312", "转码") 'UTF-8 To GB2312
Function iconv(InCharset,OutCharset,OutStr)
    Dim File
    Set File = server.CreateObject("Adodb.Stream")
    File.Charset = InCharset
    File.Mode = 3
    File.Open
    File.Type = 2
    File.Position = 0
    File.WriteText OutStr
    File.Position = 0
    File.Charset = OutCharset
    iconv = File.ReadText
End Function
'GB2312 to UTF-8
Function GBKToUTF8(inStr)
	GBKToUTF8 = iconv("GB2312", "UTF-8", inStr)
End Function
'UTF-8 to GB2312
Function UTF8ToGBK(inStr)
	UTF8ToGBK = iconv("UTF-8", "GB2312", inStr)
End Function

'------------------------------------------
Function UrlDecode_GBToUtf8(ByVal str)
    Dim B,ub    
    Dim UtfB    
    Dim UtfB1, UtfB2, UtfB3 
    Dim i, n, s
    n=0
    ub=0
    For i = 1 To Len(str)
        B=Mid(str, i, 1)
        Select Case B
            Case "+"
                s=s & " "
            Case "%"
                ub=Mid(str, i + 1, 2)
                UtfB = CInt("&H" & ub)
                If UtfB<128 Then
                    i=i+2
                    s=s & ChrW(UtfB)
                Else
                    UtfB1=(UtfB And &H0F) * &H1000    
                    UtfB2=(CInt("&H" & Mid(str, i + 4, 2)) And &H3F) * &H40        
                    UtfB3=CInt("&H" & Mid(str, i + 7, 2)) And &H3F       
                    s=s & ChrW(UtfB1 Or UtfB2 Or UtfB3)
                    i=i+8
                End If
            Case Else    
                s=s & B
        End Select
    Next
    UrlDecode_GBToUtf8 = s
End Function
'------------------------------------------

'VBScript escape/unescape
'----------------------------------------'
Function Escape(ByVal pstrInput)
     Dim objScrCtl
     
     Set objScrCtl = CreateObject("MSScriptControl.ScriptControl")
     objScrCtl.Language = "JavaScript"
     Escape = objScrCtl.Eval("escape('" & pstrInput & "')")
     Set objScrCtl = Nothing
End Function
Function Unescape(ByVal pstrInput)
     Dim objScrCtl
     
     Set objScrCtl = CreateObject("MSScriptControl.ScriptControl")
     objScrCtl.Language = "JavaScript"
     Unescape = objScrCtl.Eval("unescape('" & pstrInput & "')")
     Set objScrCtl = Nothing
End Function
'--------------------------'

Function IDsFillUp(IDs)
	Dim tempIDs
	tempIDs = IDs
	If Left(tempIDs, 1)="," Then
		tempIDs = "-1"&tempIDs
	End If
	If Right(tempIDs, 1)="," Then
		tempIDs = tempIDs&"-1"
	End If
	IDsFillUp = replace(tempIDs, ",,", ",-1,")
End Function
%>
