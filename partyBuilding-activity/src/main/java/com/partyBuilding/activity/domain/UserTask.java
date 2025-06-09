package com.partyBuilding.activity.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.partyBuilding.common.annotation.Excel;
import com.partyBuilding.common.core.domain.BaseEntity;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 普通用户的任务管理表
 */
public class UserTask extends BaseEntity {

    private static final long serialVersionUID = 1L;


    private Long id;

    /**
     * 学生id（学号）
     */
    @Excel(name = "学号")
    private Long studentId;

    /**
     * 姓名
     */
    @Excel(name = "姓名")
    private String name;

    /**
     * 任务id
     */
    @Excel(name = "任务id")
    private int taskId;

    /**
     * 任务名称
     */
    @Excel(name = "任务名称")
    private String taskName;

    /**
     * 任务开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "开始时间")
    private Date beginTime;

    /**
     * 任务结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "结束时间")
    private Date endTime;

    /**
     * 任务状态
     */
    @Excel(name = "任务状态")
    private int status;

    /**
     * 提交时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "提交时间")
    private Date commitTime;


    /**
     * 提交文件地址
     */
    @Excel(name = "提交文件地址")
    private String file;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }

    public String getCommitFile() {
        return file;
    }

    public void setCommitFile(String commitFile) {
        this.file = commitFile;
    }

    @Override
    public String toString() {
        return "UserTask{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", name='" + name + '\'' +
                ", taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", status=" + status +
                ", commitTime=" + commitTime +
                ", file='" + file + '\'' +
                '}';
    }
}
