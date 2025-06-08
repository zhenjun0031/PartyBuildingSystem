package com.partyBuilding.activity.domain;

import com.partyBuilding.common.annotation.Excel;
import com.partyBuilding.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 管理员的任务管理
 */
public class Task extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 任务id */
    private Long id;

    /** 任务名称 */
    @Excel(name="任务名称")
    private String taskName;

    /** 开始时间 */
    @Excel(name="开始时间")
    private Date beginTime;

    /** 结束时间 */
    @Excel(name="结束时间")
    private Date endTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /* 打印方便调试查看 **/
    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                '}';
    }

}
