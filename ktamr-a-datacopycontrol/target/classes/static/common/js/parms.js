layui.define(['element','layer','form','myLayui'], function(exports){
		var $ = layui.jquery;
		var layer = layui.layer, myLayui = layui.myLayui;
		var _myLayui = new myLayui;
		
	//前台校验类型
	//输入表现类型
	//后台取值类型
	//后台校验类型
	//提示方式类型
	/******************* 前台校验类型 **********************/

	function generalMask(obj)
	{
		obj.value=obj.value.replace(/[^\d]/g,'');//去除非数字
	}
	/******************* 输入表现类型 **********************/

	//下拉列表搜索排序
	/*function getSelectText(selectId)
	{
		//获得所有select标签对象组
		//var object = document.getElementsByTagName("select");
		//var obj = object[2];
		//获得某id的对象
		var object = document.getElementById(selectId);
		
		var allText;
		allText = "";
		//alert(object.length);
		//alert(object[0].index+"+"+object[0].value+"+"+object[0].text);
		//保存所有option 的值
		for(i=0;i<object.length;i++)
		{
			//alert(object[i].index);//获得option的index编号
			//alert(object[i].value);//获得option的value的值
			allText+= object[i].text+','; //关键是通过option对象的text属性获取到选项文本
		}
		return allText;
	}
	function searchSelect(obj, selectId)
	{
		//获得input输入框的内容
		var getInput = obj.value;
		//获得Select对象
		var object = document.getElementById(selectId);
		//如果输入的内容为空，所有的选项都匹配
		if(getInput!= '')
		{
			//alert(getInput);
			//获得option中的所有内容
			var allText = getSelectText(selectId);
			//alert(allText);
			// 每个option的内容分割开来
			var eachOptin = new Array();
			eachOptin = allText.split(","); //字符分割
			var f = 0;
			//alert(eachOptin[eachOptin.length-2]+'+'+eachOptin[eachOptin.length-1]);
			for (i=0;i<eachOptin.length-1 ;i++ )
			{
				//alert(eachOptin[i]);
				//如果option内容中有输入的内容就返回第一次匹配的位置（大于等于0），如果没有匹配的就返回-1
				var flag = eachOptin[i].indexOf(getInput);
				var textBuf,valueBuf;
				if(flag >=0)
				{
					if(i!=f){
						textBuf = object[f].text;
						valueBuf = object[f].value;
						object[f].text = object[i].text;
						object[f].value = object[i].value;
						object[i].text = textBuf;
						object[i].value = valueBuf;
					}
					f++;
				}
			}
		}
		object[0].selected = true;
	};*/
	
	/******************* 后台取值类型 **********************/
	function fixZero(num,length){
		var str= num + "";
		var strLen = str.length;
		var s="";
		for(i=length;i>strLen;i--){
			s+="0";
		}
		return s+str;
	}
	function getNowTimeStr(){
		var time = new Date();
		var m = time.getMonth() + 1;// 程序计时的月从0开始取值后+1
		var t = time.getFullYear() + "-" + fixZero(m, 2) + "-" + fixZero(time.getDate(), 2) + " " + fixZero(time.getHours(), 2) +":"+ fixZero(time.getMinutes(), 2) + ":" + fixZero(time.getSeconds(), 2);
		
		return t;
	}
	function getDeviceId()
	{
		return getSelectedRows("jqGrid1", "");
	}
	function getDeviceAdd(){
		var rowData = $("#jqGrid1").jqGrid('getRowData', getSelectedRows("jqGrid1", ""));
		return rowData["centorId"];
	}
	function getDevDescription(){
		var rowData = $("#jqGrid1").jqGrid('getRowData', getSelectedRows("jqGrid1", ""));
		return rowData["description"];
	}
	function isKT3NB_VIRTUAL(){
		var rowData = $("#jqGrid1").jqGrid('getRowData', getSelectedRows("jqGrid1", ""));
		return rowData["description"]=="KT3NB VIRTUAL" ? true : false;
	}
	function isKT3NB(){
		var rowData = $("#jqGrid1").jqGrid('getRowData', getSelectedRows("jqGrid1", ""));
		return rowData["description"]=="KT3NB GPRS" ? true : false;
	}
	/******************* 后台校验类型 **********************/
	function checkSelectedId(selectedId)
	{
		var a = true;
		if(selectedId == ""){
			layer.msg("请选择集中器或集采器！", {icon: 5});
			a = false;
		}
		
		return a;
	}
	function checkCmd(cmd_name, queryStr, layerSize){
		var a = true;
		
		if(cmd_name == "搜寻表具"){
			layer.confirm('【搜寻表具】为不常用命令，请慎用！确实要执行吗？', {icon:3, title:'提示'},
			function(index, layero){
				if(isKT3NB()){
					var cmd = cmd_name+":"+getDeviceAdd();
					submitCmd(getDeviceId(), cmd);
				}else if(isKT3NB_VIRTUAL()){
					_myLayui.showLayer(cmd_name, "../OperateDevice/loadKT300Meter.asp", queryStr, layerSize);
				}else{
					_myLayui.showLayer(cmd_name, "../OperateDevice/setKT300Params.asp", queryStr, layerSize);
				}
				layer.close(index);
			});
			a = false;
		}else if(cmd_name == "采集器寻表"){
			layer.confirm('【采集器寻表】为不常用命令，请慎用！确实要执行吗？', {icon:3, title:'提示'},
			function(index, layero){
				_myLayui.showLayer(cmd_name, "../OperateDevice/loadCollector.asp", queryStr, layerSize);
				layer.close(index);
			});
			a = false;
		}
		else if(cmd_name == "小区关阀"){
			layer.confirm('关闭小区所有表阀门！确实要执行吗？', {icon:3, title:'提示'},
			function(index, layero){
				_myLayui.showLayer(cmd_name, "../OperateDevice/loadArea.asp", queryStr, layerSize);
				layer.close(index);
			});
			a = false;
		}
		else if(cmd_name == "搜寻集采器"){
			layer.confirm('【搜寻集采器】为不常用命令，请慎用！确实要执行吗？', {icon:3, title:'提示'},
			function(index, layero){
				_myLayui.showLayer(cmd_name, "../OperateDevice/loadDTU.asp", queryStr, layerSize);
				layer.close(index);
			});
			a = false;
		}

		return a;
	};

	/******************* 命令提交 **********************/
	var get_cmdid_url="/smallbox/haCmd/cmdAdd";
	var get_result_url = "/smallbox/haCmd/getCmdAjax";
	function loadCmdResult(timerObj){
		$.get(get_result_url,
			{cmdid: timerObj.cmdid},
			function(data,status){
				if (status == "success"){
					var n, state, processing, s, cmd , nowStr;
					s = data;
					n = s.indexOf(":");
					if (n > 1){
						state = s.substr(0,n);
						processing = s.substr(n+1);
						if ((state == "完成") || (state == "失败")){
							if(state == "完成"){
								cmd = "<span class='fontGreen'>"+timerObj.cmd+"</span>";
								processing = "<span class='fontGreen'>"+timerObj.deviceName+':'+processing+"</span>";
								nowStr = "<span class='fontGreen'>"+getNowTimeStr()+"</span>";
							}else{
								cmd = "<span class='fontRed'>"+timerObj.cmd+"</span>";
								processing = "<span class='fontRed'>"+timerObj.deviceName+':'+processing+"</span>";
								nowStr = "<span class='fontRed'>"+getNowTimeStr()+"</span>";
							}
							$("#jqGrid2").jqGrid("addRowData", 0,{'命令':cmd, '操作日志':processing,'操作时间':nowStr}, "last"); 
							timerObj.stop();
						}
					}else{
						processing = s;
						if(processing.indexOf("class='fontGrey'")>0){
							cmd = "<span class='fontGrey'>"+timerObj.cmd+"</span>";
							nowStr = "<span class='fontGrey'>"+getNowTimeStr()+"</span>";
						}else{
							cmd = "<span class='fontRed'>"+timerObj.cmd+"</span>";
							nowStr = "<span class='fontRed'>"+getNowTimeStr()+"</span>";
						}
						$("#jqGrid2").jqGrid("addRowData", 0,{'命令':cmd, '操作日志':processing,'操作时间':nowStr}, "last"); 
						timerObj.stop();
					}		
				}
			}
		);
	}
	
	function submitCmd(deviceId, cmd){
		var rowData = $("#jqGrid1").jqGrid('getRowData', deviceId);
		var get_result_timer = $.timer(function(){
			loadCmdResult(this);
		});
		$("#jqGrid2").jqGrid("addRowData", 0,{'命令':cmd, '操作日志':rowData["addr"]+':新增命令','操作时间':getNowTimeStr()}, "last");
		$.ajax({
			url: get_cmdid_url
			,data: {
				centorid: deviceId
				,cmd: cmd
			}
			,type: "POST"
			,contentType:'application/x-www-form-urlencoded; charset=UTF-8'
			,async:true //异步请求
			,success: function(data){
				//console.log(data);
				if(!isNaN(data)){
					get_result_timer.cmdid = data;
					get_result_timer.cmd = cmd;
					get_result_timer.deviceName = rowData["addr"];
					//console.log(data+","+cmd+","+rowData["设备名称"]);
					get_result_timer.set({time: 3*1000, autostart: true});
				}else{
					cmd = "<span class='fontRed'>"+cmd+"</span>";
					nowStr = "<span class='fontRed'>"+getNowTimeStr()+"</span>";
					$("#jqGrid2").jqGrid("addRowData", 0,{'命令':cmd, '操作日志':data,'操作时间':nowStr}, "last"); 
				}
			}
		});
	}

	//parm1 小区名
	//parm2 采集器设备地址
	//parm3	表号
	//parm4 行政区号,集中器设备地址
	//parm5 集中器设置时间
	//parm6 IP,端口
	//parm7 工作时段或网络时段
	//parm8 DTUID
	//parm9 厂商码
	//parm10 表读数
	//parm11 KT420IP端口
	//parm12 设备号
	//parm13 YYYY-MM-DD
	//parm14 YYYY-MM
	$(".centorCmdList>.btn-group a").click(function(){
		var cmdName = $(this).data("title");
		if($(this).parent().hasClass("disabled"))
			return false;

		switchParms_kt410(cmdName);
	});
	$(".ccentorCmdList>.btn-group a").click(function(){
		var cmdName = $(this).data("title");
		if($(this).parent().hasClass("disabled"))
			return false;

		switchParms_kt3XX(cmdName);
	});
	/***** KT410 集中器命令*****/
	function switchParms_kt410(cmdName){
		var cmd, parms;
		var isSubmit = false;

		if(!checkSelectedId(getDeviceId()))
			return false;

		var _queryStr = [
			"devDescription="+getDevDescription(),
			"centorId="+getDeviceId(),
			"cmdName="+cmdName
		];
		var _layerSize = ['455px', '300px'];
		switch(cmdName)
		{
			case "集中器下载表地址":
			case "单表抄表":
			case "批量控阀":
				_layerSize = ['1000px', '700px'];
				_myLayui.showLayer(cmdName, "/systemmaintenance/loadCentorMeter", _queryStr, _layerSize);
				break;
			case "采集器下载表地址":
				_layerSize = ['650px', '400px'];
				_myLayui.showLayer(cmdName, "/systemmaintenance/loadCentorMeter", _queryStr, _layerSize);
				break;
			case "读采集器状态":
			case "下载采集器地址":
			case "刷新采集器":
			case "单抄采集器":
			case "初始化采集器":
			case "采集器寻表":
				_layerSize = ['1000px', '700px'];
				if(!checkCmd(cmdName, _queryStr, _layerSize))
					break;
				_myLayui.showLayer(cmdName, "/systemmaintenance/loadCollector", _queryStr, _layerSize);
				break;
			case "读取参数":
				_myLayui.showLayer(cmdName, "/systemmaintenance/readCentorParams", _queryStr, _layerSize);
				break;
			case "设集中器地址":
			case "集中器校时":
			case "设置参数":
			case "设心跳周期":
			case "设IP端口":
				_myLayui.showLayer(cmdName, "/systemmaintenance/setCentorParams", _queryStr, _layerSize);
				break;
			case "设上报时间":
				_myLayui.showLayer(cmdName, "/systemmaintenance/setCentorParams", _queryStr, _layerSize);
				break;
			case "设工作时段":
			case "设网络时段":
				_layerSize = ['550px', '350px'];
				_myLayui.showLayer(cmdName, "/systemmaintenance/setCentorParams", _queryStr, _layerSize);
				break;
			case "小区关阀":
			//case "读小区采集设备状态":
			//case "刷新小区数据":
				if(!checkCmd(cmdName, _queryStr, _layerSize)){
					break;
				}	
				_myLayui.showLayer(cmdName, "/systemmaintenance/loadArea", _queryStr, _layerSize);
				break;
			case "读日冻结数据":
			case "读月冻结数据":
				_layerSize = ['650px', '450px'];
				_myLayui.showLayer(cmdName, "/systemmaintenance/loadArea", _queryStr, _layerSize);
				break;
			default:
				parms = "0";
				isSubmit = true;
				break;
		}
		if(isSubmit == true){
			cmd = cmdName+":"+parms;
			//console.log("cmd:"+cmd);
			submitCmd(getDeviceId(), cmd);
		}
	}

	/***** KT3XX 集采器命令 *****/
	function switchParms_kt3XX(cmdName){
		var cmd, parms;
		var isSubmit = false;
		var deviceAdd = getDeviceAdd(), devDescription = getDevDescription();

		if(!checkSelectedId(getDeviceId()))
			return false;
		
		var _queryStr = [
			"centorId="+getDeviceId(),
			"cmdName="+cmdName
		];
		var _layerSize = ['455px', '300px'];
		switch(cmdName)
		{
			case "多表抄收5+4+1":
			case "多表抄收4+1":
			case "读设备地址":
			case "读表具总数":
			case "读心跳周期":
			case "读IP端口":
			case "刷新数据":
			case "读刷新数据间隔":
				parms = deviceAdd;
				isSubmit = true;
				break;
			case "多表数据抄收":
			//case "系统检修":
			case "搜寻表具":
				if(isKT3NB_VIRTUAL()){
					_layerSize = ['650px', '400px'];
				}
				if(!checkCmd(cmdName, _queryStr, _layerSize))
					break;
				if(isKT3NB()){
					parms = deviceAdd;
					isSubmit = true;
				}else if(isKT3NB_VIRTUAL()){
					_myLayui.showLayer(cmdName, "/systemmaintenance/loadKT300Meter", _queryStr, _layerSize);
				}else{
					_myLayui.showLayer(cmdName, "/systemmaintenance/loadKT300Meter", _queryStr, _layerSize);
				}
				break;
			case "设置设备地址":
			case "设IP端口":
			case "设心跳周期":
			case "设刷新数据间隔":
				_myLayui.showLayer(cmdName, "/systemmaintenance/loadKT300Meter", _queryStr, _layerSize);
				break;
			case "单表抄收(60)":
			//case "单表抄收(66)":
			case "单表抄收5+4":
			case "批量控阀":
				_layerSize = ['650px', '400px'];
				_myLayui.showLayer(cmdName, "/systemmaintenance/loadKT300Meter", _queryStr, _layerSize);
				break;   
			case "增删表地址":
				_layerSize = ['650px', '400px'];
				_queryStr = [
					"centorId="+getDeviceId(),
					"cmdName="+cmdName,
					"devDescription="+devDescription
				];
				_myLayui.showLayer(cmdName, "/systemmaintenance/loadKT300Meter", _queryStr, _layerSize);
				break;   
			//case "设机电参数"://用于KT300修改表读数
			//	_layerSize = ['650px', '400px'];
			//	_myLayui.showLayer(cmdName, "../OperateDevice/loadKT300Meter.asp", _queryStr, _layerSize);
			//	break;
			//case "抄收GPRSDTU":
			//case "刷新GPRSDTU":
			//case "搜寻集采器":
			//	if(!checkCmd(cmdName, _queryStr, _layerSize))
			//		break;
			//	_myLayui.showLayer(cmdName, "../OperateDevice/loadDTU.asp", _queryStr, _layerSize);
			//	break;
			default:
				parms = "0";
				isSubmit = true;
				break;
		}
		
		if(isSubmit == true){
			cmd = cmdName+":"+parms;
			submitCmd(getDeviceId(), cmd);
		}
	}

	exports('parms', {submitCmd});//将方法暴露出来，才可以被外部调用
});