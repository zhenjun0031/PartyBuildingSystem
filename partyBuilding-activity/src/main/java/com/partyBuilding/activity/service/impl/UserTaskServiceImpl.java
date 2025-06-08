package com.partyBuilding.activity.service.impl;

import com.partyBuilding.activity.mapper.UserTaskMapper;
import com.partyBuilding.activity.service.IUserTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTaskServiceImpl implements IUserTaskService {
    @Autowired
    private UserTaskMapper userTaskMapper;
}
