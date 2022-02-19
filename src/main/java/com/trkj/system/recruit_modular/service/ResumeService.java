package com.trkj.system.recruit_modular.service;

import com.trkj.system.recruit_modular.entity.InterviewVo;
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
    //逻辑删除简历信息
    int deleteByidResume(Integer id);
    //修改：添加简历备注信息
    int updateremarks(Resume resume);
    //转入淘汰库
    int updateeliminate(Resume resume);
    //修改: 设置候选人、备注信息
    int updatehb(Resume resume);
    //添加简历
    int addResume(Resume resume);
    //招聘计划：简历数量统计
    int planhxr(Resume resume);

}
