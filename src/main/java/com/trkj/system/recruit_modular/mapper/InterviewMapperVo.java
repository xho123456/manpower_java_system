package com.trkj.system.recruit_modular.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.system.recruit_modular.entity.InterviewVo;
import com.trkj.system.recruit_modular.entity.ResumeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 面试表 Mapper 接口
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-12
 */
@Mapper
public interface InterviewMapperVo extends BaseMapper<InterviewVo> {

    /**
     * 简历列表分页查询：已邀约
     */
    @Select("select  I.*,S.STAFF_NAME,\n" +
            "R.RESUME_NAME,R.RESUME_SEX,R.RESUME_PHONE,R.RESUME_EDUCATION,R.RESUME_SCOLLER,R.RESUME_HY,R.RESUME_AGE,R.RESUME_QXINGZ,R.RESUME_QZHIW,R.RESUME_SHENGG,R.RESUME_ZJZW,R.RESUME_MAILBOX,R.RESUME_PHOTO,R.RESUME_INTRODUCE,R.RESUME_BIRTHDAY,R.RESUME_RESIDENCE,R.RECRUITMENT_PLAN_ID,R.RESUME_POLITICAL_OUTLOOK,R.RESUME_ZT,R.TouJ_TIME,R.remarks, P.POST_NAME,D.DEPT_NAME,Z.RECRUITMENT_PLAN_NAME\n" +
            "FROM INTERVIEW I LEFT JOIN RESUME R  ON R.RESUME_ID = I.RESUME_ID\n" +
            "LEFT JOIN  RECRUITMENT_PLAN Z ON R.RECRUITMENT_PLAN_ID = Z.RECRUITMENT_PLAN_ID\n" +
            "LEFT JOIN DEPT_POST P ON Z.DEPT_POST_ID = P.DEPT_POST_ID LEFT JOIN DEPT D on\n" +
            "Z.DEPT_ID = D.DEPT_ID LEFT JOIN STAFF S ON I.STAFF_ID = S.STAFF_ID ${ew.customSqlSegment}")
    IPage<InterviewVo> findAlleInvite(Page<InterviewVo> page, @Param(Constants.WRAPPER) QueryWrapper queryWrapper);



}
