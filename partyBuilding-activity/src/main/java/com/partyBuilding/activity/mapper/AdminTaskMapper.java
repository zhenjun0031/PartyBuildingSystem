package com.partyBuilding.activity.mapper;

import com.partyBuilding.activity.domain.Task;
import com.partyBuilding.activity.domain.UserTask;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

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

    /**
     * 统计管理员下的未/已完成数
     * @return {
     *     未完成数 uncompleted
     *     已完成数 completed
     * }
     */
    @Select("SELECT" +
            "SUM(CASE WHEN ut.status = 0 THEN 1 ELSE 0 END) as uncompleted, "+
            "SUM(CASE WHEN ut.status = 1 THEN 1 ELSE 0 END) as completed " +
            "FROM usertask ut "+
            "JOIN task t ON ut.taskId=t.id "
    )
    Map<String, Integer > countTaskStats();
}