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
    public List<Map<String,Object>> selectAllRgnNodes(Map<String,Object> map) {
        return nodesMapper.selectAllRgnNodes(map);
    }

    @Override
    public List<Map<String,Object>> selectAllAreaNodes(Map<String,Object> map) {
        return nodesMapper.selectAllAreaNodes(map);
    }

    @Override
    public List<Map<String, Object>> selectAllBuildingNodes(Integer id) {
        return nodesMapper.selectAllBuildingNodes(id);
    }

    @Override
    public List<Map<String, Object>> selectAllCentorzNodes(Map<String,Object> map) {
        return nodesMapper.selectAllCentorzNodes(map);
    }

    @Override
    public List<Map<String, Object>> selectAllCentorcNodes(Map<String,Object> map) {
        return nodesMapper.selectAllCentorcNodes(map);
    }

    @Override
    public List<Map<String, Object>> selectAllCollectorNodes(Integer collectorid) {
        return nodesMapper.selectAllCollectorNodes(collectorid);
    }
}
