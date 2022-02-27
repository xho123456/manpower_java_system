package com.trkj.system.salary_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.system.salary_management.entity.Businesss;

import org.springframework.transaction.annotation.Transactional;

public interface BusinesssService {
    @Transactional
    IPage<Businesss> selectPaer(Businesss businesss);
}
