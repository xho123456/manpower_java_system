package com.trkj.system.salary_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.system.organizational_management.entity.Dept;
import com.trkj.system.salary_management.mapper.entity.FixedSalary;
import com.trkj.system.salary_management.mapper.entity.Fixedwage;
import com.trkj.system.salary_management.mapper.entity.Salary;
import com.trkj.system.salary_management.mapper.entity.SalaryList;

import java.util.List;

public interface FixedSalaryService {
    IPage<FixedSalary> selectPaer2(FixedSalary fixedSalary);
    List<Dept> findAll();

//固定工资修改
    int updateFixedSalary(Fixedwage fixedwage);
    /**
     * 调薪时修改固定工资
     * 添加调薪
     */

    int addSalary(Salary salary);

    IPage<SalaryList> selectPaer3(SalaryList salaryList);

}
