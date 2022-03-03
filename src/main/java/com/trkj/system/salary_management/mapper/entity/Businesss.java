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
public class Businesss implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "出差方案编号")
    @TableId( "BUSINESS_ID")
    private Integer businessId;


    @ApiModelProperty(value = "部门编号")
    @TableField("DEPT_ID")
    private Long deptId;

    @ApiModelProperty(value = "出差编号")
    @TableField("TRAVEL_ID")
    private Long travelId;

    @ApiModelProperty(value = "出差方案名称")
    @TableField("BUSINESS_NAME")
    private String businessName;

    @ApiModelProperty(value = "出差一天金额")
    @TableField("BUSINESS_ONEMONEY")
    private Long businessOnemoney;

    @ApiModelProperty(value = "状态")
    @TableField("BUSINESS_STATE")
    private Long businessState;

    @ApiModelProperty(value = "备注")
    @TableField("BUSINESS_REMARK")
    private String businessRemark;


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

    private int currentPage;
    private int pageSize;
}
