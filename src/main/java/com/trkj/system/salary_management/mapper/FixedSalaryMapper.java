package com.trkj.system.salary_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.salary_management.entity.FixedSalary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FixedSalaryMapper  extends BaseMapper<FixedSalary> {
    @Select("select p.DEPT_POST_ID, d.DEPT_ID, s.STAFF_NAME,s.STAFF_HIREDATE,d.DEPT_NAME,p.POST_NAME,s.STAFF_STATE, f.* from FIXEDWAGE f INNER JOIN STAFF s on f.STAFF_ID=s.STAFF_ID INNER JOIN DEPT d on s.STAFF_ID=d.STAFF_id INNER JOIN DEPT_POST p on  d.DEPT_ID=p.DEPT_ID ${ew.customSqlSegment}")
    IPage<FixedSalary>selectPaer2(Page<FixedSalary> fixedSalary, @Param(Constants.WRAPPER)QueryWrapper<FixedSalary>queryWrapper);

}
