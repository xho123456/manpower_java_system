package com.trkj.system.approval_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.approval_management.entity.LeaveEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LeaveAudMapper extends BaseMapper<LeaveEntity> {
    /**
     * 查看我的请假审批
     * @param page
     * @return
     */
    @Select("SELECT l.AUDITFLOW_ID,l.LEAVE_TYPE,l.LEAVE_MATTER,l.LEAVE_S_DATE,l.LEAVE_E_DATE," +
            "l.LEAVE_TOTAL_DATE,l.LEAVE_STATE,l.CREATED_TIME,au.AUDITFLOW_STATE,au.AUDITFLOW_TYPE,au.AUDITFLOW_TITLE," +
            "s.STAFF_NAME as STAFFNAME,ae.STAFF_NAME as STAFFNAME2,ae.AUDITFLOWDETAI_DATE,ae.AUDITFLOWDETAI_STATE" +
            " FROM LEAVE l LEFT JOIN AUDITFLOW au on l.AUDITFLOW_ID=au.AUDITFLOW_ID LEFT JOIN STAFF s on au.STAFF_ID=s.STAFF_ID" +
            " LEFT JOIN AUDITFLOWDETAIL ae on ae.AUDITFLOW_ID=au.AUDITFLOW_ID ${ew.customSqlSegment} ")
    IPage<LeaveEntity> leaverMe(Page<LeaveEntity> leaveEntityPage, @Param(Constants.WRAPPER) QueryWrapper<LeaveEntity> queryWrapper);

}
