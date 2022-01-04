package com.trkj.system.recruit_modular.entity;

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

/**
 * <p>
 * 简历表
 * </p>
 *
 * @author 鄧琪
 * @since 2021-12-31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeVo implements Serializable {

    @ApiModelProperty(value = "编号")
    private Long resumeId;

    @ApiModelProperty(value = "部门职位名称")
    @TableField("POST_NAME")
    private String postName;

    @ApiModelProperty(value = "名字")
    private String resumeName;

    @ApiModelProperty(value = "性别")
    private String resumeSex;

    @ApiModelProperty(value = "手机号码")
    private Long resumePhone;

    @ApiModelProperty(value = "学历名称")
    private String resumeEducation;

    @ApiModelProperty(value = "毕业学校")
    private String resumeScoller;

    @ApiModelProperty(value = "婚姻状况：已婚、未婚、离婚")
    private String resumeHy;

    @ApiModelProperty(value = "年龄")
    private Long resumeAge;

    @ApiModelProperty(value = "期望薪资")
    private String resumeQxingz;

    @ApiModelProperty(value = "期望职位")
    private String resumeQzhiw;

    @ApiModelProperty(value = "身高")
    private String resumeShengg;

    @ApiModelProperty(value = "最近职位")
    private String resumeZjzw;

    @ApiModelProperty(value = "邮箱")
    private String resumeMailbox;

    @ApiModelProperty(value = "照片")
    private String resumePhoto;

    @ApiModelProperty(value = "自我评价")
    private String resumeIntroduce;

    @ApiModelProperty(value = "出生日期")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date resumeBirthday;

    @ApiModelProperty(value = "户口所在地")
    private String resumeResidence;

    @ApiModelProperty(value = "招聘计划表编号")
    private Long recruitmentPlanId;

    @ApiModelProperty(value = "政治面貌")
    private String resumePoliticalOutlook;

    @ApiModelProperty(value = "0:待阅 1:以阅 2、候选人 3：已邀约  4:淘汰 5:待面试 " +
            " 6:通过 7：复试 8:待接受 9:已接受 10：已入职 11:已拒绝 12：放弃入职 13：已离职")
    private String resumeZt;

    @ApiModelProperty(value = "投简时间")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date toujTime;

    @ApiModelProperty(value = "创建时间")
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    private Long revision;

    @ApiModelProperty(value = "逻辑删除;1表示删除，0 表示未删除")
    private Long isDeleted;

    @ApiModelProperty(value = "招聘计划名称")
    private String recruitmentPlanName;

    //分页
    @TableField(exist = false)
    private int currenPage;
    @TableField(exist = false)
    private int pagesize;

    //开始时间
    @TableField(exist = false)
    private Date startTime;
    //结束
    @TableField(exist = false)
    private Date endTime;
}
