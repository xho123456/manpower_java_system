package com.trkj.system.system_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.system.system_management.entity.NoticeDept;
import com.trkj.system.system_management.entity.NoticeDeptVo;

import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface NoticeDeptVoMapper extends BaseMapper<NoticeDeptVo> {
    /**
     * 公告部门表查询公告部门名称
     * @param queryWrapper
     * @return
     */
    @Select("select t2.DEPT_NAME from NOTICE_DEPT t1 LEFT JOIN DEPT t2 on t1.DEPT_ID =t2.DEPT_ID ${ew.customSqlSegment}")
    List<NoticeDeptVo> selectDeptName(@Param(Constants.WRAPPER) QueryWrapper<NoticeDeptVo> queryWrapper);

    /**
     * 删除公告部门数据
     * @param queryWrapper
     * @return
     */
    @Delete("DELETE FROM NOTICE_DEPT ${ew.customSqlSegment}")
    int deleteNoticeDept(@Param(Constants.WRAPPER) QueryWrapper<NoticeDeptVo> queryWrapper);

}