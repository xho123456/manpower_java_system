package com.trkj.system.attendance_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.attendance_management.entity.ClockRecord;
import com.trkj.system.attendance_management.entity.Leave;
import com.trkj.system.attendance_management.entity.Overtimeask;
import com.trkj.system.attendance_management.mapper.LeaveMapper;
import com.trkj.system.attendance_management.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 请假表 服务实现类
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-18
 */
@Service
public class LeaveServiceImpl implements LeaveService {
    @Autowired
    private LeaveMapper mapper;


    //查询所有员工打卡记录
    @Override
    public IPage<ClockRecord> selectAll(ClockRecord clockRecord) {
        Page<ClockRecord> pageall = new Page<>(clockRecord.getCurrenPage(), clockRecord.getPagesize());
        QueryWrapper<Leave> wrapperall = new QueryWrapper<>();
        if(clockRecord.getStaffName()!=null && !clockRecord.getStaffName().equals("")){
            wrapperall.like("S.STAFF_NAME",clockRecord.getStaffName());
        }
        if (clockRecord.getDeptName()!=null && !clockRecord.getDeptName().equals("")){
            wrapperall.like("D.DEPT_NAME",clockRecord.getDeptName());
        }
        wrapperall.eq("C.IS_DELETED",0);
        return mapper.querybyidAll(pageall,wrapperall,clockRecord.getDates());
    }

    //查询当前登录用户的打卡记录
    @Override
    public IPage<ClockRecord> selectAlldk(ClockRecord clockRecord) {
        Page<ClockRecord> pagedk = new Page<>(clockRecord.getCurrenPage(), clockRecord.getPagesize());
        QueryWrapper<Leave> wrapperdk = new QueryWrapper<>();
        wrapperdk.eq("A.STAFF_ID",clockRecord.getStaffId());
        wrapperdk.eq("C.IS_DELETED",0);
//        wrapperdk.eq("to_char(c.DAY_DATE,'yyyy-MM')","TO_CHAR(sysdate,'yyyy-MM')");
        return mapper.querybyid(pagedk,wrapperdk,clockRecord.getDates());
    }

    //根据当前登录用户查询请假信息
    @Override
    public IPage<Leave> selectAllqj(Leave leave) {
        Page<Leave> pageqj = new Page<>(leave.getCurrenPage(), leave.getPagesize());
        QueryWrapper<Leave> wrapperqj = new QueryWrapper<>();
        wrapperqj.eq("L.STAFF_ID",leave.getStaffId());
        wrapperqj.eq("L.IS_DELETED",0);
        return mapper.queryallqj(pageqj,wrapperqj);
    }

    //统计请假次数
    @Override
    public int querynumber(Leave leave) {
        QueryWrapper<Leave> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("STAFF_ID",leave.getStaffId());
        wrapper1.eq("IS_DELETED",0);
        return mapper.leavenumber(wrapper1);
    }

    //根据当前登录用户查询加班信息
    @Override
    public IPage<Overtimeask> selectAlljb(Overtimeask overtimeask) {
        Page<Overtimeask> pagejb = new Page<>(overtimeask.getCurrenPage(), overtimeask.getPagesize());
        QueryWrapper<Leave> wrapperjb = new QueryWrapper<>();
        wrapperjb.eq("A.STAFF_ID",overtimeask.getStaffId());
        wrapperjb.eq("L.IS_DELETED",0);
        return mapper.queryalljb(pagejb,wrapperjb);
    }

    //根据当前登录用户查询迟到信息
    @Override
    public IPage<ClockRecord> selectByAllchid(ClockRecord clockRecord) {
        Page<ClockRecord> pagecd = new Page<>(clockRecord.getCurrenPage(), clockRecord.getPagesize());
        QueryWrapper<ClockRecord> wrappercd = new QueryWrapper<>();
        wrappercd.eq("S.STAFF_ID",clockRecord.getStaffId());
        wrappercd.eq("C.IS_DELETED",0);
        return mapper.querybyidAllchid(pagecd,wrappercd,clockRecord.getDates());
    }

    //统计迟到次数
    @Override
    public int selchidnumber(ClockRecord clockRecord) {
        QueryWrapper<ClockRecord> wrappercdnumber = new QueryWrapper();
        //条件查询
        wrappercdnumber.eq("SMORN_RESULT","迟到");
        wrappercdnumber.eq("STAFF_ID",clockRecord.getStaffId());
        //逻辑删除
        wrappercdnumber.eq("IS_DELETED",0);
        return mapper.chidnumber(wrappercdnumber,clockRecord.getDates());
    }

    //根据当前登录用户查询早退信息
    @Override
    public IPage<ClockRecord> selectByAllzaot(ClockRecord clockRecord) {
        Page<ClockRecord> pagezaot = new Page<>(clockRecord.getCurrenPage(), clockRecord.getPagesize());
        QueryWrapper<ClockRecord> wrapperzaot = new QueryWrapper<>();
        wrapperzaot.eq("S.STAFF_ID",clockRecord.getStaffId());
        wrapperzaot.eq("C.IS_DELETED",0);
        return mapper.querybyidAllzaot(pagezaot,wrapperzaot,clockRecord.getDates());
    }

    //统计早退次数
    @Override
    public int selzaotnumber(ClockRecord clockRecord) {
        QueryWrapper<ClockRecord> wrapperztnumber = new QueryWrapper();
        //条件查询
        wrapperztnumber.eq("XAFTERNOON_RESULT","早退");
        wrapperztnumber.eq("STAFF_ID",clockRecord.getStaffId());
        //逻辑删除
        wrapperztnumber.eq("IS_DELETED",0);
        return mapper.zaotnumber(wrapperztnumber,clockRecord.getDates());
    }

    //根据当前登录用户查询旷工信息
    @Override
    public IPage<ClockRecord> selectByAllkuang(ClockRecord clockRecord) {
        Page<ClockRecord> pagekuang = new Page<>(clockRecord.getCurrenPage(), clockRecord.getPagesize());
        QueryWrapper<ClockRecord> wrapperkuang = new QueryWrapper<>();
        wrapperkuang.eq("S.STAFF_ID",clockRecord.getStaffId());
        wrapperkuang.eq("C.IS_DELETED",0);
        return mapper.querybyidAllkuang(pagekuang,wrapperkuang,clockRecord.getDates());
    }

    //统计旷工次数
    @Override
    public int selkuangnumber(ClockRecord clockRecord) {
        QueryWrapper<ClockRecord> wrapperztnumber = new QueryWrapper();
        //条件查询
        wrapperztnumber.eq("STAFF_ID",clockRecord.getStaffId());
        //逻辑删除
        wrapperztnumber.eq("IS_DELETED",0);
        return mapper.kuangtnumber(wrapperztnumber,clockRecord.getDates());
    }


}
