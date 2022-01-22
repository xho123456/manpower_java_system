package com.trkj.system.recruit_modular.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.recruit_modular.entity.Evaluate;
import com.trkj.system.recruit_modular.entity.InterviewVo;
import com.trkj.system.recruit_modular.mapper.EvaluateMapper;
import com.trkj.system.recruit_modular.mapper.InterviewMapperVo;
import com.trkj.system.recruit_modular.service.InterviewServiceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 面试表 服务实现类
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-12
 */
@Service
public class InterviewServiceImpl implements InterviewServiceVo {

    @Autowired
    private InterviewMapperVo mapperVo;

    @Autowired
    private EvaluateMapper evaluateMapper;

    /**
     * 简历列表分页查询：已邀约
     */
    @Override
    public IPage<InterviewVo> findAllInvite(InterviewVo resumeVo) {
        Page<InterviewVo> pageyy = new Page<>(resumeVo.getCurrenPage(), resumeVo.getPagesize());
        QueryWrapper<InterviewVo> wrapperyy = new QueryWrapper<>();
        if (resumeVo.getStartTime() != null && resumeVo.getEndTime() != null) {
            //模糊查询投稿时间范围
            wrapperyy.between("R.TouJ_TIME", resumeVo.getStartTime(), resumeVo.getEndTime());
        }
        if (resumeVo.getPostName() != null && !resumeVo.getPostName().equals("")) {
            //模糊查询简历中投递职位的数据
            wrapperyy.like("P.POST_NAME", resumeVo.getPostName());
        }
        if (resumeVo.getResumeEducation() != null && !resumeVo.getResumeEducation().equals("")) {
            //模糊查询简历中学历的数据
            wrapperyy.like("R.RESUME_EDUCATION", resumeVo.getResumeEducation());
        }
        if (resumeVo.getResumeName()!=null && !resumeVo.getResumeName().equals("")) {
            //模糊查询投简人简名称
            wrapperyy.like("R.RESUME_NAME", resumeVo.getResumeName());
        }
        if (resumeVo.getDeptName()!=null && !resumeVo.getDeptName().equals("")){
            wrapperyy.like("D.DEPT_NAME",resumeVo.getDeptName());
        }
        //状态：邀约简历查询
        wrapperyy.eq("R.RESUME_ZT", 2);
        //逻辑删除查询
        wrapperyy.eq("I.IS_DELETED", 0);
        return mapperVo.findAlleInvite(pageyy, wrapperyy);
    }
    /**
     * 分页查询出面试中的所有应聘人员信息
     * @return
     */
    @Override
    public IPage<InterviewVo> findall(InterviewVo interviewVo) {
        Page<InterviewVo> page =  new Page<>(interviewVo.getCurrenPage(),interviewVo.getPagesize());
        QueryWrapper<InterviewVo> wrapper = new QueryWrapper<>();
        if (interviewVo.getStartTime() != null && interviewVo.getEndTime() != null) {
            //模糊查询投稿时间范围
            wrapper.between("R.TouJ_TIME", interviewVo.getStartTime(), interviewVo.getEndTime());
        }
        if (interviewVo.getPostName() != null && !interviewVo.getPostName().equals("")) {
            //模糊查询简历中投递职位的数据
            wrapper.like("P.POST_NAME", interviewVo.getPostName());
        }
        if (interviewVo.getResumeEducation() != null && !interviewVo.getResumeEducation().equals("")) {
            //模糊查询简历中学历的数据
            wrapper.like("R.RESUME_EDUCATION", interviewVo.getResumeEducation());
        }
        if (interviewVo.getResumeName() != null && !interviewVo.getResumeName().equals("")) {
            //模糊查询投简人简名称
            wrapper.like("R.RESUME_NAME", interviewVo.getResumeName());
        }
        if (interviewVo.getDeptName()!=null && interviewVo.getDeptName().equals("")){
            wrapper.like("D.DEPT_NAME",interviewVo.getDeptName());
        }
        //状态：候选人查询
        wrapper.eq("R.RESUME_ZT", 4);
        //逻辑删除查询
        wrapper.eq("R.IS_DELETED", 0).orderByDesc("INTERVIEW_ID");
        return mapperVo.findAlleInvite(page,wrapper);
    }
    /**
     * 分页查询复试中的所有应聘人员信息
     * @return
     */
    @Override
    public IPage<InterviewVo> findallfs(InterviewVo interviewVo) {
        Page<InterviewVo> pagefs =  new Page<>(interviewVo.getCurrenPage(),interviewVo.getPagesize());
        QueryWrapper<InterviewVo> wrapperfs = new QueryWrapper<>();
        if (interviewVo.getStartTime() != null && interviewVo.getEndTime() != null) {
            //模糊查询投稿时间范围
            wrapperfs.between("R.TouJ_TIME", interviewVo.getStartTime(), interviewVo.getEndTime());
        }
        if (interviewVo.getPostName() != null && !interviewVo.getPostName().equals("")) {
            //模糊查询简历中投递职位的数据
            wrapperfs.like("P.POST_NAME", interviewVo.getPostName());
        }
        if (interviewVo.getResumeEducation() != null && !interviewVo.getResumeEducation().equals("")) {
            //模糊查询简历中学历的数据
            wrapperfs.like("R.RESUME_EDUCATION", interviewVo.getResumeEducation());
        }
        if (interviewVo.getResumeName() != null && !interviewVo.getResumeName().equals("")) {
            //模糊查询投简人简名称
            wrapperfs.like("R.RESUME_NAME", interviewVo.getResumeName());
        }
        if (interviewVo.getDeptName()!=null && interviewVo.getDeptName().equals("")){
            wrapperfs.like("D.DEPT_NAME",interviewVo.getDeptName());
        }
        //状态：候选人查询
        wrapperfs.eq("R.RESUME_ZT", 6);
        //逻辑删除查询
        wrapperfs.eq("R.IS_DELETED", 0).orderByDesc("INTERVIEW_ID");
        return mapperVo.findAlleInvite(pagefs,wrapperfs);
    }
    /**
     * 分页查询面试通过的所有应聘人员信息
     * @return
     */
    @Override
    public IPage<InterviewVo> selectAlladopt(InterviewVo interviewVo) {
        Page<InterviewVo> pageadopt =  new Page<>(interviewVo.getCurrenPage(),interviewVo.getPagesize());
        QueryWrapper<InterviewVo> wrapperadopt = new QueryWrapper<>();
        if (interviewVo.getStartTime() != null && interviewVo.getEndTime() != null) {
            //模糊查询投稿时间范围
            wrapperadopt.between("R.TouJ_TIME", interviewVo.getStartTime(), interviewVo.getEndTime());
        }
        if (interviewVo.getPostName() != null && !interviewVo.getPostName().equals("")) {
            //模糊查询简历中投递职位的数据
            wrapperadopt.like("P.POST_NAME", interviewVo.getPostName());
        }
        if (interviewVo.getResumeEducation() != null && !interviewVo.getResumeEducation().equals("")) {
            //模糊查询简历中学历的数据
            wrapperadopt.like("R.RESUME_EDUCATION", interviewVo.getResumeEducation());
        }
        if (interviewVo.getResumeName() != null && !interviewVo.getResumeName().equals("")) {
            //模糊查询投简人简名称
            wrapperadopt.like("R.RESUME_NAME", interviewVo.getResumeName());
        }
        if (interviewVo.getDeptName()!=null && interviewVo.getDeptName().equals("")){
            wrapperadopt.like("D.DEPT_NAME",interviewVo.getDeptName());
        }
        //状态：候选人查询
        wrapperadopt.eq("R.RESUME_ZT", 5);
        //逻辑删除查询
        wrapperadopt.eq("R.IS_DELETED", 0).orderByDesc("INTERVIEW_ID");
        return mapperVo.findAlleInvite(pageadopt,wrapperadopt);
    }

    /**
     * 面试评论添加
     */
    @Override
    public int addmianspl(Evaluate evaluate) {
        return evaluateMapper.insert(evaluate);
    }


}
