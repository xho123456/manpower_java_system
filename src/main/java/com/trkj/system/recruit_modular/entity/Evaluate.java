package com.trkj.system.recruit_modular.entity;

import com.baomidou.mybatisplus.annotation.KeySequence;
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
 * 面试评价表
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("EVALUATE")
@ApiModel(value="Evaluate对象", description="面试表")
@KeySequence(value = "EVALUATE_ID", clazz = Integer.class)
public class Evaluate implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "面试评价编号")
    @TableId("EVALUATE_ID")
    private Integer evaluateId;

    @ApiModelProperty(value = "面试表外键")
    @TableField("INTERVIEW_ID")
    private Long interviewId;

    @ApiModelProperty(value = "面试评价时间")
    @TableField("EVALUATE_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date evaluateTime;

    @ApiModelProperty(value = "评价人:当前登录用户的名称")
    @TableField("STAFF_NAME")
    private String staffName;

    @ApiModelProperty(value = "面试评价的内容")
    @TableField("INTERVIEW_EVALUATE")
    private String interviewEvaluate;

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
