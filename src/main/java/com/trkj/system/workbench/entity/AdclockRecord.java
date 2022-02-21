package com.trkj.system.workbench.entity;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 打卡记录表
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("CLOCK_RECORD")
@ApiModel(value="ClockRecord对象", description="打卡记录表")
@KeySequence(value = "CLOCK_RECORD_ID", clazz = Integer.class)
public class AdclockRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "打卡记录编号")
    @TableId("CLOCK_RECORD_ID")
    private Integer clockRecordId;

    @ApiModelProperty(value = "员工编号")
    @TableField("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "默认当天：精确到天")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("DAY_DATE")
    private Date dayDate;

    @ApiModelProperty(value = "上班打卡时间 只存在时分秒")
    @TableField("SMORN_CLOCK")
    @JsonFormat(pattern = "HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date smornClock;

    @ApiModelProperty(value = "上班考勤结果")
    @TableField("SMORN_RESULT")
    private String smornResult;

    @ApiModelProperty(value = "下班打卡时间 只存在时分秒")
    @TableField("XAFTERNOON_CLOCK")
    @JsonFormat(pattern = "HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date xafternoonClock;

    @ApiModelProperty(value = "下班考勤结果")
    @TableField("XAFTERNOON_RESULT")
    private String xafternoonResult;

    @TableField("ATS_SHOULD")
    private Long atsShould;

    @TableField("AT_SHOULD")
    private Long atShould;

    @TableField("CHE_LATE")
    private Long cheLate;

    @TableField("CHES_LATE")
    private Double chesLate;

    @TableField("ZHAI_LATE")
    private Long zhaiLate;

    @TableField("ZHAIS_LATE")
    private Double zhaisLate;

    @TableField("KANG_LATE")
    private Long kangLate;

    @TableField("KANGS_LATE")
    private Double kangsLate;

    @TableField("WORK_YING")
    private Double workYing;

    @TableField("WORKS_YING")
    private Double worksYing;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATED_TIME")
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("UPDATED_TIME")
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @ApiModelProperty(value = "逻辑删除")
    @TableField("IS_DELETED")
    private Long isDeleted;


}
