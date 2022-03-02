package com.trkj.system.attendance_management.entity;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 创建补打卡表
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("CARD")
@ApiModel(value="Card对象", description="补打卡表")
@KeySequence(value = "CARD_ID", clazz = Integer.class)
public class Card implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "补打卡编号")
    @TableId("CARD_ID")
    private Integer cardId;

    @ApiModelProperty(value = "审批编号")
    @TableField("AUDITFLOW_ID")
    private String auditflowId;

    @ApiModelProperty(value = "员工编号")
    @TableField("STAFF_ID")
    private String staffId;

    @ApiModelProperty(value = "员工名称")
    @TableField("STAFF_NAME")
    private String staffName;

    @ApiModelProperty(value = "补打卡类型")
    @TableField("CARD_TYPE")
    private String cardType;

    @ApiModelProperty(value = "补打卡时间 ")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("CARD_DATE")
    private Date cardDate;

    @ApiModelProperty(value = "备注")
    @TableField("CARD_REMARKS")
    private Date cardRemarks;

    @ApiModelProperty(value = "状态 0:不同意 1:同意")
    @TableField("CARD_STATE")
    private Long cardState;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @ApiModelProperty(value = "逻辑删除")
    @TableField("IS_DELETED")
    private Long isDeleted;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATED_TIME")
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("UPDATED_TIME")
    private Date updatedTime;


    //分页
    @TableField(exist = false)
    private int currenPage;
    @TableField(exist = false)
    private int pagesize;

    @TableField(exist = false)
    private String dates;


}
