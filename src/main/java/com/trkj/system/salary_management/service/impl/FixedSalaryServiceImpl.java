package com.trkj.system.salary_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.organizational_management.entity.Dept;
import com.trkj.system.organizational_management.mapper.DeptOneMapper;
import com.trkj.system.salary_management.mapper.*;
import com.trkj.system.salary_management.mapper.entity.FixedSalary;
import com.trkj.system.salary_management.mapper.entity.Fixedwage;
import com.trkj.system.salary_management.mapper.entity.Salary;
import com.trkj.system.salary_management.mapper.entity.SalaryList;
import com.trkj.system.salary_management.service.FixedSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FixedSalaryServiceImpl implements FixedSalaryService {
    @Autowired
    private FixedSalaryMapper fixedSalaryMapper;
      @Autowired
      private DeptOneMapper deptOneMapper;
      @Autowired
      private FixedwageMapper fixedwageMapper;
      @Autowired
      private SalaryyMapper salaryMapper;
      @Autowired
      private FixedwegeSalaryMapper fixedwegeSalaryMapper;
      @Autowired
      private SalaryListMapper salaryListMapper;
    //查询固定工资
    @Override
    public IPage<FixedSalary>selectPaer2(FixedSalary fixedSalary){
        Page<FixedSalary>page=new Page<>(fixedSalary.getCurrentPage(),fixedSalary.getPageSize());
        QueryWrapper<FixedSalary> queryWrapper=new QueryWrapper<>();
        System.out.println(fixedSalary+"asdasdasdasdasdads");
        if(fixedSalary.getDeptName()!=null&&!fixedSalary.getDeptName().equals("")){
            queryWrapper.like("d.DEPT_NAME",fixedSalary.getDeptName());
            System.out.println("---------------------------------------------");
        }
        if(fixedSalary.getStaffName()!=null&&!fixedSalary.getStaffName().equals("")){
            queryWrapper.like("s.STAFF_NAME",fixedSalary.getStaffName());
            System.out.println("---------------------------------------------");
        }

        queryWrapper.eq("f.IS_DELETED",0);
        return fixedSalaryMapper.selectPaer2(page,queryWrapper);
    }
    @Override
    @Transactional
    //查询全部部门
    public List<Dept> findAll() {
        return deptOneMapper.selectList();
    }
    @Override//修改固定工资
    public int updateFixedSalary(Fixedwage fixedwage) {
        return fixedwageMapper.updateById(fixedwage);
    }

   /* @Override
    public int updateSalaryFixed(FixedwegeSalary fixedwegeSalary) {
        int dsfd=0;
        int row=fixedwegeSalaryMapper.update(fixedwegeSalary,new QueryWrapper<FixedwegeSalary>()
                .eq("FIXEDWAGE_ID",fixedwegeSalary.getFixedwageId()).eq("IS_DELETED",0));
        if(row>0){
            Salary salary=new Salary();
        }
        return dsfd;
    }*/
    @Override//添加调薪表
    public int addSalary(Salary salary) {
        return salaryMapper.insert(salary);    }
          //查询调薪，部门，员工
    @Override
    public IPage<SalaryList>selectPaer3(SalaryList salaryList){
        Page<SalaryList>page=new Page<>(salaryList.getCurrentPage(),salaryList.getPageSize());
        QueryWrapper<SalaryList> queryWrapper=new QueryWrapper<>();
        System.out.println(salaryList+"ass");
        if(salaryList.getDeptName()!=null&&!salaryList.getDeptName().equals("")){
            queryWrapper.like("d.DEPT_NAME",salaryList.getDeptName());
            System.out.println("---------------------------------------------");
        }
        if(salaryList.getStaffName()!=null&&!salaryList.getStaffName().equals("")){
            queryWrapper.like("s.STAFF_NAME",salaryList.getStaffName());
            System.out.println("---------------------------------------------");
        }

        queryWrapper.eq("sa.IS_DELETED",0);
        return salaryListMapper.selectPaer3(page,queryWrapper);
    }
}
