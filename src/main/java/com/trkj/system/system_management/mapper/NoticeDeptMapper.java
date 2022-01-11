package com.trkj.system.system_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.system.system_management.entity.Depts;
import com.trkj.system.system_management.entity.NoticeDept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface NoticeDeptMapper extends BaseMapper<NoticeDept> {
    /**
     * 批量删除公告部门数据
     * @param queryWrapper
     * @return
     */
    @Delete("DELETE FROM NOTICE_DEPT ${ew.customSqlSegment}")
    int deleteNoticeDeptList(@Param(Constants.WRAPPER) QueryWrapper<NoticeDept> queryWrapper);
}
