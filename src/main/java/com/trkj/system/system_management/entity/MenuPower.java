package com.trkj.system.system_management.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 菜单权限表
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("MENU_POWER")
@ApiModel(value="MenuPower对象", description="菜单权限表")
public class MenuPower implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "菜单权限编号")
    @TableId("MENU_POWER_ID")
    private Long menuPowerId;

    @ApiModelProperty(value = "父级菜单权限编号")
    @TableField("MENU_POWER_PID")
    private Long menuPowerPid;

    @ApiModelProperty(value = "是否有叶子 0:有 1:没有")
    @TableField("MENU_POWER_LEAF")
    private Long menuPowerLeaf;

    @ApiModelProperty(value = "菜单权限类型 0:菜单 1:按钮")
    @TableField("MENU_POWER_TYPE")
    private Long menuPowerType;

    @ApiModelProperty(value = "是否启用 0启用 1禁用")
    @TableField("MENU_STATE")
    private Long menuState;

    @ApiModelProperty(value = "图片地址")
    @TableField("PICTURE_ADDRESS")
    private String pictureAddress;

    @ApiModelProperty(value = "菜单权限名称")
    @TableField("MENU_POWER_NAME")
    private String menuPowerName;

    @ApiModelProperty(value = "路由地址")
    @TableField("MENU_POWER_ROUTE")
    private String menuPowerRoute;

    @ApiModelProperty(value = "组件地址")
    @TableField("MENU_POWER_MODULE")
    private String menuPowerModule;

    @ApiModelProperty(value = "创建时间 精确到秒")
    @TableField("CREATED_TIME")
    private Date createdTime;

    @ApiModelProperty(value = "修改时间 精确到秒")
    @TableField("UPDATED_TIME")
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @ApiModelProperty(value = "逻辑删除 0:未删 1:已删 ")
    @TableField("IS_DELETED")
    private Long isDeleted;

    @TableField(exist = false)
    private List<MenuPower> menuPower;

}
