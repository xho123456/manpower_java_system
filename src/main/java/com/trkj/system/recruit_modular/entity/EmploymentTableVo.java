package com.trkj.system.recruit_modular.entity;

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

/**
 * <p>
 * 录用表
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("EMPLOYMENT_TABLE")
@ApiModel(value="EmploymentTable对象", description="录用表")
public class EmploymentTableVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId("EMPLOYMENT_ID")
    private Long employmentId;

    @ApiModelProperty(value = "简历编号")
    @TableField("RESUME_ID")
    private Long resumeId;

    @ApiModelProperty(value = "入职时间")
    @TableField("HIREDATE")
    private Date hiredate;

    @ApiModelProperty(value = "试用期")
    @TableField("PROBATION")
    private String probation;

    @ApiModelProperty(value = "试用期月薪")
    @TableField("PROBATIONARY")
    private Long probationary;

    @ApiModelProperty(value = "转正月薪")
    @TableField("POSITIVE_MONTHLY")
    private Long positiveMonthly;

    @ApiModelProperty(value = "薪酬备注")
    @TableField("POSITIVE_REMARKS")
    private String positiveRemarks;

    @ApiModelProperty(value = "放弃原因")
    @TableField("WAIVE_REASON")
    private String waiveReason;

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
    private Long isDeleted;



    @ApiModelProperty(value = "部门职位名称")
    @TableField("POST_NAME")
    private String postName;

    @ApiModelProperty(value = "部门名称")
    @TableField("DEPT_NAME")
    private String deptName;

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
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date toujTime;

    @ApiModelProperty(value = "简历备注")
    private String remarks;

    @ApiModelProperty(value = "员工名称")
    private String staffName;

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
