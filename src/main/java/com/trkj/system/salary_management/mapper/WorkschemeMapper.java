package com.trkj.system.salary_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.organizational_management.entity.DeptDeptPost;
import com.trkj.system.salary_management.entity.Workscheme;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface WorkschemeMapper  extends BaseMapper<Workscheme> {
    /**
     /**
     * 分页查询
     */
    @Select("select *from WORKSCHEME  ${ew.customSqlSegment}")
    IPage<Workscheme> selectPaer1(Page<Workscheme> workscheme, @Param(Constants.WRAPPER) QueryWrapper<Workscheme> queryWrapper);

}
