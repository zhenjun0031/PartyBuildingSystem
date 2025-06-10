-- 创建任务表（如果不存在）
CREATE TABLE IF NOT EXISTS task (
                                    id INT AUTO_INCREMENT PRIMARY KEY,
                                    taskName VARCHAR(30) NOT NULL COMMENT '任务名称',
    beginTime DATETIME NOT NULL COMMENT '开始时间',
    endTime DATETIME NOT NULL COMMENT '结束时间'
    ) COMMENT '管理员的任务管理';

-- 创建用户任务关联表（如果不存在）
CREATE TABLE IF NOT EXISTS userTask (
                                        id         int auto_increment
                                            primary key,
                                        studentId  varchar(20)	    not null unique comment '学号',
                                        userName   varchar(10) not null comment '姓名',
                                        taskId     int         not null comment '任务id',
                                        taskName   varchar(30) not null comment '任务名称',
                                        beginTime  datetime        not null comment '开始时间',
                                        endTime    datetime        not null comment '结束时间',
                                        status     int         not null comment '状态（0：未提交/1：已提交）',
                                        commitTime datetime        null comment '提交时间',
                                        file       varchar(30) null comment '提交文件的地址'
    );