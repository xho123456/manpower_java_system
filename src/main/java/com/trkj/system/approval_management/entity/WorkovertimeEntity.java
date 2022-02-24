package com.trkj.system.approval_management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)  /** 链式写法 */
public class WorkovertimeEntity {
    //加班
    private Long AUDITFLOWID;

    private String AUDITFLOWTITLE;

    private Long AUDITFLOWSTATE;

    private String AUDITFLOWTYPE;

    private Long AUDITFLOWDETAILID;

    private Date AUDITFLOWDETAIDATE;

    private Long AUDITFLOWDETAISTATE;

    private String STAFFNAME1;
    /** 申请人名称 */

    private String STAFFNAME2;
    /** 当前审批人名称 */

    private Long OVERTIMEASKID;

    private String OVERTIMEASKTYPE;

    private String OVERTIMEASKMATTER;

    private String OVERTIMEASKREMARKS;

    private Date OVERTIMEASKSDATE;

    private Date OVERTIMEASKEDATE;

    private Long OVERTIMEASKTOTALDATE;

    private Long OVERTIMEASKSTATE;

    private Date UPDATEDTIME;

    private Date CREATEDTIME;

}
