package com.ktamr.util;




import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageUtil {


    //声明全局变量
    Integer page,pageRows;
    int page2;

    /**
     * 返回分页中的两个主要参数
     * @param page1  取得当前页数
     * @param pageRows1   取得每页显示行数
     * @return
     */
    public Integer [] pageAndPageRow(String page1,String pageRows1){


        if(page1==null&&pageRows1==null){//为了防止异常给它初始化一波
            page = 100;
            pageRows = 100;
        }else {//如果有那就获取一波
            page = Integer.parseInt(page1); // 取得当前页数
            pageRows = Integer.parseInt(pageRows1); // 取得每页显示行数
        }
         page2=page;//重新定义变量接收
        --page2;//当前页数

        return new Integer[]{pageRows,page2};
    }


    /**
     * 返回json数组集合封装成map
     * @param List
     * @param count
     * @return
     */
    public Map map(List<?> List,Integer count){
        Map<String ,Object> map=new HashMap<String, Object>();
        map.put("page",page);//设置初始的页码 就是第几页
        map.put("rowNum",pageRows);//一页显示几条数据
        map.put("records",count);//总记录数
        map.put("total",(count-1)/pageRows+1);//总页数的计算
        map.put("rows",List);//存放集合
        return map;
    }
}
