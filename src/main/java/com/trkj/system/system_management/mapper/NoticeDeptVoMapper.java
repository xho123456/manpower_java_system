package com.trkj.system.system_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.system.system_management.entity.NoticeDeptVo;
import com.trkj.system.system_management.entity.NoticeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface NoticeDeptVoMapper extends BaseMapper<NoticeDeptVo> {
    @Select("select t2.DEPT_NAME from NOTICE_DEPT t1 LEFT JOIN DEPT t2 on t1.DEPT_ID =t2.DEPT_ID ${ew.customSqlSegment}")
    List<NoticeDeptVo> selectDeptName(@Param(Constants.WRAPPER) QueryWrapper<NoticeDeptVo> queryWrapper);
}