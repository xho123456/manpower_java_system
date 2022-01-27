package com.trkj.system.system_management.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@KeySequence(value = "NOTICE_DEPT_ID", clazz = Integer.class)
public class RegisterLogVO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "登录日志编号")
    @TableId("REGISTER_LOG_ID")
    private Long registerLogId;

    @ApiModelProperty(value = "员工编号")
    @TableField("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "员工姓名")
    @TableField("STAFF_NAME")
    private String staffName;

    @ApiModelProperty(value = "手机号码")
    @TableField("REGISTER_LOG_PHONE")
    private Long registerLogPhone;

    @ApiModelProperty(value = "IP地址")
    @TableField("REGISTER_LOG_IP")
    private String registerLogIp;

    @ApiModelProperty(value = "设备类型")
    @TableField("REGISTER_LOG_TYPE")
    private String registerLogType;

    @ApiModelProperty(value = "登录状态 0:成功 1:失败")
    @TableField("REGISTER_LOG_STATE")
    private Long registerLogState;

    @ApiModelProperty(value = "浏览器")
    @TableField("REGISTER_LOG_BROWSER")
    private String registerLogBrowser;

    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    @ApiModelProperty(value = "创建时间 精确到秒")
    @TableField(value = "CREATED_TIME" , fill = FieldFill.INSERT)
    private Date createdTime;

    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    @ApiModelProperty(value = "修改时间 精确到秒")
    @TableField(value = "UPDATED_TIME",fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;;

    @Version
    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @TableLogic
    @ApiModelProperty(value = "逻辑删除 0:未删 1:已删 ")
    @TableField("IS_DELETED")
    private Long isDeleted;

    //分页
    @TableField(exist = false)
    private int currentPage;
    @TableField(exist = false)
    private int pagesize;

    //开始时间
    @TableField(exist = false)
    private Date startTime;
    //结束
    @TableField(exist = false)
    private Date endTime;


}
