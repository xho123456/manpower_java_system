package com.trkj.system.recruit_modular.entity;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 面试表
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@KeySequence(value = "INTERVIEW_ID", clazz = Integer.class)
public class Interview implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId("INTERVIEW_ID")
    private Integer interviewId;

    @ApiModelProperty(value = "简历表外键")
    @TableField("RESUME_ID")
    private Long resumeId;

    @ApiModelProperty(value = "面试日期")
    @TableField("INTERVIEW_TIME")
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date interviewTime;

    @ApiModelProperty(value = "负责人编号（员工表/员工编号)")
    @TableField("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATED_TIME")
    private Date createdTime;

    @ApiModelProperty(value = "最后修改时间")
    @TableField("UPDATED_TIME")
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @ApiModelProperty(value = "逻辑删除;1表示删除，0 表示未删除")
    @TableField("IS_DELETED")
    private Long isDeleted;

}
