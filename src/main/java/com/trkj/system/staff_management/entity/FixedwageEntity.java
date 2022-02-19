package com.trkj.system.staff_management.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)  /** 链式写法 */
public class FixedwageEntity {
    private static final long serialVersionUID = 1L;

    private Long FixedwageId;
    /** 固定工资编号 */

    private Long FIXEDWAGEPERIODMONEY;
    /** 试用期基本工资 */

    private Long staffid;
    /** 员工编号 */

    private Long FIXEDWAGEOFFICIALMONEY;
    /** 正式期基本工资 */

    private Long FIXEDWAGEPERIODPOSTMONEY;
    /** 试用期岗位工资 */

    private Long FIXEDWAGEOFFLCIALPOSTMONEY;
    /** 正式期岗位工资 */

    private String FIXEDWAGEREMARK;
    /** 备注 */

    private Date CREATEDTIME;
    /** 创建时间 */

    private Date UPDATEDTIME;
    /** 修改时间 */

    @TableLogic
    @ApiModelProperty(value = "逻辑删除 0:未删 1:已删 ")
    @TableField("IS_DELETED")
    private Long ISDELETED;
    /** 逻辑删除 */

    @Version
    @TableField("REVISION")
    private Long REVISION;
    /** 乐观锁 */
}
