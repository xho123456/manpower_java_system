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
public class ResumeEducationss {
    private Date EDUCATIONSTARTTIME;
    /** 教育开始时间 */

    private Date EDUCATIONENDTIME;
    /** 教育结束时间 */

    private String EDUCATIONSTUDENTNAME;
    /** 学校名称 */

    private String EDUCATIONMAJOR;
    /** 所属专业 */

    private int EDUCATIONFULLTIME;
    /** 是否全日制 */
}
