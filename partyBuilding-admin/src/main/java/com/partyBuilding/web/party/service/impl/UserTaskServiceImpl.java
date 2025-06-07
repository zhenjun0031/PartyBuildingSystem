package com.partyBuilding.web.party.service.impl;

import com.partyBuilding.web.party.mapper.UserTaskMapper;
import com.partyBuilding.web.party.service.IUserTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTaskServiceImpl implements IUserTaskService {
    @Autowired
    private UserTaskMapper userTaskMapper;
}
