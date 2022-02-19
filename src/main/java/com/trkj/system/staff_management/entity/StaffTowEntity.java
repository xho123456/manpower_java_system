package com.trkj.system.staff_management.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
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

    private Long staffId;
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

    private String DEPTPOSTID;
    /** 职位编号 */

    private String staffPass;
    /** 密码 */

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

    private String staffMarital;
    /** 婚姻状态 */

    private String staffRegistered;
    /** 户口所在地 */

    private String staffSchool;
    /** 毕业学校 */

    private String staffAddress;
    /** 现住地址 */

    private Long STAFFSTATE;
    /** 员工状态 */

    private Date CREATEDTIME;
    /** 创建时间 */

    private Date UPDATEDTIME;
    /** 修改时间 */

    private Long FixedwageId;
    /** 固定工资编号 */

    private Long FIXEDWAGEPERIODMONEY;
    /** 试用期基本工资 */

    private Long FIXEDWAGEOFFICIALMONEY;
    /** 正式期基本工资 */

    private String FIXEDWAGEREMARK;
    /** 备注 */

    @TableLogic
    @ApiModelProperty(value = "逻辑删除 0:未删 1:已删 ")
    @TableField("IS_DELETED")
    private Long ISDELETED;
    /** 逻辑删除 */

    @Version
    @TableField("REVISION")
    private Long REVISION;
    /** 乐观锁 */
}
