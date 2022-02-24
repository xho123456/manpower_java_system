package com.trkj.system.attendance_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.system.attendance_management.entity.ClockRecord;
import com.trkj.system.attendance_management.entity.Leave;
import com.trkj.system.attendance_management.entity.Overtimeask;
import com.trkj.system.attendance_management.entity.StaffVo;
import com.trkj.system.vo.AjaxResponse;

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

    //查询当前登录用户的打卡记录
    IPage<ClockRecord> selectAlldk(ClockRecord clockRecord);

    //根据当前登录用户查询请假信息
    IPage<Leave> selectAllqj(Leave leave);

    //统计请假次数
    int querynumber(Leave leave);

    //根据当前登录用户查询加班信息
    IPage<Overtimeask> selectAlljb(Overtimeask overtimeask);

    //根据当前登录用户查询迟到信息
    IPage<ClockRecord> selectByAllchid(ClockRecord clockRecord);

    //统计迟到次数
    int selchidnumber(ClockRecord clockRecord);

    //根据当前登录用户查询早退信息
    IPage<ClockRecord> selectByAllzaot(ClockRecord clockRecord);

    //统计早退次数
    int selzaotnumber(ClockRecord clockRecord);

    //根据当前登录用户查询旷工信息
    IPage<ClockRecord> selectByAllkuang(ClockRecord clockRecord);

    //统计旷工次数
    int selkuangnumber(ClockRecord clockRecord);

    //考勤月统计
    IPage<StaffVo> selectAllmothday(StaffVo staffVo);


}
