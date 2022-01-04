package com.trkj.system.recruit_modular.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.recruit_modular.entity.RecruitmentPlanVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 招聘计划表VO Mapper 接口
 * </p>
 *
 * @author 鄧琪
 * @since 2021-12-28
 */
@Mapper
public interface RecruitmentPlanMapperVo extends BaseMapper<RecruitmentPlanVo> {
    //分页查询所有招聘计划
    @Select("select RECRUITMENT_PLAN_ID,RECRUITMENT_PLAN_NAME,EDUCATION_NAME,RECRUITMENT_PLAN_NUMBER,RECRUITMENT_PLAN_START_TIME,RECRUITMENT_PLAN_END_TIME,RECRUITMENT_PLAN_SALARY,RECRUITMENT_ZT,R.CREATED_TIME,R.UPDATED_TIME,R.REVISION,R.IS_DELETED,D.DEPT_NAME,P.POST_NAME,S.STAFF_NAME\n" +
            "FROM\n" +
            "RECRUITMENT_PLAN R LEFT JOIN DEPT D on R.DEPT_ID = D.DEPT_ID LEFT JOIN DEPT_POST P on R.DEPT_POST_ID = P.DEPT_POST_ID LEFT JOIN STAFF S on R.STAFF_ID = S.STAFF_ID ${ew.customSqlSegment}")
    IPage<RecruitmentPlanVo> selectAllRecruitment(Page<RecruitmentPlanVo> page, @Param(Constants.WRAPPER)QueryWrapper queryWrapper);


}
