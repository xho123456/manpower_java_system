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


    //考勤月汇总记录
    @Override
    public IPage<StaffVo> querymothday(StaffVo staffVo) {
        Page<StaffVo> pagea = new Page<>(staffVo.getCurrenPage(),staffVo.getPagesize());
        QueryWrapper<StaffVo> wrappera = new QueryWrapper<>();
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

            staffVoIPage.getRecords().get(i).setTravels(travels);
            staffVoIPage.getRecords().get(i).setLeaves(leave);
            staffVoIPage.getRecords().get(i).setClockRs(list);
            staffVoIPage.getRecords().get(i).setDepts(dept);
        }
        return staffVoIPage;
    }
}
