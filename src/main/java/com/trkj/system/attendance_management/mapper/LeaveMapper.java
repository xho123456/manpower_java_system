package com.trkj.system.attendance_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.attendance_management.entity.Leave;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 请假表 Mapper 接口
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-18
 */
@Mapper
public interface LeaveMapper extends BaseMapper<Leave> {
    //查询所有请假信息
    @Select("select L.* ,A.AUDITFLOW_STATE as auditflowStaff,D.DEPT_NAME,S.STAFF_NAME as staffName1 from LEAVE L LEFT JOIN AUDITFLOW A on L.AUDITFLOW_ID = A.AUDITFLOW_ID LEFT JOIN DEPT D on D.DEPT_ID = L.DEPT_ID LEFT JOIN STAFF S ON S.STAFF_ID = L.STAFF_ID ${ew.customSqlSegment}")
    IPage<Leave> queryallqj(Page<Leave> page,@Param(Constants.WRAPPER) QueryWrapper queryWrapper);

    //统计请假次数
    @Select("select count(*) from LEAVE ${ew.customSqlSegment}")
    int leavenumber(@Param(Constants.WRAPPER) QueryWrapper queryWrapper);
}
