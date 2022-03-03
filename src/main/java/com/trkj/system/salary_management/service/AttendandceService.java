package com.trkj.system.salary_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.system.salary_management.mapper.entity.Attendandce;
import com.trkj.system.salary_management.mapper.entity.Attendandcee;
import org.springframework.transaction.annotation.Transactional;

public interface AttendandceService {
    @Transactional
    IPage<Attendandce> selectPaer(Attendandce attendandce);
    int addAttendandcee(Attendandcee attendandcee);
    int updateAttendandcee(Attendandcee attendandcee);
    int deleteAttendandcee(Integer Id);
}
