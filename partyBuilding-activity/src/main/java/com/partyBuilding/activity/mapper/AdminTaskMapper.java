package com.partyBuilding.activity.mapper;

import com.github.pagehelper.Page;
import com.partyBuilding.activity.domain.Task;
import com.partyBuilding.activity.domain.UserTask;
import com.partyBuilding.activity.domain.dto.AdminTaskPageQureyDTO;
import com.partyBuilding.activity.domain.vo.UserTaskVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
    @Select("select count(studentId) from userTask where status = #{status}")
    Integer countTaskStats(@Param("status") int status);

     /**
     * 按时间查询（年月查询）
     * @param adminTaskPageQureyDTO
     * @return
     */
    Page<Task> selectByYearAndMonth(AdminTaskPageQureyDTO adminTaskPageQureyDTO);

    /**
     * 按人名查询
     * @param name
     * @return
     */
    Page<UserTaskVo> selectByName(String name);

    //根据人名查询学号
    @Select("select studentId from userTask where userName = #{name} limit 1")
    String selectStudentIDByName(String name);

    //查询当前用户的总任务数
    @Select("select count(*) from userTask where userName = #{name}")
    Integer getTaskNumber(String name);

    //查询当前用户的已完成任务数
    @Select("select count(*) from userTask where userName = #{name} and status=1")
    Integer getFinishTaskNumber(String name);
}