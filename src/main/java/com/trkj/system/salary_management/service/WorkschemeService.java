package com.trkj.system.salary_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.system.organizational_management.entity.DeptDeptPost;
import com.trkj.system.salary_management.entity.Workscheme;
import org.springframework.transaction.annotation.Transactional;

public interface WorkschemeService {
    @Transactional
    IPage<Workscheme> selectPaer1(Workscheme workscheme);
}
