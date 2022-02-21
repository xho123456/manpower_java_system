package com.trkj.system.workbench.entity;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 考勤表
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("ATTENDANCE_SHEET")
@ApiModel(value="AttendanceSheet对象", description="考勤表")
@KeySequence(value = "ATTENDANCE_SHEET_ID", clazz = Integer.class)
public class AdattendanceSheet implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "考勤编号")
    @TableId("ATTENDANCE_SHEET_ID")
    private Integer attendanceSheetId;

    @ApiModelProperty(value = "员工编号")
    @TableField("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "关联打卡记录表(外)")
    @TableField("CLOCK_RECORD_ID")
    private Long clockRecordId;

    @ApiModelProperty(value = "关联班次方案表(外)")
    @TableField("CLASSES_ID")
    private Long classesId;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATED_TIME")
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("UPDATED_TIME")
    private Date updatedTime;

    @ApiModelProperty(value = "逻辑删除")
    @TableField("IS_DELETED")
    private Long isDeleted;


}
