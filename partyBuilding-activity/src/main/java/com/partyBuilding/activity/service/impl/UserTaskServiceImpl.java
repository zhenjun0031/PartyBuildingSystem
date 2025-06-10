package com.partyBuilding.activity.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.partyBuilding.activity.domain.UserTask;
import com.partyBuilding.activity.domain.dto.UserTaskHandleDto;
import com.partyBuilding.activity.domain.dto.UserTaskPageQueryDto;
import com.partyBuilding.activity.domain.vo.PageVo;
import com.partyBuilding.activity.mapper.UserTaskMapper;
import com.partyBuilding.activity.service.IUserTaskService;
import com.partyBuilding.common.constant.UserTaskConstants;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Service
public class UserTaskServiceImpl implements IUserTaskService {
    @Autowired
    private UserTaskMapper userTaskMapper;


    /**
     * 分页查询用户任务
     * @param userTaskPageQueryDto
     * @return
     */
    @Override
    public PageVo list(UserTaskPageQueryDto userTaskPageQueryDto) {
        //校验参数
        if(Objects.isNull(userTaskPageQueryDto)||
                Objects.isNull(userTaskPageQueryDto.getStudentId())||
                Objects.isNull(userTaskPageQueryDto.getPage())){
            throw new RuntimeException("参数错误");
        }
        //获取分页查询信息
        Integer page=userTaskPageQueryDto.getPage();
        String studentId=userTaskPageQueryDto.getStudentId();
        //开启分页查询
        PageHelper.startPage(page, UserTaskConstants.USER_TASK_PAGE_SIZE);
        Page<UserTask> pageResult = userTaskMapper.list(studentId);
        return new PageVo(pageResult.getTotal(),  pageResult.getResult());
    }

    
    /**
     * 用户办理任务
     * @param userTaskHandleDto
     */
    @Override
    public void handle(UserTaskHandleDto userTaskHandleDto) {
       //校验参数
        if(Objects.isNull(userTaskHandleDto)){
            throw new RuntimeException("参数错误");
        }else if(userTaskHandleDto.getFile()==null || userTaskHandleDto.getFile().isEmpty()){
            throw new RuntimeException("请上传文件");
        }
        //封装任务对象
        UserTask userTask = new UserTask();
        BeanUtils.copyProperties(userTaskHandleDto,userTask);
        userTask.setStatus(UserTaskConstants.STATUS_COMPLETED);
        userTask.setCommitTime(LocalDateTime.now());
        //更新任务
        int count=userTaskMapper.update(userTask);
        //判断更新结果
        if (count<=0){
            throw new RuntimeException("更新任务失败");
        }
    }


    /**
     * 用户上传文件
     * @param file
     */
    @Override
    public String userFileUpload(MultipartFile file,Long id) {
        //校验文件大小
        if(Objects.isNull(id)){
            throw new RuntimeException("参数异常");
        }
        if(Objects.isNull(file)){
            throw new RuntimeException("请上传文件");
        }else if (file.getSize()>UserTaskConstants.UPLOAD_FILE_MAX_SIZE){
            throw new RuntimeException("文件过大");
        }
        //校验文件后缀
            //拼接提示字符串
        StringBuilder str=new StringBuilder();
        UserTaskConstants.UPLOAD_FILE_TYPES.forEach(x->str.append(x).append(","));
            //进行判断
        String fileName = file.getOriginalFilename();
        String suffix;
        if(!Objects.isNull(fileName) && fileName.contains(".")){
            suffix=fileName.substring(fileName.lastIndexOf(".")+1);
        } else  {
            throw new RuntimeException("文件非法，只支持上传：" + str.toString()+ "等文件");
        }
        if(!UserTaskConstants.UPLOAD_FILE_TYPES.contains(suffix)){
            throw new RuntimeException("文件非法，只支持上传：" + str.toString()+ "等文件");
        }
        if(fileName.length()>=30){
            throw new RuntimeException("文件名最多支持30个字符");
        }

        //上传文件到本地
        try {
            //获取基本路径
            String  basePath =UserTaskConstants.UPLOAD_FILE_PATH;
            //获取当前时间
            DateTimeFormatter  formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            String time=LocalDateTime.now().format(formatter);
            //获取任务名
            UserTask userTask = userTaskMapper.getById(id);
            String taskName=userTask.getTaskName();
            fileName=userTask.getStudentId()+"_"+System.currentTimeMillis()+"_"+fileName;
            //拼接文件路径
            String path=basePath+"/"+taskName+"/"+time;
            File filePath = new File(path);
            //保存文件
            if(!filePath.exists()){
                filePath.mkdirs();
            }
            file.transferTo(new File(System.getProperty("user.dir")+"/"+path+"/"+fileName));
            return taskName+"/"+time+"/"+fileName;
        } catch (IOException e) {
            throw new RuntimeException("文件上传失败");
        }

    }
}
