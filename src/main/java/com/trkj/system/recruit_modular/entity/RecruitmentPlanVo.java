package com.trkj.system.recruit_modular.entity;

import java.util.Date;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * <p>
 * 招聘计划表
 * </p>
 *
 * @author 鄧琪
 * @since 2021-12-28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecruitmentPlanVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    private Long recruitmentPlanId;

    @ApiModelProperty(value = "部门名称")
    private String deptName;

    @ApiModelProperty(value = "部门职位名称")
    @TableField("POST_NAME")
    private String postName;

    @ApiModelProperty(value = "学历名称")
    private String educationName;

    @ApiModelProperty(value = "需招聘人数")
    private Long recruitmentPlanNumber;

    @ApiModelProperty(value = "开始时间")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date recruitmentPlanStartTime;

    @ApiModelProperty(value = "结束时间")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date recruitmentPlanEndTime;

    @ApiModelProperty(value = "月薪范围")
    private String recruitmentPlanSalary;

    @ApiModelProperty(value = "月薪结束金额")
    private Long monthlySalaryEnd;

    @ApiModelProperty(value = "负责人编号（员工表/员工编号)")
    private String staffName;

    @ApiModelProperty(value = "招聘计划状态: 0 招聘中，1 已结束")
    private Long recruitmentZt;

    @ApiModelProperty(value = "创建时间")
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    private Long revision;

    @ApiModelProperty(value = "逻辑删除;1表示删除，0 表示未删除")
    @TableLogic
    private Long isDeleted;

    @ApiModelProperty(value = "招聘计划名称")
    private String recruitmentPlanName;
    @TableField(exist = false)
    private int currenPage;
    @TableField(exist = false)
    private int pagesize;
}
