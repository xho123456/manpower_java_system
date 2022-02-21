package com.trkj.system.workbench.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.system.recruit_modular.entity.Resume;
import com.trkj.system.workbench.entity.workRecruitmentPlan;
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
 * @since 2022-02-06
 */
@Mapper
public interface workRecruitmentPlanMapper extends BaseMapper<workRecruitmentPlan> {
    //招聘计划:在招职位
    @Select("select count(*) from RECRUITMENT_PLAN ${ew.customSqlSegment}")
    int selecnumber(@Param(Constants.WRAPPER) QueryWrapper queryWrapper);

    //简历
    @Select("select count(*) from RESUME ${ew.customSqlSegment}")
    int selectnum(@Param(Constants.WRAPPER) QueryWrapper queryWrapper);

}
