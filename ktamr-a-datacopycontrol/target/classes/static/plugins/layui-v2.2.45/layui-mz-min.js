layui.selMeltiple = function(a) {
    a(".layui-form select[multiple=multiple]").each(function(k, e) {
        var f = "",
        d = "",
        c = "";
        a(this).find("option").each(function(h, b) {
            if (0 != h || null != a(this).attr("value") && "" !== a(this).attr("value")) {
                h = a(this).attr("value");
                b = a(this).text();
                var g = a(this).attr("img"),
                e = a(this).is(":selected");
                f += '<dd lay-value="' + h + '" class="' + (e ? "layui-this": "") + '">';
                f += '<i style="display:inline-block;width:16px;height:16px;border:1px solid #e6e6e6;vertical-align:middle;margin-right:5px;line-height:19px;text-align:center;">' + (e ? "&radic;": "") + "</i>";
                null != g && "" != g && (g = eval("(" + g + ")"), null != g.src && "" != g.src && (f += '<img src="' + g.src + '" height="16" width="16" style="margin-right:5px;vertical-align:middle;' + g.css + '"/>'));
                f += '<span>'+b+'</span>';
                f += "</dd>";
                e && (d += "," + h, c += "," + b)
            }
        });
        "" != d && (d = d.substring(1));
        "" != c && (c = c.substring(1));
        a(this).siblings("div.layui-form-select").find("dl").html(f);
        a(this).before('<input type="hidden" class="txtSel" name="' + a(this).attr("name") + '" value="' + d + '">');
        a(this).removeAttr("name");
        a(this).siblings("div.layui-form-select").find(".layui-select-title input").val(c).attr("lay-verify", a(this).attr("lay-verify"));
        a(this).siblings("div.layui-form-select").find("dd").each(function(e, b) {
            a(this).click(function() {
                c = d = "";
                a(this).hasClass("layui-this") ? a(this).removeClass("layui-this").find("i").text("") : a(this).addClass("layui-this").find("i").html("&radic;");
                a(this).parent().find("dd.layui-this").each(function() {
                    d += "," + a(this).attr("lay-value");
                    c += "," + a(this).text().substring(1)
                });
                "" != d && (d = d.substring(1));
                "" != c && (c = c.substring(1));
                a(this).parent().parent().siblings("input.txtSel").val(d);
                a(this).parent().siblings(".layui-select-title").find("input.layui-input").val(c);
                var b = {};
                b.elem = a(this).parent().parent().siblings("select");
                b.value = a(this).attr("lay-value");
                selMeltipleSelect(b);
            })
        });
        //防止选中两项之后再点击select框会出现问题
        a(this).siblings("div.layui-form-select").on("click", function(){
            if(!$(this).hasClass("layui-form-selected")){
                var array = [];
                $.each($(this).find("dd.layui-this span"), function(i, v){
                    array.push($(v).html());
                });
                //console.log(array);
                $(this).find(".layui-select-title").find("input.layui-input").val(array.join(','));
            }
        });
        //多选时dl范围不应用点击事件
        a(this).siblings("div.layui-form-select").find("dl").on('click',function(e){
            e.stopPropagation();//阻止该区域事件冒泡
        });
    });
};
layui.selImg = function(a, k) {
    null == k && (k = "select");
    a("" + k).each(function() {
        if ("multiple" != a(this).attr("multiple")) {
            var e = a(this).find("option"),
            f = 0;
            null != e && 0 < e.length && ("" == a(e[0]).attr("value") || null == a(e[0]).attr("value")) && (f = 1);
            for (var d = a(this).siblings("div.layui-form-select").find("dd"), c = 0, h = d.length; c < h; c++) {
                var b = a(e[f]).attr("img");
                null != b && "" != b && (b = eval("(" + b + ")"), null != b.src && "" != b.src && a(d[c]).prepend('<img src="' + b.src + '" height="16" width="16" style="margin-right:5px;vertical-align:middle;' + b.css + '"/>'));
                f++
            }
        }
    })
};
function selMeltipleSelect(a) {};