package com.trkj.system.recruit_modular.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.system.recruit_modular.entity.RecruitmentPlanVo;

/**
 * <p>
 * 招聘计划表 服务类
 * </p>
 *
 * @author 鄧琪
 * @since 2021-12-28
 */
public interface RecruitmentPlanServiceVo {
    /**
     * 分页查询所有招聘计划
     */
    IPage<RecruitmentPlanVo> selectAll(RecruitmentPlanVo recruitmentPlanVo);


}
