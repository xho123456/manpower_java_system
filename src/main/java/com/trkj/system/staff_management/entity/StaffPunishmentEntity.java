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
public class StaffPunishmentEntity {
    private Long staffId;
    /** 员工编号 */

    private String staffName;
    /** 员工姓名 */

    private String deptName;
    /** 部门名称 */

    private String POSTNAME;
    /** 职位名称 */

    private String PUNISHCAUSE;
    /** 惩罚原因 */

    private String PUNISHTYPE;
    /** 惩罚类型 */

    private String PUNISHUNIT;
    /** 惩罚单位 */

    private Date CREATEDTIME;
    /** 创建时间 */

    private Long CurrentPage;

    private Long Pagesize;

}
