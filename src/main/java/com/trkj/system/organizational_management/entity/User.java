package com.trkj.system.organizational_management.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor//生成全参构造函数
@NoArgsConstructor//生成无参构造函数
@KeySequence(value = "USERS_ID" ,clazz = Integer.class)
@TableName(value = "userss")
public class User {
    @TableId(value = "id")
    private Integer id;
    private String name;
    private String pass;
    private Long phone;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date birthday;
    private String loc;
    //乐观锁version注解
    @Version
    private Integer version;

    /*逻辑删除*/
    @TableLogic
    @TableField(value = "DELETED")
    private Integer deleted;
    /**
     *字段添加填充内容
     */
    @TableField(value = "createtime" ,fill = FieldFill.INSERT)
    private Date createtime;
    @TableField(value = "updatetime",fill = FieldFill.INSERT_UPDATE)
    private Date updatetime;
}
