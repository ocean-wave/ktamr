package com.ktamr.service.impl;

import com.ktamr.mapper.NodesMapper;
import com.ktamr.service.NodesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NodesServiceImpl implements NodesService {

    @Autowired
    private NodesMapper nodesMapper;

    @Override
    public List<Map<String,Object>> selectAllRgnNodes(String rgnAndAreaId) {
        return nodesMapper.selectAllRgnNodes(rgnAndAreaId);
    }

    @Override
    public List<Map<String,Object>> selectAllAreaNodes(String id) {
        return nodesMapper.selectAllAreaNodes(id);
    }

    @Override
    public List<Map<String, Object>> selectAllBuildingNodes(Integer id) {
        return nodesMapper.selectAllBuildingNodes(id);
    }

    @Override
    public List<Map<String, Object>> selectAllCentorzNodes(String areaType,String id) {
        return nodesMapper.selectAllCentorzNodes(areaType,id);
    }

    @Override
    public List<Map<String, Object>> selectAllCentorcNodes(String rgnAndAreaId) {
        return nodesMapper.selectAllCentorcNodes(rgnAndAreaId);
    }

    @Override
    public List<Map<String, Object>> selectAllCollectorNodes(Integer collectorid) {
        return nodesMapper.selectAllCollectorNodes(collectorid);
    }
}
