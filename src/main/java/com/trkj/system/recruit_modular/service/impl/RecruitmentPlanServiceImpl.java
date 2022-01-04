package com.trkj.system.recruit_modular.service.impl;

import com.trkj.system.recruit_modular.entity.RecruitmentPlan;
import com.trkj.system.recruit_modular.mapper.RecruitmentPlanMapper;
import com.trkj.system.recruit_modular.service.RecruitmentPlanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 招聘计划表 服务实现类
 * </p>
 *
 * @author 鄧琪
 * @since 2021-12-29
 */
@Service
public class RecruitmentPlanServiceImpl extends ServiceImpl<RecruitmentPlanMapper, RecruitmentPlan> implements RecruitmentPlanService {
   @Autowired
   private RecruitmentPlanMapper recruitmentPlanMapper;

    /**
     * 招聘计划: 关闭计划修改状态
     */
    @Override
    public int updateRecruitmentPlan(RecruitmentPlan recruitmentPlan) {
        return recruitmentPlanMapper.updateById(recruitmentPlan);
    }
    /**
     * 招聘计划: 删除招聘计划
     */
    @Override
    public int deleteRecruitmentPlan(Integer id) {
        return recruitmentPlanMapper.deleteById(id);
    }
}
