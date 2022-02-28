package com.trkj.system.insurance_management.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.trkj.system.system_management.entity.Depts;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@KeySequence(value = "NOTICE_ID", clazz = Integer.class)
public class DefinsuredDefSchemeVo {
    //员工表
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "获奖人编号")
    @TableId("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "员工姓名")
    @TableField("STAFF_NAME")
    private String staffName;

    @ApiModelProperty(value = "性别")
    @TableField("STAFF_SEX")
    private String staffSex;

    @ApiModelProperty(value = "手机号码")
    @TableField("STAFF_PHONE")
    private Long staffPhone;

    @ApiModelProperty(value = "邮箱")
    @TableField("STAFF_EMAIL")
    private String staffEmail;

    @ApiModelProperty(value = "照片")
    @TableField("STAFF_PICTURE")
    private String staffPicture;

    @ApiModelProperty(value = "出生日期")
    @TableField("STAFF_BIRTHDAY")
    private Date staffBirthday;

    @ApiModelProperty(value = "政治面貌")
    @TableField("STAFF_OUTLOOK")
    private String staffOutlook;

    @ApiModelProperty(value = "学历")
    @TableField("STAFF_EDUCATION")
    private String staffEducation;

    @ApiModelProperty(value = "部门职位编号外键")
    @TableField("DEPT_POST_ID")
    private Long deptPostId;

    @ApiModelProperty(value = "密码")
    @TableField("STAFF_PASS")
    private String staffPass;

    @ApiModelProperty(value = "入职日期")
    @TableField("STAFF_HIREDATE")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date staffHiredate;

    @ApiModelProperty(value = "身份证")
    @TableField("STAFF_IDENTITY")
    private String staffIdentity;

    @ApiModelProperty(value = "部门编号")
    @TableField("DEPT_ID")
    private Long deptId;

    @ApiModelProperty(value = "专业")
    @TableField("STAFF_MAJOR")
    private String staffMajor;

    @ApiModelProperty(value = "紧急联系人")
    @TableField("STAFF_EMERGENCY")
    private Long staffEmergency;

    @ApiModelProperty(value = "微信")
    @TableField("STAFF_WECHAT")
    private String staffWechat;

    @TableField("STAFF_QQ")
    private String staffQq;

    @ApiModelProperty(value = "银行卡号")
    @TableField("STAFF_CREDIT")
    private String staffCredit;

    @ApiModelProperty(value = "血型")
    @TableField("STAFF_BLOOD")
    private String staffBlood;

    @ApiModelProperty(value = "星座")
    @TableField("STAFF_SIGN")
    private String staffSign;

    @ApiModelProperty(value = "婚姻状态")
    @TableField("STAFF_MARITAL")
    private String staffMarital;

    @ApiModelProperty(value = "户口所在地")
    @TableField("STAFF_REGISTERED")
    private String staffRegistered;

    @ApiModelProperty(value = "毕业学校")
    @TableField("STAFF_SCHOOL")
    private String staffSchool;

    @ApiModelProperty(value = "现住地址")
    @TableField("STAFF_ADDRESS")
    private String staffAddress;

    @TableField("STAFF_STATE")
    private Long staffState;

    //部门表


    @ApiModelProperty(value = "父级菜单")
    @TableId("MENU_PID")
    private Long menuPid;

    @ApiModelProperty(value = "是否有叶子 0:有 1:没有")
    @TableId("MENU_LEAF")
    private Long menuLeaf;

    @TableField(exist = false)
    private List<Depts> deptlist;

    @ApiModelProperty(value = "状态;0：启用  1：禁用")
    @TableField("DEPT_STATE")
    private Long deptState;

    @ApiModelProperty(value = "部门名称")
    @TableField("DEPT_NAME")
    private String deptName;



    //转正表
    @ApiModelProperty(value = "转正编号")
    @TableId("WORKER_ID")
    private Long workerId;

    @ApiModelProperty(value = "转正类型")

    @TableField("WORKER_TYPE")
    private String workerType;


    @TableField("WORKER_DATE")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date workerDate;

    //职位表

    @ApiModelProperty(value = "职位名称")
    @TableField("POST_NAME")
    private String postName;

    @ApiModelProperty(value = "职位工资")
    @TableField("DEPT_POST_MONEY")
    private Long deptPostMoney;

    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    @ApiModelProperty(value = "创建时间 精确到秒")
    @TableField(value = "CREATED_TIME" , fill = FieldFill.INSERT)
    private Date createdTime;

    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    @ApiModelProperty(value = "修改时间 精确到秒")
    @TableField(value = "UPDATED_TIME",fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @Version
    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @TableLogic
    @ApiModelProperty(value = "逻辑删除 0:未删 1:已删 ")
    @TableField("IS_DELETED")
    private Long isDeleted;

    //默认参保方案表

    @ApiModelProperty(value = "默认参保方案编号")
    @TableId("DEF_INSURED_ID")
    private Integer defInsuredId;

    @ApiModelProperty(value = "默认参保方案名称")
    @TableField("DEF_INSURED_NAME")
    private String defInsuredName;

    @ApiModelProperty(value = "默认参保方案状态 0:启用 1:禁用")
    @TableField("DEF_INSURED_STATE")
    private Integer defInsuredState;

    @ApiModelProperty(value = "默认参保方案数量")
    @TableField("DEF_INSURED_NUMBER")
    private Long defInsuredNumber;

    //参保缴纳表

    @ApiModelProperty(value = "参保缴纳编号")
    @TableId("INSURED_PAYMENT_ID")
    private Long insuredPaymentId;

    @ApiModelProperty(value = "参保明细编号")
    @TableField("INS_DETAIL_ID")
    private Long insDetailId;

    @ApiModelProperty(value = "缴纳基数")
    @TableField("INSURED_PAYMENT_NUMBER")
    private Long insuredPaymentNumber;

    @ApiModelProperty(value = "公积金缴纳基数")
    @TableField("INSURED_PAYMENT_FUND")
    private Long insuredPaymentFund;

    //默认方案表

    @ApiModelProperty(value = "默认方案表编号")
    @TableId("DEF_SCHEME_ID")
    private Integer defSchemeId;

    @ApiModelProperty(value = "最少基数")
    @TableField("DEF_SCHEME_MIN")
    private Long defSchemeMin;

    @ApiModelProperty(value = "最多基数")
    @TableField("DEF_SCHEME_MAX")
    private Long defSchemeMax;

    @ApiModelProperty(value = "基数上限")
    @TableField("DEF_SCHEME_UPPER")
    private Long defSchemeUpper;

    @ApiModelProperty(value = "基数下限")
    @TableField("DEF_SCHEME_FLOOR")
    private Long defSchemeFloor;

    @ApiModelProperty(value = "个人缴纳比例")
    @TableField("DEF_SCHEME_PERSON_PROP")
    private Double defSchemePersonProp;

    @ApiModelProperty(value = "个人固定缴纳")
    @TableField("DEF_SCHEME_PERSON_SUM")
    private Double defSchemePersonSum;

    @ApiModelProperty(value = "企业缴纳比例")
    @TableField("DEF_SCHEME_FIRM_PROP")
    private Double defSchemeFirmProp;

    @ApiModelProperty(value = "企业固定缴纳")
    @TableField("DEF_SCHEME_FIRM_SUM")
    private Double defSchemeFirmSum;

    @ApiModelProperty(value = "参保类型")
    @TableField("DEF_SCHEME_TYPE")
    private String defSchemeType;

    //缴纳明细表


    @ApiModelProperty(value = "员工名称")
    @TableField("INS_DETAIL_STAFF_NAME")
    private String insDetailStaffName;

    @ApiModelProperty(value = "参保方案名称")
    @TableField("INS_DETAIL_INSURED_NAME")
    private String insDetailInsuredName;

    @ApiModelProperty(value = "参保月份 精确到年月")
    @TableField("INS_DETAIL_INSURED_MONTH")
    @JsonFormat(pattern="yyyy-MM",timezone="GMT+8")
    private Date insDetailInsuredMonth;

    @ApiModelProperty(value = "计薪月份 精确到年月")
    @TableField("INS_DETAIL_SALARY_MONTH")
    private Date insDetailSalaryMonth;

    @ApiModelProperty(value = "社保个人缴费")
    @TableField("INS_DETAIL_SOCIAL_PERSON_PAY")
    private Double insDetailSocialPersonPay;

    @ApiModelProperty(value = "社保公司缴费")
    @TableField("INS_DETAIL_SOCIAL_FIRM_PAY")
    private Double insDetailSocialFirmPay;

    @ApiModelProperty(value = "积金个人缴费")
    @TableField("INS_DETAIL_FUND_PERSON_PAY")
    private Double insDetailFundPersonPay;

    @ApiModelProperty(value = "积金公司缴费")
    @TableField("INS_DETAIL_FUND_FIRM_PAY")
    private Double insDetailFundFirmPay;


    private int currentPage;

    private int pagesize;

}
