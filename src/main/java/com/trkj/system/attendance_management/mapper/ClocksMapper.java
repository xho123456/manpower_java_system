package com.trkj.system.attendance_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.system.attendance_management.entity.ClockRecord;
import com.trkj.system.attendance_management.entity.ClockRecords;
import com.trkj.system.attendance_management.entity.Leave;
import com.trkj.system.attendance_management.entity.Travels;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 班次管理 Mapper 接口
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-10
 */
@Mapper
public interface ClocksMapper extends BaseMapper<ClockRecords> {


    //考勤月汇总记录
    @Select("SELECT \n" +
            "    distinct(C.STAFF_ID),\n" +
            "    SUM(C.AT_SHOULD) OVER (PARTITION BY C.STAFF_ID ORDER BY C.STAFF_ID) S1,\n" +
            "\t\tSUM(C.CHE_LATE) OVER (PARTITION BY C.STAFF_ID ORDER BY C.STAFF_ID) S2,\n" +
            "\t\tSUM(C.CHES_LATE) OVER (PARTITION BY C.STAFF_ID ORDER BY C.STAFF_ID) S3,\n" +
            "\t\tSUM(C.ZHAI_LATE) OVER (PARTITION BY C.STAFF_ID ORDER BY C.STAFF_ID) S4,\n" +
            "\t\tSUM(C.ZHAIS_LATE) OVER (PARTITION BY C.STAFF_ID ORDER BY C.STAFF_ID) S5,\n" +
            "\t\tSUM(C.KANG_LATE) OVER (PARTITION BY C.STAFF_ID ORDER BY C.STAFF_ID) S6,\n" +
            "\t\tSUM(C.KANGS_LATE) OVER (PARTITION BY C.STAFF_ID ORDER BY C.STAFF_ID) S7,\n" +
            "\t\tSUM(C.WORK_YING) OVER (PARTITION BY C.STAFF_ID ORDER BY C.STAFF_ID) S8\n" +
            "FROM\n" +
            "    CLOCK_RECORD C ${ew.customSqlSegment}")
    ClockRecords querydaymoth(@Param(Constants.WRAPPER) QueryWrapper queryWrapper);


    //请假数据汇总
    @Select("SELECT \n" +
            "    distinct(L.STAFF_ID),\n" +
            "    SUM(L.LEAVE_TOTAL_DATE) OVER (PARTITION BY L.STAFF_ID ORDER BY L.STAFF_ID)/24 qidays,\n" +
            "    SUM(L.LEAVE_TOTAL_DATE) OVER (PARTITION BY L.STAFF_ID ORDER BY L.STAFF_ID) qjtimes FROM LEAVE L " +
            "LEFT JOIN AUDITFLOW a on l.AUDITFLOW_ID = a.AUDITFLOW_ID ${ew.customSqlSegment} and a.AUDITFLOW_STATE = 1")
    Leave queryqingia(@Param(Constants.WRAPPER) QueryWrapper queryWrapper);

    //请假数据汇总
    @Select("SELECT  distinct(T.STAFF_ID),\n" +
            "    SUM(T.TRAVEL_TOTAL_DATE) OVER (PARTITION BY T.STAFF_ID ORDER BY T.STAFF_ID)/24 ccday,\n" +
            "    SUM(T.TRAVEL_TOTAL_DATE) OVER (PARTITION BY T.STAFF_ID ORDER BY T.STAFF_ID) cctiams\n" +
            "FROM TRAVEL T " +
            "LEFT JOIN AUDITFLOW a on T.AUDITFLOW_ID = a.AUDITFLOW_ID ${ew.customSqlSegment} and a.AUDITFLOW_STATE = 1")
    Travels querycc(@Param(Constants.WRAPPER) QueryWrapper queryWrapper);

}
