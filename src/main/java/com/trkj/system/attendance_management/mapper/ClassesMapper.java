package com.trkj.system.attendance_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.attendance_management.entity.Classes;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 班次管理 Mapper 接口
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-10
 */
@Mapper
public interface ClassesMapper extends BaseMapper<Classes> {

    //查询所有班次
    @Select("select * from Classes ${ew.customSqlSegment}")
    IPage<Classes> selectAllPage(Page<Classes> page,@Param(Constants.WRAPPER) QueryWrapper queryWrapper);

}
