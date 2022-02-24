package com.trkj.system.insurance_management.entity;

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
 * <p>
 * 参保方案表
 * </p>
 *
 * @author 谢海欧
 * @since 2022-02-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("INSURED_PAYMENT")
@ApiModel(value="InsuredPayment对象", description="参保缴纳表")
@KeySequence(value = "INSURED_PAYMENT_ID", clazz = Integer.class)
public class InsuredPayment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "参保缴纳编号")
    @TableId("INSURED_PAYMENT_ID")
    private Long insuredPaymentId;

    @ApiModelProperty(value = "员工编号")
    @TableField("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "参保方案编号")
    @TableField("INSURED_SCHEME_ID")
    private Long insuredSchemeId;

    @ApiModelProperty(value = "参保明细编号")
    @TableField("INS_DETAIL_ID")
    private Long insDetailId;

    @ApiModelProperty(value = "缴纳基数")
    @TableField("INSURED_PAYMENT_NUMBER")
    private Long insuredPaymentNumber;

    @ApiModelProperty(value = "参保月份 精确到年月")
    @TableField("INSURED_PAYMENT_INSURED_MONTH")
    private Date insuredPaymentInsuredMonth;

    @ApiModelProperty(value = "计薪月份 精确到年月")
    @TableField("INSURED_PAYMENT_SALARY_MONTH")
    private Date insuredPaymentSalaryMonth;


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
