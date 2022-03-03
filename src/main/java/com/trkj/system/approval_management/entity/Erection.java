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
@TableName("TRAVEL")
@KeySequence(value = "TRAVEL_ID",clazz = Integer.class)
public class Erection {

    @TableId("TRAVEL_ID")
    private Integer travelId;

    @ApiModelProperty(value = "审批编号")
    @TableField("AUDITFLOW_ID")
    private Integer auditflowId;

    @ApiModelProperty(value = "员工名称")
    @TableField("STAFF_NAME")
    private String staffName;

    @ApiModelProperty(value = "部门编号")
    @TableField("DEPT_ID")
    private Long deptId;

    private String travelPlace;

    private String travelMatter;

    private Date travelSDate;

    private Date travelEDate;

    private Long travelTotalDate;

    private Long travelState;

    private Date updatedTime;

    private Date createdTime;
}
