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
    //转正
    public Long auditflowid;

    public String auditflowtitle;

    private Long auditflowstate;

    public String auditflowtype;

    private Long auditflowdetailid;

    public Long staffid;
    /** 申请人编号 */

    private String staffname1;
    /** 申请人名称 */

    private String staffname2;
    /** 当前审批人名称 */

    public String auditflowdetairemarks;

    public Date auditflowdetaidate;

    public Long auditflowdetaistate;

    private Long workerid;

    public Long deptid;

    public String workertype;

    public String workerremarks;

    public Long workerstate;

    public Date workerdate;

    private Date updatedtime;

    private Date createdtime;

    private Long currentPage;

    private Long pagesize;

}
