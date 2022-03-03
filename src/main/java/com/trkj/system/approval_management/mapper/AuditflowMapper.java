package com.trkj.system.approval_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.approval_management.entity.PositiveEntity;
import com.trkj.system.staff_management.entity.StaffInductionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface AuditflowMapper extends BaseMapper<PositiveEntity> {

    /**
     * 查看所有转正待办审批
     * @param page
     * @return
     */
    @Select("SELECT w.AUDITFLOW_ID,w.WORKER_TYPE,w.WORKER_DATE,w.CREATED_TIME,au.AUDITFLOW_TYPE,au.AUDITFLOW_TITLE," +
            "s.STAFF_NAME as STAFFNAME1,ae.STAFF_NAME as STAFFNAME2,ae.AUDITFLOWDETAI_DATE,ae.AUDITFLOWDETAI_STATE" +
            " FROM WORKER w LEFT JOIN AUDITFLOW au on w.AUDITFLOW_ID=au.AUDITFLOW_ID LEFT JOIN STAFF s on au.STAFF_ID=s.STAFF_ID" +
            " LEFT JOIN AUDITFLOWDETAIL ae on ae.AUDITFLOW_ID=au.AUDITFLOW_ID where ae.AUDITFLOWDETAI_STATE=1 ")
        IPage<PositiveEntity> positveme(Page<PositiveEntity> page);

    /**
     * 查看所有转正已办审批
     * @param page
     * @return
     */
    @Select("SELECT w.AUDITFLOW_ID,w.WORKER_TYPE,w.WORKER_DATE,w.CREATED_TIME,au.AUDITFLOW_TYPE,au.AUDITFLOW_TITLE," +
            "s.STAFF_NAME as STAFFNAME1,ae.STAFF_NAME as STAFFNAME2,ae.AUDITFLOWDETAI_DATE,ae.AUDITFLOWDETAI_STATE" +
            " FROM WORKER w LEFT JOIN AUDITFLOW au on w.AUDITFLOW_ID=au.AUDITFLOW_ID LEFT JOIN STAFF s on au.STAFF_ID=s.STAFF_ID" +
            " LEFT JOIN AUDITFLOWDETAIL ae on ae.AUDITFLOW_ID=au.AUDITFLOW_ID where ae.AUDITFLOWDETAI_STATE=2")
    IPage<PositiveEntity> positveed(Page<PositiveEntity> page);

    /**
     * 根据名字查询所有转正审批
     * @param page
     * @return
     */
    @Select("SELECT w.AUDITFLOW_ID,w.WORKER_TYPE,w.WORKER_DATE,w.CREATED_TIME,au.AUDITFLOW_TYPE,au.AUDITFLOW_TITLE," +
            "s.STAFF_NAME as STAFFNAME1,ae.STAFF_NAME as STAFFNAME2,ae.AUDITFLOWDETAI_DATE,ae.AUDITFLOWDETAI_STATE" +
            " FROM WORKER w LEFT JOIN AUDITFLOW au on w.AUDITFLOW_ID=au.AUDITFLOW_ID LEFT JOIN STAFF s on au.STAFF_ID=s.STAFF_ID" +
            " LEFT JOIN AUDITFLOWDETAIL ae on ae.AUDITFLOW_ID=au.AUDITFLOW_ID ${ew.customSqlSegment} ")
    IPage<PositiveEntity> positvemeByname(Page<PositiveEntity> positiveEntityPage, @Param(Constants.WRAPPER) QueryWrapper<PositiveEntity> queryWrapper);

    /**
     * 查询我的转正审批
     * @param page
     * @return
     */
    @Select("SELECT w.AUDITFLOW_ID,w.WORKER_TYPE,w.WORKER_DATE,w.CREATED_TIME,au.AUDITFLOW_STATE,au.AUDITFLOW_TYPE,au.AUDITFLOW_TITLE," +
            "s.STAFF_NAME as STAFFNAME1,ae.STAFF_NAME as STAFFNAME2,ae.AUDITFLOWDETAI_DATE,ae.AUDITFLOWDETAI_STATE" +
            " FROM WORKER w LEFT JOIN AUDITFLOW au on w.AUDITFLOW_ID=au.AUDITFLOW_ID LEFT JOIN STAFF s on au.STAFF_ID=s.STAFF_ID" +
            " LEFT JOIN AUDITFLOWDETAIL ae on ae.AUDITFLOW_ID=au.AUDITFLOW_ID ${ew.customSqlSegment} ")
    IPage<PositiveEntity> positvemyid(Page<PositiveEntity> positiveEntityPage, @Param(Constants.WRAPPER) QueryWrapper<PositiveEntity> queryWrapper);


}
