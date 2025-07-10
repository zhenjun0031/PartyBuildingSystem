package com.partyBuilding.activity.mapper;

import com.github.pagehelper.Page;
import com.partyBuilding.activity.domain.UserTask;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Mapper
public interface UserTaskMapper {


    /**
     * 查询用户任务列表
     * @param StudentId
     * @return
     */
    @Select("select id,taskName,userTask.beginTime,userTask.endTime,commitTime,status from userTask where studentId=#{studentId}")
    Page<UserTask> list(String StudentId);

    /**
     * 更新用户任务
     * @param userTask
     * @return
     */
    int update(UserTask userTask);

    /**
     * 根据id查询用户任务
     * @param id
     * @return
     */
    UserTask  getById(Long id);

    /**
     * 查询用户未完成数
     * @param studentId
     * @return
     */
    @Select("SELECT COUNT(*) FROM userTask WHERE studentId = #{studentId} AND status=0")
    Integer countUnfinishedByStudentId(String studentId);

    /**
     * 获取当前用户学号值
     * 根据用户id查询用户学号
     * @param userId
     * @return studentId
     */
    @Select("SELECT sys_user.student_id FROM sys_user WHERE sys_user.user_id = #{userId}")
    String getStudentId(Long userId);

    /**
     * 查询学生学号信息
     * @return
     */
    List<UserTask> getAllStudentIds();

    /**
     * 添加学生任务
     * @return
     */
    int insertUserTask(List<UserTask> records);

    /**
     * 删除学生任务
     * @param ids
     * @return
     */
    int deleteUserTask(Long[] ids);
}
