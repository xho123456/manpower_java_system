package com.trkj.system.salary_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.system.organizational_management.entity.Dept;
import com.trkj.system.salary_management.mapper.entity.SalaryList;
import com.trkj.system.salary_management.mapper.entity.StaffSalary;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StaffSalaryService {
    @Transactional
    IPage<StaffSalary> selectPaer(StaffSalary staffSalary);
    List<StaffSalary> findAll11();
    IPage<StaffSalary> selectPaer1(StaffSalary staffSalary);
}
