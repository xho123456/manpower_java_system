package com.trkj.system.approval_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.approval_management.entity.ErectionEntity;
import com.trkj.system.approval_management.entity.WorkovertimeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ErectionMapper extends BaseMapper<ErectionEntity> {
    /**
     * 查看我的出差审批
     * @param page
     * @return
     */
    @Select("SELECT ov.AUDITFLOW_ID,ov.OVERTIMEASK_TYPE,ov.OVERTIMEASK_MATTER,ov.OVERTIMEASK_S_DATE,ov.OVERTIMEASK_E_DATE," +
            "ov.OVERTIMEASK_TOTAL_DATE,ov.OVERTIMEASK_STATE,ov.CREATED_TIME,au.AUDITFLOW_TYPE,au.AUDITFLOW_TITLE," +
            "s.STAFF_NAME as STAFFNAME,ae.STAFF_NAME as STAFFNAME2,ae.AUDITFLOWDETAI_DATE,ae.AUDITFLOWDETAI_STATE" +
            " FROM OVERTIMEASK ov LEFT JOIN AUDITFLOW au on ov.AUDITFLOW_ID=au.AUDITFLOW_ID LEFT JOIN STAFF s on au.STAFF_ID=s.STAFF_ID" +
            " LEFT JOIN AUDITFLOWDETAIL ae on ae.AUDITFLOW_ID=au.AUDITFLOW_ID ${ew.customSqlSegment} ")
    IPage<ErectionEntity> erectionMe(Page<ErectionEntity> erectionEntityPage, @Param(Constants.WRAPPER) QueryWrapper<ErectionEntity> queryWrapper);

}
