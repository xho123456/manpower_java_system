package com.trkj.system.recruit_modular.service;

import com.trkj.system.recruit_modular.entity.Resume;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 简历表 服务类
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-05
 */
public interface ResumeService extends IService<Resume> {
    //查询简历详情页面个人信息
    Resume findByidselect(Long id);
    //逻辑删除简历信息
    int deleteByidResume(Integer id);
    //修改：添加简历备注信息
    int updateremarks(Resume resume);
}
