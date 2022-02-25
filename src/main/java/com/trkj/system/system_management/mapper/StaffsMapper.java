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

    /**
     *查询出部门下的所有员工
     */
    @Select("select * from staff ${ew.customSqlSegment}")
    List<Staffs> selectStaffId(@Param(Constants.WRAPPER) QueryWrapper<Staffs> queryWrapper);

    /**
     * 通过员工查询员工数据
     */
    @Select("select * from staff ${ew.customSqlSegment}")
    List<Staffs> selectStaff(@Param(Constants.WRAPPER) QueryWrapper<Staffs> queryWrapper);

    /**
     * 判断登录数据是否和数据库一致
     * @param queryWrapper
     * @return
     */
    @Select("select t1.*, t2.POST_NAME from staff t1 LEFT JOIN DEPT_POST t2 on t1.DEPT_POST_ID = t2.DEPT_POST_ID ${ew.customSqlSegment}")
    Staffs selectStaffs(@Param(Constants.WRAPPER) QueryWrapper<Staffs> queryWrapper);

    /**
     * 通过部门id查询员工id
     * @param queryWrapper
     * @return
     */
    @Select("select STAFF_ID from staff ${ew.customSqlSegment}")
    List<Staffs> selectStaffsID(@Param(Constants.WRAPPER) QueryWrapper<Staffs> queryWrapper);
}
