package com.trkj.system.attendance_management.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 出差表
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Travels {

    @ApiModelProperty(value = "出差编号")
    @TableId("TRAVEL_ID")
    private Long travelId;

    @ApiModelProperty(value = "审批编号")
    @TableField("AUDITFLOW_ID")
    private Long auditflowId;

    @ApiModelProperty(value = "员工编号")
    @TableField("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "出差总时长")
    @TableField("TRAVEL_TOTAL_DATE")
    private Long tracelTotalDate;

    @ApiModelProperty(value = "状态 0:不同意 1:同意")
    @TableField("TRAVEL_STATE")
    private Long travelState;

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

    //分页
    @TableField(exist = false)
    private int currenPage;
    @TableField(exist = false)
    private int pagesize;

    //出差天数
    @TableField(exist = false)
    private Long ccday;

    //出差总时长
    @TableField(exist = false)
    private Double cctiams;

}
