package com.trkj.system.recruit_modular.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.system.recruit_modular.entity.InterviewVo;
import com.trkj.system.recruit_modular.entity.Resume;
import com.trkj.system.recruit_modular.mapper.ResumeMapper;
import com.trkj.system.recruit_modular.service.ResumeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 简历表 服务实现类
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-05
 */
@Service
public class ResumeServiceImpl extends ServiceImpl<ResumeMapper, Resume> implements ResumeService {

    @Autowired
    private ResumeMapper mapper;

    //逻辑删除简历信息
    @Transactional
    @Override
    public int deleteByidResume(Integer id) {
        return mapper.deleteById(id);
    }
    //修改：添加简历备注信息
    @Transactional
    @Override
    public int updateremarks(Resume resume) {
        return mapper.updateById(resume);
    }
    //转入淘汰库
    @Transactional
    @Override
    public int updateeliminate(Resume resume) {
        return mapper.updateById(resume);
    }

    //修改: 设置候选人、备注信息
    @Transactional
    @Override
    public int updatehb(Resume resume) {
        return mapper.updateById(resume);
    }

    //添加简历
    @Transactional
    @Override
    public int addResume(Resume resume) {
        return mapper.insert(resume);
    }

    //招聘计划：简历数量统计
    @Override
    public int planhxr(Resume resume) {
        QueryWrapper<Resume> planwrapper = new QueryWrapper<>();
        planwrapper.eq("RECRUITMENT_PLAN_ID",resume.getRecruitmentPlanId());
        planwrapper.eq("RESUME_ZT",resume.getResumeZt());
        planwrapper.eq("IS_DELETED",0);
        return mapper.planhxr(planwrapper);
    }

}
