package com.trkj.system.recruit_modular.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.system.recruit_modular.entity.Dept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
 * @since 2022-01-08
 */
@Mapper
public interface DeptsumMapper extends BaseMapper<Dept> {

    @Select("select * from Dept ${ew.customSqlSegment}")
    List<Dept> selectAll(@Param(Constants.WRAPPER)QueryWrapper queryWrapper);

}
