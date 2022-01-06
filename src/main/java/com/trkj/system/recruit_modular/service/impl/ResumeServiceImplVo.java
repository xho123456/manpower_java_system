package com.trkj.system.recruit_modular.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.recruit_modular.entity.RecruitmentPlanVo;
import com.trkj.system.recruit_modular.entity.ResumeVo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.system.recruit_modular.mapper.ResumeMapperVo;
import com.trkj.system.recruit_modular.service.ResumeServiceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 简历表 服务实现类
 * </p>
 *
 * @author 鄧琪
 * @since 2021-12-31
 */
@Service
public class ResumeServiceImplVo extends ServiceImpl<ResumeMapperVo, ResumeVo> implements ResumeServiceVo {

    @Autowired
    private ResumeMapperVo resumeMapperVo;

    //全部简历列表分页查询
    @Override
    public IPage<ResumeVo> findAllresume(ResumeVo resumeVo) {
        Page<ResumeVo> page = new Page<>(resumeVo.getCurrenPage(),resumeVo.getPagesize());
        QueryWrapper<ResumeVo> wrapper = new QueryWrapper<>();
        if (resumeVo.getPostName()!=null && !resumeVo.getPostName().equals("")){
            //模糊查询简历中投递职位的数据
            wrapper.like("P.POST_NAME",resumeVo.getPostName());
        }
        if (resumeVo.getResumeEducation()!=null && !resumeVo.getResumeEducation().equals("")){
            //模糊查询简历中学历的数据
            wrapper.like("R.RESUME_EDUCATION",resumeVo.getResumeEducation());
        }
        if (resumeVo.getStartTime()!=null || resumeVo.getEndTime()!=null){
            //模糊查询投稿时间范围
            wrapper.between("R.TouJ_TIME",resumeVo.getStartTime(),resumeVo.getEndTime());
        }
        if (resumeVo.getResumeName()!=null || !resumeVo.getResumeName().equals("")){
            //模糊查询投简人简名称
            wrapper.like("R.RESUME_NAME",resumeVo.getResumeName());
        }

        //逻辑删除查询
        wrapper.like("R.IS_DELETED",0);
        return resumeMapperVo.selectAllres(page,wrapper);
    }

    //分页 ：通过招聘计划编号查询出该计划招聘的所有简历信息
    @Override
    public IPage<ResumeVo> findByidresum(ResumeVo resumeVo) {
        Page<ResumeVo> page = new Page<>(resumeVo.getCurrenPage(),resumeVo.getPagesize());
        QueryWrapper<ResumeVo> queryWrapper = new QueryWrapper<>();
        if (resumeVo.getResumeName()!=null || !resumeVo.getResumeName().equals("")){
            //模糊查询投简人简名称
            queryWrapper.like("R.RESUME_NAME",resumeVo.getResumeName());
        }

        if (resumeVo.getResumeEducation()!=null && !resumeVo.getResumeEducation().equals("")){
            //模糊查询简历中学历的数据
            queryWrapper.like("R.RESUME_EDUCATION",resumeVo.getResumeEducation());
        }

        if (resumeVo.getResumeZt()!=null || !resumeVo.getResumeZt().equals("")){
            queryWrapper.like("R.RESUME_ZT",resumeVo.getResumeZt());
        }


        queryWrapper.eq("R.RECRUITMENT_PLAN_ID",resumeVo.getRecruitmentPlanId());
        //逻辑删除查询
        queryWrapper.eq("R.IS_DELETED",0);
        return resumeMapperVo.findByidAll(page,queryWrapper);
    }

    //候选人简历列表分页查询
    @Override
    public IPage<ResumeVo> findAllhouxr(ResumeVo resumeVo) {
        Page<ResumeVo> page1 = new Page<>(resumeVo.getCurrenPage(),resumeVo.getPagesize());
        QueryWrapper<ResumeVo> wrapper1 = new QueryWrapper<>();
        if (resumeVo.getStartTime()!=null || resumeVo.getEndTime()!=null){
            //模糊查询投稿时间范围
            wrapper1.between("R.TouJ_TIME",resumeVo.getStartTime(),resumeVo.getEndTime());
        }
        if (resumeVo.getPostName()!=null && !resumeVo.getPostName().equals("")){
            //模糊查询简历中投递职位的数据
            wrapper1.like("P.POST_NAME",resumeVo.getPostName());
        }
        if (resumeVo.getResumeEducation()!=null && !resumeVo.getResumeEducation().equals("")){
            //模糊查询简历中学历的数据
            wrapper1.like("R.RESUME_EDUCATION",resumeVo.getResumeEducation());
        }

        //状态：候选人查询
        wrapper1.like("R.RESUME_ZT",1);
        //逻辑删除查询
        wrapper1.like("R.IS_DELETED",0);
        return resumeMapperVo.selectAllhxr(page1,wrapper1);
    }

    //简历列表分页查询：新简历
    @Override
    public IPage<ResumeVo> findAllnew(ResumeVo resumeVo) {
        Page<ResumeVo> pagenew = new Page<>(resumeVo.getCurrenPage(),resumeVo.getPagesize());
        QueryWrapper<ResumeVo> wrappernew = new QueryWrapper<>();
        if (resumeVo.getStartTime()!=null || resumeVo.getEndTime()!=null){
            //模糊查询投稿时间范围
            wrappernew.between("R.TouJ_TIME",resumeVo.getStartTime(),resumeVo.getEndTime());
        }
        if (resumeVo.getPostName()!=null && !resumeVo.getPostName().equals("")){
            //模糊查询简历中投递职位的数据
            wrappernew.like("P.POST_NAME",resumeVo.getPostName());
        }
        if (resumeVo.getResumeEducation()!=null && !resumeVo.getResumeEducation().equals("")){
            //模糊查询简历中学历的数据
            wrappernew.like("R.RESUME_EDUCATION",resumeVo.getResumeEducation());
        }
        //状态：新简历查询
        wrappernew.like("R.RESUME_ZT",0);
        //逻辑删除查询
        wrappernew.like("R.IS_DELETED",0);
        return resumeMapperVo.selectAllnew(pagenew,wrappernew);
    }

}
