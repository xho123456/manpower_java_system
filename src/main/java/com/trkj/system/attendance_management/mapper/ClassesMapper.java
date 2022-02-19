package com.trkj.system.attendance_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.attendance_management.entity.Classes;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.system.attendance_management.entity.ClassesVo;
import org.apache.ibatis.annotations.*;

/**
 * <p>
 * 班次管理 Mapper 接口
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-10
 */
@Mapper
public interface ClassesMapper extends BaseMapper<ClassesVo> {

    //查询所有班次
    @Select("select * from Classes ${ew.customSqlSegment}")
    IPage<Classes> selectAllPage(Page<Classes> page,@Param(Constants.WRAPPER) QueryWrapper queryWrapper);

    //禁用所有班次
    @Update("update CLASSES set CLASSESSTATE = 0")
    int updateclasesall();


}
