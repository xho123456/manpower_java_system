package com.trkj.system.approval_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.approval_management.entity.DepartureEntity;
import com.trkj.system.approval_management.entity.PositiveEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DepartureMapper extends BaseMapper<DepartureEntity> {
    /**
     * 查看我的离职审批
     * @param page
     * @return
     */
    @Select("SELECT q.AUDITFLOW_ID,q.QUIT_TYPE,q.APPLY_QUIT_DATE,q.FORMAL_QUIT_DATE,q.CREATED_TIME,au.AUDITFLOW_STATE,au.AUDITFLOW_TYPE,au.AUDITFLOW_TITLE," +
            "s.STAFF_NAME as STAFFNAME,ae.STAFF_NAME as STAFFNAME2,ae.AUDITFLOWDETAI_DATE,ae.AUDITFLOWDETAI_STATE" +
            " FROM QUIT q LEFT JOIN AUDITFLOW au on q.AUDITFLOW_ID=au.AUDITFLOW_ID LEFT JOIN STAFF s on au.STAFF_ID=s.STAFF_ID" +
            " LEFT JOIN AUDITFLOWDETAIL ae on ae.AUDITFLOW_ID=au.AUDITFLOW_ID ${ew.customSqlSegment} ")
    IPage<DepartureEntity> DepartureMe(Page<DepartureEntity> DepartureEntityPage, @Param(Constants.WRAPPER) QueryWrapper<DepartureEntity> queryWrapper);

}
