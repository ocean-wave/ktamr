package com.ktamr.service.impl;

import com.ktamr.domain.HaCustom;
import com.ktamr.mapper.HaCustomMapper;
import com.ktamr.service.HaCustomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HaCustomServiceImpl implements HaCustomService {
    @Resource
    private HaCustomMapper haCustomMapper;


    /**
     * 查询用户账号列表
     * @param haCustom
     * @param page
     * @param rowNum
     * @return
     */
    @Override
    public List<HaCustom> queryHaCustomList(HaCustom haCustom, Integer page, Integer rowNum) {
        List<HaCustom> haCustomList = haCustomMapper.queryHaCustomList(haCustom, page, rowNum);
        if(haCustomList!=null){
            return haCustomList;
        }

        return null;
    }

    /**
     * 查询用户账号列表的总记录数
     * @param haCustom
     * @return
     */
    @Override
    public Integer queryHaCustomListCount(HaCustom haCustom) {

        Integer haCustomListCount = haCustomMapper.queryHaCustomListCount(haCustom);
        if(haCustomListCount!=null){
            return haCustomListCount;
        }
        return null;
    }

    /**
     * 查询预存费用
     * @param haCustom
     * @return
     */
    @Override
    public HaCustom selectYuCunFeiYong(HaCustom haCustom) {
        HaCustom yuCunFeiYong = haCustomMapper.selectYuCunFeiYong(haCustom);
        if(yuCunFeiYong!=null){
            return yuCunFeiYong;
        }
        return null;
    }

    /**
     * 佛系更新预存费用
     * @param haCustom
     * @return
     */
    @Override
    public Integer updateYuCunFeiYong(HaCustom haCustom) {
        Integer updateYuCunFeiYong = haCustomMapper.updateYuCunFeiYong(haCustom);
        if(updateYuCunFeiYong!=null){
            return  updateYuCunFeiYong;
        }
        return null;
    }

    public List<HaCustom> HaCustomList(HaCustom haCustom, Integer page,
                                       Integer rowNum) {
        return haCustomMapper.HaCustomList(haCustom,page,rowNum);
    }

    @Override
    public HaCustom updateByIdHaCustom(HaCustom haCustom) {
        return haCustomMapper.updateByIdHaCustom(haCustom);
    }

    @Override
    public Integer selectHaCustomCount(HaCustom haCustom) {
        Integer haCustoms = haCustomMapper.selectHaCustomCount(haCustom);
        if(haCustoms!=null){
            return  haCustoms;
        }
        return null;
    }

    public Integer addHaCustom(HaCustom haCustom) {
        return haCustomMapper.addHaCustom(haCustom);
    }

    public Integer updateHaCustom(HaCustom haCustom) {
        return haCustomMapper.updateHaCustom(haCustom);
    }

    public Integer deleteHaCustom(HaCustom haCustom) {
        return haCustomMapper.deleteHaCustom(haCustom);
    }
}
