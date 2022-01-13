package com.trkj.system.recruit_modular.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.recruit_modular.entity.EmploymentTableVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 录用表Vo Mapper 接口
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-13
 */
@Mapper
public interface EmploymentTableMapperVo extends BaseMapper<EmploymentTableVo> {

    /**
     * 查询所有录用信息
     * @param page
     * @param queryWrapper
     * @return
     */
    @Select("select  E.*,R.RESUME_NAME,R.RESUME_SEX,R.RESUME_PHONE,R.RESUME_EDUCATION,R.RESUME_SCOLLER,R.RESUME_HY,R.RESUME_AGE,R.RESUME_QXINGZ,R.RESUME_QZHIW,R.RESUME_SHENGG,R.RESUME_ZJZW,R.RESUME_MAILBOX,R.RESUME_PHOTO,R.RESUME_INTRODUCE,R.RESUME_BIRTHDAY,R.RESUME_RESIDENCE,R.RECRUITMENT_PLAN_ID,R.RESUME_POLITICAL_OUTLOOK,R.RESUME_ZT,R.TouJ_TIME,R.remarks, P.POST_NAME,D.DEPT_NAME,Z.RECRUITMENT_PLAN_NAME\n" +
            "FROM EMPLOYMENT_TABLE E LEFT JOIN RESUME R  ON R.RESUME_ID = E.RESUME_ID\n" +
            "LEFT JOIN  RECRUITMENT_PLAN Z ON R.RECRUITMENT_PLAN_ID = Z.RECRUITMENT_PLAN_ID\n" +
            "LEFT JOIN DEPT_POST P ON Z.DEPT_POST_ID = P.DEPT_POST_ID LEFT JOIN DEPT D on\n" +
            "Z.DEPT_ID = D.DEPT_ID ${ew.customSqlSegment}")
    IPage<EmploymentTableVo> findAllemployment(Page<EmploymentTableVo> page, @Param(Constants.WRAPPER) QueryWrapper queryWrapper);

}
