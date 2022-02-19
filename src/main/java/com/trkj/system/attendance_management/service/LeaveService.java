package com.trkj.system.attendance_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.system.attendance_management.entity.Classes;
import com.trkj.system.attendance_management.entity.Leave;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 请假表 服务类
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-18
 */
public interface LeaveService {

    //查询所有请假信息
    IPage<Leave> selectAllqj(Leave leave);
    //统计请假次数
    int querynumber(Leave leave);

}
