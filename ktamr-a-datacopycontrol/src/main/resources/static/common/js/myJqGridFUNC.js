﻿var myJqGrid = function (GridId, GridPagerId, GridFormId, heightDelta,url){
	this.GridId = GridId;
	this.GridPagerId = GridPagerId;
	this.GridFormId = GridFormId;
	this.heightDelta = heightDelta;
	this.ExcelFileName = "";

	this.jqdefaultGridConfig = {
		url: url,
		styleUI: 'Bootstrap',
		mtype: "POST",
		datatype: "json",
		ajaxGridOptions: {contentType: 'application/x-www-form-urlencoded; charset=utf-8'},
		autowidth: true,
		height: 100,//默认高度
		shrinkToFit: false,
		rowNum: 200,
		rowList: [100, 200, 500],
		viewrecords: true,
		rownumbers: true,
		sortName: "id",
		sortOrder: "asc",
		scroll: false,//是否全页滚动加载
		altRows: true,
		altclass: 'userAltClass',
		multiselect: false,
		//multikey: "ctrlKey",
		caption: "",
		pager: "#"+GridPagerId,
		toolbar: [ false, "top" ],
		footerrow: false,
		userDataOnFooter: false,
        jsonReader:{
                     total:'total',
                     page:'page',
                     records:'records',
			         root:'rows',
			         repeatitems:false,
                     id : "id"
             }
             /*, gridComplete:function(){gridComplete(GridId);}//调用方法*/


	};
	this.excelButtonConfig = {
		caption: "Excel",
		buttonicon: "ui-icon-arrowthickstop-1-s",
		onClickButton: function(){ $.ktamr.exportToExcel(url,GridId);},
		position: "first",
		title: "导出Excel",
		cursor: "pointer",
	};
	this.gridButtonConfig = {
		del:false
		,add:false
		,edit:false
	};

};

myJqGrid.prototype.unloadGrid = function(){
	$.jgrid.gridUnload(this.GridId);
}

myJqGrid.prototype.drawGrid = function(){
	$("#"+this.GridId).jqGrid(this.jqdefaultGridConfig);
}
myJqGrid.prototype.drawGridPager = function(){

	$("#"+this.GridId).jqGrid('navGrid', '#'+this.GridPagerId, this.gridButtonConfig,{},{},{},{multipleSearch:true,multipleGroup:false,sopt: ["like","not like","=","!="]}
	);

	$("#"+this.GridId).jqGrid('navGrid', '#'+this.GridPagerId).jqGrid('navButtonAdd', '#'+this.GridPagerId, this.excelButtonConfig);

}
myJqGrid.prototype.freezeGridCol = function(){
	$("#"+this.GridId).jqGrid('setFrozenColumns');

}
myJqGrid.prototype.setGridSize = function(){
	var _this = this;
	var winHeight = $(window).height();
	var gridWidth = $("#" + _this.GridFormId).width();
	var gridHeight = winHeight - _this.heightDelta;
	if(gridHeight < 100){
		gridHeight = 100;
	}
	$("#"+_this.GridId).setGridWidth(gridWidth, false);
	$("#"+_this.GridId).setGridHeight(gridHeight);

}
myJqGrid.prototype.gridResize = function(){
	var _this = this;
	$(window).bind('resize', function (){
		$(window).unbind("onresize");
		_this.setGridSize();
		$(window).bind("onresize", this);
	});

}
myJqGrid.prototype.removeGridResize = function(){
	$(window).unbind('resize');

}
myJqGrid.prototype.getSelRowIds = function(){
	var _this = this;
	return getSelectedRows(_this.GridId);

}

myJqGrid.prototype.hideCols = function(colNameArray){
	var _this = this;
	$("#"+_this.GridId).setGridParam().hideCol(colNameArray);

}

function setGridsSize(op) {
	var formId = "jqgridForm";
	if(op.formId){
		formId = op.formId;
	}
	$("table[rel="+formId+"]").each(function() {
		var rel = $(this).attr("rel");
		var heightPercent = $(this).data("height");
		if (rel) {
		  var winHeight = $(window).height();
		  var gridWidth = $("#" + rel).width();
		  var gridHeight = winHeight - op.heightDelta;
		  if(heightPercent != undefined){
			gridHeight = gridHeight*parseInt(heightPercent)/100;
		  }
		  if(gridHeight < 100){
			gridHeight = 100;
		  }
		  $(this).setGridWidth(gridWidth-1, false);
		  $(this).setGridHeight(gridHeight);
		}
	});
}
function resizeGrids(op) {
	var formId = "jqgridForm";
	if(op.formId){
		formId = op.formId;
	}
	$(window).bind('resize', function (){
		$(window).unbind("onresize");
		setGridsSize(op);
		$(window).bind("onresize", this);
	});

}
//分页的数据，Page 当前位置是什么
function fullTextSearch(jqGridID, postDataArray){

	var grid = $("#"+jqGridID);
	var _postData=grid.getGridParam("postData");
	$.each(postDataArray, function (k, v) { 
		_postData[k] =  $.trim(v);
	});
	grid.jqGrid('setGridParam',{
        page:$("#input_jqGridPager").find("input").val(),
		postData: _postData
	}).trigger("reloadGrid");

}

function relodThisPage(jqGridID){
	var grid = $("#"+jqGridID);
	var p=grid.jqGrid('getGridParam','page');//获取当前页
	grid.jqGrid('setGridParam',{
        page:p
	}).trigger("reloadGrid");

}
function getSelectedRows(jqGridID, idType) {
	var grid = $("#"+jqGridID);
	var opStr = "";
	var rowKey = grid.getGridParam("selrow");
	var selectedIDs = grid.getGridParam("selarrrow");
	var reIDs="";
	
	idType = idType || "num";
	if(idType == "num"){
		opStr = "";
	}else if(idType == "str"){
		opStr = "'";
	}
	if (rowKey){
		if(selectedIDs.length){
			var result = "";
			for (var i = 0; i < selectedIDs.length; i++) {
				if(i == 0)
					result += opStr+selectedIDs[i]+opStr;
				else
					result += "," + opStr+selectedIDs[i]+opStr;
			}
			//alert(result);
			reIDs = result;
		}else{
			//alert(rowKey);
			reIDs = rowKey;
		}
	}
	//alert(reIDs);
	return reIDs;

}

function isMultiIDs(IDs)
{
	if(IDs.indexOf(",") >= 0)
		return true;
	else
		return false;
	
}

function isIDsHaveID(IDs)
{

	var IDsArray = new Array();
	IDsArray = IDs.split(",");
	for(var i=0; i<IDsArray.length; i++){
		if(IDsArray[i] != "")
			return true;
	}
	return false;
}
function isIDsHaveNull(IDs){
	if(IDs.indexOf(",,") >= 0)
		return true;
	else
		return false;

}

function checkIDsNumbers(IDs, MaxIDscount)
{
	var IDsArray = new Array();
	IDsArray = IDs.split(",");
	if(IDsArray.length > MaxIDscount){
		alert("选择超过了最多"+MaxIDscount+"行的限制！");
		return false;
	}
	
	return true;	
}
//获取多选ID的最后一个
function getLastMultiIDs(jqGridID){
		var lastId="";
		//--获取表格最后被选中得ID
		lastId=$("#"+jqGridID).getGridParam("selrow");
		$("#"+lastId).find("td").addClass("SelectBG");
		$("#"+jqGridID).on("click", 'tr[role="row"]', function() {
			$("#"+lastId).find("td").removeClass("SelectBG");
})
		return lastId;
};
/*function rowEdit(){
	alert("edit!");
}*/

//小区稽核状态单元格字体加颜色
function AuditStateCellColor(rowId, val, rawObject, cm, rdata){
		var styleStr = "";
		
		if(val == "稽核异常"){
			styleStr = "style='color:red;'";
		}
		
		return styleStr;
};

//缴费单状态单元格字体加颜色
function BillStateCellColor(rowId, val, rawObject, cm, rdata){
		var styleStr = "";
		
		if(val == "出单"){
			styleStr = "style='color:green;'";
		}else if(val == "已缴"){
			styleStr = "style='color:blue;'";
		}else if(val == "完成"){
			styleStr = "style='color:gray;'";
		}else{
			styleStr = "style='color:red;'";
		}
		
		return styleStr;
};
//欠费单元格字体加颜色
function arrearageCellColor(rowId, val, rawObject, cm, rdata){
	var styleStr = "";
	
	if(val > 0){
		styleStr = "style='color:red;'";
	}
	
	return styleStr;
}
//账户余额单元格字体加颜色
function remainingSumCellColor(rowId, val, rawObject, cm, rdata){
	var styleStr = "";
	
	if(val > 0){
		styleStr = "style='color:green;'";
	}else if(val < 0){
		styleStr = "style='color:red;'";
	}
	
	return styleStr;
}
//命令状态单元格字体加颜色
function CmdStateCellColor(rowId, val, rawObject, cm, rdata){
		var styleStr = "";
		if(val == "失败"){
			styleStr = "style='color:red;'";
		}else if(val == "完成"){
			styleStr = "style='color:green;'";
		}else if(val == "待执行"){
			styleStr = "style='color:gold;'";
		}
		return styleStr;
};

//设备状态单元格字体加颜色
function deviceStateCellColor(rowId, val, rawObject, cm, rdata){
		var styleStr = "";
		if(val=="断开" || val=="断线" || val=="离线"){
			styleStr = "style='color:red;'";
		}else if(val=="连接" || val=="联机" || val=="在线"){
			styleStr = "style='color:green;'";
		}
		return styleStr;
};
//读入表数量与实际表数量比较，不一致加颜色
function compareMetersCellColor(rowId, val, rawObject, cm, rdata){
		var styleStr = "";

		if(Number(rdata["读入表数"]) < Number(rdata["总表数"])){
			styleStr = "style='color:red;'";
		}else if(Number(rdata["读入表数"]) > Number(rdata["总表数"])){
			styleStr = "style='color:#FF9900;'";
		}

		return styleStr;
};
//大于零单元格加颜色
function greatThen0CellColor(rowId, val, rawObject, cm, rdata){
	var styleStr = "";
		if(Number(val)>0){	
			styleStr = "style='color:red;'";
		}

		return styleStr;
	
}
//采集器通讯状态单元格加颜色
function collectorStateCellColor(rowId, val, rawObject, cm, rdata){
		var styleStr = "";

		if(val.indexOf("EE")>=0 || val.indexOf("0")>=0){
			styleStr = "style='color:red;'";
		}else if(val.indexOf("2")>=0 || val.indexOf("4")>=0 || val.indexOf("8")>=0){
			styleStr = "style='color:green;'";
		}

		return styleStr;
};
//档案状态单元格字体加颜色
function ArchiveStateCellColor(rowId, val, rawObject, cm, rdata){
		var styleStr = "";
		if(val == "一致"){
			styleStr = "style='color:green;'";
		}else{
			styleStr = "style='color:red;'";
		}
		
		return styleStr;
};
//抄表资料状态单元格字体加颜色
function MeterDataStateCellColor(rowId, val, rawObject, cm, rdata){
		var styleStr = "";
		
		if(val == "无资料"){
			styleStr = "style='color:Orange;'";
		}else{
			styleStr = "style='color:red;'";
		}
		
		return styleStr;
};
//表状态单元格字体加颜色
function MeterStateCellColor(rowId, val, rawObject, cm, rdata){
	var styleStr = "";
	if(val != "正常" && val != "月结"){
		switch(val){
			case "正确":
				styleStr = "style='color:Green;'";//绿色正确
				break;
			case "关阀":
				styleStr = "style='color:DimGray;'";//暗灰关阀
				break;
			case "建档":
			case "已更换":
			case "集中器无返回":
			case "采集器无返回":
				styleStr = "style='color:#FF9900;'";//橙色警告
				break;
			default:
				styleStr = "style='color:red;font-weight:800;'";//红色警告
				break;
		}
	}
	
	return styleStr;
}
//表状态行加背景色
function MeterStateRowColor(jqGridID, colName){
	var grid = $("#"+jqGridID);
	var ids = grid.getDataIDs();
	var rowData = "";

	for(var i=0;i < ids.length; i++)
	{
		rowData = grid.getRowData(ids[i]);
		
		if(rowData[colName] && rowData[colName] != "正常" && rowData[colName] != "正确"){
			//alert(rowData[colName]+"正常");
			if(rowData[colName].indexOf("用量异常") >= 0){
				continue;
			}
			switch(rowData[colName])
			{
				case "关阀":
					$("#"+ids[i]).find("td").css("background-color","Silver");//银灰关阀
					break;
				case "建档":
					break;
				case "修改":
					break;
				case "已更换":
					break;
				case "集中器无返回":
					break;
				case "采集器无返回":
					break;
				case "月结":
					break;
				default:
					$("#"+ids[i]).find("td").css("background-color","pink");//表异常状态粉红警告
					break;
			}
		}
	}
} 
//配置参数修改时间字体加颜色
function editTimeCellColor(rowId, val, rawObject, cm, rdata){
	var styleStr = "";
	var date = new Date();
	
	var diffDays = (date.getTime() - Date.parse(val))/(24 * 3600 * 1000);
	//alert(diffDays);
	
	if(diffDays < 1){
		styleStr = "style='color:red;'";
	}else if(diffDays < 7){
		styleStr = "style='color:LightPink;'";
	}

	return styleStr;
}
//导入用户档案校验结果单元格字体加颜色
function metersReplaceCellColor(rowId, val, rawObject, cm, rdata){
	var styleStr = "";
	switch(val){
		case "新增":
			styleStr = "style='color:blue;'";
			break;
		case "待更换":
		case "修改":
			styleStr = "style='color:Green;'";
			break;
		default:
			styleStr = "style='color:red;font-weight:800;'";
			break;
	}

	
	return styleStr;
}
//导入档案校验结果单元格字体加颜色
function importCheckCellColor(rowId, val, rawObject, cm, rdata){
	var styleStr = "";
	switch(val){
		case "新增":
			styleStr = "style='color:blue;'";
			break;
		case "待更换":
		case "待导入":
		case "修改":
			styleStr = "style='color:Green;'";
			break;
		default:
			styleStr = "style='color:red;font-weight:800;'";
			break;
	}


	return styleStr;
}
//导入用户档案校验结果单元格字体加颜色
function usersInfoCellColor(rowId, val, rawObject, cm, rdata){
	var styleStr = "";
	_val = val.substr(0, 2);
	switch(_val){
		case "新增":
			styleStr = "style='color:blue;'";
			break;
		case "待更换":
		case "修改":
			styleStr = "style='color:Green;'";
			break;
		default:
			styleStr = "style='color:red;font-weight:800;'";
			break;
	}

	
	return styleStr;
}

//操作员账号状态单元格字体加颜色
function operatorStateCellColor(rowId, val, rawObject, cm, rdata){
	var styleStr = "";
	switch(val){
		case "启用":
			styleStr = "style='color:Green;'";
			break;
		default:
			styleStr = "style='color:red;'";
			break;
	}
	
	return styleStr;
}
//用户账单操作类型单元格字体加颜色
function CustBillOptCellColor(rowId, val, rawObject, cm, rdata){
	var styleStr = "";
	switch(val){
		case "收费":
			styleStr = "style='color:Green;'";
			break;
		case "退费":
		case "减免":
		case "恢复收费":
			styleStr = "style='color:Orange;'";
			break;
		default:
			styleStr = "style='color:red;'";
			break;
	}
	
	return styleStr;
}

(function ($) {
	$.extend({
		ktamr: {
			exportToExcel: function(url,GridId){
				var grid = $("#"+GridId);
				$.ktamr.loading("正在导出数据，请稍后...");
				url = url.substring(0,url.lastIndexOf("/"));
				var reg=/[\u4E00-\u9FA5]/;
				var pdArray =grid.jqGrid("getGridParam", "postData");
				var colModel = grid.jqGrid("getGridParam", "colModel");
				var colNames = grid.jqGrid("getGridParam", "colNames");
				var excelLabel = new Array();
				var excelName = new Array();
				var excelWidth = new Array();
				var excelDataFormat = new Array();
				var excelAlign = new Array();
				for(var i = 0;i<colModel.length;i++){
					if(!colModel[i].hidden) {
						if (colNames != null && reg.exec(colNames[i]) && colNames[i] != "操作" && colNames[i] != "操作结果") {
							excelLabel.push(colNames[i]);
							excelWidth.push(colModel[i].width)
							excelName.push(colModel[i].name);
						}
						if (colNames == null && reg.exec(colModel[i].label) && !reg.exec(colModel[i].name) && colNames[i] != "操作" && colNames[i] != "操作结果") {
							excelLabel.push(colModel[i].label);
							excelWidth.push(colModel[i].width);
							excelName.push(colModel[i].name);
						}
						if (colModel[i].align != undefined && reg.exec(colNames[i]) && colNames[i] != "操作" && colNames[i] != "操作结果") {
							excelAlign.push(colModel[i].align);
						} else if (colModel[i].align == undefined && reg.exec(colNames[i]) && colNames[i] != "操作" && colNames[i] != "操作结果") {
							excelAlign.push("left");
						}
						if (colModel[i].dataFormat != undefined) {
							excelDataFormat.push(colModel[i].dataFormat);
						}
					}
				}
				pdArray['excelLabel'] = excelLabel;
				pdArray['excelWidth'] = excelWidth;
				pdArray['excelName'] = excelName;
				pdArray['excelDataFormat'] = excelDataFormat;
				pdArray['excelAlign'] = excelAlign;
				$.ajax({
					url:url+"/export",
					type: "POST",
					traditional :true,
					data:pdArray,
					success:function(result){
						if (result.code == web_status.SUCCESS) {
							var url = ctx + "common/download?fileName=" + encodeURI(result.msg) + "&delete=" + true;
							window.location.href = ctx + "common/download?fileName=" + encodeURI(result.msg) + "&delete=" + true;
						}else{
							$.ktamr.alert(result.msg,modal_status.FAIL);
						}
						$.ktamr.closeloading();
					}
				});
			},
			exportTxtDbf: function(pUrl, pData){
				var grid = $("#jqGrid");
				var colModel = grid.jqGrid("getGridParam", "colModel");
				var nameArray = new Array();
				for(var i = 0;i<colModel.length;i++){
					var name = colModel[i].name;
					var hidden = colModel[i].hidden;
					if(name != "rn" && name != "cb" && !hidden){
						nameArray.push(name);
					}
				}
				pData["name"]=nameArray;
				$.ktamr.loading("正在导出数据，请稍后...");
				$.post(pUrl,pData,function(data){
						if(data.code == "0"){
							window.location.href = ctx + "common/download?fileName=" + encodeURI(data.msg)+"&delete="+true;
						}else{
							$.ktamr.alert(result.msg,modal_status.FAIL);
						}
						$.ktamr.closeloading();
				});
			},
			exportCustomExcel: function(pUrl, pData){
				$.ktamr.loading("正在导出数据，请稍后...");
				$.post(pUrl,pData,function(data){
					if(data.code == "0"){
						window.location.href = ctx + "common/download?fileName=" + encodeURI(data.msg)+"&delete="+true;
					}else{
						$.ktamr.alert(result.msg,modal_status.FAIL);
					}
					$.ktamr.closeloading();
				});
			},
			loading: function (message) {
				$.blockUI({message: '<div class="loaderbox"><div class="loading-activity"></div> ' + message + '</div>'});
			},
			closeloading: function () {
				setTimeout(function () {
					$.unblockUI();
				}, 50);
			},
			alert: function (content, type) {
				layer.alert(content, {
					icon: type,
					title: "系统提示",
					btn: ['确认'],
					btnclass: ['btn btn-primary'],
				});
			}
		}
	});
})(jQuery);

/** 消息状态码 */
web_status = {
	SUCCESS: 0,
	FAIL: 500
};

/** 弹窗状态码 */
modal_status = {
	SUCCESS: "success",
	FAIL: "error",
	WARNING: "warning"
};















