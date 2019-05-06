package com.ktamr.service.impl;

import com.ktamr.common.utils.DateUtils;
import com.ktamr.common.utils.ServletUtils;
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
    public Integer selectCmdId(String cmd,String centorid) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("mcmd",cmd.split(":")[0]);
        map.put("parms",cmd.substring(cmd.indexOf(":")+1));
        if(centorid == ""){
            map.put("centorid",0);
        }else if (centorid != ""){
            map.put("centorid",Integer.parseInt(centorid));
        }
        return haCmdMapper.selectCmdId(map);
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
        map.put("uid", ServletUtils.getSession().getAttribute("operatorCode"));
        map.put("state","待执行");
        map.put("id",0);
        map.put("deviceType","1");
        haCmdMapper.insertCmd(map);
        return Integer.parseInt(map.get("id").toString());
    }

    @Override
    public Integer insertCmd(Integer id) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("cmdId",id);
        map.put("uid", ServletUtils.getSession().getAttribute("operatorCode"));
        map.put("createTime", DateUtils.getNowDate());
        map.put("state","待执行");
        map.put("deviceType","2");
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

    @Override
    public List<HaCmd> selectCmdLeftJoinTow(HaCmd haCmd) {
        return haCmdMapper.selectCmdLeftJoinTow(haCmd);
    }

    @Override
    public HaCmd selectCmdById(Integer id) {
        return haCmdMapper.selectCmdById(id);
    }

    /**
     * 根据id批量删除Ha_cmd表
     * @param cmdids id数组
     * @return 返回int
     */
    @Override
    public Integer deleteCmdByid(Integer[] cmdids) {
        return haCmdMapper.deleteCmdByid(cmdids);
    }

    /**
     * 查询是否已经存在未完成的相同命令
     * @param haCmd
     * @return
     */
    @Override
    public List<HaCmd> BreturnID(HaCmd haCmd) {
        List<HaCmd> returnID = haCmdMapper.BreturnID(haCmd);
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
    public Integer BinsertHaCmd(HaCmd haCmd) {
        Integer insertHaCmd = haCmdMapper.BinsertHaCmd(haCmd);
        if(insertHaCmd!=null){
            return haCmd.getId();
        }
        return null;
    }
}
