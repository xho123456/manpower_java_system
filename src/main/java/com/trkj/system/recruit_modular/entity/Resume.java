package com.trkj.system.recruit_modular.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 简历表
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("RESUME")
@ApiModel(value="Resume对象", description="简历表")
@KeySequence(value = "RESUME_ID", clazz = Integer.class)
public class Resume implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId("RESUME_ID")
    private Integer resumeId;

    @ApiModelProperty(value = "名字")
    @TableField("RESUME_NAME")
    private String resumeName;

    @ApiModelProperty(value = "性别")
    @TableField("RESUME_SEX")
    private String resumeSex;

    @ApiModelProperty(value = "手机号码")
    @TableField("RESUME_PHONE")
    private Long resumePhone;

    @ApiModelProperty(value = "学历名称")
    @TableField("RESUME_EDUCATION")
    private String resumeEducation;

    @ApiModelProperty(value = "毕业学校")
    @TableField("RESUME_SCOLLER")
    private String resumeScoller;

    @ApiModelProperty(value = "婚姻状况：已婚、未婚、离婚")
    @TableField("RESUME_HY")
    private String resumeHy;

    @ApiModelProperty(value = "年龄")
    @TableField("RESUME_AGE")
    private Long resumeAge;

    @ApiModelProperty(value = "期望薪资")
    @TableField("RESUME_QXINGZ")
    private String resumeQxingz;

    @ApiModelProperty(value = "期望职位")
    @TableField("RESUME_QZHIW")
    private String resumeQzhiw;

    @ApiModelProperty(value = "身高")
    @TableField("RESUME_SHENGG")
    private String resumeShengg;

    @ApiModelProperty(value = "最近职位")
    @TableField("RESUME_ZJZW")
    private String resumeZjzw;

    @ApiModelProperty(value = "邮箱")
    @TableField("RESUME_MAILBOX")
    private String resumeMailbox;

    @ApiModelProperty(value = "照片")
    @TableField("RESUME_PHOTO")
    private String resumePhoto;

    @ApiModelProperty(value = "自我评价")
    @TableField("RESUME_INTRODUCE")
    private String resumeIntroduce;

    @ApiModelProperty(value = "出生日期")
    @TableField("RESUME_BIRTHDAY")
    private Date resumeBirthday;

    @ApiModelProperty(value = "户口所在地")
    @TableField("RESUME_RESIDENCE")
    private String resumeResidence;

    @TableField("RECRUITMENT_PLAN_ID")
    private Long recruitmentPlanId;

    @TableField("RESUME_POLITICAL_OUTLOOK")
    private String resumePoliticalOutlook;

    @ApiModelProperty(value = "状态 0:待阅 1:以阅 2、候选人 3：已邀约  4:淘汰 5:待面试  6:通过 7：复试 8:待接受 9:已接受 10：已入职 11:已拒绝 12：放弃入职 13：已离职")
    @TableField("RESUME_ZT")
    private String resumeZt;

    @ApiModelProperty(value = "投简时间")
    @TableField("TOUJ_TIME")
    private Date toujTime;

    @ApiModelProperty(value = "简历备注")
    @TableField("remarks")
    private String remarks;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATED_TIME")
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("UPDATED_TIME")
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @ApiModelProperty(value = "逻辑删除;1表示删除，0 表示未删除")
    @TableField("IS_DELETED")
    @TableLogic
    private Long isDeleted;


}
