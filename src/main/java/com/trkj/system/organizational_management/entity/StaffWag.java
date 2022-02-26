package com.trkj.system.organizational_management.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("STAFFWAG")
@KeySequence(value = "STAFFWAG_ID" ,clazz = Integer.class)
@ApiModel(value="STAFFWAG对象", description="员工工资表")
public class StaffWag implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "员工工资编号")
    @TableId(value = "STAFFWAG_ID",type = IdType.INPUT)
    private Integer staffwagID;

    @ApiModelProperty(value = "员工编号")
    @TableField("STAFF_ID")
    private Integer staffId;


    @ApiModelProperty(value = "创建时间")
    @TableField(value = "CREATED_TIME",fill = FieldFill.INSERT)
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "UPDATED_TIME",fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @Version
    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @TableLogic
    @ApiModelProperty(value = "逻辑删除;0：未删除，1：已删除")
    @TableField("IS_DELETED")
    private Long isDeleted;



}
