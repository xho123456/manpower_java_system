package com.trkj.system.approval_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.approval_management.entity.FillclockEntity;
import com.trkj.system.approval_management.entity.WorkovertimeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FillclockMapper extends BaseMapper<FillclockEntity> {
    /**
     * 查看我的补打卡审批
     * @param page
     * @return
     */
    @Select("SELECT c.AUDITFLOW_ID,c.CARD_TYPE,c.CARD_DATE,c.CARD_STATE,c.CREATED_TIME,au.AUDITFLOW_STATE,au.AUDITFLOW_TYPE,au.AUDITFLOW_TITLE," +
            "s.STAFF_NAME as STAFFNAME,ae.STAFF_NAME as STAFFNAME2,ae.AUDITFLOWDETAI_DATE,ae.AUDITFLOWDETAI_STATE" +
            " FROM CARD c LEFT JOIN AUDITFLOW au on c.AUDITFLOW_ID=au.AUDITFLOW_ID LEFT JOIN STAFF s on au.STAFF_ID=s.STAFF_ID" +
            " LEFT JOIN AUDITFLOWDETAIL ae on ae.AUDITFLOW_ID=au.AUDITFLOW_ID ${ew.customSqlSegment} ")
    IPage<FillclockEntity> fillclockMe(Page<FillclockEntity> fillclockEntityPage, @Param(Constants.WRAPPER) QueryWrapper<FillclockEntity> queryWrapper);


}
