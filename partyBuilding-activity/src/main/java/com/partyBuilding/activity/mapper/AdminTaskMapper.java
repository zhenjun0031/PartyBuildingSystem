package com.partyBuilding.activity.mapper;

import com.partyBuilding.activity.domain.Task;
import com.partyBuilding.activity.domain.UserTask;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminTaskMapper {

    List<UserTask> selectProgress();

    List<UserTask> detail(Long studentId);

    List<Task>  selectTasks();

    int insertTask(Task task);

    int deleteTask(Long id);

    int deleteTasks(Long[] ids);
}
