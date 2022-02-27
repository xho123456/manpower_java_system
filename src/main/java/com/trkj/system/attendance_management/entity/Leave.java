package com.trkj.system.attendance_management.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 请假表
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Leave implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "请假编号")
    @TableId("LEAVE_ID")
    private Long leaveId;

    @ApiModelProperty(value = "审批编号")
    @TableField("AUDITFLOW_ID")
    private Long auditflowId;

    @ApiModelProperty(value = "员工编号")
    @TableField("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "员工名称")
    @TableField("STAFF_NAME")
    private String staffName;

    @ApiModelProperty(value = "员工表：员工名称")
    @TableField("STAFF_NAME")
    private String staffName1;

    @ApiModelProperty(value = "部门表：部门名称")
    @TableField("DEPT_NAME")
    private String deptName;

    @ApiModelProperty(value = "审批主表：申请状态")
    @TableField("AUDITFLOW_STATE")
    private String auditflowStaff;

    @ApiModelProperty(value = "发起人部门")
    @TableField("DEPT_ID")
    private Long deptId;

    @ApiModelProperty(value = "请假类型")
    @TableField("LEAVE_TYPE")
    private String leaveType;

    @ApiModelProperty(value = "请假事由")
    @TableField("LEAVE_MATTER")
    private String leaveMatter;

    @ApiModelProperty(value = "备注")
    @TableField("LEAVE_REMARKS")
    private String leaveRemarks;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "请假开始时间")
    @TableField("LEAVE_S_DATE")
    private Date leaveSDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "请假结束时间")
    @TableField("LEAVE_E_DATE")
    private Date leaveEDate;

    @ApiModelProperty(value = "请假总小时")
    @TableField("LEAVE_TOTAL_DATE")
    private Long leaveTotalDate;

    @ApiModelProperty(value = "状态 0:不同意 1:同意")
    @TableField("LEAVE_STATE")
    private Long leaveState;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATED_TIME")
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("UPDATED_TIME")
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @ApiModelProperty(value = "逻辑删除")
    @TableField("IS_DELETED")
    private Long isDeleted;

    //分页
    @TableField(exist = false)
    private int currenPage;
    @TableField(exist = false)
    private int pagesize;

    //请假天数
    @TableField(exist = false)
    private Double qidays;

    //请假总时长
    @TableField(exist = false)
    private Double qjtimes;

}
