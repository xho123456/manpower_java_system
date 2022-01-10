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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 受教育经历表
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("EDUCATIONSS")
@ApiModel(value="Educationss对象", description="受教育经历表")
public class Educationss implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId("EDUCATIONSS_ID")
    private Long educationssId;

    @ApiModelProperty(value = "开始时间")
    @TableField("EDUCATION_START_TIME")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date educationStartTime;

    @ApiModelProperty(value = "结束时间")
    @TableField("EDUCATION_END_TIME")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date educationEndTime;

    @ApiModelProperty(value = "简历编号外键")
    @TableField("RESUME_ID")
    private Long resumeId;

    @ApiModelProperty(value = "学校名称")
    @TableField("EDUCATION_STUDENTNAME")
    private String educationStudentname;

    @ApiModelProperty(value = "所属专业")
    @TableField("EDUCATION_MAJOR")
    private String educationMajor;

    @ApiModelProperty(value = "是否全日制")
    @TableField("EDUCATION_FULL_TIME")
    private Long educationFullTime;

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
