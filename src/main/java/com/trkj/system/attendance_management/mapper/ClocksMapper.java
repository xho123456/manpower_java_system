package com.trkj.system.attendance_management.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.system.attendance_management.entity.ClockRecord;
import com.trkj.system.attendance_management.entity.ClockRecords;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 班次管理 Mapper 接口
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-10
 */
@Mapper
public interface ClocksMapper extends BaseMapper<ClockRecords> {



}
