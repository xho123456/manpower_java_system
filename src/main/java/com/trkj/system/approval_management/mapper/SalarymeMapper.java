package com.trkj.system.approval_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.approval_management.entity.MoveEntity;
import com.trkj.system.approval_management.entity.SalaryincreaseEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SalarymeMapper extends BaseMapper<SalaryincreaseEntity> {

    /**
     * 查看调薪审批
     * @param page
     * @return
     */
    @Select("SELECT sa.AUDITFLOW_ID,sa.FRONT_SALARY,sa.AFTER_SALARY,sa.SALARY_STATE,sa.TAKE_EFFECT_DATE," +
            "sa.SALARY_REMARKS,sa.CREATED_TIME,au.AUDITFLOW_STATE,au.AUDITFLOW_TYPE,au.AUDITFLOW_TITLE," +
            "s.STAFF_NAME as STAFFNAME,ae.STAFF_NAME as STAFFNAME2,ae.AUDITFLOWDETAI_DATE,ae.AUDITFLOWDETAI_STATE" +
            " FROM SALARY sa LEFT JOIN AUDITFLOW au on sa.AUDITFLOW_ID=au.AUDITFLOW_ID LEFT JOIN STAFF s on au.STAFF_ID=s.STAFF_ID " +
            "LEFT JOIN AUDITFLOWDETAIL ae on ae.AUDITFLOW_ID=au.AUDITFLOW_ID ${ew.customSqlSegment} ")
    IPage<SalaryincreaseEntity> Moveapperme(Page<SalaryincreaseEntity> salaryincreaseEntityPage, @Param(Constants.WRAPPER) QueryWrapper<SalaryincreaseEntity> queryWrapper);

    /**
     * 查看当前用户的原有工资
     */
    @Select("select f.FIXEDWAGE_OFFICIALMONEY from staff s left join FIXEDWAGE f on s.STAFF_ID = f.STAFF_ID where s.staff_id = #{id}")
    SalaryincreaseEntity salaryFixed (Integer id);
}
