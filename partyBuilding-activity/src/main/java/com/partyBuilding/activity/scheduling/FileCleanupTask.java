package com.partyBuilding.activity.scheduling;

import com.partyBuilding.common.annotation.Log;
import com.partyBuilding.common.constant.UserTaskConstants;
import com.partyBuilding.common.enums.BusinessType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.time.Duration;
import java.time.Instant;
import java.util.Objects;

//定期清理临时文件
@Component
public class FileCleanupTask {

    // 每天凌晨 2:00 执行一次
    @Scheduled(cron = "0 0 2  * * ?")
    public void cleanupTempFiles() {
        String tempDirPath = UserTaskConstants.UPLOAD_FILE_TEMPORARY_PATH;
        long maxAgeInHours = UserTaskConstants.UPLOAD_FILE_TEMPORARY_TIME;  // 删除超过 24 小时的文件

        File tempDir = new File(tempDirPath);
        //判断临时目录是否存在
        if (!tempDir.exists() || !tempDir.isDirectory()) {
            System.out.println("临时目录不存在或不是目录");
            return;
        }
        //删除文件，指定时间内未修改则删除文件
        deleteRecursively(tempDir, maxAgeInHours);
    }

    //递归删除文件
    private void deleteRecursively(File fileOrDir, long maxAgeInHours) {
        if (fileOrDir.isFile()) {
            Instant lastModified = Instant.ofEpochMilli(fileOrDir.lastModified());
            Instant now = Instant.now();
            if (Duration.between(lastModified, now).toHours() >= maxAgeInHours) {
                boolean deleted = fileOrDir.delete();
                if (deleted) {
                    System.out.println("已删除文件：" + fileOrDir.getAbsolutePath());
                } else {
                    System.err.println("无法删除文件：" + fileOrDir.getAbsolutePath());
                }
            }
        } else if (fileOrDir.isDirectory()) {
            File[] files = fileOrDir.listFiles();
            if (files != null) {
                for (File child : files) {
                    deleteRecursively(child, maxAgeInHours);
                }
            }
        }
    }
}