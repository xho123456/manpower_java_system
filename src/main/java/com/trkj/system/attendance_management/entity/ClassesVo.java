package com.trkj.system.attendance_management.entity;

import com.baomidou.mybatisplus.annotation.*;
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
 * 班次方案表
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("CLASSES")
@ApiModel(value="Classes对象", description="班次方案表")
@KeySequence(value = "CLASSES_ID", clazz = Integer.class)
public class ClassesVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "班次编号")
    @TableId("CLASSES_ID")
    private Integer classesId;

    @ApiModelProperty(value = "班次名称")
    @TableField("CLASSES_NAME")
    private String classesName;

    @ApiModelProperty(value = "班次时段")
    @TableField("CLASSES_SD")
    private String classesSd;

    @ApiModelProperty(value = "工作时间范围一(上班) ")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("CLASSES_TIMEONES")
    private Date classesTimeones;

    @ApiModelProperty(value = "工作时间范围一(下班) ")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("CLASSES_TIMEONEX")
    private Date classesTimeonex;


    @ApiModelProperty(value = "工作时间范围二(上班) ")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("CLASSES_TIMETWOS")
    private Date classesTimetwos;

    @ApiModelProperty(value = "工作时间范围二(下班) ")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("CLASSES_TIMETWOX")
    private Date classesTimetwox;

    @ApiModelProperty(value = "班次状态（0：启用，1：禁用）")
    @TableField("CLASSESSTATE")
    private Long classesstate;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @ApiModelProperty(value = "逻辑删除")
    @TableField("IS_DELETED")
    @TableLogic
    private Long isDeleted;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATED_TIME")
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("UPDATED_TIME")
    private Date updatedTime;

    @ApiModelProperty(value = "休息开始时段")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("CLASSES_XXTIME_STATE")
    private Date classesXxtimeState;

    @ApiModelProperty(value = "休息结束时段")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("CLASSES_XXTIME_END")
    private Date classesXxtimeEnd;

    @TableField("DK_STATE")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dkState;

    @TableField("DK_END")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dkEnd;


    //分页
    @TableField(exist = false)
    private int currenPage;
    @TableField(exist = false)
    private int pagesize;


}
