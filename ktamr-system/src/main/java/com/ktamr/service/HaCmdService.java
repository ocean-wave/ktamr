package com.ktamr.service;

import com.ktamr.domain.HaCmd;
import com.ktamr.domain.HaMeter;

import java.util.List;
import java.util.Map;

public interface HaCmdService {

    public Integer insertCmd(String cmd,String centorid);

    public Integer insertCmdTwo(HaMeter haMeter);

    public Integer insertCmdTwo2(Map<String,Object> map);

    public Integer selectCmdId(String cmd,String centorid);

    public Integer insertCmd(Integer id);

    public Map<String,Object> selectCmdParmsById(Integer id);

    public String selectCentorById(Integer centorid);

    public List<HaCmd> selectAllCmd(HaCmd haCmd);

    public List<HaCmd> selectCmdLeftJoinTow(HaCmd haCmd);

    public HaCmd selectCmdById(Integer id);

    /**
     * 根据id批量删除Ha_cmd表
     * @param cmdids id数组
     * @return 返回int
     */
    public Integer deleteCmdByid(Integer[] cmdids);

    /**
     * 查询是否已经存在未完成的相同命令!
     * @param haCmd
     * @return
     */
    public List<HaCmd> BreturnID(HaCmd haCmd);

    /**
     * 添加命令执行表
     * @param haCmd
     * @return
     */
    public Integer BinsertHaCmd(HaCmd haCmd);

    /**
     * 插入一条批量导入余额的命令
     * @param haCmd
     * @return
     */
    public Integer insertCommand(HaCmd haCmd);

    Integer addHaCmd(HaCmd haCmd);

    Integer addHaCmdMeter(Integer parms,String uid,double processing,double processing2);
}
