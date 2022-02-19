package com.trkj.system.recruit_modular.service;

import com.trkj.system.recruit_modular.entity.WorkExperiencess;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 工作经历表 服务类
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-06
 */
public interface WorkExperiencessService{

    //个人简历信息页面：工作经历查询
    List<WorkExperiencess> selectByidWork(WorkExperiencess workExperiencess);
    //新增工作经历
    int addWorkexper(WorkExperiencess workExperiencess);
    //删除工作经历信息
    int deletehomes(Integer id);
}
