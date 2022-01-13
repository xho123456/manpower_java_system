package com.trkj.system.recruit_modular.service.impl;

import com.trkj.system.recruit_modular.entity.Resume;
import com.trkj.system.recruit_modular.mapper.ResumeMapper;
import com.trkj.system.recruit_modular.service.ResumeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    //查询简历详情页面个人信息
    @Override
    public Resume findByidselect(Long id) {
        return mapper.selectById(id);
    }
    //逻辑删除简历信息
    @Override
    public int deleteByidResume(Integer id) {
        return mapper.deleteById(id);
    }
    //修改：添加简历备注信息
    @Override
    public int updateremarks(Resume resume) {
        return mapper.updateById(resume);
    }
    //转入淘汰库
    @Override
    public int updateeliminate(Resume resume) {
        return mapper.updateById(resume);
    }

    //修改: 设置候选人、备注信息
    @Override
    public int updatehb(Resume resume) {
        return mapper.updateById(resume);
    }
}
