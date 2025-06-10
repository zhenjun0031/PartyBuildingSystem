package com.partyBuilding.activity.service;

import com.partyBuilding.activity.domain.vo.PageVo;
import com.partyBuilding.common.core.page.PageDomain;

public interface IAdminTaskService {

    PageVo selectProgress(Integer pageNum, Integer pageSize);

    PageVo detail(Integer pageNum, Integer pageSize, Long studentId);
}
