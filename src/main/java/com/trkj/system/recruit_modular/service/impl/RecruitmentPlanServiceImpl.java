package com.trkj.system.recruit_modular.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.system.recruit_modular.entity.RecruitmentPlan;
import com.trkj.system.recruit_modular.mapper.RecruitmentPlanMapper;
import com.trkj.system.recruit_modular.service.RecruitmentPlanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 招聘计划表 服务实现类
 * </p>
 *
 * @author 鄧琪
 * @since 2021-12-29
 */
@Service
public class RecruitmentPlanServiceImpl implements RecruitmentPlanService {
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

    /**
     *根据职位id和部门id查询所有招聘计划名称
     */
    @Override
    public List<RecruitmentPlan> findByidall(RecruitmentPlan RecruitmentPlan) {
        QueryWrapper<RecruitmentPlan> wrappers = new QueryWrapper<>();
            //部门编号
            wrappers.eq("DEPT_ID",RecruitmentPlan.getDeptId());
            //职位编号
            wrappers.eq("DEPT_POST_ID",RecruitmentPlan.getDeptPostId());


        //逻辑删除
        wrappers.eq("IS_DELETED",0);
        return recruitmentPlanMapper.findByids(wrappers);
    }
}
