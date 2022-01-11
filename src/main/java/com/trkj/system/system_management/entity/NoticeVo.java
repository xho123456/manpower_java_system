package com.trkj.system.system_management.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@KeySequence(value = "NOTICE_ID", clazz = Integer.class)
public class NoticeVo {
    private static final long serialVersionUID = 1L;

   @TableId
    @ApiModelProperty(value = "公告编号")
    private Long noticeId;

   @TableId
    @ApiModelProperty(value = "公告部门编号")
    private Long noticeDeptId;

   @TableId
    @ApiModelProperty(value = "部门编号")
    private Long deptId;

    @ApiModelProperty(value = "员工编号")
    private Long staffId;

    @TableField(exist = false)
    @ApiModelProperty(value = "公告类型 0:要事性 1:政策性 2:任免性")
    private Long noticeType;

    @ApiModelProperty(value = "公告标题")
    private String noticeTitle;

    @ApiModelProperty(value = "公告状态 0:启用 1:禁用")
    private Long noticeState;

    @ApiModelProperty(value = "发布人")
    private String noticePeople;

    @ApiModelProperty(value = "职位")
    private String noticePost;

    @ApiModelProperty(value = "发布内容")
    private String noticeMatter;

    private int currentPage;
    private int pagesize;



    @ApiModelProperty(value = "状态;0：启用  1：禁用")
    private Long deptState;


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
