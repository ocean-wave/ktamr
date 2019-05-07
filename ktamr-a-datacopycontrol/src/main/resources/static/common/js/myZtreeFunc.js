//@author fengjing
/**
 function reAsyncChildNodes
 *强行异步加载父节点的子节点,已经加载过的父节点可反复使用此方法重新加载,需要通过ztree对象使用该方法
 *@param parentNode：指定需要异步加载的父节点 JSON数据
 （1、parentNode = null 时，相当于从根节点 Root 进行异步加载
 2、parentNode.isParent = false 时，不进行异步加载）
 *@param reloadType：eloadType = "refresh" 表示清空后重新加载。reloadType != "refresh" 时，表示追加子节点处理。
 *@param isSilent:设定异步加载后是否自动展开父节点。isSilent = true 时，不展开父节点，其他值或缺省状态都自动展开
 */

var myzTree = function(treeId, option) {
	var _this = this;
	this.treeId = treeId;
	this.zNodes = "";
	this.url = option.url;
	this.nodeTypeId = option.nodeTypeId;
	this.nodeIdsId = option.nodeIdsId;
	this.nodeNamesId = option.nodeNamesId;
	if(option.deviceDescriptionId){
		this.deviceDescriptionId = option.deviceDescriptionId;
	}

	this.lastValue = "";
	this.clickCount = 0;
	this.nodeList = [];
	this.fontCss = {};
	if(option.treeFormClass){
		this.treeFormClass = option.treeFormClass;
	}else{
		this.treeFormClass = "my-tree-class"
	}
	if(option.inputSelId){
		this.inputSelId = option.inputSelId
	}else{
		this.inputSelId = "areaSel"
	}
	if(option.menuId){
		this.menuId = option.menuId;
	}else{
		this.menuId = "menuContent"
	}
	if(option.postData){
		this.postData = option.postData;
	}
	this.setting = {
		view: {
			dblClickExpand: true,
			selectedMulti: option.selectedMulti,
			autoCancelSelected: true,
			fontCss: _this.getFontCss
		}
		,callback: {
			//beforeClick: beforeClick,
			onClick: function zTreeOnClick(event, treeId, treeNode) {
				//console.log(treeNode.tId + "," + treeNode.name);
				//console.log(treeNode.id +","+treeNode.LevelType);
				//console.log(_this.clickCallBack);
				_this.getMultiSelectedNodes();
				if(option.clickCallBack){
					option.clickCallBack();
				}
			}
			//,onDblClick: onDblClick
		}
		,async: {
			enable: true
			,url: option.url
			,type: "get"
			,contentType: "application/x-www-form-urlencoded"
			,dataType: "text"
			,autoParam:["id=id", "name=n", "level=lv"]
			,otherParam: _this.postData
			,dataFilter: _this.filter
		}
	};
	$.fn.zTree.init($("#"+this.treeId), this.setting);
};

//设置颜色
myzTree.prototype.getFontCss = function(treeId, treeNode) {
	return (!!treeNode.highlight) ? {color:"#A60000", "font-weight":"bold"} : {color:"#333", "font-weight":"normal"};
}

myzTree.prototype.refreshParentNode = function()
{
	var treeNode="", reloadType="", isSilent="", treeObj=$.fn.zTree.getZTreeObj(this.treeId);
	treeNode = null;
	reloadType = "refresh";
	isSilent = false;
	nodes = treeObj.getSelectedNodes();
	if (nodes.length == 0) {
		treeObj.reAsyncChildNodes(null, reloadType, isSilent);
		return true;
	}
	for (var i=0, l=nodes.length; i<l; i++) {
		treeNode = nodes[i];//此参数为选中的父节点，刷新下属的所有子节点
		treeObj.reAsyncChildNodes(treeNode, reloadType, isSilent);
	}
	//alert("refreshZtree");
}

myzTree.prototype.reloadZtreeNodes = function(){
	var _this = this;
	$.ajax({
		type: "POST",
		url: _this.url,
		data: _this.postData,
		dataType: "text",
		async:false,
		success: function(data){
			var nodes = eval('(' + data + ')');
			//console.log("data:",nodes);
			$.fn.zTree.init($("#"+_this.treeId), _this.setting, nodes);
		}
	});
}

myzTree.prototype.filter = function(treeId, parentNode, childNodes){
	if (!childNodes){
		return null;
	}
	for (var i=0, l=childNodes.length; i<l; i++) {
		childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
	}
	return childNodes;
}

myzTree.prototype.dropDownTreeOpen = function() {
	var _this = this;
	var $dropdownDiv = $('.'+this.treeFormClass);
	$dropdownDiv.mouseenter(function() {
		_this.showMenu();
	}).mouseleave(function() {
		_this.hideMenu();
	});
}
//注册关闭下拉树的事件
myzTree.prototype.onBodyDown = function(event) {
	var _this = this;
	if (!(event.target.id == _this.inputSelId ||  event.target.id == _this.menuId || $(event.target).parents("#"+_this.menuId).length>0)) {
		_this.hideMenu();
	}
}
//显示下拉树
myzTree.prototype.showMenu = function() {
	var _this = this;
	$("#"+_this.menuId).stop(true).slideDown("fast");
	//$("body").bind("mousedown", _this.onBodyDown);
}

//隐藏下拉树
myzTree.prototype.hideMenu = function() {
	var _this = this;
	$("#"+_this.menuId).stop(true).slideUp("fast");
	//$("body").unbind("mousedown", _this.onBodyDown);
}

//键盘释放：当输入框的键盘按键被松开时，把查询到的数据结果显示在标签中
myzTree.prototype.callNumber = function(){
	var _this = this;
	var treeObj = $.fn.zTree.getZTreeObj(_this.treeId);

	//如果结果有值，则显示比例；如果结果为0，则显示"[0/0]"；如果结果为空，则清空标签框；
	if(_this.nodeList.length){
		//让结果集里边的第一个获取焦点（主要为了设置背景色），再把焦点返回给搜索框
		treeObj.selectNode(_this.nodeList[0], false);
		$("#"+_this.keyId).focus();

		_this.clickCount=1; //防止重新输入的搜索信息的时候，没有清空上一次记录

		//显示当前所在的是第一条
		$("#"+_this.numId).html("["+_this.clickCount+"/"+_this.nodeList.length+"]");

	}else if(_this.nodeList.length == 0){
		$("#"+_this.numId).html("[0/0]");
		treeObj.cancelSelectedNode(); //取消焦点
	}

	//如果输入框中没有搜索内容，则清空标签框
	if($("#"+_this.keyId).val() == ""){
		$("#"+_this.numId).html("");
		treeObj.cancelSelectedNode();
	}
}
myzTree.prototype.focusKey = function(e) {
	var key = $("#"+this.keyId);
	if (key.hasClass("empty")) {
		key.removeClass("empty");
	}
}
myzTree.prototype.blurKey = function(e) {
	var key = $("#"+this.keyId);
	if (key.get(0).value === "") {
		key.addClass("empty");
	}
}
//高亮显示被搜索到的节点
myzTree.prototype.updateNodes = function(highlight) {
	var _this = this;
	var treeObj = $.fn.zTree.getZTreeObj(_this.treeId);
	for( var i=0, l=_this.nodeList.length; i<l; i++) {
		_this.nodeList[i].highlight = highlight; //高亮显示搜索到的节点(highlight是自己设置的一个属性)
		if(highlight == true){
			treeObj.expandNode(_this.nodeList[i].getParentNode(), true, false, false); //将搜索到的节点的父节点展开
		}else{
			treeObj.expandNode(_this.nodeList[i].getParentNode(), false, false, false); //将搜索到的节点的父节点展开
		}
		treeObj.updateNode(_this.nodeList[i]); //更新节点数据，主要用于该节点显示属性的更新
	}
}
//搜索节点
myzTree.prototype.searchNode = function(e) {
	var _this = this, key = $("#"+_this.keyId);
	var treeObj = $.fn.zTree.getZTreeObj(_this.treeId);
	var value = $.trim(key.get(0).value);
	var keyType = "name";
	if (key.hasClass("empty")) {
		value = "";
	}
	if (_this.lastValue === value){
		return;
	}
	_this.lastValue = value;
	_this.updateNodes(false);
	if (value === ""){
		_this.nodeList = [];
		return;
	};
	_this.nodeList = treeObj.getNodesByParamFuzzy(keyType, value); //调用ztree的模糊查询功能，得到符合条件的节点
	_this.updateNodes(true); //更新节点
}

//点击向上按钮时，将焦点移向上一条数据
myzTree.prototype.clickUp = function(){
	var _this = this;
	var treeObj = $.fn.zTree.getZTreeObj(_this.treeId);
	//如果焦点已经移动到了最后一条数据上，就返回第一条重新开始，否则继续移动到下一条
	if(_this.nodeList.length == 0){
		alert("没有搜索结果！");
		return ;
	}else if(_this.clickCount==1){
		alert("您已位于第一条记录上！");
		return;
		//让结果集里边的下一个节点获取焦点（主要为了设置背景色），再把焦点返回给搜索框
		//treeObj.selectNode(_this.nodeList[_this.clickCount], false)
	}else{
		//让结果集里边的第一个获取焦点（主要为了设置背景色），再把焦点返回给搜索框
		_this.clickCount --;
		treeObj.selectNode(_this.nodeList[_this.clickCount - 1], false);
	}
	$("#"+_this.keyId).focus();
	//显示当前所在的是条数
	$("#"+_this.numId).html("[" + _this.clickCount + "/" + _this.nodeList.length + "]");
}
//点击向上按钮时，将焦点移向下一条数据
myzTree.prototype.clickDown = function(){
	var _this = this;
	var treeObj = $.fn.zTree.getZTreeObj(_this.treeId);
	//如果焦点已经移动到了最后一条数据上，则提示用户（或者返回第一条重新开始），否则继续移动到下一条
	if(_this.nodeList.length==0){
		alert("没有搜索结果！");
		return ;
	}else if(_this.nodeList.length==_this.clickCount){
		alert("您已位于最后一条记录上！");
		return;
	}else{
		//让结果集里边的第一个获取焦点（主要为了设置背景色），再把焦点返回给搜索框
		_this.clickCount ++;
		treeObj.selectNode(_this.nodeList[_this.clickCount - 1], false);
	}
	$("#"+_this.keyId).focus();
	//显示当前所在的条数
	$("#"+_this.numId).html("[" + _this.clickCount + "/" + _this.nodeList.length + "]");
}

myzTree.prototype.fuzzySearch = function(keyId, clickUpId, clickDownId, numId){
	var _this = this;
	//fuzzySearch(_this.treeId, '#'+keyId, true, false); //初始化模糊搜索方法
	_this.keyId = keyId;
	_this.clickUpId = clickUpId;
	_this.clickDownId = clickDownId;
	_this.numId = numId;
	$("#"+keyId).val(""); //清空搜索框中的内容
	//绑定事件
	var key = $("#"+keyId);
	key.bind("focus", _this.focusKey.bind(_this))
		.bind("blur", _this.blurKey.bind(_this))
		.bind("propertychange", _this.searchNode.bind(_this)) //property(属性)change(改变)的时候，触发事件(包括剪切和粘贴)
		.bind("input", _this.searchNode.bind(_this));
	key.bind("keyup", _this.callNumber.bind(_this));
	$("#"+clickUpId).bind("click", _this.clickUp.bind(_this));
	$("#"+clickDownId).bind("click", _this.clickDown.bind(_this));
}

myzTree.prototype.getMultiSelectedNodes = function(){
	var treeObj=$.fn.zTree.getZTreeObj(this.treeId),
		nodes=treeObj.getSelectedNodes(),
		ids = "", names = "", levelType = "", _nodes= Array();

	if(nodes.length <= 1){
		$("#"+this.nodeTypeId).val(nodes[0].LevelType);
		$("#"+this.nodeIdsId).val(nodes[0].id);
		$("#"+this.nodeNamesId).val(nodes[0].name.replace(/<[^>]*>|/g,""));
		if(nodes[0].LevelType == "centor" || nodes[0].LevelType == "ccentor" || nodes[0].LevelType == "readLine"){
			$("#"+this.deviceDescriptionId).val(nodes[0].description);
		}
		return null;
	}
	for(var i=0;i<nodes.length;i++){
		if(nodes[i].LevelType == "allRgn"){
			levelType = "allRgn";
			_nodes.push(nodes[i]);
			break;
		}else if(nodes[i].LevelType == "allArea"){
			levelType = "allArea";
			_nodes.push(nodes[i]);
			break;
		}else if(nodes[i].LevelType == "allMeter"){
			levelType = "allMeter";
			_nodes.push(nodes[i]);
			break;
		}
	}
	if(levelType == "allRgn" || levelType == "allArea" || levelType == "allMeter"){
		nodes = _nodes;
	}else{
		for(var i=0;i<nodes.length;i++){
			if(nodes[i].LevelType == "rgn"){
				levelType = "rgn";
				_nodes.push(nodes[i]);
			}
		}
		if(levelType == "rgn"){
			nodes = _nodes;
		}else{
			for(var i=0;i<nodes.length;i++){
				if(nodes[i].LevelType == "area"){
					levelType = "area";
					_nodes.push(nodes[i]);
				}
			}
			if(levelType == "area"){
				nodes = _nodes;
			}
		}
	}
	for(var i=0;i<nodes.length;i++){
		if(i<nodes.length-1){
			ids+=nodes[i].id+",";
			names+=nodes[i].name+",";
		}else{
			ids+=nodes[i].id;
			names+=nodes[i].name;
		}
	}
	//console.log("节点id:"+ids+",节点名称:"+names+",levelType:"+levelType); //获取选中节点的值
	$("#"+this.nodeTypeId).val(levelType);
	$("#"+this.nodeIdsId).val(ids);
	$("#"+this.nodeNamesId).val(names.replace(/<[^>]*>|/g,""));
}
//$(function () {
/*$.ajax({
    url: '../client_trans/getNodes.asp',
    type: 'POST',
    dataType : "json",
    data: {id: ""},
    async: false,
    success: function (data) {
        var d = $.parseJSON(data);
        zNodes = d;
    }
});*/
//初始化下拉树
/*$.fn.zTree.init($("#areaTree"), setting);
dropDownTreeOpen();
fuzzySearch('areaTree', '#zTreeKey', null, false); //初始化模糊搜索方法
gridChange("allRgn", "");*/
//});
