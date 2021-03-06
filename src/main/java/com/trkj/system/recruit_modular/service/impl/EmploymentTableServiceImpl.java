package com.trkj.system.recruit_modular.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.recruit_modular.entity.EmploymentTable;
import com.trkj.system.recruit_modular.entity.EmploymentTableVo;
import com.trkj.system.recruit_modular.mapper.EmploymentTableMapperVo;
import com.trkj.system.recruit_modular.service.EmploymentTableServiceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    @Override
    public int updatefq(EmploymentTable employmentTable) {
        return mapperVo.updateById(employmentTable);
    }
    /**
     * 面试通过新增录用人员
     */
    @Transactional
    @Override
    public int addEmploy(EmploymentTable employmentTable) {
        return mapperVo.insert(employmentTable);
    }
    /**
     * 通过简历id查询录用表数据
     */
    @Override
    public EmploymentTable findbyresumeid(EmploymentTable employmentTable) {
        QueryWrapper<EmploymentTable> lywrapper = new QueryWrapper<>();
        lywrapper.eq("RESUME_ID",employmentTable.getResumeId());
        lywrapper.eq("IS_DELETED",0);
        return mapperVo.selectbyresumeid(lywrapper);
    }


}
