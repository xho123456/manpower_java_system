package com.trkj.system.salary_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.organizational_management.entity.Dept;
import com.trkj.system.salary_management.mapper.entity.SalaryList;
import com.trkj.system.salary_management.mapper.entity.StaffSalary;
import com.trkj.system.salary_management.mapper.StaffSalaryMapper;
import com.trkj.system.salary_management.service.StaffSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StaffSalaryServiceImpl implements StaffSalaryService {
    @Autowired
    private StaffSalaryMapper staffSalaryMapper;

    @Override
    public IPage<StaffSalary> selectPaer(StaffSalary staffSalary) {
        Page<StaffSalary> page=new Page<>(staffSalary.getCurrentPage(),staffSalary.getPageSize());
        QueryWrapper<StaffSalary> queryWrapper=new QueryWrapper<>();

        if(staffSalary.getStaffName() !=null && !staffSalary.getStaffName().equals("")){
            queryWrapper.like("s.STAFF_NAME" ,staffSalary.getStaffName());
        }
        return staffSalaryMapper.selectPaer(page,queryWrapper);
    }

    @Override
    public List<StaffSalary> findAll11() {
        return staffSalaryMapper.selectList();
    }

    @Override
    public IPage<StaffSalary> selectPaer1(StaffSalary staffSalary) {
        Page<StaffSalary> page=new Page<>(staffSalary.getCurrentPage(),staffSalary.getPageSize());
        QueryWrapper<StaffSalary> queryWrapper=new QueryWrapper<>();

        if(staffSalary.getStaffName() !=null && !staffSalary.getStaffName().equals("")){
            queryWrapper.like("s.STAFF_NAME" ,staffSalary.getStaffName());
        }  if(staffSalary.getGdid() !=null && !staffSalary.getGdid().equals("")){
            queryWrapper.like("sw.MONEYPIGEONHOLE_ID" ,staffSalary.getGdid());
        }
        return staffSalaryMapper.selectPaer1(page,queryWrapper);
    }


}
