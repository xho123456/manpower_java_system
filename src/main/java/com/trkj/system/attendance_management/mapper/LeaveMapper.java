package com.trkj.system.attendance_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.attendance_management.entity.ClockRecord;
import com.trkj.system.attendance_management.entity.Leave;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.system.attendance_management.entity.Overtimeask;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 请假表 Mapper 接口
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-18
 */
@Mapper
public interface LeaveMapper extends BaseMapper<Leave> {
    //查询所有员工打卡记录
    @Select("select S.STAFF_NAME,D.DEPT_NAME,C.*,B.CLASSES_TIMEONES,B.CLASSES_TIMEONEX,B.CLASSES_TIMETWOS,B.CLASSES_TIMETWOX\n" +
            "            FROM ATTENDANCE_SHEET A LEFT JOIN CLOCK_RECORD C ON A.CLOCK_RECORD_ID = C.CLOCK_RECORD_ID\n" +
            "            LEFT JOIN CLASSES B ON B.CLASSES_ID = A.CLASSES_ID LEFT JOIN STAFF S ON  S.STAFF_ID =A.STAFF_ID LEFT JOIN DEPT D ON S.DEPT_ID = D.DEPT_ID ${ew.customSqlSegment}")
    IPage<ClockRecord> querybyidAll(Page<ClockRecord> page, @Param(Constants.WRAPPER) QueryWrapper queryWrapper);



    //根据当前登录用户查询请假信息
    @Select("select L.* ,A.AUDITFLOW_STATE as auditflowStaff,D.DEPT_NAME,S.STAFF_NAME as staffName1 from LEAVE L LEFT JOIN AUDITFLOW A on L.AUDITFLOW_ID = A.AUDITFLOW_ID LEFT JOIN DEPT D on D.DEPT_ID = L.DEPT_ID LEFT JOIN STAFF S ON S.STAFF_ID = L.STAFF_ID ${ew.customSqlSegment}")
    IPage<Leave> queryallqj(Page<Leave> page,@Param(Constants.WRAPPER) QueryWrapper queryWrapper);

    //根据当前登录用户查询加班信息
    @Select("select L.* ,A.AUDITFLOW_STATE as auditflowStaff,D.DEPT_NAME,S.STAFF_NAME as staffName1 from OVERTIMEASK L LEFT JOIN AUDITFLOW A on L.AUDITFLOW_ID = A.AUDITFLOW_ID LEFT JOIN DEPT D on D.DEPT_ID = L.DEPT_ID LEFT JOIN STAFF S ON S.STAFF_ID = A.STAFF_ID ${ew.customSqlSegment}")
    IPage<Overtimeask> queryalljb(Page<Overtimeask> page, @Param(Constants.WRAPPER) QueryWrapper queryWrapper);


    //查询当前登录用户的打卡记录
    @Select("select A.STAFF_ID,C.*,B.CLASSES_TIMEONES,B.CLASSES_TIMEONEX,B.CLASSES_TIMETWOS,B.CLASSES_TIMETWOX\n" +
            "FROM ATTENDANCE_SHEET A LEFT JOIN CLOCK_RECORD C ON A.CLOCK_RECORD_ID = C.CLOCK_RECORD_ID \n" +
            "LEFT JOIN CLASSES B ON B.CLASSES_ID = A.CLASSES_ID ${ew.customSqlSegment}")
    IPage<ClockRecord> querybyid(Page<ClockRecord> page, @Param(Constants.WRAPPER) QueryWrapper queryWrapper);


    //统计请假次数
    @Select("select count(*) from LEAVE ${ew.customSqlSegment}")
    int leavenumber(@Param(Constants.WRAPPER) QueryWrapper queryWrapper);
}
