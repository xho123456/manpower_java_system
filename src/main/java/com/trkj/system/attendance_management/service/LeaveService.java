package com.trkj.system.attendance_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.system.attendance_management.entity.ClockRecord;
import com.trkj.system.attendance_management.entity.Leave;
import com.trkj.system.attendance_management.entity.Overtimeask;

/**
 * <p>
 * 请假表 服务类
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-18
 */
public interface LeaveService {
    //查询所有员工的打卡记录
    IPage<ClockRecord> selectAll(ClockRecord clockRecord);




    //根据当前登录用户查询请假信息
    IPage<Leave> selectAllqj(Leave leave);

    //根据当前登录用户查询加班信息
    IPage<Overtimeask> selectAlljb(Overtimeask overtimeask);

    //查询当前登录用户的打卡记录
    IPage<ClockRecord> selectAlldk(ClockRecord clockRecord);

    //统计请假次数
    int querynumber(Leave leave);



}
