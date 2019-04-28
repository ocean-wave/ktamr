<%@LANGUAGE="VBScript" CodePage="65001"%>
<!--#INCLUDE FILE="../checkright.asp"-->
<!-- #include file="../common/common.asp" -->
<%
Response.Addheader "Content-Type","text/html; charset=utf-8"
CheckGeneralLevel

    Dim op, serverName, cmdStr, msg, RetCode
    serverName = Application("sysServerName")
    op = request("op")
    If serverName<>"" And op = "start" Then
        cmdStr = "net start """& serverName &""""
    ElseIf serverName<>"" And op = "stop" Then
        cmdStr = "net stop """& serverName &""""
    Else
        response.write "未知的操作！"
        response.end
    End If

    Set WshShell = Server.CreateObject("WScript.Shell")
	'WScript Run函数的参数 待执行命令字符串，是否显示命令窗口（1为显示，0为不显示），是否阻塞运行
	'如果参数带空格，则路径要用双引号引起来
    RetCode = WshShell.Run (cmdStr, 0, true)
    'RetCode = WshShell.ShellExecute (0, "runas", "net", "start """& serverName &"""", null, 1)
    'response.write cmdStr&"<br>"
	'0 ： 正常，没有错误；
	'1 ： 警告，没有致命的错误，例如某些文件正在被使用，没有被压缩；
	'2 ： 致命错误；
	'7 ： 命令行错误；
	'8 ： 没有足够的内存；
    '255 ： 用户停止了操作；
    Set WshShell = Nothing
    If RetCode=0 Then
        msg = ""
	Else
        msg = "error["&RetCode&"]:执行失败！权限不够或者net命令无法运行。"
    End If

Response.Charset="GBK"
Response.Write msg
%>