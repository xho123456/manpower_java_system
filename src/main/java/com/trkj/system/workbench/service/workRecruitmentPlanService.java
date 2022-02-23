package com.trkj.system.workbench.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.system.recruit_modular.entity.Resume;
import com.trkj.system.workbench.entity.workRecruitmentPlan;
import com.trkj.system.workbench.entity.workResume;

import java.util.List;

/**
 * <p>
 * 招聘计划表 服务类
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-06
 */
public interface workRecruitmentPlanService {
    //招聘计划
    int selecnumber(workRecruitmentPlan workRecruitmentPlan);
    //简历
    int selecnumber(workResume workResume);

}
