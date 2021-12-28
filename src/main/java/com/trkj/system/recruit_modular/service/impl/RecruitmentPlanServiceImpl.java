package com.trkj.system.recruit_modular.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.recruit_modular.entity.RecruitmentPlanVo;
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
 * @since 2021-12-28
 */
@Service
public class RecruitmentPlanServiceImpl  implements RecruitmentPlanService {

    @Autowired
    private RecruitmentPlanMapper recruitmentPlanMapper;


    @Override
    public IPage<RecruitmentPlanVo> selectAll(Page<RecruitmentPlanVo> page) {
        System.out.println("111111111111111111111111111111");
        return recruitmentPlanMapper.selectAllRecruitment(page);
    }

}
