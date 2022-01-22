package com.trkj.system.recruit_modular.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.recruit_modular.entity.EmploymentTableVo;
import com.trkj.system.recruit_modular.mapper.EmploymentTableMapperVo;
import com.trkj.system.recruit_modular.service.EmploymentTableServiceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 录用表 服务实现类
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-13
 */
@Service
public class EmploymentTableServiceImpl implements EmploymentTableServiceVo {
    @Autowired
    private EmploymentTableMapperVo mapperVo;

    /**
     * 查询 已录用待接受信息
     */
    @Override
    public IPage<EmploymentTableVo> findAllemployment(EmploymentTableVo employmentTableVo) {
        Page<EmploymentTableVo> pagejs = new Page<>(employmentTableVo.getCurrenPage(),employmentTableVo.getPagesize());
        QueryWrapper<EmploymentTableVo> wrapperjs = new QueryWrapper<>();
        if (employmentTableVo.getStartTime() != null && employmentTableVo.getEndTime() != null) {
            //模糊查询投稿时间范围
            wrapperjs.between("R.TouJ_TIME", employmentTableVo.getStartTime(), employmentTableVo.getEndTime());
        }
        if (employmentTableVo.getPostName() != null && !employmentTableVo.getPostName().equals("")) {
            //模糊查询简历中投递职位的数据
            wrapperjs.like("P.POST_NAME", employmentTableVo.getPostName());
        }
        if (employmentTableVo.getResumeEducation() != null && !employmentTableVo.getResumeEducation().equals("")) {
            //模糊查询简历中学历的数据
            wrapperjs.like("R.RESUME_EDUCATION", employmentTableVo.getResumeEducation());
        }
        if (employmentTableVo.getResumeName() != null && !employmentTableVo.getResumeName().equals("")) {
            //模糊查询投简人简名称
            wrapperjs.like("R.RESUME_NAME", employmentTableVo.getResumeName());
        }
        if (employmentTableVo.getDeptName()!=null && employmentTableVo.getDeptName().equals("")){
            wrapperjs.like("D.DEPT_NAME",employmentTableVo.getDeptName());
        }

        wrapperjs.eq("R.RESUME_ZT",employmentTableVo.getResumeZt());
        wrapperjs.eq("E.IS_DELETED",0).orderByDesc("E.EMPLOYMENT_ID");
        return mapperVo.findAllemployment(pagejs,wrapperjs);
    }



    /**
     * 录用放弃原因
     */
    @Override
    public int updatefq(EmploymentTableVo employmentTableVo) {
        return mapperVo.updateById(employmentTableVo);
    }


}
