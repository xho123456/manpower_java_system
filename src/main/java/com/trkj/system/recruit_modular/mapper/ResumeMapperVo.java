package com.trkj.system.recruit_modular.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.recruit_modular.entity.ResumeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 简历表 Mapper 接口
 * </p>
 *
 * @author 鄧琪
 * @since 2021-12-31
 */
@Mapper
public interface ResumeMapperVo extends BaseMapper<ResumeVo> {
  //简历列表分页查询：全部简历
  @Select("select  R.*,Z.RECRUITMENT_PLAN_NAME,P.POST_NAME,D.DEPT_NAME from\n" +
          "          RESUME R LEFT JOIN RECRUITMENT_PLAN Z ON R.RECRUITMENT_PLAN_ID = Z.RECRUITMENT_PLAN_ID\n" +
          "          LEFT JOIN DEPT_POST P ON Z.DEPT_POST_ID = P.DEPT_POST_ID LEFT JOIN DEPT D on\n" +
          "\t\t\t\t\tZ.DEPT_ID = D.DEPT_ID ${ew.customSqlSegment}")
    IPage<ResumeVo> selectAllres(Page<ResumeVo> page,@Param(Constants.WRAPPER) QueryWrapper queryWrapper);

  //分页 ：通过招聘计划编号查询出该计划招聘的所有简历信息
  @Select("select R.*,Z.RECRUITMENT_PLAN_NAME,P.POST_NAME from RECRUITMENT_PLAN Z LEFT JOIN RESUME R ON Z.RECRUITMENT_PLAN_ID = R.RECRUITMENT_PLAN_ID LEFT JOIN DEPT_POST P " +
          "on Z.DEPT_POST_ID = P.DEPT_POST_ID ${ew.customSqlSegment}")
  IPage<ResumeVo> findByidAll(Page<ResumeVo> page, @Param(Constants.WRAPPER)QueryWrapper queryWrapper);

  //简历信息详情页面查询
  @Select("\n" +
          "select R.*,I.INTERVIEW_ID from RESUME R LEFT JOIN INTERVIEW I on R.RESUME_ID\n" +
          " = I.RESUME_ID ${ew.customSqlSegment}")
  ResumeVo selectBisid(@Param(Constants.WRAPPER) QueryWrapper queryWrapper);

}
