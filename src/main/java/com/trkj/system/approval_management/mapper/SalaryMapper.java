package com.trkj.system.approval_management.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.approval_management.entity.MoveEntity;
import com.trkj.system.approval_management.entity.SalaryincreaseEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SalaryMapper extends BaseMapper<SalaryincreaseEntity> {
    /**
     * 查看所有调薪待办审批
     * @param page
     * @return
     */
    @Select("SELECT sa.AUDITFLOW_ID,sa.FRONT_SALARY,sa.AFTER_SALARY,sa.SALARY_STATE,sa.TAKE_EFFECT_DATE," +
            "sa.SALARY_REMARKS,au.AUDITFLOW_TYPE," +
            "s.STAFF_NAME as STAFFNAME1,ae.STAFF_NAME as STAFFNAME2,ae.AUDITFLOWDETAI_DATE,ae.AUDITFLOWDETAI_STATE" +
            " FROM SALARY sa LEFT JOIN AUDITFLOW au on sa.AUDITFLOW_ID=au.AUDITFLOW_ID LEFT JOIN STAFF s on au.STAFF_ID=s.STAFF_ID" +
            " LEFT JOIN AUDITFLOWDETAIL ae on ae.AUDITFLOW_ID=au.AUDITFLOW_ID where ae.AUDITFLOWDETAI_STATE=1 ")
    IPage<SalaryincreaseEntity> Salaryme(Page<SalaryincreaseEntity> page);

    /**
     * 查看所有调薪已办审批
     * @param page
     * @return
     */
    @Select("SELECT sa.AUDITFLOW_ID,sa.FRONT_SALARY,sa.AFTER_SALARY,sa.SALARY_STATE,sa.TAKE_EFFECT_DATE," +
            "sa.SALARY_REMARKS,au.AUDITFLOW_TYPE," +
            "s.STAFF_NAME as STAFFNAME1,ae.STAFF_NAME as STAFFNAME2,ae.AUDITFLOWDETAI_DATE,ae.AUDITFLOWDETAI_STATE" +
            " FROM SALARY sa LEFT JOIN AUDITFLOW au on sa.AUDITFLOW_ID=au.AUDITFLOW_ID LEFT JOIN STAFF s on au.STAFF_ID=s.STAFF_ID" +
            " LEFT JOIN AUDITFLOWDETAIL ae on ae.AUDITFLOW_ID=au.AUDITFLOW_ID where ae.AUDITFLOWDETAI_STATE=2 ")
    IPage<SalaryincreaseEntity> Salaryed(Page<SalaryincreaseEntity> page);
}
