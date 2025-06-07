-- 创建任务表（如果不存在）
CREATE TABLE IF NOT EXISTS task (
                                    id INT AUTO_INCREMENT PRIMARY KEY,
                                    taskName VARCHAR(30) NOT NULL COMMENT '任务名称',
    beginTime DATE NOT NULL COMMENT '开始时间',
    endTime DATE NOT NULL COMMENT '结束时间'
    ) COMMENT '管理员的任务管理';

-- 创建用户任务关联表（如果不存在）
CREATE TABLE IF NOT EXISTS userTask (
                                        id INT AUTO_INCREMENT PRIMARY KEY,
                                        studentId INT NOT NULL COMMENT '学号',
                                        userName VARCHAR(10) NOT NULL COMMENT '姓名',
    taskId INT NOT NULL COMMENT '任务id',
    taskName VARCHAR(30) NOT NULL COMMENT '任务名称',
    beginTime DATE NOT NULL COMMENT '开始时间',
    endTime DATE NOT NULL COMMENT '结束时间',
    status INT NOT NULL COMMENT '状态（0：未提交/1：已提交）'
    );