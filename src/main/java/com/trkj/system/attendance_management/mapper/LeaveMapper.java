package com.trkj.system.attendance_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.attendance_management.entity.ClockRecord;
import com.trkj.system.attendance_management.entity.Leave;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.system.attendance_management.entity.Overtimeask;
import com.trkj.system.attendance_management.entity.StaffVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import javax.xml.crypto.Data;
import java.util.Date;

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
    @Select("select S.STAFF_NAME,D.DEPT_NAME, R.*,C.CLASSES_TIMEONES,C.CLASSES_TIMEONEX,C.CLASSES_TIMETWOS,C.CLASSES_TIMETWOX\n" +
            "FROM CLOCK_RECORD R LEFT JOIN ATTENDANCE_SHEET A  ON R.CLOCK_RECORD_ID = A.CLOCK_RECORD_ID\n" +
            "LEFT JOIN CLASSES C ON A.CLASSES_ID = C.CLASSES_ID LEFT JOIN STAFF S ON A.STAFF_ID = S.STAFF_ID LEFT JOIN DEPT D ON S.DEPT_ID = D.DEPT_ID ${ew.customSqlSegment} AND to_char(R.DAY_DATE,'yyyy-MM-dd') = #{dates}")
    IPage<ClockRecord> querybyidAll(Page<ClockRecord> page, @Param(Constants.WRAPPER) QueryWrapper queryWrapper,@Param("dates") String dates);


    //查询当前登录用户的打卡记录
    @Select("select A.STAFF_ID as staffId1 ,C.*,B.CLASSES_TIMEONES,B.CLASSES_TIMEONEX,B.CLASSES_TIMETWOS,B.CLASSES_TIMETWOX\n" +
            "FROM ATTENDANCE_SHEET A LEFT JOIN CLOCK_RECORD C ON A.CLOCK_RECORD_ID = C.CLOCK_RECORD_ID \n" +
            "LEFT JOIN CLASSES B ON B.CLASSES_ID = A.CLASSES_ID ${ew.customSqlSegment} AND to_char(c.DAY_DATE,'yyyy-MM') = #{dates}")
    IPage<ClockRecord> querybyid(Page<ClockRecord> page, @Param(Constants.WRAPPER) QueryWrapper queryWrapper,@Param("dates") String dates);


    //根据当前登录用户查询请假信息
    @Select("select L.* ,A.AUDITFLOW_STATE as auditflowStaff,D.DEPT_NAME,S.STAFF_NAME as staffName1 from LEAVE L LEFT JOIN AUDITFLOW A on L.AUDITFLOW_ID = A.AUDITFLOW_ID LEFT JOIN DEPT D on D.DEPT_ID = L.DEPT_ID LEFT JOIN STAFF S ON S.STAFF_ID = L.STAFF_ID ${ew.customSqlSegment}")
    IPage<Leave> queryallqj(Page<Leave> page,@Param(Constants.WRAPPER) QueryWrapper queryWrapper);

    //统计请假次数
    @Select("select count(*) from LEAVE ${ew.customSqlSegment}")
    int leavenumber(@Param(Constants.WRAPPER) QueryWrapper queryWrapper);

    //根据当前登录用户查询加班信息
    @Select("select L.* ,A.AUDITFLOW_STATE as auditflowStaff,D.DEPT_NAME,S.STAFF_NAME as staffName1 from OVERTIMEASK L LEFT JOIN AUDITFLOW A on L.AUDITFLOW_ID = A.AUDITFLOW_ID LEFT JOIN DEPT D on D.DEPT_ID = L.DEPT_ID LEFT JOIN STAFF S ON S.STAFF_ID = A.STAFF_ID ${ew.customSqlSegment}")
    IPage<Overtimeask> queryalljb(Page<Overtimeask> page, @Param(Constants.WRAPPER) QueryWrapper queryWrapper);

    //统计加班次数
    @Select("select count(*) from OVERTIMEASK L LEFT JOIN AUDITFLOW A on L.AUDITFLOW_ID = A.AUDITFLOW_ID LEFT JOIN DEPT D on D.DEPT_ID = L.DEPT_ID LEFT JOIN STAFF S ON S.STAFF_ID = A.STAFF_ID  ${ew.customSqlSegment} AND TO_CHAR(L.CREATED_TIME,'yyyy-MM') = #{dates}")
    int jabnumber(@Param(Constants.WRAPPER) QueryWrapper queryWrapper,@Param("dates") String dates);


    //根据当前登录用户查询迟到信息
    @Select("SELECT S.STAFF_NAME,D.DEPT_NAME,L.CLASSES_TIMEONES,L.CLASSES_TIMEONEX,L.CLASSES_TIMETWOS,L.CLASSES_TIMETWOX,C.* \n" +
            "FROM ATTENDANCE_SHEET A LEFT JOIN STAFF S ON A.STAFF_ID = S.STAFF_ID\n" +
            "LEFT JOIN CLOCK_RECORD C ON A.CLOCK_RECORD_ID = C.CLOCK_RECORD_ID \n" +
            "LEFT JOIN CLASSES L ON A.CLASSES_ID = L.CLASSES_ID \n" +
            "LEFT JOIN DEPT D ON S.DEPT_ID = D.DEPT_ID ${ew.customSqlSegment} AND C.SMORN_RESULT = '迟到' AND TO_CHAR(C.DAY_DATE,'yyyy-MM') = #{dates}")
    IPage<ClockRecord> querybyidAllchid(Page<ClockRecord> page, @Param(Constants.WRAPPER) QueryWrapper queryWrapper,@Param("dates") String dates);

    //统计迟到次数
    @Select("select count(*) from CLOCK_RECORD ${ew.customSqlSegment} AND TO_CHAR(DAY_DATE,'yyyy-MM') = #{dates}")
    int chidnumber(@Param(Constants.WRAPPER) QueryWrapper queryWrapper,@Param("dates") String dates);

    ///根据当前登录用户查询早退信息
    @Select("SELECT S.STAFF_NAME,D.DEPT_NAME,L.CLASSES_TIMEONES,L.CLASSES_TIMEONEX,L.CLASSES_TIMETWOS,L.CLASSES_TIMETWOX,C.* \n" +
            "FROM ATTENDANCE_SHEET A LEFT JOIN STAFF S ON A.STAFF_ID = S.STAFF_ID\n" +
            "LEFT JOIN CLOCK_RECORD C ON A.CLOCK_RECORD_ID = C.CLOCK_RECORD_ID \n" +
            "LEFT JOIN CLASSES L ON A.CLASSES_ID = L.CLASSES_ID \n" +
            "LEFT JOIN DEPT D ON S.DEPT_ID = D.DEPT_ID ${ew.customSqlSegment} AND C.XAFTERNOON_RESULT = '早退' AND TO_CHAR(C.DAY_DATE,'yyyy-MM') = #{dates}")
    IPage<ClockRecord> querybyidAllzaot(Page<ClockRecord> page, @Param(Constants.WRAPPER) QueryWrapper queryWrapper,@Param("dates") String dates);

    //统计早退次数
    @Select("select count(*) from CLOCK_RECORD ${ew.customSqlSegment} AND TO_CHAR(DAY_DATE,'yyyy-MM') = #{dates}")
    int zaotnumber(@Param(Constants.WRAPPER) QueryWrapper queryWrapper,@Param("dates") String dates);

    ///根据当前登录用户查询旷工信息
    @Select("SELECT S.STAFF_NAME,D.DEPT_NAME,L.CLASSES_TIMEONES,L.CLASSES_TIMEONEX,L.CLASSES_TIMETWOS,L.CLASSES_TIMETWOX,C.* \n" +
            "FROM ATTENDANCE_SHEET A LEFT JOIN STAFF S ON A.STAFF_ID = S.STAFF_ID\n" +
            "LEFT JOIN CLOCK_RECORD C ON A.CLOCK_RECORD_ID = C.CLOCK_RECORD_ID \n" +
            "LEFT JOIN CLASSES L ON A.CLASSES_ID = L.CLASSES_ID \n" +
            "LEFT JOIN DEPT D ON S.DEPT_ID = D.DEPT_ID ${ew.customSqlSegment} AND TO_CHAR(C.DAY_DATE,'yyyy-MM') = #{dates} AND  C.SMORN_RESULT='旷工' OR C.XAFTERNOON_RESULT = '旷工'")
    IPage<ClockRecord> querybyidAllkuang(Page<ClockRecord> page, @Param(Constants.WRAPPER) QueryWrapper queryWrapper,@Param("dates") String dates);

    //统计旷工次数
    @Select("select count(*) from CLOCK_RECORD ${ew.customSqlSegment} AND TO_CHAR(DAY_DATE,'yyyy-MM') = #{dates} AND  SMORN_RESULT='旷工' OR XAFTERNOON_RESULT = '旷工'")
    int kuangtnumber(@Param(Constants.WRAPPER) QueryWrapper queryWrapper,@Param("dates") String dates);



    //当前登录用户考勤次数查询
    @Select("select count(*) from CLOCK_RECORD ${ew.customSqlSegment} AND TO_CHAR(DAY_DATE,'yyyy-MM') = #{dates}")
    int countquerys(@Param(Constants.WRAPPER) QueryWrapper queryWrapper,@Param("dates") String dates);


}
