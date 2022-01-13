package com.trkj.system.staff_management.entity;

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
public class ResumeEntity {
    private Long RESUMEID;
    /** 简历编号 */

    private String RESUMENAME;
    /** 员工姓名 */

    private String RESUMESEX;
    /** 员工性别 */

    private Long RESUMEPHONE;
    /** 员工手机号码 */

    private String RESUMEEDUCATION;
    /** 学历 */

    private String RESUMEMAILBOX;
    /** 员工邮箱 */

    private Date RESUMEBIRTHDAY;
    /** 员工生日 */

    private String RESUMEPOLITICALOUTLOOK;
    /** 政治面貌 */

    private String RESUMERESIDENCE;
    /** 户口所在地 */

    private Long RESUMEZT;
    /** 入职状态 */

}
