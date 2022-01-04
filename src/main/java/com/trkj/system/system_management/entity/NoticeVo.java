package com.trkj.system.system_management.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeVo {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "公告编号")
    private Long noticeId;

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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间 精确到秒")
    private Date createdTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "修改时间 精确到秒")
    private Date updatedTime;

    private int currentPage;
    private int pagesize;

    @Version
    @ApiModelProperty(value = "乐观锁")
    private Long revision;

    @TableLogic
    @ApiModelProperty(value = "逻辑删除 0:未删 1:已删 ")
    private Long isDeleted;


}
