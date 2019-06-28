package com.ktamr.mapper;

import com.ktamr.domain.HatBalanceimport;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface HatBalanceimportMapper {

    /**
     * 添加状态为待校验
     * @param params
     * @return
     */
    public Integer insertHatBalanceimport(@Param("params") List<Map<String, Object>> params);

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

    /**
     * 查询总条目数
     * @param hatBalanceimport
     * @return
     */
    public Integer selectAllrows(HatBalanceimport hatBalanceimport);

    /**
     * 查询待导入数
     * @param hatBalanceimport
     * @return
     */
    public Integer selectImports(HatBalanceimport hatBalanceimport);

    /**
     * 查询用户余额确认列表
     * @param hatBalanceimport
     * @return
     */
    public List<HatBalanceimport> selectCustBalanceImportList(HatBalanceimport hatBalanceimport);

    /**
     * 修改用户余额
     * @param hatBalanceimport
     * @return
     */
    public Integer modifyUserBalance(HatBalanceimport hatBalanceimport);

    /**
     * 清理临时表
     * @param hatBalanceimport
     * @return
     */
    public Integer cleanupTemporaryTables(HatBalanceimport hatBalanceimport);
}
