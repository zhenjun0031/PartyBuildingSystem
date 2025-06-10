package com.partyBuilding.activity.service;

import com.partyBuilding.activity.domain.vo.PageVo;
import com.partyBuilding.common.core.page.PageDomain;

public interface IAdminTaskService {
    //  查询全部进度
    PageVo selectProgress(Integer pageNum, Integer pageSize);
    //查询具体进度
    PageVo detail(Integer pageNum, Integer pageSize, Long studentId);
}
