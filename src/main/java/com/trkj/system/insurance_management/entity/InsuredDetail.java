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
 * 参保明细表
 * </p>
 *
 * @author 谢海欧
 * @since 2022-02-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("INSURED_DETAIL")
@ApiModel(value="InsuredDetail对象", description="参保明细表")
@KeySequence(value = "INS_DETAIL_ID", clazz = Integer.class)
public class InsuredDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "参保明细编号")
    @TableId("INS_DETAIL_ID")
    private Integer insDetailId;

    @ApiModelProperty(value = "员工名称")
    @TableField("INS_DETAIL_STAFF_NAME")
    private String insDetailStaffName;

    @ApiModelProperty(value = "参保方案名称")
    @TableField("INS_DETAIL_INSURED_NAME")
    private String insDetailInsuredName;

    @ApiModelProperty(value = "参保月份 精确到年月")
    @TableField("INS_DETAIL_INSURED_MONTH")
    private Date insDetailInsuredMonth;

    @ApiModelProperty(value = "计薪月份 精确到年月")
    @TableField("INS_DETAIL_SALARY_MONTH")
    private Date insDetailSalaryMonth;

    @ApiModelProperty(value = "社保个人缴费")
    @TableField("INS_DETAIL_SOCIAL_PERSON_PAY")
    private Double insDetailSocialPersonPay;

    @ApiModelProperty(value = "社保公司缴费")
    @TableField("INS_DETAIL_SOCIAL_FIRM_PAY")
    private Double insDetailSocialFirmPay;

    @ApiModelProperty(value = "积金个人缴费")
    @TableField("INS_DETAIL_FUND_PERSON_PAY")
    private Double insDetailFundPersonPay;

    @ApiModelProperty(value = "积金公司缴费")
    @TableField("INS_DETAIL_FUND_FIRM_PAY")
    private Double insDetailFundFirmPay;

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




}
