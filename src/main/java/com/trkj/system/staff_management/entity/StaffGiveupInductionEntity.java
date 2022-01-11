package com.trkj.system.staff_management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)  /** 链式写法 */
public class StaffGiveupInductionEntity {
    private String RESUMENAME;
    /** 员工姓名 */

    private String RESUMESEX;
    /** 员工性别 */

    private Long RESUMEPHONE;
    /** 员工手机号码 */

    private String RESUMEMAILBOX;
    /** 员工邮箱 */

    private Date RESUMEBIRTHDAY;
    /** 员工生日 */

    private String RESUMEPOLITICALOUTLOOK;
    /** 政治面貌 */

    private String RESUMEEDUCATION;
    /** 学历 */

    private String deptName;
    /** 部门名称 */

    private String RESUMERESIDENCE;
    /** 户口所在地 */

    private String POSTNAME;
    /** 职位名称 */

    private Long EMPLOYMENTSTATE;
    /** 入职状态 */

    private String waivereason;
    /** 放弃原因 */

    private Long CurrentPage;

    private Long Pagesize;
}
