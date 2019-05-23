package com.ktamr.web.basecontroller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ktamr.common.core.domain.BaseEntity;
import com.ktamr.common.core.page.PageDomain;
import com.ktamr.common.core.page.TableSupport;
import com.ktamr.common.utils.ServletUtils;
import com.ktamr.common.utils.StringUtils;
import com.ktamr.common.utils.sql.SqlCondition;
import com.ktamr.common.utils.sql.SqlUtil;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseController {

    protected final Logger logger = LoggerFactory.getLogger(BaseController.class);

    protected void inti(BaseEntity baseEntity){
        if(baseEntity.getParams() == null){
            baseEntity.setParams(new HashMap<>());
        }
        baseEntity.getParams().put("operatorRgnType", ServletUtils.getSession().getAttribute("operatorRgnType"));
        baseEntity.getParams().put("rgnStr", ServletUtils.getSession().getAttribute("rgnStr"));
        baseEntity.getParams().put("areaNo", ServletUtils.getSession().getAttribute("areaNo"));
        baseEntity.getParams().put("operatorCompanyId", ServletUtils.getSession().getAttribute("operatorCompanyId"));
        baseEntity.getParams().put("operatorCode", ServletUtils.getSession().getAttribute("operatorCode"));
        baseEntity.getParams().put("operatorLevel",ServletUtils.getSession().getAttribute("operatorLevel"));
        baseEntity.getParams().put("multipleConditions", SqlCondition.getMultipleConditions());
        startPage();
    }

    protected Map<String,Object> getDataTable(List<?> list)
    {
        Map<String,Object> m = new HashMap<String, Object>();
        long records = new PageInfo(list).getTotal();
        PageDomain pageDomain = TableSupport.buildPageRequest();
        pageDomain.setTotal(Integer.parseInt(Long.toString(records)));
        m.put("page",pageDomain.getPage());
        m.put("rows",list);
        m.put("records",records);
        m.put("total",pageDomain.getTotal());
        return m;
    }

    protected void startPage()
    {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer page = pageDomain.getPage();
        Integer rows = pageDomain.getRows();
        if (StringUtils.isNotNull(page) && StringUtils.isNotNull(rows))
        {
            String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
            PageHelper.startPage(page, rows,orderBy);
        }
    }

    public static Map<Integer,Integer> getValuesByKey(List<?> object,Map<Integer,String> m) {
        List<Map<Integer,Integer>> list = new ArrayList<Map<Integer,Integer>>();
        Map<Integer,Integer> map = new HashMap<>();
        for (Object obj : object) {
            // 得到类对象
            Class userCla =  obj.getClass();
            /* 得到类中的所有属性集合 */
            Class cs = userCla.getSuperclass();
            Field[] fs = userCla.getDeclaredFields();
            for (int i = 0; i < fs.length; i++) {
                Field f = fs[i];
                f.setAccessible(true); // 设置些属性是可以访问的
                try {
                    for (int j=0;j<m.size();j++){
                    if (f.getName().endsWith(m.get(j))) {
                            if (map.get(j) != null && f.get(obj) != null) {
                                map.put(j, map.get(j) + Integer.parseInt(f.get(obj).toString()));
                            } else if (map.get(j) == null && f.get(obj) != null) {
                                map.put(j, Integer.parseInt(f.get(obj).toString()));
                            } else if (map.get(j) == null) {
                                map.put(j, 0);
                            }
                        }
                    }
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        if (map.size() == 0) {
            for (int i = 0; i < m.size(); i++) {
                map.put(i, 0);
            }
        }
        return map;
    }
}
