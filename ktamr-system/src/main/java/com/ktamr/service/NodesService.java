package com.ktamr.service;

import java.util.List;
import java.util.Map;

/**
 * 父类Service
 */
public interface NodesService {

    /**
     * 查询所有大区节点名称
     * @return
     */
    public List<Map<String,Object>> selectAllRgnNodes(Map<String,Object> map);

    public List<Map<String,Object>> selectAllAreaNodes(Map<String,Object> map);

    public List<Map<String,Object>> selectAllBuildingNodes(Integer id);

    public List<Map<String,Object>> selectAllCentorzNodes(String areaType,String id);

    public List<Map<String,Object>> selectAllCentorcNodes(String rgnAndAreaId,String id);

    public List<Map<String,Object>> selectAllCollectorNodes(Integer collectorid);
}
