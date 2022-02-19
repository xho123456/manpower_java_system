package com.trkj.system.recruit_modular.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.system.recruit_modular.entity.RecruitmentPlanVo;
import com.trkj.system.recruit_modular.entity.ResumeVo;

import java.util.List;

/**
 * <p>
 * 简历表Vo 服务类
 * </p>
 *
 * @author 鄧琪
 * @since 2021-12-31
 */
public interface ResumeServiceVo {
  //简历列表分页查询：全部简历
  IPage<ResumeVo> findAllresume(ResumeVo resumeVo);
  //简历列表分页查询：候选人
  IPage<ResumeVo> findAllhouxr(ResumeVo resumeVo);
  //简历列表分页查询：新简历
  IPage<ResumeVo> findAllnew(ResumeVo resumeVo);
  //简历列表分页查询：淘汰库
  IPage<ResumeVo> findAlltt(ResumeVo resumeVo);
  //分页 ：通过招聘计划编号查询出该计划招聘的所有简历信息
  IPage<ResumeVo> findByidresum(ResumeVo resumeVo);

  //简历信息详情页面查询
  ResumeVo selectAllid(ResumeVo resumeVo);
  //面试管理录用应聘者信息简历查询
  ResumeVo lufindbyid(ResumeVo resumeVo);







}
