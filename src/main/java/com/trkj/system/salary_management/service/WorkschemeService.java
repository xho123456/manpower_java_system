package com.trkj.system.salary_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.system.salary_management.mapper.entity.Workscheme;
import com.trkj.system.salary_management.mapper.entity.Workschemee;
import org.springframework.transaction.annotation.Transactional;

public interface WorkschemeService {
    @Transactional
    IPage<Workscheme> selectPaer1(Workscheme workscheme);
    //加班方案修改
    int updateWorkscheme(Workschemee workschemee);
    int deleteWorkscheme(Integer id);
    int addWorkschemee(Workschemee workschemee);
}
