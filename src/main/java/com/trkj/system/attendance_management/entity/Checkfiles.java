package com.trkj.system.attendance_management.entity;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 *  考勤汇总明细表
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("CHECKFILES")
@ApiModel(value="Checkfiles对象", description="")
@KeySequence(value = "CHECKFILES_ID", clazz = Integer.class)
public class Checkfiles implements Serializable {

    private static final long serialVersionUID = 1L;

    //考勤归档编号
    @TableId("CHECKFILES_ID")
    private Integer checkfilesId;

    //员工名称
    @TableField("STAFF_NAME")
    private String staffName;

    //部门名称
    @TableField("DEPT_NAME")
    private String deptName;

    //所属年月
    @TableField("YEARS")
    @JsonFormat(pattern = "yyyy-MM",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date years;

    //应出勤天数
    @TableField("ATTENDANCE_TIME")
    private Long attendanceTime;

    //实际出勤天数
    @TableField("ACTUALATTENDANCE_TIME")
    private Long actualattendanceTime;

    //迟到次数
    @TableField("LATE_TIMES")
    private Long lateTimes;

    //迟到总时长
    @TableField("HOURS_LATE")
    private Double hoursLate;

    //早退次数
    @TableField("EARLY_LEAVE")
    private Long earlyLeave;

    //早退总时长
    @TableField("EARLY_HOURS")
    private Double earlyHours;

    //旷工次数
    @TableField("ABSENTEEISM")
    private Long absenteeism;

    //旷工总时长
    @TableField("ABSENTEEISM_HOURS")
    private Double absenteeismHours;

    //加班总时长
    @TableField("OVERTIME_HOURS")
    private Double overtimeHours;

    //请假天数
    @TableField("NUMBEROF_LEAVE")
    private Long numberofLeave;

    //请假总时长
    @TableField("LENGTHOF_LEAVE")
    private Double lengthofLeave;

    //出差天数
    @TableField("TRAVEL_DAYS")
    private Long travelDays;

    //创建时间
    @TableField("CREATED_TIME")
    private Date createdTime;

    //修改时间
    @TableField("UPDATED_TIME")
    private Date updatedTime;

    //乐观锁
    @TableField("REVISION")
    private Long revision;

    //逻辑删除
    @TableField("IS_DELETED")
    private Long isDeleted;

    //分页
    @TableField(exist = false)
    private int currenPage;
    @TableField(exist = false)
    private int pagesize;

    @TableField(exist = false)
    private String datesgd;



}
