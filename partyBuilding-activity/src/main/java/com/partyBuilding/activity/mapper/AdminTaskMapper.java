package com.partyBuilding.activity.mapper;

import com.partyBuilding.activity.domain.UserTask;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminTaskMapper {

    List<UserTask> selectProgress();

    List<UserTask> detail(Long studentId);
}
