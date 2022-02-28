package com.trkj.system.attendance_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.system.attendance_management.entity.Checkfiles;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.system.attendance_management.entity.ClockRecord;
import com.trkj.system.attendance_management.entity.StaffVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-25
 */
public interface CheckfilesService {

    //考勤月汇总
    IPage<StaffVo> querymothday(StaffVo staffVo);
}
