package com.ktamr.mapper;

import com.ktamr.domain.HaCmd;
import com.ktamr.domain.HaMeter;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface HaCmdMapper {

    public Integer selectCmdId(Map<String,Object> cmd);

    public Integer insertCmd(Map<String,Object> cmd);

    public Map<String,Object> selectCmdParmsById(Integer id);

    public String selectCentorById(Integer centorid);

    public List<HaCmd> selectAllCmd(HaCmd haCmd);

    public Integer insertCmdTwo(HaMeter haMeter);

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
    public HaCmd BreturnID(HaCmd haCmd);

    /**
     * 添加命令执行表
     * @param haCmd
     * @return
     */
    public Integer BinsertHaCmd(HaCmd haCmd);
}
