package com.trkj.system.recruit_modular.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.system.recruit_modular.entity.Educationss;
import com.trkj.system.recruit_modular.mapper.EducationssMapper;
import com.trkj.system.recruit_modular.service.EducationssService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 受教育经历表 服务实现类
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-06
 */
@Service
public class EducationssServiceImpl implements EducationssService {
    @Autowired
    private EducationssMapper mapper;

    @Override
    public List<Educationss> selectByidEd(Educationss educationss) {
        QueryWrapper<Educationss> wrapper = new QueryWrapper<>();
        wrapper.eq("RESUME_ID",educationss.getResumeId());
        wrapper.eq("IS_DELETED",0);
        return mapper.findByidEds(wrapper);
    }
}
