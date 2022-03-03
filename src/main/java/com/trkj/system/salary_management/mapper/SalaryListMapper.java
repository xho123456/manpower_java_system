package com.trkj.system.salary_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.salary_management.mapper.entity.SalaryList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SalaryListMapper extends BaseMapper<SalaryList> {
    @Select("select sa.*,d.DEPT_NAME from SALARY  sa INNER JOIN DEPT d on sa.DEPT_ID=d.DEPT_ID INNER JOIN STAFF s on sa.STAFF_ID=s.STAFF_ID ${ew.customSqlSegment}")
    IPage<SalaryList>selectPaer3(Page<SalaryList> salaryList, @Param(Constants.WRAPPER)QueryWrapper<SalaryList>queryWrapper);
}
