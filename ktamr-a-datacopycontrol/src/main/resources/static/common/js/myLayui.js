layui.define(['jquery', 'layer'], function(exports) {
	var $ = layui.jquery,
        layer = layui.layer;
	myLayui = function() {
		this.options = {
			method: "GET"
		};
	};
	myLayui.prototype.showLayer = function(title, url, queryString, layerSize){
		var _title = title,
			_url, 
			_layerSize = layerSize, 
			winWidth = $(window).width(), 
			winHeight = $(window).height(), 
			layerWidth = parseInt(layerSize[0]), 
			layerHeight = parseInt(layerSize[1]);
		var _queryString = "";
		if(queryString){
			_queryString = queryString.join("&");
			_url = url+"?"+_queryString.replace(/\+/g, "%2B");//使“+”能够在服务端接收到
		}else{
			_url = url;
		}
		if(layerWidth > winWidth){
			_layerSize[0] = winWidth+'px';
		}
		if(layerHeight > winHeight){
			_layerSize[1] = winHeight+'px';
		}
		layer.open({
			type: 2
			,title: _title
			,content: [_url]
			,area: _layerSize
			,cancel: function(){ //右上角关闭回调
				return true;
			}
			,scrollbar: false
		});
	}

	myLayui.prototype.initLayerSize = function(initWidth, initHeight){
		var winWidth = $(top.window).width(), winHeight = $(top.window).height();
		var width = winWidth > initWidth ? initWidth+"px" : "100%";
		var height = winHeight > initHeight ? initHeight+"px" : "100%";
	
		return [width,height];
	}
	
	myLayui.prototype.resizeLayer = function(layerIndex,layerInitWidth,layerInitHeight){
		if(layerIndex == null || layerIndex == undefined){
			return false;
		}
		var winWidth = $(top.window).width(), winHeight = $(top.window).height();
		var minWidth = winWidth > layerInitWidth ? layerInitWidth : winWidth;
		var minHeight = winHeight > layerInitHeight ? layerInitHeight : winHeight;
		//console.log("win:",winWidth,winHeight);
		//console.log("lay:",layerInitWidth,layerInitHeight);
		//console.log("min:",minWidth,minHeight);
		top.layer.style(layerIndex, {
			width: minWidth,
			height: minHeight
		});
	}

    exports('myLayui', myLayui);
});