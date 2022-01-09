package com.trkj.system.staff_management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)  /** 链式写法 */
public class StaffTransferEntity {
    private Long staffId;
    /** 员工编号 */

    private String staffName;
    /** 员工姓名 */

    private String TRANSFERTYPE;
    /** 异动类型 */

    private Long TRANSFERSTATE;
    /** 员工编号 */

    private String CREATEDDEPTNAME;
    /** 原部门名称 */

    private String UPDATEDDEPTNAME;
    /** 现部门名称 */

    private String transferrawpostname;
    /** 原职位名称 */

    private String transferafterpostname;
    /** 现职位名称 */

    private String TAKEEFFECTDATE;
    /** 生效日期 */

}
