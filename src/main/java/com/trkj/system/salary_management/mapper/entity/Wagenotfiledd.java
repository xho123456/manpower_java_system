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
public class Wagenotfiledd implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "工资归档编号")
    @TableId( "WAGENOTFILED_ID")
    private Integer wagenotfiledId;


    @ApiModelProperty(value = "计薪人数")
    @TableField("WAGENOTFILED_ASKPERSON")
    private Long wagenotfiledAskperson;

    @ApiModelProperty(value = "应发工资")
    @TableField("WAGENOTFILED_SALARY")
    private Long wagenotfiledSalary;

    @ApiModelProperty(value = "实发工资")
    @TableField("WAGENOTFILED_PAYROLLSALARY")
    private Long wagenotfiledPayrollsalary;

    @ApiModelProperty(value = "公司缴纳")
    @TableField("WAGENOTFILED_FIRMPAYMENT")
    private Long wagenotfiledFirmpayment;

    @ApiModelProperty(value = "员工成本")
    @TableField("WAGENOTFILED_STAFFCOST")
    private Long wagenotfiledStaffcost;

    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    @ApiModelProperty(value = "日期")
    @TableField(value = "WAGENOTFILED_DATE" , fill = FieldFill.INSERT)
    private Date wagenotfiledDate;

    @ApiModelProperty(value = "状态;0：未归档，1：已归档")
    @TableField("WAGENOTFILED_STATE")
    private Long wagenotfiledState;

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
