package com.trkj.system.salary_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.salary_management.mapper.entity.Attendandce;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AttendandceMapper extends BaseMapper<Attendandce> {
    @Select("select *from ATTENDANDCE  ${ew.customSqlSegment}")
    IPage<Attendandce> selectPaer(Page<Attendandce> attendandce, @Param(Constants.WRAPPER) QueryWrapper<Attendandce> queryWrapper);
}
