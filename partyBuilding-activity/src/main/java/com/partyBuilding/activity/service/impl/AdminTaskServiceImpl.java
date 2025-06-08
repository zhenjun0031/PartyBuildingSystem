package com.partyBuilding.activity.service.impl;

import com.partyBuilding.activity.mapper.AdminTaskMapper;
import com.partyBuilding.activity.service.IAdminTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminTaskServiceImpl implements IAdminTaskService {
    @Autowired
    private AdminTaskMapper adminTaskMapper;

}
