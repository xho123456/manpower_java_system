package com.trkj.system.salary_management.mapper.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@KeySequence(value = "ATTENDANDCE_ID" ,clazz = Integer.class)
@TableName(value = "ATTENDANDCE")
public class Attendandcee implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "考勤扣款方案编号")
    @TableId( "ATTENDANDCE_ID")
    private Integer attendandceId;


    @ApiModelProperty(value = "迟到一次金额")
    @TableField("ATTENDANDCE_LITEMONEY")
    private Long attendandceLitemoney;

    @ApiModelProperty(value = "考勤扣款方案名称")
    @TableField("ATTENDANDCE_NAME")
    private String attendandceName;

    @ApiModelProperty(value = "早退一次金额")
    @TableField("ATTENDANDCE_LEAVEMONEY")
    private Long attendandceLeavemoney;

    @ApiModelProperty(value = "旷工一天金额")
    @TableField("ATTENDANDCE_ABSCNTMONEY")
    private Long attendandceAbscntmoney;

    @ApiModelProperty(value = "状态")
    @TableField("ATTENDANDCE_STATE")
    private Long attendandceState;

    @ApiModelProperty(value = "部门编号")
    @TableField("DEPT_ID")
    private Long deptId;

    @ApiModelProperty(value = "备注")
    @TableField("ATTENDANDCE_REMARK")
    private String attendandceRemark;


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

}
