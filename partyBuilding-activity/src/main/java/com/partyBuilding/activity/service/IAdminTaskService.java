package com.partyBuilding.activity.service;

import java.util.Map;

public interface IAdminTaskService {

    /**
     * 获取管理员下的未/已完成数
     */
    Map<String,Integer > getTaskStats();


}
