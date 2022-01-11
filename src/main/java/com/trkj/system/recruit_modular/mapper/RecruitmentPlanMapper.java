package com.trkj.system.recruit_modular.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.system.recruit_modular.entity.RecruitmentPlan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 招聘计划表 Mapper 接口
 * </p>
 *
 * @author 鄧琪
 * @since 2021-12-29
 */
@Mapper
public interface RecruitmentPlanMapper extends BaseMapper<RecruitmentPlan> {
    //根据职位id和部门id查询所有招聘计划名称
    @Select("select * from RECRUITMENT_PLAN ${ew.customSqlSegment}")
    List<RecruitmentPlan> findByids(@Param(Constants.WRAPPER) QueryWrapper queryWrapper);


}
