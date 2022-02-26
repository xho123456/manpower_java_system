package com.trkj.system.staff_management.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)  /** 链式写法 */
public class StaffTowEntity {
    private static final long serialVersionUID = 1L;

    private Integer staffId;
    /** 员工编号 */

    private String staffName;
    /** 员工姓名 */

    private String staffSex;
    /** 员工性别 */

    private Long staffPhone;
    /** 员工手机号码 */

    private String staffEmail;
    /** 员工邮箱 */

    private String staffPicture;
    /** 员工照片 */

    private Date staffBirthday;
    /** 员工生日 */

    private String staffOutlook;
    /** 政治面貌 */

    private String staffEducation;
    /** 学历 */

    private String deptPostId;
    /** 职位编号 */

    private String staffPass;
    /** 密码 */

    private Date staffHiredate;
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

    private String staffQq;
    /** qq */

    private String staffCredit;
    /** 银行卡号 */

    private String staffBlood;
    /** 血型 */

    private String staffSign;
    /** 星座 */

    private String staffMarital;
    /** 婚姻状态 */

    private String staffRegistered;
    /** 户口所在地 */

    private String staffSchool;
    /** 毕业学校 */

    private String staffAddress;
    /** 现住地址 */

    private Long staffState;
    /** 员工状态 */

    private Date createdTime;
    /** 创建时间 */

    private Date updatedTime;
    /** 修改时间 */

    private Long fixedWageid;
    /** 固定工资编号 */

    private Long fixedwageperiodmoney;
    /** 试用期基本工资 */

    private Long fixedWageofficialmoney;
    /** 正式期基本工资 */

    private String fixedWageremark;
    /** 备注 */

    private Integer FixedwageId;
    /** 固定工资编号 */

    private Long fixedwagePeriodmoney;
    /** 试用期基本工资 */

    private Long fixedwageOfficialmoney;
    /** 正式期基本工资 */

    private Long fixedwagepPeriodpostmoney;
    /** 试用期岗位工资 */

    private Long fixedwageOfflcialpostmoney;
    /** 正式期岗位工资 */

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

    private String resumeHy;
    /** 婚姻状态 */

    @TableLogic
    @ApiModelProperty(value = "逻辑删除 0:未删 1:已删 ")
    @TableField("IS_DELETED")
    private Long isDeleted;
    /** 逻辑删除 */

    @Version
    @TableField("REVISION")
    private Long revision;
    /** 乐观锁 */
}
