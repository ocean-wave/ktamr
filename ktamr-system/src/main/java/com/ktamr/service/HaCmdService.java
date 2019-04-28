package com.ktamr.service;

import com.ktamr.domain.HaCmd;
import com.ktamr.domain.HaMeter;

import java.util.List;
import java.util.Map;

public interface HaCmdService {

    public Integer selectCmdById(String cmd,String centorid);

    public Integer insertCmd(String cmd,String centorid);

    public Map<String,Object> selectCmdParmsById(Integer id);

    public String selectCentorById(Integer centorid);

    public List<HaCmd> selectAllCmd(HaCmd haCmd);

    public Integer insertCmdTwo(HaMeter haMeter);

    /**
     * 查询是否已经存在未完成的相同命令!
     * @param haCmd
     * @return
     */
    public HaCmd returnID(HaCmd haCmd);

    /**
     * 添加命令执行表
     * @param haCmd
     * @return
     */
    public Integer insertHaCmd(HaCmd haCmd);
}
