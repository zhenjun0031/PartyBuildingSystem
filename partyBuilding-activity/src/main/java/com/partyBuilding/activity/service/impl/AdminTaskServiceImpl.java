package com.partyBuilding.activity.service.impl;

import com.partyBuilding.activity.mapper.AdminTaskMapper;
import com.partyBuilding.activity.service.IAdminTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AdminTaskServiceImpl implements IAdminTaskService {
    private static final Logger log = LoggerFactory.getLogger(AdminTaskServiceImpl.class);
    @Autowired
    private AdminTaskMapper adminTaskMapper;

    /**
     *获取管理员下的未/已完成数
     */
    @Override
    public Map<String,Integer > getTaskStats(){
        Map<String,Integer> stats = adminTaskMapper.countTaskStats();
        return Map.of(
                "uncompleted", stats.getOrDefault("uncompleted", 0),
                "completed", stats.getOrDefault("completed",1)
        );
    }
}
