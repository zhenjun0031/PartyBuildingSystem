package com.partyBuilding.common.constant;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserTaskConstants {

    //  用户任务列表每页显示数量
    public static final Integer USER_TASK_PAGE_SIZE = 14;

    //任务状态（已完成）
    public static final Integer STATUS_COMPLETED = 1;

    //任务状态（未完成）
    public static final Integer STATUS_UNFINISHED = 0;

    //上传文件最大大小
    public static final long UPLOAD_FILE_MAX_SIZE = 10 * 1024 * 1024;

    //支持文件上传类型
    public static final List<String> UPLOAD_FILE_TYPES =
            Arrays.asList("jpg", "jpeg", "png", "gif",
                    "bmp", "doc", "docx", "xls", "xlsx", "ppt", "pptx", "pdf", "txt",
                    "zip", "rar", "7z");

    //项目路径
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    //文件上传路径
    public static final String UPLOAD_FILE_PATH = PROJECT_PATH+"/"+"partyBuilding-activity/src/main/resources/static";
    //临时文件上传路径
    public static final String UPLOAD_FILE_TEMPORARY_PATH = PROJECT_PATH+"/"+ "temporary";

    //临时文件最大可保存时间(小时)
    public static final Integer UPLOAD_FILE_TEMPORARY_TIME = 24;
}
