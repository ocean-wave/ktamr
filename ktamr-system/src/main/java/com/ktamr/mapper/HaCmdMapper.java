package com.ktamr.mapper;

import com.ktamr.domain.HaCmd;
import com.ktamr.domain.HaMeter;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface HaCmdMapper {

    public Integer insertCmd(Map<String,Object> cmd);

    public Integer insertCmdTwo(HaMeter haMeter);

    public Integer insertCmdTwo2(Map<String,Object> map);

    public Integer selectCmdId(Map<String,Object> cmd);

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
    public Integer deleteCmdByid(@Param("cmdids") Integer[] cmdids);

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

    Integer addHaCmdMeter(@Param("parms") Integer parms,@Param("uid") String uid,@Param("processing") double processing,@Param("processing") double processing2);
}
