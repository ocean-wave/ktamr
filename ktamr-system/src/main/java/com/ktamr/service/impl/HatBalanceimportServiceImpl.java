package com.ktamr.service.impl;

import com.ktamr.domain.HatBalanceimport;
import com.ktamr.mapper.HatBalanceimportMapper;
import com.ktamr.service.HatBalanceimportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HatBalanceimportServiceImpl  implements HatBalanceimportService {

    @Resource
    HatBalanceimportMapper hatBalanceimportMapper;


    /**
     * 添加状态为待校验
     * @param hatBalanceimport
     * @return
     */
    @Override
    public Integer insertHatBalanceimport(HatBalanceimport hatBalanceimport) {
        Integer insertHatBalanceimport = hatBalanceimportMapper.insertHatBalanceimport(hatBalanceimport);
        if(insertHatBalanceimport!=null){
            return insertHatBalanceimport;
        }
        return null;
    }

    /**
     * 导入用户编号校验1
     * @param hatBalanceimport
     * @return
     */
    @Override
    public Integer UserNumberCheck1(HatBalanceimport hatBalanceimport) {
        Integer UserNumberCheck1 = hatBalanceimportMapper.UserNumberCheck1(hatBalanceimport);
        if(UserNumberCheck1!=null){
            return UserNumberCheck1;
        }
        return null;
    }

    /**
     * 导入用户编号校验2
     * @param hatBalanceimport
     * @return
     */
    @Override
    public Integer UserNumberCheck2(HatBalanceimport hatBalanceimport) {
        Integer UserNumberCheck2 = hatBalanceimportMapper.UserNumberCheck2(hatBalanceimport);
        if(UserNumberCheck2!=null){
            return UserNumberCheck2;
        }
        return null;
    }

    /**
     * 导入档案内表号校验1
     * @param hatBalanceimport
     * @return
     */
    @Override
    public Integer TableNumberCheck1(HatBalanceimport hatBalanceimport) {
        Integer TableNumberCheck1 = hatBalanceimportMapper.TableNumberCheck1(hatBalanceimport);
        if(TableNumberCheck1!=null){
            return TableNumberCheck1;
        }
        return null;
    }

    /**
     * 导入档案内表号校验2
     * @param hatBalanceimport
     * @return
     */
    @Override
    public Integer TableNumberCheck2(HatBalanceimport hatBalanceimport) {
        Integer TableNumberCheck2 = hatBalanceimportMapper.TableNumberCheck2(hatBalanceimport);
        if(TableNumberCheck2!=null){
            return TableNumberCheck2;
        }
        return null;
    }

    /**
     * 匹配用户编号
     * @param hatBalanceimport
     * @return
     */
    @Override
    public Integer MatchingUserNumber(HatBalanceimport hatBalanceimport) {
        Integer MatchingUserNumber = hatBalanceimportMapper.MatchingUserNumber(hatBalanceimport);
        if(MatchingUserNumber!=null){
            return MatchingUserNumber;
        }
        return null;
    }

    /**
     * 匹配表号
     * @param hatBalanceimport
     * @return
     */
    @Override
    public Integer Matchingtablenumber(HatBalanceimport hatBalanceimport) {
        Integer Matchingtablenumber = hatBalanceimportMapper.Matchingtablenumber(hatBalanceimport);
        if(Matchingtablenumber!=null){
            return Matchingtablenumber;
        }
        return null;
    }

    /**
     * 校验余额
     * @param hatBalanceimport
     * @return
     */
    @Override
    public Integer CheckBalance(HatBalanceimport hatBalanceimport) {
        Integer CheckBalance = hatBalanceimportMapper.CheckBalance(hatBalanceimport);
        if(CheckBalance!=null){
            return CheckBalance;
        }
        return null;
    }

    /**
     * 查询总条目数
     * @param hatBalanceimport
     * @return
     */
    @Override
    public Integer selectAllrows(HatBalanceimport hatBalanceimport) {
        Integer selectAllrows = hatBalanceimportMapper.selectAllrows(hatBalanceimport);
        if(selectAllrows!=null){
            return selectAllrows;
        }
        return null;
    }

    /**
     * 查询待导入数
     * @param hatBalanceimport
     * @return
     */
    @Override
    public Integer selectImports(HatBalanceimport hatBalanceimport) {
        Integer selectImports = hatBalanceimportMapper.selectImports(hatBalanceimport);
        if(selectImports!=null){
            return  selectImports;
        }
        return null;
    }

    /**
     * 查询用户余额确认列表
     * @param hatBalanceimport
     * @return
     */
    @Override
    public List<HatBalanceimport> selectCustBalanceImportList(HatBalanceimport hatBalanceimport) {
        List<HatBalanceimport> hatBalanceimportList = hatBalanceimportMapper.selectCustBalanceImportList(hatBalanceimport);
        if(hatBalanceimportList!=null){
            return hatBalanceimportList;
        }
        return null;
    }
}
