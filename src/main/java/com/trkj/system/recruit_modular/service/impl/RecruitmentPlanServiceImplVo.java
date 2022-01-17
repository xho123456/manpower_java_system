package com.trkj.system.recruit_modular.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.recruit_modular.entity.RecruitmentPlanVo;
import com.trkj.system.recruit_modular.mapper.RecruitmentPlanMapperVo;
import com.trkj.system.recruit_modular.service.RecruitmentPlanServiceVo;
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
public class RecruitmentPlanServiceImplVo implements RecruitmentPlanServiceVo {

    @Autowired
    private RecruitmentPlanMapperVo recruitmentPlanMappervo;
    //分页查询所有招聘计划
    @Override
    public IPage<RecruitmentPlanVo> selectAll(RecruitmentPlanVo recruitmentPlanVo) {
        //招聘计划分页查询all数据
        Page<RecruitmentPlanVo> page = new Page<>(recruitmentPlanVo.getCurrenPage(),recruitmentPlanVo.getPagesize());
        QueryWrapper<RecruitmentPlanVo> queryWrapper = new QueryWrapper<>();

        if (recruitmentPlanVo.getRecruitmentZt()!=null && !recruitmentPlanVo.getRecruitmentZt().equals("")){
            //招聘计划状态模糊查询数据
            queryWrapper.like("R.RECRUITMENT_ZT",recruitmentPlanVo.getRecruitmentZt());
        }

        if (recruitmentPlanVo.getRecruitmentPlanName()!=null&& !recruitmentPlanVo.getRecruitmentPlanName().equals("")){
            //招聘计划名称模糊查询数据
            queryWrapper.like("R.RECRUITMENT_PLAN_NAME",recruitmentPlanVo.getRecruitmentPlanName());
        }

        //逻辑删除查询
        queryWrapper.eq("R.IS_DELETED",0).orderByDesc("R.RECRUITMENT_PLAN_ID");

        return recruitmentPlanMappervo.selectAllRecruitment(page,queryWrapper);

    }

}
