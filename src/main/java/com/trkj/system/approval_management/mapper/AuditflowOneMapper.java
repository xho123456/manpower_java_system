package com.trkj.system.approval_management.mapper;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.system.approval_management.entity.Auditflow;
import com.trkj.system.approval_management.entity.Auditflowdetail;
import com.trkj.system.approval_management.entity.PositiveEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AuditflowOneMapper extends BaseMapper<Auditflow> {
    @Update("update AUDITFLOW set ${ew.sqlSet} ${ew.customSqlSegment} ")
    int positive(@Param(Constants.WRAPPER) UpdateWrapper<Auditflow> wrapper);

}
