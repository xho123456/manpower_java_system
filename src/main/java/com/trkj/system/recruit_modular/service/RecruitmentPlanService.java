package com.trkj.system.recruit_modular.service;

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
public interface RecruitmentPlanService {
    /**
     * 招聘计划分页查询
     */
    IPage<RecruitmentPlanVo> selectAll(Page<RecruitmentPlanVo> page);
}
