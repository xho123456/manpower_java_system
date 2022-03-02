package com.trkj.system.approval_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.system.approval_management.entity.Auditflowdetail;
import com.trkj.system.staff_management.entity.StaffEntity;
import com.trkj.system.staff_management.entity.StaffGiveupInductionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AuditflowTowMapper extends BaseMapper<Auditflowdetail> {
    @Update("update AUDITFLOWDETAIL set ${ew.sqlSet} ${ew.customSqlSegment} ")
    int positive(@Param(Constants.WRAPPER) UpdateWrapper<Auditflowdetail> wrapper);


}
