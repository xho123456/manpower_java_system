package com.trkj.system.recruit_modular.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
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
 * 招聘计划表
 * </p>
 *
 * @author 鄧琪
 * @since 2021-12-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("RECRUITMENT_PLAN")
@ApiModel(value="RecruitmentPlan对象", description="招聘计划表")
public class RecruitmentPlan implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId("RECRUITMENT_PLAN_ID")
    private Long recruitmentPlanId;

    @TableField("RECRUITMENT_PLAN_NAME")
    private String recruitmentPlanName;

    @ApiModelProperty(value = "部门编号")
    @TableField("DEPT_ID")
    private Long deptId;

    @ApiModelProperty(value = "部门职位编号")
    @TableField("DEPT_POST_ID")
    private Long deptPostId;

    @ApiModelProperty(value = "最低学历")
    @TableField("EDUCATION_NAME")
    private String educationName;

    @ApiModelProperty(value = "需招聘人数")
    @TableField("RECRUITMENT_PLAN_NUMBER")
    private Long recruitmentPlanNumber;

    @ApiModelProperty(value = "开始时间")
    @TableField("RECRUITMENT_PLAN_START_TIME")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date recruitmentPlanStartTime;

    @ApiModelProperty(value = "结束时间")
    @TableField("RECRUITMENT_PLAN_END_TIME")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date recruitmentPlanEndTime;

    @ApiModelProperty(value = "月薪范围")
    @TableField("RECRUITMENT_PLAN_SALARY")
    private String recruitmentPlanSalary;

    @ApiModelProperty(value = "招聘计划状态: 0 招聘中，1 已结束")
    @TableField("RECRUITMENT_ZT")
    private Long recruitmentZt;

    @ApiModelProperty(value = "负责人编号（员工表/员工编号)")
    @TableField("STAFF_ID")
    private Long staffId;

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
