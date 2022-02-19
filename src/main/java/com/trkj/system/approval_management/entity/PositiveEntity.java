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
public class PositiveEntity {
    public Long AUDITFLOWID;

    public String AUDITFLOWTITLE;

    private Long AUDITFLOWSTATE;

    public String AUDITFLOWTYPE;

    private Long AUDITFLOWDETAILID;

//    public Long STAFFID;
//    /** 申请人编号 */

    private String STAFFNAME1;
    /** 申请人名称 */

    private String STAFFNAME2;
    /** 当前审批人名称 */

    public String AUDITFLOWDETAIREMARKS;

    public Date AUDITFLOWDETAIDATE;

    public Long AUDITFLOWDETAISTATE;

    private Long WORKERID;

//    public Long DEPTID;

    public String WORKERTYPE;

    public String WORKERREMARKS;

    public Long WORKERSTATE;

    public Date WORKERDATE;

    private Date UPDATEDTIME;

    private Date CREATEDTIME;

}
