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
public class ErectionEntity {
    //出差
    private Integer auditflowId;

    private String auditflowTitle;

    private Long auditflowState;

    private String auditflowType;

    private Integer auditflowdetailId;

    private Date auditflowdetaiDate;

    private Long auditflowdetaiState;

    private String staffName;
    /** 申请人名称 */

    private String staffName1;
    /** 当前审批人名称1 */

    private String staffName2;
    /** 当前审批人名称2 */

    private String staffName3;
    /** 当前审批人名称3 */

    private Integer travelId;

    private Long deptId;

    private String travelPlace;

    private String travelMatter;

    private Date travelSDate;

    private Date travelEDate;

    private Long travelTotalDate;

    private Long travelState;

    private Date updatedTime;

    private Date createdTime;

    private Long currentPage;

    private Long pageSize;

}
