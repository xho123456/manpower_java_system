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
    private Integer resumeId;
    /** 简历编号 */
    private Integer employmentId;
    /** 录用编号 */

    private Long probationary;
    /** 试用期工资 */

    private Long positiveMonthly;
    /** 转正工资 */

    private String resumeName;
    /** 员工姓名 */

    private String resumePhoto;
    /** 照片 */

    private String resumeSex;
    /** 员工性别 */

    private Long resumePhone;
    /** 员工手机号码 */

    private String resumeMailbox;
    /** 员工邮箱 */

    private Date resumeBirthday;
    /** 员工生日 */

    private String resumePoliticalOutlook;
    /** 政治面貌 */

    private String resumeEducation;
    /** 学历 */

    private Integer deptPostId;
    /** 职位编号 */

    private Date staffHiredate;
    /** 入职日期 */

    private String staffIdentity;
    /** 员工身份证 */

    private Integer deptId;
    /** 部门编号 */

    private String staffMajor;
    /** 员工专业 */

    private long staffEmergency;
    /** 紧急联系人 */

    private String staffWechat;
    /** 微信 */

    private String staffQq;
    /** qq */

    private String staffCredit;
    /** 银行卡号 */

    private String staffBlood;
    /** 血型 */

    private String staffSign;
    /** 星座 */

    private String deptName;
    /** 部门名称 */

    private String resumeResidence;
    /** 户口所在地 */

    private String postName;
    /** 职位名称 */

    private Long resumeZt;
    /** 入职状态 */

    private String staffSchool;
    /** 毕业学校 */

    private String staffAddress;
    /** 现住地址 */

    private String resumeHy;
    /** 婚姻状态 */

    private Long currentPage;

    private Long pagesize;
}


