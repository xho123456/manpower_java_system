package com.trkj.system.salary_management.mapper.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class StaffSalary implements Serializable {
    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "实发工资")
    @TableField("SFGZ")
    private Long  sfgz;
    @ApiModelProperty(value = "应发工资")
    @TableField("YFGZ")
    private Long  yfgz;


    @ApiModelProperty(value = "个人社保")
    @TableField("GRSB")
    private Long grsb;

    @ApiModelProperty(value = "公司社保")
    @TableField("GSSB")
    private Long gssb;

    @ApiModelProperty(value = "个人公积金")
    @TableField("GRGJJ")
    private Long grgjj;

    @ApiModelProperty(value = "公司公积金")
    @TableField("GSGJJ")
    private Long gsgjj;

    @ApiModelProperty(value = "员工名称")
    @TableField("STAFF_NAME")
    private String staffName;

    @ApiModelProperty(value = "员工ID")
    @TableField("STAFF_ID")
    private Long staffId;
    @ApiModelProperty(value = "员工状态")
    @TableField("STAFF_STATE")
    private Long zt;

    @ApiModelProperty(value = "员工职位")
    @TableField("POST_NAME")
    private String postName;

    @ApiModelProperty(value = "员工部门")
    @TableField("DEPT_NAME")
    private String deptName;

    @ApiModelProperty(value = "员工试用期工资")
    @TableField("FIXEDWAGE_PERIODMONEY")
        private Long fixedwagePeriodmoney;

    @ApiModelProperty(value = "工资归档编号")
    @TableField( "MONEYPIGEONHOLE_ID")
    private Long moneypigeonholeId  ;

    @ApiModelProperty(value = "员工正式期工资")
    @TableField("FIXEDWAGE_OFFICIALMONEY")
    private Long fixedwageOfficialmoney;

    @ApiModelProperty(value = "加班工资")
    @TableField("JIABANMONEY")
    private Long jiabanmoney;

    @ApiModelProperty(value = "迟到工资")
    @TableField("CHIDAOMONY")
    private Long chidaomony;
    @ApiModelProperty(value = "早退工资")
    @TableField("ZAOTUEIMONEY")
    private Long zaotueimoney;
    @ApiModelProperty(value = "矿工工资")
    @TableField("KUANGONMONEY")
    private Long kuangonmoney;
    @ApiModelProperty(value = "请假工资")
    @TableField("QINJIAMONEY")
    private Long qinjiamoney;
    @ApiModelProperty(value = "工资归档编号")
    @TableField( "MONEYPIGEONHOLE_ID")
    private Integer   gdid;

    private int currentPage;
    private int pageSize;
}
