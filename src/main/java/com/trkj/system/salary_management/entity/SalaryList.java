package com.trkj.system.salary_management.entity;

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
public class SalaryList implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "调薪编号")
    @TableId( "SALARY_ID")
    private Integer salaryId;


    @ApiModelProperty(value = "审批编号")
    @TableField("AUDITFLOW_ID")
    private Long auditflowId;

    @ApiModelProperty(value = "员工编号")
    @TableField("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "员工名称")
    @TableField("STAFF_NAME")
    private String staffName;

    @ApiModelProperty(value = "部门编号")
    @TableField("DEPT_ID")
    private Long deptId;
    @ApiModelProperty(value = "部门名称")
    @TableField("DEPT_NAME")
    private String deptName;

    @ApiModelProperty(value = "调薪前基本工资")
    @TableField("FRONT_SALARY")
    private Long frontSalary;

    @ApiModelProperty(value = "调薪后基本工资")
    @TableField("AFTER_SALARY")
    private Long afterSalary;

    @ApiModelProperty(value = "操作人")
    @TableField("OPERATOR")
    private String operator;

    @ApiModelProperty(value = "备注")
    @TableField("SALARY_REMARKS")
    private String salaryRemarks;

    @ApiModelProperty(value = "状态")
    @TableField("SALARY_STATE")
    private Long salaryState;

    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    @ApiModelProperty(value = "生效日期")
    @TableField(value = "TAKE_EFFECT_DATE")
    private Date takeEffectDate;

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
