package com.trkj.system.recruit_modular.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.system.recruit_modular.entity.RecruitmentPlan;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 招聘计划表 服务类
 * </p>
 *
 * @author 鄧琪
 * @since 2021-12-29
 */
public interface RecruitmentPlanService {
    /**
     * 招聘计划: 关闭计划修改状态
     */
    int updateRecruitmentPlan(RecruitmentPlan RecruitmentPlan);
    /**
     * 招聘计划: 删除招聘计划
     */
    int deleteRecruitmentPlan(Integer id);
    /**
     *  //根据职位id和部门id查询所有招聘计划名称
     */
    List<RecruitmentPlan> findByidall(RecruitmentPlan RecruitmentPlan);

    /**
     * 新增招聘计划
     */
    int addplan(RecruitmentPlan recruitmentPlan);

}
