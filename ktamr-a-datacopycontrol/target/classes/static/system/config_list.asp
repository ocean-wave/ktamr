<%@ Language=VBScript CodePage="65001"%>
<% response.expires = 0 %>
<!--#INCLUDE FILE="../checkright.asp"-->
<!-- #include file="../common/page_header.asp" -->
<%
CheckGeneralLevel

Dim sTitle

pageTitle = "系统参数配置"
writePageHeader pageTitle
%>
</head>
<body class="myPage-body">
<div class="container myContainer">
	<div class="row" style="margin:0;padding:5px 0px 5px 0px;">
		<div class="col-xs-2 my-form-col">		
			<input class="input-sm form-control" type="text" id="keyWord" size="10" placeholder="请输入关键字">
		</div>
		<div class="col-xs-2 my-form-col">
				<button data-modal="" data-title="查询" class="layui-btn layui-btn-normal layui-btn-sm search"><span class="glyphicon glyphicon-search"></span> 查询</button>		
		</div>
		<div class="my-btns pull-right" style="display:block;">
			<%If operator_level_code() = "" Then%>
			<button data-modal="" data-title="停止服务" class="layui-btn layui-btn-sm"><span class="glyphicon glyphicon-stop"></span> 停止服务</button>		
			<button data-modal="" data-title="启动服务" class="layui-btn layui-btn-sm"><span class="glyphicon glyphicon-play"></span> 启动服务</button>
			<% End IF%>
		</div>
	</div>
	<div class="row my-form-no-edge">
		<div class="col-md-12 my-form-no-edge">
			<form class="form-horizontal" id="jqgridForm" role="form">
			<table id="jqGrid" rel="jqgridForm" class="jqgrid"></table>
			<div id="jqGridPager"></div>
			</form>
		</div>
	</div>
</div>
<script language="JavaScript">
layui.use(['layer','form'], function(){
	var layer = layui.layer;
	var Post_Data = {ListNumber: 30, colKey: "pos"};
	var GridObj = new myJqGrid("jqGrid", "jqGridPager", "jqgridForm", 114);
	//GridObj.jqdefaultGridConfig.caption = "配置参数列表：";
	GridObj.jqdefaultGridConfig.editurl = '/client_trans/RowEditing.asp?OpNumber=1';
	GridObj.jqdefaultGridConfig.multiselect = false;
	GridObj.jqdefaultGridConfig.postData = Post_Data;
	GridObj.jqdefaultGridConfig.colNames = ['','显示顺序','配置类别','配置项','配置名称','配置值','修改时间','修改人'];
	GridObj.jqdefaultGridConfig.colModel = [
		{ name: 'myac', width:80, fixed:true, sortable:false, resize:false, formatter:"actions",
			formatoptions:{
				keys:true,
				delbutton:true,
				editbutton:true
	　　　　				//delOptions: { recreateForm: true, beforeShowForm: beforeDeleteCallback }
	　　　　				//formatter:"actionFormatter"
				
			}
		},
		{ name: 'pos', index: 'pos', width: 75, key: true, hidden: false, editable : true},
		{ name: 's', index: 's', width: 100, sortable:false ,editable : true},//, edittype : "select",editoptions : {value : "系统参数:系统参数;KT410集中器:KT410集中器"} 
		{ name: 'k', index: 'k', width: 120, sortable:false ,editable : true },
		{ name: 'kName', index: 'kName', width: 120, sortable:false ,editable : true },
		{ name: 'v', index: 'v', width: 200, sortable:false ,editable : true },
		{ name: 'lasttime', index: 'lasttime',width: 120 , sortable:false, cellattr:editTimeCellColor },
		{ name: 'uid', index: 'uid',width: 100, sortable:false  }
	];
	GridObj.jqdefaultGridConfig.grouping = true; 
	GridObj.jqdefaultGridConfig.groupingView = {
		groupField : ['s'],
		groupColumnShow : [true],
		groupText : ['<b>{0} - {1} 项</b>'],
		groupCollapse : false,
		groupOrder: ['desc']
	};
	GridObj.jqdefaultGridConfig.gridButtonConfig = {
		del:false
		,add:true
		,edit:false
	};	
	GridObj.drawGrid();
	//GridObj.drawGridPager();
	$("#jqGrid").jqGrid('navGrid', '#jqGridPager', {
		del:false
		,add:true
		,edit:false
	},{},{},{},{multipleSearch:true,multipleGroup:false,sopt: ["cn","nc","eq","ne"]});
	GridObj.setGridSize();
	GridObj.gridResize();
	GridObj = null;
	
	$("#jqGrid").jqGrid('saveRow',  {
		successfunc: function (response) {
			if(response.responseText == "true"){
				layer.msg("表数据录入成功！", {icon: 1});
			}else
				layer.msg(response.responseText, {icon: 5});
		}
	});
	$(document).keydown(function(event){
		if(event.keyCode==13){
			$(".search").click();
		}
	}); 
	$(".search").click(function(){
		var  _pdArray = "";
		_pdArray = {
			"keyWord": $("#keyWord").val()
		};
		fullTextSearch("jqGrid", _pdArray);
	});

	function submitInfo(getResultUrl, sendData){
      $.ajax({
        url: getResultUrl
        ,data: sendData
		,type: "POST"
		,contentType:'application/x-www-form-urlencoded; charset=UTF-8'
        ,async:false //同步请求
        ,success: function(data){
		  layer.close(loadingIndex);  
          if(data == ""){
			layer.msg("操作成功！", {icon: 1});
          }else{
			layer.msg(data, {icon: 5});
          }
        }
      });
    }
	var loadingIndex = "";
	$(".layui-btn-primary, .layui-btn").click(function(){
		var btnTitle = $(this).data("title"), op ="";
		if (btnTitle == "查询"){
			return false;
		}
		switch(btnTitle){
			case "停止服务":
				var sendData = {
					op: "stop"
				};
				layer.confirm('确定停止后台服务吗？', {icon:3, title:'提示'},
					function(index, layero){
						loadingIndex = layer.load(3, {time: 15*1000});
						submitInfo("service_op.asp", sendData);		
				});
				break ;
			case "启动服务":
				var sendData = {
					op: "start"
				};
				loadingIndex = layer.load(3, {time: 15*1000});
				submitInfo("service_op.asp", sendData);		
				break ;
			default:
				break;
		}
	});
});
</script>
</body></html>