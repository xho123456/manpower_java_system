package com.trkj.system.approval_management.entity;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("TRANSFER")
@KeySequence(value = "TRANSFER_ID",clazz = Integer.class)
public class Move {

    @TableId("TRANSFER_ID")
    private Integer transferId;

    @ApiModelProperty(value = "审批编号")
    @TableField("AUDITFLOW_ID")
    private Integer auditflowId;

    @ApiModelProperty(value = "员工编号")
    @TableField("STAFF_ID")
    private Integer staffId;


    private String transferType;

    private String createdDeptName;

    private Long transferState;

    private String updatedDeptName;

    private String transferRawpostName;

    private String transferAfterpostName;

    private Date takeEffectDate;

    private Date updatedTime;

    private Date createdTime;
}
