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
 * @author 鄧琪
 * @since 2022-03-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("INSURED_SCHEME")
@ApiModel(value="InsuredScheme对象", description="参保方案表")
@KeySequence(value = "INSURED_SCHEME_ID", clazz = Integer.class)
public class InsuredScheme implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "参保方案编号")
    @TableId("INSURED_SCHEME_ID")
    private Integer insuredSchemeId;

    @ApiModelProperty(value = "员工编号")
    @TableField("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "默认参保方案编号")
    @TableField("DEF_INSURED_ID")
    private Long defInsuredId;

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
