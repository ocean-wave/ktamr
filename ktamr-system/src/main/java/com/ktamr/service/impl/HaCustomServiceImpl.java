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
     * @return
     */
    @Override
    public List<HaCustom> queryHaCustomListB(HaCustom haCustom) {
        List<HaCustom> haCustomList = haCustomMapper.queryHaCustomListB(haCustom);
        if(haCustomList!=null){
            return haCustomList;
        }

        return null;
    }


    /**
     * 查询预存费用
     * @param haCustom
     * @return
     */
    @Override
    public HaCustom selectYuCunFeiYongB(HaCustom haCustom) {
        HaCustom yuCunFeiYong = haCustomMapper.selectYuCunFeiYongB(haCustom);
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
    public Integer updateYuCunFeiYongB(HaCustom haCustom) {
        Integer updateYuCunFeiYong = haCustomMapper.updateYuCunFeiYongB(haCustom);
        if(updateYuCunFeiYong!=null){
            return  updateYuCunFeiYong;
        }
        return null;
    }

    public List<HaCustom> HaCustomList(HaCustom haCustom) {
        return haCustomMapper.HaCustomList(haCustom);
    }

    @Override
    public HaCustom updateByIdHaCustom(HaCustom haCustom) {
        return haCustomMapper.updateByIdHaCustom(haCustom);
    }

    @Override
    public List<HaCustom> ByIdHaCustom(Integer custId) {
        return haCustomMapper.ByIdHaCustom(custId);
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
