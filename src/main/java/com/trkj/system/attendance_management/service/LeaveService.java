package com.trkj.system.attendance_management.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.system.attendance_management.entity.*;
import com.trkj.system.vo.AjaxResponse;
import org.apache.ibatis.annotations.Param;

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

    //统计加班次数
    int jabsnumber(Overtimeask overtimeask);

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

    //当前登录用户考勤次数查询
    int countquerys(ClockRecord clockRecord);

    //根据当前登录用户查询补打卡信息
    IPage<Card> selectBudk(Card card);

    //统计补打卡次数
    int selectbudkcounts(Card card);
}
