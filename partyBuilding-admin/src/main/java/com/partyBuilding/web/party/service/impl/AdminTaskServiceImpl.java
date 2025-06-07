package com.partyBuilding.web.party.service.impl;

import com.partyBuilding.web.party.mapper.AdminTaskMapper;
import com.partyBuilding.web.party.service.IAdminTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminTaskServiceImpl implements IAdminTaskService {
    @Autowired
    private AdminTaskMapper adminTaskMapper;

}
