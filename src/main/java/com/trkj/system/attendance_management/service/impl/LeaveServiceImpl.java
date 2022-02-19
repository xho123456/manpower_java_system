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
        wrapperall.eq("C.IS_DELETED",0);
        return mapper.querybyidAll(pageall,wrapperall);
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

    //根据当前登录用户查询加班信息
    @Override
    public IPage<Overtimeask> selectAlljb(Overtimeask overtimeask) {
        Page<Overtimeask> pagejb = new Page<>(overtimeask.getCurrenPage(), overtimeask.getPagesize());
        QueryWrapper<Leave> wrapperjb = new QueryWrapper<>();
        wrapperjb.eq("A.STAFF_ID",overtimeask.getStaffId());
        wrapperjb.eq("L.IS_DELETED",0);
        return mapper.queryalljb(pagejb,wrapperjb);
    }

    //查询当前登录用户的打卡记录
    @Override
    public IPage<ClockRecord> selectAlldk(ClockRecord clockRecord) {
        Page<ClockRecord> pagedk = new Page<>(clockRecord.getCurrenPage(), clockRecord.getPagesize());
        QueryWrapper<Leave> wrapperdk = new QueryWrapper<>();
        wrapperdk.eq("A.STAFF_ID",clockRecord.getStaffId());
        wrapperdk.eq("C.IS_DELETED",0);
        return mapper.querybyid(pagedk,wrapperdk);
    }


    //统计请假次数
    @Override
    public int querynumber(Leave leave) {
        QueryWrapper<Leave> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("STAFF_ID",leave.getStaffId());
        wrapper1.eq("IS_DELETED",0);
        return mapper.leavenumber(wrapper1);
    }


}
