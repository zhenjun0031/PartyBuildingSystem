package com.partyBuilding.activity.service.impl;

import com.github.pagehelper.PageHelper;
import com.partyBuilding.activity.domain.UserTask;
import com.partyBuilding.activity.mapper.AdminTaskMapper;
import com.partyBuilding.activity.service.IAdminTaskService;
import com.partyBuilding.common.core.page.PageDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminTaskServiceImpl implements IAdminTaskService {
    @Autowired
    private AdminTaskMapper adminTaskMapper;

    @Override
    public PageDomain selectProgress(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserTask> taskList = adminTaskMapper.selectProgress();
        PageDomain p = (PageDomain) taskList;
        return p;
    }

    @Override
    public PageDomain detail(Integer pageNum, Integer pageSize , Long studentId) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserTask> taskList = adminTaskMapper.detail(studentId);
        PageDomain p = (PageDomain) taskList;
        return p;
    }

}
