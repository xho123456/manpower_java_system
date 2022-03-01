package com.trkj.system.attendance_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.attendance_management.entity.*;
import com.trkj.system.attendance_management.mapper.CheckfilesMapper;
import com.trkj.system.attendance_management.mapper.ClocksMapper;
import com.trkj.system.attendance_management.mapper.StaffVoMapper;
import com.trkj.system.attendance_management.mapper.deptattenMapper;
import com.trkj.system.attendance_management.service.CheckfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-25
 */
@Service
public class CheckfilesServiceImpl implements CheckfilesService {

    @Autowired
    private CheckfilesMapper checkfilesMapper;

    @Autowired
    private StaffVoMapper staffVoMapper;

    @Autowired
    private deptattenMapper deptattenMapper;

    @Autowired
    private ClocksMapper clocksMapper;

    //考勤月汇总数据记录查询
    @Override
    public IPage<StaffVo> querymothday(StaffVo staffVo) {
        Page<StaffVo> pagea = new Page<>(staffVo.getCurrenPage(),staffVo.getPagesize());
        QueryWrapper<StaffVo> wrappera = new QueryWrapper<>();
        if(staffVo.getStaffName()!=null && !staffVo.getStaffName().equals("")){
            wrappera.like("STAFF_NAME",staffVo.getStaffName());
        }
        IPage<StaffVo> staffVoIPage = staffVoMapper.selectPage(pagea, wrappera);
        for (int i = 0; i <staffVoIPage.getRecords().size() ; i++) {
            //打卡记录
            QueryWrapper<ClockRecords> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("TO_CHAR(DAY_DATE,'yyyy-MM')",staffVo.getYears());
            queryWrapper.eq("STAFF_ID",staffVoIPage.getRecords().get(i).getStaffId());
            ClockRecords list = clocksMapper.querydaymoth(queryWrapper);
            //部门
            Deptattent dept = deptattenMapper.selectById(staffVoIPage.getRecords().get(i).getDeptId());
            //请假记录
            QueryWrapper<Leave> wrapper1 = new QueryWrapper<>();
            wrapper1.eq("TO_CHAR(L.LEAVE_S_DATE,'yyyy-MM')",staffVo.getYears());
            wrapper1.eq("L.STAFF_ID",staffVoIPage.getRecords().get(i).getStaffId());
            Leave leave = clocksMapper.queryqingia(wrapper1);
            //出差记录
            QueryWrapper<Travels> wrapper2 = new QueryWrapper<>();
            wrapper2.eq("T.STAFF_ID",staffVoIPage.getRecords().get(i).getStaffId());
            wrapper2.eq("TO_CHAR(T.TRAVEL_S_DATE,'yyyy-MM')",staffVo.getYears());
            Travels travels = clocksMapper.querycc(wrapper2);

            //加班记录
            QueryWrapper<Overtimeask> wrapper3 = new QueryWrapper<>();
            wrapper3.eq("O.STAFF_NAME",staffVoIPage.getRecords().get(i).getStaffName());
            wrapper3.eq("TO_CHAR(O.OVERTIMEASK_S_DATE,'yyyy-MM')",staffVo.getYears());
            Overtimeask overtimeask = clocksMapper.queryjb(wrapper3);

            staffVoIPage.getRecords().get(i).setOvertimeask(overtimeask);
            staffVoIPage.getRecords().get(i).setTravels(travels);
            staffVoIPage.getRecords().get(i).setLeaves(leave);
            staffVoIPage.getRecords().get(i).setClockRs(list);
            staffVoIPage.getRecords().get(i).setDepts(dept);
        }

        return staffVoIPage;
    }

    //考勤归档添加
    @Override
    public IPage<StaffVo> addmothday(StaffVo staffVo) {
        Page<StaffVo> pagea = new Page<>(staffVo.getCurrenPage(),staffVo.getPagesize());
        QueryWrapper<StaffVo> wrappera = new QueryWrapper<>();
        if(staffVo.getStaffName()!=null && !staffVo.getStaffName().equals("")){
            wrappera.like("STAFF_NAME",staffVo.getStaffName());
        }
        IPage<StaffVo> staffVoIPage = staffVoMapper.selectPage(pagea, wrappera);
        for (int i = 0; i <staffVoIPage.getRecords().size() ; i++) {
            //打卡记录
            QueryWrapper<ClockRecords> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("TO_CHAR(DAY_DATE,'yyyy-MM')",staffVo.getYears());
            queryWrapper.eq("STAFF_ID",staffVoIPage.getRecords().get(i).getStaffId());
            ClockRecords list = clocksMapper.querydaymoth(queryWrapper);
            //部门
            Deptattent dept = deptattenMapper.selectById(staffVoIPage.getRecords().get(i).getDeptId());
            //请假记录
            QueryWrapper<Leave> wrapper1 = new QueryWrapper<>();
            wrapper1.eq("L.STAFF_ID",staffVoIPage.getRecords().get(i).getStaffId());
            Leave leave = clocksMapper.queryqingia(wrapper1);
            //出差记录
            QueryWrapper<Travels> wrapper2 = new QueryWrapper<>();
            wrapper2.eq("T.STAFF_ID",staffVoIPage.getRecords().get(i).getStaffId());
            Travels travels = clocksMapper.querycc(wrapper2);

            //加班记录
            QueryWrapper<Overtimeask> wrapper3 = new QueryWrapper<>();
            wrapper3.eq("O.STAFF_NAME",staffVoIPage.getRecords().get(i).getStaffName());
            Overtimeask overtimeask = clocksMapper.queryjb(wrapper3);

            staffVoIPage.getRecords().get(i).setOvertimeask(overtimeask);
            staffVoIPage.getRecords().get(i).setTravels(travels);
            staffVoIPage.getRecords().get(i).setLeaves(leave);
            staffVoIPage.getRecords().get(i).setClockRs(list);
            staffVoIPage.getRecords().get(i).setDepts(dept);
        }

        //数据归档添加
        for (int i = 0; i <staffVoIPage.getRecords().size() ; i++) {
            Checkfiles checkfiles = new Checkfiles();
            //员工姓名
            System.out.println("员工姓名"+staffVoIPage.getRecords().get(i).getStaffName());
            checkfiles.setStaffName(staffVoIPage.getRecords().get(i).getStaffName());
            //所属部门
            System.out.println("所属部门"+staffVoIPage.getRecords().get(i).getDepts().getDeptName());
            checkfiles.setDeptName(staffVoIPage.getRecords().get(i).getDepts().getDeptName());
            //归档日期
            Date date = new Date();
            int year = date.getYear()+1900;
            int month  = date.getMonth()+1;
            System.out.println(month>9?year+"-"+month:year+"-"+"0"+month);
            checkfiles.setYears(new Date());
            //应出勤天数
            checkfiles.setAttendanceTime(22L);
            //实际出勤天数
            if (staffVoIPage.getRecords().get(i).getClockRs()==null){
                System.out.println("实际出勤天数:"+"0.0");
                checkfiles.setActualattendanceTime(0L);
            }else{
               System.out.println("实际出勤天数:"+staffVoIPage.getRecords().get(i).getClockRs().getS1());
               checkfiles.setActualattendanceTime(staffVoIPage.getRecords().get(i).getClockRs().getS1());
            }
            //迟到次数
            if (staffVoIPage.getRecords().get(i).getClockRs()==null){
                System.out.println("迟到次数:"+"0.0");
                checkfiles.setLateTimes(0L);
            }else{
                System.out.println("迟到次数:"+staffVoIPage.getRecords().get(i).getClockRs().getS2());
                checkfiles.setLateTimes(staffVoIPage.getRecords().get(i).getClockRs().getS2());
            }
            //迟到总时长
            if (staffVoIPage.getRecords().get(i).getClockRs()==null){
                System.out.println("迟到总时长:"+"0.0");
                checkfiles.setHoursLate((double) 0);
            }else{
                System.out.println("迟到总时长:"+staffVoIPage.getRecords().get(i).getClockRs().getS3());
                checkfiles.setHoursLate(staffVoIPage.getRecords().get(i).getClockRs().getS3());
            }
            //早退次数
            if (staffVoIPage.getRecords().get(i).getClockRs()==null){
                System.out.println("早退次数:"+"0.0");
                checkfiles.setEarlyLeave(0L);
            }else{
                System.out.println("早退次数:"+staffVoIPage.getRecords().get(i).getClockRs().getS4());
                checkfiles.setEarlyLeave(staffVoIPage.getRecords().get(i).getClockRs().getS4());
            }
            //早退总时长
            if (staffVoIPage.getRecords().get(i).getClockRs()==null){
                System.out.println("早退总时长:"+"0.0");
                checkfiles.setEarlyHours((double) 0);
            }else{
                System.out.println("早退总时长:"+staffVoIPage.getRecords().get(i).getClockRs().getS5());
                checkfiles.setEarlyHours(staffVoIPage.getRecords().get(i).getClockRs().getS5());
            }
            //旷工次数
            if (staffVoIPage.getRecords().get(i).getClockRs()==null){
                System.out.println("旷工次数:"+"0.0");
                checkfiles.setAbsenteeism(0L);
            }else{
                System.out.println("旷工次数:"+staffVoIPage.getRecords().get(i).getClockRs().getS6());
                checkfiles.setAbsenteeism(staffVoIPage.getRecords().get(i).getClockRs().getS6());
            }
            //旷工总时长
            if (staffVoIPage.getRecords().get(i).getClockRs()==null){
                System.out.println("旷工总时长:"+"0.0");
                checkfiles.setAbsenteeismHours((double) 0);
            }else{
                System.out.println("旷工总时长:"+staffVoIPage.getRecords().get(i).getClockRs().getS7());
                checkfiles.setAbsenteeismHours(staffVoIPage.getRecords().get(i).getClockRs().getS7());
            }
            //加班总时长
            if (staffVoIPage.getRecords().get(i).getOvertimeask()==null){
                System.out.println("加班总时长:"+"0.0");
                checkfiles.setOvertimeHours((double) 0);
            }else{
                System.out.println("加班总时长:"+staffVoIPage.getRecords().get(i).getOvertimeask().getJbtimes());
                checkfiles.setOvertimeHours(staffVoIPage.getRecords().get(i).getOvertimeask().getJbtimes());
            }
            //请假天数
            if (staffVoIPage.getRecords().get(i).getLeaves()==null){
                System.out.println("请假天数:"+"0.0");
                checkfiles.setNumberofLeave(0L);
            }else{
                System.out.println("请假天数:"+staffVoIPage.getRecords().get(i).getLeaves().getQidays());
                checkfiles.setNumberofLeave(staffVoIPage.getRecords().get(i).getLeaves().getQidays());
            }
            //请假总时长
            if (staffVoIPage.getRecords().get(i).getLeaves()==null){
                System.out.println("请假总时长:"+"0.0");
                checkfiles.setLengthofLeave((double) 0);
            }else{
                System.out.println("请假总时长:"+staffVoIPage.getRecords().get(i).getLeaves().getQjtimes());
                checkfiles.setLengthofLeave(staffVoIPage.getRecords().get(i).getLeaves().getQjtimes());
            }
            //出差天数
            if (staffVoIPage.getRecords().get(i).getTravels()==null){
                System.out.println("出差天数:"+"0.0");
                checkfiles.setTravelDays(0L);
            }else{
                System.out.println("出差天数:"+staffVoIPage.getRecords().get(i).getTravels().getCcday());
                checkfiles.setTravelDays(staffVoIPage.getRecords().get(i).getTravels().getCcday());
            }
            System.out.println("=================================================================");
            //调用添加方法
            checkfilesMapper.insert(checkfiles);
        }
        return staffVoIPage;
    }

    //查询当前选择器月份是否有归档数据
    @Override
    public IPage<Checkfiles> querygds(Checkfiles checkfiles) {
        Page<Checkfiles> pagegd = new Page<>(checkfiles.getCurrenPage(),checkfiles.getPagesize());
        return checkfilesMapper.querygd(pagegd,checkfiles.getDatesgd());
    }

    //查询所有归档月份
    @Override
    public List<Checkfiles> querysDay(Checkfiles checkfiles) {
        QueryWrapper<Checkfiles> aa = new QueryWrapper<>();
        return checkfilesMapper.selectAllsDay(aa);
    }

    //通过日期查询归档表的数据
    @Override
    public IPage<Checkfiles> selectDayis(Checkfiles checkfiles) {
        Page<Checkfiles> pagecs = new Page<>(checkfiles.getCurrenPage(),checkfiles.getPagesize());
        QueryWrapper<Checkfiles> wrapperdayis = new QueryWrapper<>();
        if (checkfiles.getDeptName()!=null && !checkfiles.getDeptName().equals("")){
            wrapperdayis.like("DEPT_NAME",checkfiles.getDeptName());
        }
        if (checkfiles.getStaffName()!=null && !checkfiles.getStaffName().equals("")){
            wrapperdayis.like("STAFF_NAME",checkfiles.getStaffName());
        }
        wrapperdayis.eq("IS_DELETED",0);
        return checkfilesMapper.queryAllgd(pagecs,wrapperdayis,checkfiles.getDatesgd());
    }


}
