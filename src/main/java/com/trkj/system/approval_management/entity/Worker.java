package com.trkj.system.approval_management.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 转正
 *
 * @author suki
 * @since 2021-12-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("WORKER")
@ApiModel(value="Worker对象", description="转正")
@KeySequence(value = "WORKER_ID",clazz = Integer.class)
public class Worker implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "转正编号")
    @TableId("WORKER_ID")
    private Integer workerId;

    @ApiModelProperty(value = "审批编号")
    @TableField("AUDITFLOW_ID")
    private Integer auditflowId;

    @ApiModelProperty(value = "员工名称")
    @TableField("STAFF_NAME")
    private String staffName;

    @ApiModelProperty(value = "部门编号")
    @TableField("DEPT_ID")
    private Long deptId;

    private Long staffId;

    @ApiModelProperty(value = "部门名称")
    @TableField("DEPT_NAME")
    private String deptname;

    @ApiModelProperty(value = "转正类型")
    @TableField("WORKER_TYPE")
    private String workerType;

    @ApiModelProperty(value = "备注")
    @TableField("WORKER_REMARKS")
    private String workerRemarks;

    @ApiModelProperty(value = "状态 0:不同意 1:同意")
    @TableField("WORKER_STATE")
    private Long workerState;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "转正日期")
    @TableField("WORKER_DATE")
    private Date workerDate;

    @ApiModelProperty(value = "创建时间 精确到秒")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "CREATED_TIME", fill = FieldFill.INSERT)
    private Date createdTime;

    @ApiModelProperty(value = "修改时间 精确到秒")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "UPDATED_TIME", fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    @Version
    private Long revision;

    @ApiModelProperty(value = "逻辑删除 0:未删 1:已删")
    @TableField("IS_DELETED")
    @TableLogic
    private Long isDeleted;

}
