package com.trkj.system.attendance_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.system.attendance_management.entity.Checkfiles;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.system.attendance_management.entity.ClockRecord;
import com.trkj.system.attendance_management.entity.StaffVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-25
 */
public interface CheckfilesService {

    //考勤月统计
    IPage<StaffVo> querymothday(StaffVo staffVo);

    //考勤一键归档
    IPage<StaffVo> addmothday(StaffVo staffVo);

    //查询当前选择器月份是否有归档数据
    IPage<Checkfiles> querygds(Checkfiles checkfiles);

    //查询所有归档月份
    List<Checkfiles> querysDay(Checkfiles checkfiles);

    //通过日期查询归档表的数据
    IPage<Checkfiles> selectDayis(Checkfiles checkfiles);
}
