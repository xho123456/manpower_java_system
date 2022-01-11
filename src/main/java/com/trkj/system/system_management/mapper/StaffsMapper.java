package com.trkj.system.system_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.system.system_management.entity.NoticeVo;
import com.trkj.system.system_management.entity.Staffs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StaffsMapper extends BaseMapper<Staffs> {
    /**
     *查询某个部门下的所有员工
     */
    @Select("select STAFF_ID from staff ${ew.customSqlSegment}")
    List<Staffs> selectStaffDeptID(@Param(Constants.WRAPPER) QueryWrapper<Staffs> queryWrapper);
}
