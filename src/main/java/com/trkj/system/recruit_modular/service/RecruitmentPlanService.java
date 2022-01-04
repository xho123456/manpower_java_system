package com.trkj.system.recruit_modular.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.system.recruit_modular.entity.RecruitmentPlan;

/**
 * <p>
 * 招聘计划表 服务类
 * </p>
 *
 * @author 鄧琪
 * @since 2021-12-29
 */
public interface RecruitmentPlanService extends IService<RecruitmentPlan> {
    /**
     * 招聘计划: 关闭计划修改状态
     */
    int updateRecruitmentPlan(RecruitmentPlan RecruitmentPlan);
    /**
     * 招聘计划: 删除招聘计划
     */
    int deleteRecruitmentPlan(Integer id);
}
