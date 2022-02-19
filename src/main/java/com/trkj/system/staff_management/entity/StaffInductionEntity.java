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
@Accessors(chain = true)  /** 链式写法 */
public class StaffInductionEntity {
    private Long RESUMEID;
    /** 简历编号 */
    private Long EMPLOYMENTID;
    /** 录用编号 */

    private Long probationary;
    /** 试用期工资 */

    private Long positivemonthly;
    /** 转正工资 */

    private String RESUMENAME;
    /** 员工姓名 */

    private String RESUMEPHOTO;
    /** 照片 */

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

    private String DEPTPOSTID;
    /** 职位编号 */

    private Date staffHIREDATE;
    /** 入职日期 */

    private String staffIdentity;
    /** 员工身份证 */

    private long deptId;
    /** 部门编号 */

    private String staffMajor;
    /** 员工专业 */

    private long staffEmergency;
    /** 紧急联系人 */

    private String staffWechat;
    /** 微信 */

    private String staffQQ;
    /** qq */

    private String staffCredit;
    /** 银行卡号 */

    private String staffBlood;
    /** 血型 */

    private String staffSign;
    /** 星座 */

    private String deptName;
    /** 部门名称 */

    private String RESUMERESIDENCE;
    /** 户口所在地 */

    private String POSTNAME;
    /** 职位名称 */

    private Long RESUMEZT;
    /** 入职状态 */

    private String staffSchool;
    /** 毕业学校 */

    private String staffAddress;
    /** 现住地址 */

    private String RESUMEHY;
    /** 婚姻状态 */

    private Long CurrentPage;

    private Long Pagesize;
}


