package com.trkj.system.workbench.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 公告员工表
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("NOTICE_STAFF")
@ApiModel(value="NoticeStaff对象", description="公告员工表")
public class workNoticeStaff implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "公告员工编号")
    @TableId("NOTICE_STAFF_ID")
    private Long noticeStaffId;

    @ApiModelProperty(value = "员工编号")
    @TableField("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "公告编号")
    @TableField("NOTICE_ID")
    private Long noticeId;

    @ApiModelProperty(value = "公告状态")
    @TableField("NOTICE_STATE")
    private Long noticeState;

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


}
