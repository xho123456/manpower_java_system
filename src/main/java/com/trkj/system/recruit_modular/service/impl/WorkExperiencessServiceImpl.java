package com.trkj.system.recruit_modular.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.system.recruit_modular.entity.WorkExperiencess;
import com.trkj.system.recruit_modular.mapper.WorkExperiencessMapper;
import com.trkj.system.recruit_modular.service.WorkExperiencessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 工作经历表 服务实现类
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-06
 */
@Service
public class WorkExperiencessServiceImpl implements WorkExperiencessService {

    @Autowired
    private WorkExperiencessMapper mapper;

    //个人简历信息页面：工作经历查询
    @Override
    public List<WorkExperiencess> selectByidWork(WorkExperiencess workExperiencess) {
        QueryWrapper<WorkExperiencess> wrapper = new QueryWrapper<>();

        //通过简历编号查询所有工作经历信息
        wrapper.eq("RESUME_ID",workExperiencess.getResumeId());
        //逻辑删除
        wrapper.eq("IS_DELETED",0);
        return mapper.findByidWork(wrapper);
    }
    //新增工作经历
    @Override
    public int addWorkexper(WorkExperiencess workExperiencess) {
        return mapper.insert(workExperiencess);
    }

    //删除工作经历信息
    @Override
    public int deletehomes(Integer id) {
        return mapper.deleteById(id);
    }
}
