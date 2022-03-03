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
@KeySequence(value = "FIXEDWAGE" ,clazz = Integer.class)
@Accessors(chain = true)
public class Fixedwage implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "固定工资编号")
    @TableId( "FIXEDWAGE_ID")
    private Integer fixedwageId;


    @ApiModelProperty(value = "员工编号")
    @TableField("STAFF_ID")
    private Long staffId;


    @ApiModelProperty(value = "试用期基本工资")
    @TableField("FIXEDWAGE_PERIODMONEY")
    private Long fixedwagePeriodmoney;

    @ApiModelProperty(value = "正式期基本工资")
    @TableField("FIXEDWAGE_OFFICIALMONEY")
    private Long fixedwageOfficialmoney;

    @ApiModelProperty(value = "备注")
    @TableField("FIXEDWAGE_REMARK")
    private String fixedwageRemark;

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
