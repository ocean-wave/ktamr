package com.ktamr.service.impl;

import com.ktamr.common.utils.DateUtils;
import com.ktamr.domain.HaCmd;
import com.ktamr.domain.HaMeter;
import com.ktamr.mapper.HaCmdMapper;
import com.ktamr.service.HaCmdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HaCmdServiceImpl implements HaCmdService {
    @Autowired
    private HaCmdMapper haCmdMapper;

    @Override
    public Integer selectCmdById(String cmd,String centorid) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("mcmd",cmd.split(":")[0]);
        map.put("parms",cmd.substring(cmd.indexOf(":")+1));
        if(centorid == ""){
            map.put("centorid",0);
        }else if (centorid != ""){
            map.put("centorid",Integer.parseInt(centorid));
        }
        return haCmdMapper.selectCmdById(map);
    }

    @Override
    public Integer insertCmd(String cmd, String centorid) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("mcmd",cmd.split(":")[0]);
        map.put("parms",cmd.substring(cmd.indexOf(":")+1));
        if(centorid!=null && centorid == ""){
            map.put("centorid",0);
        }else if ( centorid!=null && centorid != ""){
            map.put("centorid",Integer.parseInt(centorid));
        }
        map.put("createTime", DateUtils.getNowDate());
        map.put("operatorCode","zk");
        map.put("state","待执行");
        map.put("id",0);
        haCmdMapper.insertCmd(map);
        return Integer.parseInt(map.get("id").toString());
    }

    @Override
    public Map<String, Object> selectCmdParmsById(Integer id) {
        return haCmdMapper.selectCmdParmsById(id);
    }

    @Override
    public String selectCentorById(Integer centorid) {
        return haCmdMapper.selectCentorById(centorid);
    }

    @Override
    public List<HaCmd> selectAllCmd(HaCmd haCmd) {
        return haCmdMapper.selectAllCmd(haCmd);
    }

    @Override
    public Integer insertCmdTwo(HaMeter haMeter) {
        return haCmdMapper.insertCmdTwo(haMeter);
    }

    /**
     * 查询是否已经存在未完成的相同命令
     * @param haCmd
     * @return
     */
    @Override
    public HaCmd returnID(HaCmd haCmd) {
        HaCmd returnID = haCmdMapper.returnID(haCmd);
        if(returnID!=null){
            return returnID;
        }
        return null;
    }

    /**
     * 添加命令执行表
     * @param haCmd
     * @return
     */
    @Override
    public Integer insertHaCmd(HaCmd haCmd) {
        Integer insertHaCmd = haCmdMapper.insertHaCmd(haCmd);
        if(insertHaCmd!=null){
            return haCmd.getId();
        }
        return null;
    }
}