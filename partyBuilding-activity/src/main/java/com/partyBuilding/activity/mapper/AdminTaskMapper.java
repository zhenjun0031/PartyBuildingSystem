package com.partyBuilding.activity.mapper;

import com.partyBuilding.activity.domain.Task;
import com.partyBuilding.activity.domain.UserTask;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

import java.util.List;

@Mapper
public interface AdminTaskMapper {

    List<UserTask> selectProgress(String name);

    List<UserTask> detail(Long studentId);

    List<Task>  selectTasks();

    int insertTask(Task task);

    int deleteTask(Long id);

    int deleteTasks(Long[] ids);


    /**
     * 统计管理员下的未/已完成数
     * @return {
     *     未完成数 uncompleted
     *     已完成数 completed
     * }
     */
    @Select("select count(studentId) from usertask where status = #{status}")
    Integer countTaskStats(@Param("status") int status);
}