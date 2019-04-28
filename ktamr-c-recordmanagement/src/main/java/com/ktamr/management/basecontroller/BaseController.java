package com.ktamr.management.basecontroller;//package com.ktamr.web.Controller.basecontroller;
//
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import com.ktamr.common.core.page.PageDomain;
//import com.ktamr.common.core.page.TableSupport;
//import com.ktamr.common.utils.ServletUtils;
//import com.ktamr.common.utils.StringUtils;
//import com.ktamr.common.utils.sql.SqlUtil;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class BaseController {
//
//    protected Map<String,Object> getDataTable(List<?> list)
//    {
//        Map<String,Object> m = new HashMap<String, Object>();
//        long records = new PageInfo(list).getTotal();
//        PageDomain pageDomain = TableSupport.buildPageRequest();
//        pageDomain.setTotal(Integer.parseInt(Long.toString(records)));
//        m.put("page",pageDomain.getPage());
//        m.put("rows",list);
//        m.put("records",records);
//        m.put("total",pageDomain.getTotal());
//        return m;
//    }
//
//    protected void startPage()
//    {
//        PageDomain pageDomain = TableSupport.buildPageRequest();
//        Integer page = pageDomain.getPage();
//        Integer rows = pageDomain.getRows();
//        if (StringUtils.isNotNull(page) && StringUtils.isNotNull(rows))
//        {
//            String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
//            PageHelper.startPage(page, rows, orderBy);
//        }
//    }
//
////    public String getRightCondition(String fieldName,String noType,String condition){
////        String sql = "";
////        if(ServletUtils.getSession().getAttribute("operatorRgnType") == "rgn"){
////            sql = condition+" LEFT(a.areaNo,1) in ("+ ServletUtils.getSession().getAttribute("rgnid")+")  ";
////        }else if(ServletUtils.getSession().getAttribute("operatorRgnType") == "area"){
////            if(noType == "rgn"){
////                sql =  condition+" LEFT(a.areaNo,1) in ("+ ServletUtils.getSession().getAttribute("rgnid")+")  ";
////            }else{
////                sql = condition+" LEFT(a.areaNo,5) in ("+ ServletUtils.getSession().getAttribute("areaid")+")  ";
////            }
////        }
////        return sql;
////    }
//}
