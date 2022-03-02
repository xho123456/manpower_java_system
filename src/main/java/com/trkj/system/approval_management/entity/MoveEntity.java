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
public class MoveEntity {
    //异动
    private Integer auditflowId;

    private String auditflowTitle;

    private Long auditflowState;

    private String auditflowType;

    private Integer auditflowdetailId;

    private Date auditflowdetaiDate;

    private Long auditflowdetaiState;

    private String staffName;
    /** 申请人名称 */

    private Integer staffId;

    private String staffName1;
    /** 当前审批人名称1 */

    private String staffName2;
    /** 当前审批人名称2 */

    private String staffName3;
    /** 当前审批人名称3 */

    private Integer transferId;

    private Long deptId;

    private String deptName;

    private String transferType;

    private String createdDeptName;

    private Long transferState;

    private String updatedDeptName;

    private String transferRawpostName;

    private String transferAfterpostName;

    private Date takeefFectDate;

    private Date updatedTime;

    private Date createdtime;

    private Long currentPage;

    private Long pageSize;

}
