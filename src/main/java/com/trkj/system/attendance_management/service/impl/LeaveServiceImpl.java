package com.trkj.system.attendance_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.attendance_management.entity.*;
import com.trkj.system.attendance_management.mapper.*;
import com.trkj.system.attendance_management.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

    @Autowired
    private StaffVoMapper staffMapper;

    @Autowired
    private ClocksMapper clocksMapper;

    @Autowired
    private deptattenMapper deptmapper;


    //查询所有员工打卡记录
    @Override
    public IPage<ClockRecord> selectAll(ClockRecord clockRecord) {
        Page<ClockRecord> pageall = new Page<>(clockRecord.getCurrenPage(), clockRecord.getPagesize());
        QueryWrapper<ClockRecord> wrapperall = new QueryWrapper<>();
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
        QueryWrapper<ClockRecord> wrapperdk = new QueryWrapper<>();
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
        QueryWrapper<Overtimeask> wrapperjb = new QueryWrapper<>();
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

    //考勤月统计123123
    @Override
    public IPage<StaffVo> selectAllmothday(StaffVo staffVo) {
        Page<StaffVo> pagemothday = new Page<>(staffVo.getCurrenPage(), staffVo.getPagesize());
        QueryWrapper<StaffVo> wrappers = new QueryWrapper<>();
        IPage<StaffVo> staffVoIPage = staffMapper.selectPage(pagemothday, null);
        for (int i = 0; i <staffVoIPage.getRecords().size() ; i++) {
            QueryWrapper<ClockRecords> queryWrapper = new QueryWrapper<>();
            queryWrapper.isNull("CLOCK_RECORD_ID").or();
            Date date = new Date();
            int year = date.getYear()+1900;
            int month  = date.getMonth()+1;
            queryWrapper.eq("TO_CHAR(DAY_DATE,'yyyy-MM')",month>9?year+"-"+month:year+"-"+"0"+month);
//            queryWrapper.eq("TO_CHAR(DAY_DATE,'yyyy-MM')",staffVoIPage.getRecords().get(i).getDates());
            queryWrapper.eq("STAFF_ID",staffVoIPage.getRecords().get(i).getStaffId());
            Deptattent dept = deptmapper.selectById(staffVoIPage.getRecords().get(i).getDeptId());
            List<ClockRecords> list = clocksMapper.selectList(queryWrapper);
            staffVoIPage.getRecords().get(i).setClockRsList(list);
            staffVoIPage.getRecords().get(i).setDept(dept);
        }
        // 获取当前年月
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        Calendar calendar = Calendar.getInstance();
        //当天是星期几
        int number = calendar.get(Calendar.DAY_OF_WEEK);//星期表示1-7，是从星期日开始，
        String [] str = {"","星期日","星期一","星期二","星期三","星期四","星期五","星期六",};

        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DATE, 1);
        cal.roll(Calendar.DATE, -1);
        int maxDate = cal.get(Calendar.DATE);
        // 获取当前年月
        List list1 = new ArrayList();
        for (int i = 0; i < maxDate-1; i++) {
            cal.add(Calendar.DATE, 1);//在第一天的基础上加1
            int week = cal.get(Calendar.DAY_OF_WEEK);
            if (week == Calendar.SATURDAY || week == Calendar.SUNDAY) {// 1代表周日，7代表周六 判断这是一个星期的第几天从而判断是否是周末
                list1.add(month+"-"+cal.get(Calendar.DAY_OF_MONTH));// 得到当天是一个月的第几天
            }
        }
        for (int j = 0; j < staffVoIPage.getRecords().size(); j++) {
            List<ClockRecords> list = new ArrayList<ClockRecords>();
            for (int i = 1; i <= maxDate; i++) {
                ClockRecords clockRecord = null;
                for (int k = 0; k < staffVoIPage.getRecords().get(j).getClockRsList().size(); k++) {
                    if (staffVoIPage.getRecords().get(j).getClockRsList().get(k).getDayDate().getDate() == i) {
                        staffVoIPage.getRecords().get(j).getClockRsList().get(k).setMoth(
                                staffVoIPage.getRecords().get(j).getClockRsList().get(k).getDayDate().getMonth()+1 + "-"
                                        + i);
                        clockRecord =staffVoIPage.getRecords().get(j).getClockRsList().get(k);
                    }
                }
                if (clockRecord==null){
                    clockRecord= new ClockRecords();
                    clockRecord.setMoth(month+ "-" + i);
                    clockRecord.setSmornResult("");
                    clockRecord.setXafternoonResult("");
                }
                list.add(clockRecord);
            }
            staffVoIPage.getRecords().get(j).setClockRsList(list);
        }

        return staffVoIPage;
    }


}
