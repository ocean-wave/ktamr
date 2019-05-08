
$.ajaxSetup({
	type:'post', 
	contentType:'application/x-www-form-urlencoded; charset=UTF-8',	
	success:function(data){}   
});  
//--------------------------------取得对象函数开始--------------------------------

//取得对象，适用于所有对象
function dtm(id){return document.all.item(id);}

//取得对象的值，适用于表单域对象
function dtmVal(id){return document.all.item(id).value;}

//取得事件对象
function evtElmt(){return window.event.srcElement;}

//取得显示属性
function dspla(x){
	if(x == 0){return "none";}
	else{return "block";}
}

//取得对象的style
function objStl(id){return dtm(id).style;}

//--------------------------------取得对象函数开始--------------------------------


//--------------------------------判断函数开始--------------------------------

//判断id目标是否不存在
function idNoExs(id){
	if(!dtm(id)){
		alert("名为'" + id + "'的对象不存在！");
		return true;
	}
}

//判断对象目标是否不存在
function objNoExs(obj){
	if(!obj){
		alert("对象不存在！");
		return true;
	}
}

//判断字段是否为空、非数、是负数
//例子：if(!Ept_NaN_Xy0("编号","id")){return false;}
function Ept_NaN_Xy0(name,id) {
	if(idNoExs(id)){return false;}
	var dtmid = dtm(id);
	if(isEpt(name,dtmid)) {return false;}
	if(notNum(name,dtmid)) {return false;}
	if(Xy0(name,dtmid)) {return false;}
	return true;
}

function Ept_NaN_Xy0_nomsg(name,id) {
	if(idNoExs(id)){return false;}
	var dtmid = dtm(id);
	if(isEpt0(name,dtmid)) {return false;}
	if(notNum(name,dtmid)) {return false;}
	if(Xy0(name,dtmid)) {return false;}
	return true;
}

//判断字段是否为空
//例子：if(isEpt("编号",dtm("id"))){return false;}
function isEpt(aNam,aid){
	if(objNoExs(aid)){return false;}
	if(aid.value == ""){
		alert(aNam+"不能为空！");
		aid.focus();
		//aid.select();
		return true;
	}
}

function isEpt0(aNam,aid){
	if(objNoExs(aid)){return false;}
	if(aid.value == ""){
		alert(aNam+"不能为空！");
		aid.focus();
		return true;
	}else if(aid.value == 0){
		alert(aNam+"不能为0！");
		aid.focus();
		return true;
	}
}

//判断字段是否非数
//例子：if(notNum("编号",dtm("id"))){return false;}
function notNum(aNam,aid){
	if(objNoExs(aid)){return false;}
	if(isNaN(aid.value)){
		alert(aNam+"要求输入数字！");
		aid.focus();
		aid.select();
		return true;
	}
}

//判断字段是否负数
//例子：if(Xy0("编号",dtm("id"))){return false;}
function Xy0(aNam,aid){
	if(objNoExs(aid)){return false;}
	if(aid.value<0){
		alert(aNam+"不能小于0！")
		aid.focus();
		aid.select();
		return true;
	}
}
function checkLen(aNam, aid, len){
	if(objNoExs(aid)){return false;}
	if(String(aid.value).length != len){
		alert(aNam+"输入长度不为"+len+"！");
		return false;
	}
	return true;
}
function checkIDCode(aNam, str){
	if(isEpt(aNam, str)){
		return false;
	}
	if(checkChinese(str) == true || checkQuote(str) == true){
		alert(aNam+"只支持数字、字母及下划线！");
		return false;
	}
	return true;
}
/*
 * 检查输入的一串字符是否包含汉字
 * 输入:str  字符串
 * 返回:true 或 flase; true表示包含汉字
 */
function checkChinese(str){
	//[\u4E00-\u9FA5]为汉字﹐[\uFE30-\uFFA0]为全角符号
    if (/^[\x00-\xff]*$/.test(str)) {
        return false;
    }
    else {
        return true;
    }
}
function strDateTime2(str)
{
	var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2}) (\d{1,2}):(\d{1,2}):(\d{1,2})$/; 
	var r = str.match(reg); 
	if(r==null)return false; 
	var d= new Date(r[1], r[3]-1,r[4],r[5],r[6],r[7]); 
	return (d.getFullYear()==r[1]&&(d.getMonth()+1)==r[3]&&d.getDate()==r[4]&&d.getHours()==r[5]&&d.getMinutes()==r[6]&&d.getSeconds()==r[7]);
}
/*
 * 检查输入的字符是否具有特殊字符
 * 输入:str  字符串
 * 返回:true 或 flase; true表示包含特殊字符
 * 主要用于注册信息的时候验证
 */
function checkQuote(str){
    var items = new Array("~", "`", "!", "@", "#", "$", "%", "^", "&", "*", "{", "}", "[", "]", "(", ")");
    items.push(":", ";", "'", "|", "\\\\", "<", ">", "?", "/", "<<", ">>", "||", "//");
    //items.push("admin", "administrators", "administrator", "管理员", "系统管理员");
    items.push("select", "delete", "update", "insert", "create", "drop", "alter", "trancate");
    str = str.toLowerCase();
    for (var i = 0; i < items.length; i++) {
        if (str.indexOf(items[i]) >= 0) {
            return true;
        }
    }
    return false;
}


/* 判断IPV4是否合法 */
function isValidIP(ip) {
	var reg = /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/;
	
    return reg.test(ip);
} 



function getStrLength(str) {
    var len = str.length;
    var reLen = 0;
    for (var i = 0; i < len; i++) {       
        if (str.charCodeAt(i) < 27 || str.charCodeAt(i) > 126) {
            // 全角   
            reLen += 2;
        } else {
            reLen++;
        }
    }
    return reLen;   
}
//按内容大小改变元素大小
function resizeInput() {
    $(this).attr('size', getStrLength(this.value));
}

function generalMask(obj)
{
	obj.value=obj.value.replace(/[^\d]/g,'');//去除非数字
}
function generalMaskHex(obj)
{
	obj.value=obj.value.replace(/[^a-fA-F0-9]/g,'');//去除非16进制数
}
function timeTypeCheck(obj)
{
	var checkedStr = obj.value;
	var reDateTime = /^(?:19|20)[0-9][0-9]-(?:(?:0[1-9])|(?:1[0-2]))-(?:(?:[0-2][1-9])|(?:[1-3][0-1])) (?:(?:[0-2][0-3])|(?:[0-1][0-9])):[0-5][0-9]:[0-5][0-9]$/;
	//var reDateTime = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2}) (\d{1,2}):(\d{1,2}):(\d{1,2})$/;
	//return reDateTime.test(obj.value);
	if(checkedStr.match(reDateTime) == null)
	{
		obj.style.backgroundColor="LightSalmon";
		alert("请填写正确的时间格式！");
		return false;
	}else{
		obj.style.backgroundColor="";
		return true;
	}
}

function checkTimeType(value)
{
	var checkedStr = value;
	var reDateTime = /^(?:19|20)[0-9][0-9]-(?:(?:0[1-9])|(?:1[0-2]))-(?:(?:[0-2][1-9])|(?:[1-3][0-1])) (?:(?:[0-2][0-3])|(?:[0-1][0-9])):[0-5][0-9]:[0-5][0-9]$/;

	if(checkedStr.match(reDateTime) == null)
	{
		return false;
	}else{
		return true;
	}
}
function validateFloat(val){//验证小数  
	var patten = /^-?(?:\d+|\d{1,3}(?:,\d{3})+)(?:\.\d+)?$/;  
	return patten.test(val);  
}
//判断资料是否重复
function isDataRepeat(queryData){
	var check_url = "/common/ajax_get_data_is_repeat.asp?";
	var re = "";
	$.ajax({
		url: check_url
		,type: "POST"
		,contentType:'application/x-www-form-urlencoded; charset=UTF-8'
		,data: queryData
		,async:false //同步请求
		,success: function(data){
			if(data == "True"){
				re = true; 
			}else{
				re = false;
			}
		}
	});
	return re;
}
/**
* 校验正负正数就返回true
**/
function isIntNum(val){
    var regPos = / ^\d+$/; // 非负整数
    var regNeg = /^\-[1-9][0-9]*$/; // 负整数
    if(regPos.test(val) || regNeg.test(val)){
        return true;
    }else{
        return false;
    }
}
/**
* 校验是否是正整数
**/
function isNumber(value) {
    var patrn = /^[0-9]*$/;
    if (patrn.exec(value) == null || value == "") {
        return false
    } else {
        return true
    }
}

//给指定的SELECT动态添加OPTION
function appendSelectOption(idname, str, ids){
	var option = "";
	var arr = new Array();  //存储的是一整条数据       0   1      2    3   4       
	var atr = new Array();  //存储一条数据的每个项atr(id,name)
	var attrObj = $("#"+idname);
	if(str!=""){
		var selectId = attrObj.val();

		attrObj.empty();
		option = $("<option>").val("").text(""); 
		attrObj.append(option); 
		arr = str.split(";");
		for(i=0;i<arr.length-1;i++){
			atr=arr[i].split(",");
			option = $("<option>").val(atr[0]).text(atr[1]);
			attrObj.append(option);
			//if(ids.indexOf(atr[0])>0){
			//	attrObj.find("option:contains('"+atr[0]+"')").attr("selected", true);
			//}  
		}

		attrObj.val(selectId);
	}
	else{
		attrObj.empty();
		option = $("<option>").val("").text(""); 
		attrObj.append(option); 
	}
}  
//--------------------------------判断函数结束--------------------------------
//给数字字符串补零，不支持负数
function padNumber(num, fill) {
	var len = ('' + num).length;
	return (Array(
		fill > len ? fill - len + 1 || 0 : 0
	).join(0) + num);
}
//数组转化成用逗号隔开的字符串
function arrayToStr(ids){
	var _ids = ids;
	if(_ids != "" && _ids != null){
		_ids = _ids.join(',');
	}

	return _ids;
}
//数组添加单引号并转化成用逗号隔开的字符串
function arrayAddSingleQuotes(ids){
	var i = 0, _ids = ids;
	if(_ids != "" && _ids != null){
		for (i=0; i<_ids.length; i++)
		{    
			_ids[i] = _ids[i].trim();
			_ids[i]="'" + _ids[i] + "'" ;
		}
		_ids = _ids.join(',');
	}

	return _ids;
}
//导航菜单鼠标进入自动展开
function dropdownOpen() {
	var $dropdownLi = $('div.btn-group');
	$dropdownLi.mouseover(function() {
		$(this).addClass('open');
	}).mouseout(function() {
		$(this).removeClass('open');
	});
}

// 对Date的扩展，将 Date 转化为指定格式的String
// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符， 
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字) 
// 例子： 
// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423 
// (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18
Date.prototype.Format = function (fmt) { //author: meizz
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)){
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	}
    for (var k in o){
		if (new RegExp("(" + k + ")").test(fmt)){
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
		} 
	}

    return fmt;
}
//调用： 
//var time1 = new Date().Format("yyyy-MM-dd");
//console.log(time1);
//var time2 = new Date().Format("yyyy-MM-dd HH:mm:ss"); 
/*(function () {
	function resize() {
		var body = document.getElementsByTagName('body')[0];
		var html = document.getElementsByTagName('html')[0];
		var width = html.clientWidth;
		var height =  html.clientHeight;
		var max = width > height ? width : height;
		var min = width > height ? height : width;
		body.style.width = max + "px";
		body.style.height = min + "px";
	}
	resize();
	window.addEventListener("resize", resize)
})();*/
