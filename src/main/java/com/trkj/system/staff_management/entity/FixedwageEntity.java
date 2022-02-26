package com.trkj.system.staff_management.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("FIXEDWAGE")
@Accessors(chain = true)  /** 链式写法 */
@KeySequence(value = "FIXEDWAGE_ID",clazz = Integer.class)
public class FixedwageEntity {
    private static final long serialVersionUID = 1L;

    @TableId("FIXEDWAGE_ID")
    private Integer fixedwageId;
    /** 固定工资编号 */

    private Long fixedwagePeriodmoney;
    /** 试用期基本工资 */

    private Integer staffId;
    /** 员工编号 */

    private Long fixedwageOfficialmoney;
    /** 正式期基本工资 */

    private Long fixedwagePeriodpostmoney;
    /** 试用期岗位工资 */

    private Long fixedwageOfflcialpostmoney;
    /** 正式期岗位工资 */

    private String fixedwageRemark;
    /** 备注 */

    private Date createdTime;
    /** 创建时间 */

    private Date updatedTime;
    /** 修改时间 */

    @TableLogic
    @ApiModelProperty(value = "逻辑删除 0:未删 1:已删 ")
    @TableField("IS_DELETED")
    private Long isDeleted;
    /** 逻辑删除 */

    @Version
    @TableField("REVISION")
    private Long revision;
    /** 乐观锁 */
}
