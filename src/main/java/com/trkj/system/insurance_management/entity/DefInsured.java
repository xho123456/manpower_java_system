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
 * 默认参保方案表
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("DEF_INSURED")
@ApiModel(value="DefInsured对象", description="默认参保方案表")
public class DefInsured implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "默认参保方案编号")
    @TableId("DEF_INSURED_ID")
    private Long defInsuredId;

    @ApiModelProperty(value = "默认参保方案名称")
    @TableField("DEF_INSURED_NAME")
    private String defInsuredName;

    @ApiModelProperty(value = "默认参保方案状态 0:启用 1:禁用")
    @TableField("DEF_INSURED_STATE")
    private Long defInsuredState;

    @ApiModelProperty(value = "默认参保方案数量")
    @TableField("DEF_INSURED_NUMBER")
    private Long defInsuredNumber;

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
    private int pagesize;


}
