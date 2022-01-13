package com.trkj.system.organizational_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.organizational_management.entity.Dept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.system.organizational_management.entity.DeptStaff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 部门表 Mapper 接口
 * </p>
 *
 * @author 谢海欧
 * @since 2021-12-28
 */
@Mapper
public interface DeptMapper extends BaseMapper<DeptStaff> {
    //查询部门详情
//    @Select("select  d.DEPT_ID, d.DEPT_STATE, d.STAFF_ID,d.DEPT_NAME, STAFF_NAME from  DEPT d left outer join STAFF s on d.STAFF_ID= s.STAFF_ID where d.IS_DELETED=0  ")
//    IPage<DeptStaff> selectpage(Page<DeptStaff> page);


    /**
     * 分页查询 部门详情
     */
    @Select("select  d.*, s.STAFF_NAME from  DEPT d left join STAFF s on d.STAFF_ID= s.STAFF_ID ${ew.customSqlSegment}")
    IPage<DeptStaff>selectPaer(Page<DeptStaff> deptStaff, @Param(Constants.WRAPPER)QueryWrapper<DeptStaff> queryWrapper);




}

