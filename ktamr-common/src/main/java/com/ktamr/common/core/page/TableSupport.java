package com.ktamr.common.core.page;

import com.ktamr.common.constant.Constants;
import com.ktamr.common.utils.ServletUtils;

/**
 * 表格数据处理
 * 
 * @author ktamr
 */
public class TableSupport
{
    /**
     * 封装分页对象
     */
    public static PageDomain getPageDomain()
    {
        PageDomain pageDomain = new PageDomain();
        pageDomain.setPage(ServletUtils.getParameterToInt(Constants.PAGE));
        pageDomain.setRows(ServletUtils.getParameterToInt(Constants.ROWS));
        pageDomain.setOrderByColumn(ServletUtils.getParameter(Constants.ORDER_BY_COLUMN));
        pageDomain.setIsAsc(ServletUtils.getParameter(Constants.SORD));
        return pageDomain;
    }

    public static PageDomain buildPageRequest()
    {
        return getPageDomain();
    }
}
