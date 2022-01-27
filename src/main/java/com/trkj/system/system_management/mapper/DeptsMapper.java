package com.trkj.system.system_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.system.system_management.entity.Depts;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.system.system_management.entity.NoticeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 部门表 Mapper 接口
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-04
 */
@Mapper
public interface DeptsMapper extends BaseMapper<Depts> {
    /**
     * 对话框查询所有部门名称
     * @return
     * @param queryWrapper
     */
    @Select("select * from DEPT ${ew.customSqlSegment}")
    List<Depts> selectDepts(@Param(Constants.WRAPPER) QueryWrapper<Depts> queryWrapper);

    /**
     * 查询所有部门Id
     * @param queryWrapper
     * @return
     */
    @Select("select DEPT_ID from DEPT ${ew.customSqlSegment}")
     Depts selectDepts1(@Param(Constants.WRAPPER) QueryWrapper<Depts> queryWrapper);
}
