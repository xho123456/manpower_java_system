package com.trkj.system.salary_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.system.salary_management.mapper.entity.Businesss;

import com.trkj.system.salary_management.mapper.entity.Businessss;
import org.springframework.transaction.annotation.Transactional;

public interface BusinesssService {
    @Transactional
    IPage<Businesss> selectPaer(Businesss businesss);
    int addBusinesss(Businessss businessss);
    int updatebusinessss(Businessss businessss);
    int deleteBusinessss(Integer id);
}
