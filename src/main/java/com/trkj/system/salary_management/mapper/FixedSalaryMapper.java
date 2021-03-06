package com.trkj.system.salary_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.salary_management.mapper.entity.FixedSalary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FixedSalaryMapper  extends BaseMapper<FixedSalary> {
    @Select("\tselect s.STAFF_STATE,d.DEPT_ID, s.STAFF_NAME,s.STAFF_HIREDATE,d.DEPT_NAME,f.* from FIXEDWAGE f LEFT JOIN STAFF s  on  f.STAFF_ID=s.STAFF_ID   LEFT JOIN  DEPT d on d.DEPT_ID= s.DEPT_ID   ${ew.customSqlSegment}")
    IPage<FixedSalary>selectPaer2(Page<FixedSalary> fixedSalary, @Param(Constants.WRAPPER)QueryWrapper<FixedSalary>queryWrapper);

}
