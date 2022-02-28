package com.trkj.system.attendance_management.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.trkj.system.recruit_modular.entity.Dept;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 员工表
 * </p>
 *
 * @author 鄧琪
 * @since 2021-12-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("STAFF")
@ApiModel(value="Staff对象", description="员工表")
@KeySequence(value = "STAFF_ID", clazz = Integer.class)

public class StaffVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "员工编号")
    @TableId("STAFF_ID")
    private Long staffId;

    @TableId("DEPT_ID")
    private Long deptId;

    @ApiModelProperty(value = "员工姓名")
    @TableField("STAFF_NAME")
    private String staffName;


    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    @ApiModelProperty(value = "创建时间 精确到秒")
    @TableField(value = "CREATED_TIME" , fill = FieldFill.INSERT)
    private Date createdTime;

    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    @ApiModelProperty(value = "修改时间 精确到秒")
    @TableField(value = "UPDATED_TIME",fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @Version
    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @TableLogic
    @ApiModelProperty(value = "逻辑删除 0:未删 1:已删 ")
    @TableField("IS_DELETED")
    private Long isDeleted;

    //打卡记录表对象
    @TableField(exist = false)
    private List<ClockRecords> clockRsList;

    //打卡记录表对象
    @TableField(exist = false)
    private ClockRecords clockRs;

    //分页
    @TableField(exist = false)
    private int currenPage;
    @TableField(exist = false)
    private int pagesize;

    //日期
    @TableField(exist = false)
    private String dates;

    //部门
    @TableField(exist = false)
    private Deptattent depts;

    //考勤汇总明细表对象
    @TableField(exist = false)
    private Checkfiles checkfiles;

    //打卡记录表日期
    @TableField(exist = false)
    private String years;

    //部门名称
    @TableField(exist = false)
    private String deptName;

    //请假表对象
    @TableField(exist = false)
    private Leave leaves;

    //出差表对象
    @TableField(exist = false)
    private Travels travels;

}
