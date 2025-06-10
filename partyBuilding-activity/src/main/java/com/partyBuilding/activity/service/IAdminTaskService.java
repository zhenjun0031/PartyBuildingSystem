package com.partyBuilding.activity.service;

import com.partyBuilding.activity.domain.UserTask;
import com.partyBuilding.common.core.page.PageDomain;

public interface IAdminTaskService {

    PageDomain selectProgress(Integer pageNum, Integer pageSize);

    PageDomain detail(Integer pageNum, Integer pageSize, Long studentId);
}
