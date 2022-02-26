package com.trkj.system.attendance_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.attendance_management.entity.Classes;
import com.trkj.system.attendance_management.entity.ClassesVo;
import com.trkj.system.attendance_management.entity.ClockRecord;
import com.trkj.system.attendance_management.entity.StaffVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 * 班次管理 Mapper 接口
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-10
 */
@Mapper
public interface StaffVoMapper extends BaseMapper<StaffVo> {

    @Select("select S.*,D.DEPT_NAME FROM STAFF S LEFT JOIN DEPT D ON S.DEPT_ID = D.DEPT_ID ${ew.customSqlSegment}")
    IPage<StaffVo> querydepts(Page<StaffVo> page, @Param(Constants.WRAPPER) QueryWrapper queryWrapper);

}
