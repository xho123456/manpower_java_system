package com.trkj.system.salary_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.system.salary_management.mapper.entity.Wagenotfiledd;
import org.springframework.transaction.annotation.Transactional;

public interface WagenotfileddService {
    @Transactional
    IPage<Wagenotfiledd> selectPaer(Wagenotfiledd wagenotfiledd);

}
