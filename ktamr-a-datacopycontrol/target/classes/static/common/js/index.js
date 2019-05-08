/*
 * @Author: https://github.com/WangEn
 * @Author: https://gitee.com/lovetime/
 * @Date:   2018-01-01
 * @lastModify 2018-3-27 15:00:35
 * +----------------------------------------------------------------------
 * | Weadmin [ 后台管理模板 ]
 * | 基于Layui http://www.layui.com/
 * +----------------------------------------------------------------------
 */

layui.define(['jquery', 'laytpl', 'form', 'layer', 'element', 'myLayui'], function(exports) {
	var $ = layui.jquery,
		tpl = layui.laytpl,
		form = layui.form,
		layer = layui.layer,
		myLayui = layui.myLayui,
		element = layui.element;
	var menu = [];
	var curMenu;
	var _myLayui = new myLayui;

	/**加载左侧菜单 **/
	function renderTpl(tplId, listId, data){
		var getTpl = $('#'+ tplId).html();
		tpl(getTpl).render(data, function(html){
			$('#'+listId).html(html);
		});
	}
	function getMenuAjax(tplId, listId, url){
		var l = layer.load(1);
        $.ajax({
            type: "GET",
            url: url,
            dataType: "json",
            data: '',
            cache: false,
            timeout: 10000,
            error: function(XMLHttpRequest, status, thrownError) {
                layer.close(l);
                layer.msg('网络繁忙，请稍后重试...');
                return;
            },
            success: function(ret) {
                layer.close(l);
                if (ret.status == 200) {
                    if (undefined == ret.data || "" == ret.data) {
                        return false;
                    }
					renderTpl(tplId, listId, ret.data);
                } else {
                    layer.msg('请求数据出错，请稍后再试...');
                    return;
                }
			}
		})
	}
	function reloadMenu(title){
		if(title == "数据抄收" || title == "0" || title == "1"){
			getMenuAjax("nav-tpl", "nav", "system/menu/menu1.json");
		}else if(title == "费用结算" || title == "2"){
			getMenuAjax("nav-tpl", "nav", "system/menu/menu2.json");
		}else if(title == "档案管理" || title == "3"){
			getMenuAjax("nav-tpl", "nav", "system/menu/menu3.json");
		}
	}
	function topMenuSet(menuIndex){
		$(".top-menu-pc").find("li").siblings().removeClass("layui-this");
		$(".top-menu-mobile").find("dd").siblings().removeClass("layui-this");
		if(menuIndex == "0" || menuIndex == "1"){
			$(".top-menu-pc").find("li[data-menu='ReadMeter']").addClass("layui-this");
			$(".top-menu-mobile").find("dd[data-menu='ReadMeter']").addClass("layui-this");
		}else if(menuIndex == "2"){
			$(".top-menu-pc").find("li[data-menu='FeeCalculate']").addClass("layui-this");
			$(".top-menu-mobile").find("dd[data-menu='FeeCalculate']").addClass("layui-this");
		}else if(menuIndex == "3"){
			$(".top-menu-pc").find("li[data-menu='InfoManagement']").addClass("layui-this");
			$(".top-menu-mobile").find("dd[data-menu='InfoManagement']").addClass("layui-this");
		}
		reloadMenu(menuIndex);
	}
	
	reloadMenu("数据抄收");
	
	element.on('nav(mobile-left-nav)', function(elem){
		var menu_title = elem.find('cite').html();
		reloadMenu(menu_title);
		$('body').removeClass('site-mobile');
        $(".site-mobile-shade").removeClass('layui-hide');
	});
	element.on('nav(pc-left-nav)', function(elem){
		var menu_title = elem.find('cite').html();
		reloadMenu(menu_title);
	});

	/*
	 *Tab加载后刷新
	 * 判断是刷新后第一次点击时，刷新frame子页面
	 * */
	window.reloadTab = function(which){
		var len = $('.layui-tab-title').children('li').length;
		var layId = $(which).attr('lay-id');
		var i=1;	   
		if($(which).attr('data-bit') == 0){
			$(which).attr('data-bit',i);  	
			var frame = $('.weIframe[tab-id='+layId+']');
			frame.attr('src', frame.attr('src'));
			//console.log("reload:"+$(which).attr('data-bit'));
		}else{
			return false; //判断页面打开后第一次点击，执行刷新
		} 
    }
	/**
	 *@todo Frame内部的按钮点击打开其他frame的tab
	 */
	/*
	 * @todo 初始化加载完成执行方法
	 * 打开或刷新后执行
	 */
	$(function() {
		/*
		 * @todo 读取本地存储中记录的已打开的tab项
		 * 刷新后，读取记录，打开原来已打开的tab项
		 */

		/*
		 * @todo table事件
		 */
		tableCheck = {
			init: function() {
				$(".layui-form-checkbox").click(function(event) {
					if($(this).hasClass('layui-form-checked')) {
						$(this).removeClass('layui-form-checked');
						if($(this).hasClass('header')) {
							$(".layui-form-checkbox").removeClass('layui-form-checked');
						}
					} else {
						$(this).addClass('layui-form-checked');
						if($(this).hasClass('header')) {
							$(".layui-form-checkbox").addClass('layui-form-checked');
						}
					}
				});
			},
			getData: function() {
				var obj = $(".layui-form-checked").not('.header');
				var arr = [];
				obj.each(function(index, el) {
					arr.push(obj.eq(index).attr('data-id'));
				});
				return arr;
			}
		}
		//开启表格多选
		tableCheck.init();
		//延时加载
		setTimeout(function() {
			if(sessionStorage.getItem("menu")) {
				menu = JSON.parse(sessionStorage.getItem("menu"));
				for(var i = 0; i < menu.length; i++) {
					tab.tabAdd(menu[i].title, menu[i].url, menu[i].id);
					$('.layui-tab-title li[lay-id="0"]').attr('data-bit', 0);//给首页加上自动刷新标志位
					$('.layui-tab-title li[lay-id="' + menu[i].id + '"]').attr('data-bit', 0); 
				}
			} else {
				return false;
			}
			if(sessionStorage.getItem("curMenu")) {
				$('.layui-tab-title').find('layui-this').removeClass('layui-class');
				curMenu = JSON.parse(sessionStorage.getItem("curMenu"));
				id = curMenu.id;
				if(id) { //因为默认桌面首页不存在lay-id,所以要对此判断
					$('.layui-tab-title li[lay-id="' + id + '"]').addClass('layui-this');
					$('.layui-tab-title li[lay-id="' + id + '"]').attr('data-bit', 1);
					topMenuSet(id.substr(0, 1));
					tab.tabChange(id);
				} else {
					$(".layui-tab-title li").eq(0).addClass('layui-this'); //未生效
					$('.layui-tab-content iframe').eq(0).parent().addClass('layui-show');
				}
			} else {
				$(".layui-tab-title li").eq(0).addClass('layui-this'); //未生效
				$('.layui-tab-content iframe').eq(0).parent().addClass('layui-show');
			}
		}, 100);
		//点击tab标题时，触发reloadTab函数
		$('#tabName').on('click','li',function(){
			reloadTab(this);
		});

		//初始化加载结束
	});

	/*
	 * @todo 左侧导航菜单的显示和隐藏
	 */
	var ishide = false;
    //隐藏侧边导航
    function hideSideNav() {
        if (!ishide) {
            $('#main').removeClass('main');
            var tishi = layer.msg('鼠标靠左自动显示菜单', { time: 1500 });
            layer.style(tishi, {
                top: 'auto',
                bottom: '50px'
            });
            ishide = true;
        }
    }
    //显示侧边导航
    function showSideNav() {
        if (ishide) {
            $('#main').addClass('main');
            ishide = false;
        }
    }
	$('.index-top .index-top-switch1 i').click(function(event) {
		if($('#main').hasClass('main')) {
			hideSideNav();
		} else {
			showSideNav();
		}
	});
    //鼠标靠左展开侧边导航
    $(document).mousemove(function(e) {
        if (e.pageX == 0) {
            showSideNav();
        }
    });
	//手机屏幕上对侧边导航展开/隐藏
    $(".index-top .index-top-switch2 i").click(function(){
        $('body').removeClass('site-mobile');
        $(".site-mobile-shade").removeClass('layui-hide');
    });

    $('.site-mobile-shade').click(function(){
        $('body').addClass('site-mobile');
        $(".site-mobile-shade").addClass('layui-hide');
	});

	/*
	 * @todo 左侧菜单事件
	 * 如果有子级就展开，没有就打开frame
	 */
	$(document).on('click', '.left-nav #nav li', function(event) {
		if($(this).children('.sub-menu').length) {
			if($(this).hasClass('open')) {
				$(this).removeClass('open');
				$(this).find('.nav_right').removeClass('fa fa-angle-down');
				$(this).find('.nav_right').addClass('fa fa-angle-left');
				$(this).children('.sub-menu').stop().slideUp();
				$(this).siblings().children('.sub-menu').slideUp();
			} else {
				$(this).addClass('open');
				$(this).children('a').find('.nav_right').removeClass('fa fa-angle-left');
				$(this).children('a').find('.nav_right').addClass('fa fa-angle-down');
				$(this).children('.sub-menu').stop().slideDown();
				$(this).siblings().children('.sub-menu').stop().slideUp();
				$(this).siblings().find('.nav_right').removeClass('fa fa-angle-down');
				$(this).siblings().find('.nav_right').addClass('fa fa-angle-left');
				$(this).siblings().removeClass('open');
			}
		} else {
			var url = $(this).children('a').data('url');
			var title = $(this).children('a').data('title');
			var index = $(this).children('a').data('id');

			for(var i = 0; i < $('.weIframe').length; i++) {
				if($('.weIframe').eq(i).attr('tab-id') == index) {
					var frame = $('.weIframe[tab-id='+index+']');
					tab.tabChange(index);
					//点击菜单再次刷新页面
					frame.attr('src', frame.attr('src'));
					event.stopPropagation();
					return;
				}
			};

			tab.tabAdd(title, url, index);
			tab.tabChange(index);
		}
		event.stopPropagation(); //不触发任何前辈元素上的事件处理函数
	});

	/*
	 * @todo tab触发事件：增加、删除、切换
	 */
	var tab = {
		tabAdd: function(title, url, id) {
			//判断当前id的元素是否存在于tab中
			var li = $("#WeTabTip li[lay-id=" + id + "]").length;
			//console.log(li);
			if(url == ""){
				layer.msg("没有页面可以打开！");
				return false;
			}
			if(li > 0) {
				//tab已经存在，直接切换到指定Tab项
				//console.log(">0");
				element.tabChange('wenav_tab', id); //切换到：用户管理
			} else {
				//该id不存在，新增一个Tab项
				//console.log("<0");
				element.tabAdd('wenav_tab', {
					title: title,
					content: '<iframe tab-id="' + id + '" frameborder="0" src="' + url + '" scrolling="yes" class="weIframe"></iframe>',
					id: id
				});
				//当前窗口内容
				setStorageMenu(title, url, id);

			}
			CustomRightClick(id); //绑定右键菜单
			FrameWH(); //计算框架高度

		},
		tabDelete: function(id) {
			element.tabDelete("wenav_tab", id); //删除
			removeStorageMenu(id);

		},
		tabChange: function(id) {
			//切换到指定Tab项
			element.tabChange('wenav_tab', id);
		},
		tabDeleteAll: function(ids) { //删除所有
			$.each(ids, function(i, item) {
				element.tabDelete("wenav_tab", item);
			})
			sessionStorage.removeItem('menu');
		}
	};

	/*
	 * @todo 监听右键事件,绑定右键菜单
	 * 先取消默认的右键事件，再绑定菜单，触发不同的点击事件
	 */
	function CustomRightClick(id) {
		//取消右键 
		$('.layui-tab-title li').on('contextmenu', function() {
			return false;
		})
		$('.layui-tab-title,.layui-tab-title li').on('click', function() {
			$('.rightMenu').hide();
		});
		//桌面点击右击 
		$('.layui-tab-title li').on('contextmenu', function(e) {
			var aid = $(this).attr("lay-id"); //获取右键时li的lay-id属性
			var popupmenu = $(".rightMenu");
			popupmenu.find("li").attr("data-id", aid);
			//console.log("popopmenuId:" + popupmenu.find("li").attr("data-id"));
			l = ($(document).width() - e.clientX) < popupmenu.width() ? (e.clientX - popupmenu.width()) : e.clientX;
			t = ($(document).height() - e.clientY) < popupmenu.height() ? (e.clientY - popupmenu.height()) : e.clientY;
			popupmenu.css({
				left: l,
				top: t
			}).show();
			//alert("右键菜单")
			return false;
		});
	}
	$("#rightMenu li").click(function() {
		var type = $(this).attr("data-type");
		var layId = $(this).attr("data-id")
		if(type == "current") {
			//console.log("close this:" + layId);
			tab.tabDelete(layId);
		} else if(type == "all") {
			//console.log("closeAll");
			var tabtitle = $(".layui-tab-title li");
			var ids = new Array();
			$.each(tabtitle, function(i) {
				ids[i] = $(this).attr("lay-id");
			})
			tab.tabDeleteAll(ids);
		} else if(type == "fresh") {
			//console.log("fresh:" + layId);
			tab.tabChange($(this).attr("data-id"));
			var othis = $('.layui-tab-title').find('>li[lay-id="' + layId + '"]'),
				index = othis.parent().children('li').index(othis),
				parents = othis.parents('.layui-tab').eq(0),
				item = parents.children('.layui-tab-content').children('.layui-tab-item'),
				src = item.eq(index).find('iframe').attr("src");
			item.eq(index).find('iframe').attr("src", src);
		} else if(type == "other") {
			var thisId = layId;
			$('.layui-tab-title').find('li').each(function(i, o) {
				var layId = $(o).attr('lay-id');
				if(layId != thisId && layId != 0) {
					tab.tabDelete(layId);
				}
			});
		}
		$('.rightMenu').hide();
	});

	/*
	 * @todo 重新计算iframe高度
	 */
	function FrameWH() {
		var h = $(window).height() - 80;
		$("iframe").css("height", h + "px");
	}
	$(window).resize(function() {
		FrameWH();
	});

	/*
	 * @todo 弹出层，弹窗方法
	 * layui.use 加载layui.define 定义的模块，当外部 js 或 onclick调用 use 内部函数时，需要在 use 中定义 window 函数供外部引用
	 * http://blog.csdn.net/xcmonline/article/details/75647144 
	 */
	/*
	    参数解释：
	    title   标题
	    url     请求的url
	    id      需要操作的数据id
	    w       弹出层宽度（缺省调默认值）
	    h       弹出层高度（缺省调默认值）
	*/
	window.WeAdminShow = function(title, url, w, h) {
		if(title == null || title == '') {
			title = false;
		};
		if(url == null || url == '') {
			url = "404.html";
		};
		if(w == null || w == '') {
			w = ($(window).width() * 0.9);
		};
		if(h == null || h == '') {
			h = ($(window).height() - 50);
		};
		layer.open({
			type: 2,
			area: [w + 'px', h + 'px'],
			fix: false, //不固定
			maxmin: true,
			shadeClose: true,
			shade: 0.4,
			title: title,
			content: url
		});
	}
	/*弹出层+传递ID参数*/
	window.WeAdminEdit = function(title, url, id, w, h) {
		if(title == null || title == '') {
			title = false;
		};
		if(url == null || url == '') {
			url = "404.html";
		};
		if(w == null || w == '') {
			w = ($(window).width() * 0.9);
		};
		if(h == null || h == '') {
			h = ($(window).height() - 50);
		};
		layer.open({
			type: 2,
			area: [w + 'px', h + 'px'],
			fix: false, //不固定
			maxmin: true,
			shadeClose: true,
			shade: 0.4,
			title: title,
			content: url,
			success: function(layero, index) {
				//向iframe页的id=house的元素传值  // 参考 https://yq.aliyun.com/ziliao/133150
				var body = layer.getChildFrame('body', index);
				body.contents().find("#dataId").val(id);
				console.log(id);
			},
			error: function(layero, index) {
				alert("aaa");
			}
		});
	}

	/**
	 *@todo tab监听：点击tab项对应的关闭按钮事件
	 */
	$('.layui-tab-close').click(function(event) {
		$('.layui-tab-title li').eq(0).find('i').remove();
	});
	/**
	 *@todo tab切换监听
	 * tab切换监听不能写字初始化加载$(function())方法内，否则不执行
	 */
	element.on('tab(wenav_tab)', function(data) {
		//console.log(this); //当前Tab标题所在的原始DOM元素
		var layId = $(this).attr('lay-id');
		setStorageCurMenu();
		if(layId != undefined){
			menuIndex = layId.substr(0, 1);
			topMenuSet(menuIndex)
		}
	});
	/*
	 * @todo 监听layui Tab项的关闭按钮，改变本地存储
	 */
	element.on('tabDelete(wenav_tab)', function(data) {
		var layId = $(this).parent('li').attr('lay-id');
		//console.log(layId);
		removeStorageMenu(layId);
	});
	/**
	 *@todo 本地存储 localStorage
	 * 为了保持统一，将sessionStorage更换为存储周期更长的localStorage
	 */
	//本地存储记录所有打开的窗口
	function setStorageMenu(title, url, id) {
		var menu = JSON.parse(sessionStorage.getItem('menu'));
		if(menu) {
			var deep = false;
			for(var i = 0; i < menu.length; i++) {
				if(menu[i].id == id) {
					deep = true;
					menu[i].title = title;
					menu[i].url = url;
					menu[i].id = id;
				}
			}
			if(!deep) {
				menu.push({
					title: title,
					url: url,
					id: id
				})
			}
		} else {
			var menu = [{
				title: title,
				url: url,
				id: id
			}]
		}
		sessionStorage.setItem('menu', JSON.stringify(menu));
	}
	//本地存储记录当前打开窗口
	function setStorageCurMenu() {
		var curMenu = sessionStorage.getItem('curMenu');
		var text = $('.layui-tab-title').find('.layui-this').text();
		text = text.split('ဆ')[0];
		var url = $('.layui-tab-content').find('.layui-show').find('.weIframe').attr('src');
		var id = $('.layui-tab-title').find('.layui-this').attr('lay-id');
		//console.log(text);
		curMenu = {
			title: text,
			url: url,
			id: id
		}
		sessionStorage.setItem('curMenu', JSON.stringify(curMenu));
	}
	//本地存储中移除删除的元素
	function removeStorageMenu(id) {
		var menu = JSON.parse(sessionStorage.getItem('menu'));
		//var curMenu = JSON.parse(localStorage.getItem('curMenu'));
		if(menu) {
			var deep = false;
			for(var i = 0; i < menu.length; i++) {
				if(menu[i].id == id) {
					deep = true;
					menu.splice(i, 1);
				}
			}
		} else {
			return false;
		}
		sessionStorage.setItem('menu', JSON.stringify(menu));
	}

	//锁屏
    function lockPage(){
        layer.open({
            title : false,
            type : 1,
            content : 	'<div class="admin-header-lock" id="lock-box">'+
                        '<div class="admin-header-lock-img"><img src="'+ $('.userPortrait')[0].src +'" /></div>'+
                        '<div class="admin-header-lock-name" id="lockUserName">'+ $('.userName').html() +'</div>'+
                        '<div class="input_btn">'+
                        '<input type="password" class="admin-header-lock-input layui-input" autocomplete="off" placeholder="请输入密码解锁.." name="lockPwd" id="lockPwd" />'+
                        '<button class="layui-btn" id="unlock">解锁</button>'+
                        '</div>'+
                        '</div>',
            closeBtn : 0,
            shade : 0.9,
            success : function(){
                //判断是否设置过头像，如果设置过则修改顶部、左侧和个人资料中的头像，否则使用默认头像
                //if(window.sessionStorage.getItem('userFace') &&  $(".userAvatar").length > 0){
                //    $(".userAvatar").attr("src",$(".userAvatar").attr("src").split("images/")[0] + "images/" + window.sessionStorage.getItem('userFace').split("images/")[1]);
                //}
            }
        })
        $(".admin-header-lock-input").focus();
    }
    $(".locksys").on("click",function(){
        window.sessionStorage.setItem("locksys",true);
        lockPage();
    })
    // 判断是否显示锁屏
    if(window.sessionStorage.getItem("locksys") == "true"){
        lockPage();
    }
    // 解锁
    $("body").on("click","#unlock",function(){
        if($(this).siblings(".admin-header-lock-input").val() == ''){
            layer.msg("请输入解锁密码！");
            $(this).siblings(".admin-header-lock-input").focus();
        }else{
			var getUserCode = $("#userInfo").data("usercode");
			console.log(getUserCode);
			var getPassWord = $(this).siblings(".admin-header-lock-input").val();
			var ajaxReturnData;
            //登陆验证
            $.ajax({
                url: '/checklogin.asp',
                type: 'post',
                async: false,
                data: {
					"lockUid": getUserCode,
					"lockPwd": getPassWord
				},
                success: function (data) {
                    ajaxReturnData = data;
                }
            });
            if(ajaxReturnData == "true"){
                window.sessionStorage.setItem("locksys",false);
                $(this).siblings(".admin-header-lock-input").val('');
                layer.closeAll("page");
            }else{
                layer.msg("密码错误，请重新输入！");
                $(this).siblings(".admin-header-lock-input").val('').focus();
            }
        }
    });
    $(document).on('keydown', function(event) {
        var event = event || window.event;
        if(event.keyCode == 13) {
            $("#unlock").click();
        }
	});
	
	/**
	 *@todo 模拟登录
	 * 判断初次登录时，跳转到登录页
	 */
	//var login = localStorage.getItem('login');
	$('.loginOut').click(function() {
		//login = 0;
		//localStorage.setItem('login', login);
		window.sessionStorage.clear();
		window.location.href = "logout.asp";
	});
	//$('.loginin').click(function() {
	//	login = 1;
	//	localStorage.setItem('login', login);
	//});
	$('.passwordChange').click(function(){
		var _queryStr = "", _layerSize = ['455px', '350px'];
		_myLayui.showLayer("修改密码","/operator/operator_pwd_change.asp", _queryStr, _layerSize);
	});

	exports('index', {});
});