package com.ktamr.mapper;

import com.ktamr.domain.HatBalanceimport;

public interface HatBalanceimportMapper {

    /**
     * 添加状态为待校验
     * @param hatBalanceimport
     * @return
     */
    public Integer insertHatBalanceimport(HatBalanceimport hatBalanceimport);

    /**
     * 导入用户编号校验1
     * @param hatBalanceimport
     * @return
     */
    public Integer UserNumberCheck1(HatBalanceimport hatBalanceimport);

    /**
     * 导入用户编号校验2
     * @param hatBalanceimport
     * @return
     */
    public Integer UserNumberCheck2(HatBalanceimport hatBalanceimport);

    /**
     * 导入档案内表号校验1
     * @param hatBalanceimport
     * @return
     */
    public Integer TableNumberCheck1(HatBalanceimport hatBalanceimport);

    /**
     * 导入档案内表号校验2
     * @param hatBalanceimport
     * @return
     */
    public Integer TableNumberCheck2(HatBalanceimport hatBalanceimport);

    /**
     * 匹配用户编号
     * @param hatBalanceimport
     * @return
     */
    public Integer MatchingUserNumber(HatBalanceimport hatBalanceimport);

    /**
     * 匹配表号
     * @param hatBalanceimport
     * @return
     */
    public Integer Matchingtablenumber(HatBalanceimport hatBalanceimport);

    /**
     * 校验余额
     * @param hatBalanceimport
     * @return
     */
    public Integer CheckBalance(HatBalanceimport hatBalanceimport);
}
