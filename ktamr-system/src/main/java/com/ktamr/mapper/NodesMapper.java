package com.ktamr.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 父类Mapper
 */
public interface NodesMapper {

    /**
     * 查询所有大区节点名称
     * @return
     */
    public List<Map<String,Object>> selectAllRgnNodes();

    public List<Map<String,Object>> selectAllAreaNodes(String id);

    public List<Map<String,Object>> selectAllBuildingNodes(Integer id);

    public List<Map<String,Object>> selectAllCentorzNodes(@Param(value = "wheresql") String wheresql);

    public List<Map<String,Object>> selectAllCentorcNodes(@Param(value = "wheresql") String wheresql);

    public List<Map<String,Object>> selectAllCollectorNodes(Integer collectorid);
}
