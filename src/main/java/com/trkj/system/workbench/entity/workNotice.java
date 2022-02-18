package com.trkj.system.workbench.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 公告表
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class workNotice implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "公告编号")
    @TableId("NOTICE_ID")
    private Long noticeId;

    @ApiModelProperty(value = "员工编号")
    @TableField("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "公告类型 0:要事性 1:政策性 2:任免性")
    @TableField("NOTICE_TYPE")
    private Long noticeType;

    @ApiModelProperty(value = "公告标题")
    @TableField("NOTICE_TITLE")
    private String noticeTitle;

    @ApiModelProperty(value = "公告状态 0:启用 1:禁用")
    @TableField("NOTICE_STATE")
    private Long noticeState;

    @ApiModelProperty(value = "发布人")
    @TableField("NOTICE_PEOPLE")
    private String noticePeople;

    @ApiModelProperty(value = "职位")
    @TableField("NOTICE_POST")
    private String noticePost;

    @ApiModelProperty(value = "发布内容")
    @TableField("NOTICE_MATTER")
    private String noticeMatter;

    @ApiModelProperty(value = "创建时间 精确到秒")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("CREATED_TIME")
    private Date createdTime;

    @ApiModelProperty(value = "修改时间 精确到秒")
    @TableField("UPDATED_TIME")
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @ApiModelProperty(value = "逻辑删除 0:未删 1:已删 ")
    @TableField("IS_DELETED")
    private Long isDeleted;



    @ApiModelProperty(value = "公告员工编号")
    @TableId("NOTICE_STAFF_ID")
    private Long noticeStaffId;

    @ApiModelProperty(value = "员工编号")
    @TableField("STAFF_ID")
    private Long staffId1;

    @ApiModelProperty(value = "公告编号")
    @TableField("NOTICE_ID")
    private Long noticeId1;

    @ApiModelProperty(value = "公告状态")
    @TableField("NOTICE_STATE")
    private Long noticeState1;


    //分页
    @TableField(exist = false)
    private int currenPage;
    @TableField(exist = false)
    private int pagesize;

}
