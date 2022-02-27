package com.trkj.system.staff_management.entity;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName(value = "RESUME")
@KeySequence(value = "RESUME_ID",clazz = Integer.class)
public class ResumeEntity {

    @TableId("RESUME_ID")
    private Integer resumeId;
    /** 简历编号 */

    private String resumeName;
    /** 员工姓名 */

    private String resumeSex;
    /** 员工性别 */

    private Long resumePhone;
    /** 员工手机号码 */

    private String resumeEducation;
    /** 学历 */

    private String resumemMailbox;
    /** 员工邮箱 */

    private Date resumeBirthday;
    /** 员工生日 */

    private String resumePoliticaloOutlook;
    /** 政治面貌 */

    private String resumeResidence;
    /** 户口所在地 */

    private Long resumeZt;
    /** 入职状态 */

}
