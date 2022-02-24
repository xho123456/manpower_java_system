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
@KeySequence(value = "WORKSCHEME_ID" ,clazz = Integer.class)
@Accessors(chain = true)
@TableName(value = "workscheme")
public class Workschemee implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "加班方案编号")
    @TableId( "WORKSCHEME_ID")
    private Integer workschemeId;


    @ApiModelProperty(value = "加班方案名称")
    @TableField("WORKSCHEME_NAME")
    private String workschemeName;

    @ApiModelProperty(value = "节假日加班工资")
    @TableField("WORKSCHEME_HOLIDAYRATIO")
    private Long workschemeHolidayratio;

    @ApiModelProperty(value = "休息日加班工资")
    @TableField("WORKSCHEME_DAYOFFRATIO")
    private Long workschemeDayoffratio;

    @ApiModelProperty(value = "工作日加班工资")
    @TableField("WORKSCHEME_WORKRATIO")
    private Long workschemeWorkratio;

    @ApiModelProperty(value = "备注")
    @TableField("WORKSCHEME_REMARK")
    private String workschemeRemark;

    @ApiModelProperty(value = "状态")
    @TableField("WORKSCHEME_STATE")
    private Long workschemeState;

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
