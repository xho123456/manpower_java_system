package com.trkj.system.attendance_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.attendance_management.entity.Checkfiles;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.system.attendance_management.entity.Classes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-25
 */
@Mapper
public interface CheckfilesMapper extends BaseMapper<Checkfiles> {



}
