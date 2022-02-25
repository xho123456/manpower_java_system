package com.trkj.system.attendance_management.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("DEPT")
@ApiModel(value="Dept对象", description="部门表")
public class Deptattent implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "部门编号")
    @TableId("DEPT_ID")
    private Long deptId;

    @ApiModelProperty(value = "父级菜单")
    @TableId("MENU_PID")
    private Long menuPid;

    @ApiModelProperty(value = "是否有叶子 0:有 1:没有")
    @TableId("MENU_LEAF")
    private Long menuLeaf;

    @TableField(exist = false)
    private List<Deptattent> deptlist;

    @ApiModelProperty(value = "状态;0：启用  1：禁用")
    @TableField("DEPT_STATE")
    private Long deptState;

    @ApiModelProperty(value = "部门名称")
    @TableField("DEPT_NAME")
    private String deptName;

    @ApiModelProperty(value = "部门负责人;提供ID到员工表锁定具体的人")
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

    @ApiModelProperty(value = "逻辑删除;0：未删除，1：已删除")
    @TableField("IS_DELETED")
    private Long isDeleted;


}
