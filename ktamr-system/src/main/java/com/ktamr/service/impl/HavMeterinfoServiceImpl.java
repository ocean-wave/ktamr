package com.ktamr.service.impl;

import com.ktamr.domain.HaMeter;
import com.ktamr.domain.HavMeterinfo;
import com.ktamr.mapper.HavMeterinfoMapper;
import com.ktamr.service.HavMeterinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 小区表实现类
 */
@Service
public class HavMeterinfoServiceImpl implements HavMeterinfoService {

    @Autowired
    private HavMeterinfoMapper havMeterinfoMapper;

    @Override
    public List<HavMeterinfo> selectReadResult(HavMeterinfo parms) {
        String[] s;
        Integer[] si;
        Map<String,Object> map;
        s = parms.getParams().get("cmdIds").toString().split(",");
        si = new Integer[s.length];
        String[] ids = parms.getParams().get("ids").toString().split(",");
        Integer[] id = new Integer[ids.length];
        if (ids.length>1){
            for (int i = 0; i < ids.length; i++) {
                id[i] = Integer.parseInt(ids[i]);
            }
        }
        if(s.length > 1) {
            for (int i = 0; i < s.length; i++) {
                si[i] = Integer.parseInt(s[i]);
            }
        }else{
            si[0] = 0;
        }
        map = new HashMap<String,Object>();
        String cmdName = parms.getParams().get("cmdName").toString();
        map.put("cmdName",parms.getParams().get("cmdName").toString());
        map.put("cmdids",si);
        if(ids.length>1) {
            map.put("ids",id);
        }else {
            if("抄收小区".equals(cmdName)){
                id[0] = Integer.parseInt(ids[0]);;
                map.put("ids", id);
            }else {
                map.put("ids", parms.getParams().get("ids").toString());
            }
        }
        map.put("params",parms.getParams());
        map.put("multipleConditions",parms.getMultipleConditions());
        return havMeterinfoMapper.selectReadResult(map);
    }

    @Override
    public List<HavMeterinfo> selectThirdParty(HavMeterinfo havMeterinfo) {
        return havMeterinfoMapper.selectThirdParty(havMeterinfo);
    }

    @Override
    public List<HavMeterinfo> changeFormByAreaId(HavMeterinfo havMeterinfo) {
        return havMeterinfoMapper.changeFormByAreaId(havMeterinfo);
    }

    @Override
    public HavMeterinfo userAddr(Integer meterid) {
        return havMeterinfoMapper.userAddr(meterid);
    }
}
