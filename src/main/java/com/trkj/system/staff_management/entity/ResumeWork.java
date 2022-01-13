package com.trkj.system.staff_management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ResumeWork {
    private Date WORKSTARETIME;
    /** 工作开始时间 */

    private Date WORKENDTIME;
    /** 工作结束时间 */

    private String COMPANYNAME;
    /** 公司名称 */

    private String POSITIONNAME;
    /** 工作职位 */

    private String POSITIONINDUSTRY;
    /** 所属行业 */

    private String POSITIONDESCRIBE;
    /** 工作描述 */

    private Number POSITIONSQMONTHLY;
    /** 税前月薪 */
}
