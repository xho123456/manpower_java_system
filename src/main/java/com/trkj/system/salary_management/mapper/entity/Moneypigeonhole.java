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
@KeySequence(value = "SALARY_ID" ,clazz = Integer.class)
@Accessors(chain = true)
@TableName(value = "MONEYPIGEONHOLE")
public class Moneypigeonhole implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "工资归档编号")
    @TableId( "MONEYPIGEONHOLE_ID")
    private Integer moneypigeonholeId  ;
    @ApiModelProperty(value = "计薪人数")
    @TableField("MONEYPIGEONHOLE_ASKPERSON")
    private Long moneypigeonholeAskperson ;

    @ApiModelProperty(value = "应发工资")
    @TableField("MONEYPIGEONHOLE_SALARY")
    private Long moneypigeonholeSalary;

    @ApiModelProperty(value = "实发工资")
    @TableField("MONEYPIGEONHOLE_PAYROLLSALARY")
    private Long moneypigeonholePayrollsalary;

    @ApiModelProperty(value = "公司缴纳")
    @TableField("MONEYPIGEONHOLE_FIRMPAYMENT")
    private Long moneypigeonholeFirmpayment;

    @ApiModelProperty(value = "员工成本")
    @TableField("MONEYPIGEONHOLE_STAFFCOST")
    private Long moneypigeonholeStaffcost;

    @ApiModelProperty(value = "工资合计")
    @TableField("TOTALWAGE")
    private Long totalwage;

    @JsonFormat(pattern = "yyyy-MM", timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间")
    @TableField(value = "CREATED_TIME" , fill = FieldFill.INSERT)
    private Date createdTime;

    @JsonFormat(pattern="yyyy-MM")
    @ApiModelProperty(value = "修改时间")
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
    @TableField(exist = false)
    private int currentPage;
    @TableField(exist = false)
    private int pageSize;
}
