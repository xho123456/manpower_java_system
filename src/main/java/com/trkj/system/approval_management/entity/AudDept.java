package com.trkj.system.approval_management.entity;


import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("DEPT")
@KeySequence(value = "DEPT_ID",clazz = Integer.class)
public class AudDept {

    @TableId("DEPT_ID")
    private Integer deptId;

    private String deptName;

}
