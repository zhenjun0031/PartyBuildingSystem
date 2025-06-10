package com.partyBuilding.activity.mapper;

import com.github.pagehelper.Page;
import com.partyBuilding.activity.domain.UserTask;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.GetMapping;

@Mapper
public interface UserTaskMapper {


    /**
     * 查询用户任务列表
     * @param StudentId
     * @return
     */
    @Select("select id,taskName,usertask.beginTime,usertask.endTime,commitTime,status from usertask where studentId=#{studentId}")
    Page<UserTask> list(String StudentId);
}
