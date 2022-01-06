package com.trkj.system.system_management.entity;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeDeptVo {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "公告部门编号")
    private Long noticeDeptId;

    @ApiModelProperty(value = "部门编号")
    private Long deptId;

    @ApiModelProperty(value = "公告编号")
    private Long noticeId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间 精确到秒")
    private Date createdTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "修改时间 精确到秒")
    private Date updatedTime;

    @Version
    @ApiModelProperty(value = "乐观锁")
    private Long revision;

    @TableLogic
    @ApiModelProperty(value = "逻辑删除 0:未删 1:已删 ")
    private Long isDeleted;

    @ApiModelProperty(value = "状态;0：启用  1：禁用")
    private Long deptState;

    @ApiModelProperty(value = "部门名称")
    private String deptName;

}
