package com.trkj.system.organizational_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.organizational_management.entity.Dept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.system.organizational_management.entity.DeptDeptPost;
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
public interface DeptPostMapper extends BaseMapper<DeptDeptPost> {

    /**
    /**
     * 分页查询 部门职位
     */
    @Select("select p.*,d.dept_Name from DEPT_POST p  inner join DEPT  d on d.DEpt_ID=p.DEPT_ID   ${ew.customSqlSegment}")
    IPage<DeptDeptPost>selectPaer1(Page<DeptDeptPost> deptDeptPost, @Param(Constants.WRAPPER)QueryWrapper<DeptDeptPost> queryWrapper);

}

