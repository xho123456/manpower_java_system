package com.trkj.system.recruit_modular.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.recruit_modular.entity.RecruitmentPlanVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 招聘计划表 Mapper 接口
 * </p>
 *
 * @author 鄧琪
 * @since 2021-12-28
 */
@Mapper
public interface RecruitmentPlanMapper extends BaseMapper<RecruitmentPlanVo> {

    @Select("select RECRUITMENT_PLAN_ID,D.DEPT_NAME,P.POST_NAME,EDUCATION_NAME,RECRUITMENT_PLAN_NUMBER,RECRUITMENT_PLAN_START_TIME,RECRUITMENT_PLAN_END_TIME,RECRUITMENT_PLAN_NAME\n" +
            "RECRUITMENT_PLAN_SALARY_ID,RECRUITMENT_ZT,R.CREATED_TIME,R.UPDATED_TIME,R.REVISION,R.IS_DELETED\n" +
            "from DEPT D \n" +
            "inner join  RECRUITMENT_PLAN R on D.DEPT_ID =  R.DEPT_ID LEFT JOIN DEPT_POST P on R.DEPT_POST_ID = P.DEPT_POST_ID\n")
    IPage<RecruitmentPlanVo> selectAllRecruitment(Page<RecruitmentPlanVo> page);
}
