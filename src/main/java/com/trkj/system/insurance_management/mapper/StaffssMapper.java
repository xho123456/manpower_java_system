package com.trkj.system.insurance_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.system.insurance_management.entity.DefInsured;
import com.trkj.system.insurance_management.entity.Staffss;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 员工表 Mapper 接口
 * </p>
 *
 * @author 谢海欧
 * @since 2022-02-23
 */
@Mapper
public interface StaffssMapper extends BaseMapper<Staffss> {

    /**
     * 根于员工名称查询员工id
     */
    @Select("select * from STAFF ${ew.customSqlSegment}")
    Staffss selectStaffID(@Param(Constants.WRAPPER) QueryWrapper<Staffss> queryWrapper);}
