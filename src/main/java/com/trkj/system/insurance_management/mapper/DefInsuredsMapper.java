package com.trkj.system.insurance_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.system.insurance_management.entity.DefInsureds;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DefInsuredsMapper extends BaseMapper<DefInsureds> {
    //查询默认参保方案表id
    @Select("select DEF_INSURED_ID from DEF_INSURED ${ew.customSqlSegment}")
    DefInsureds selectDefInsureds(@Param(Constants.WRAPPER) QueryWrapper<DefInsureds> queryWrapper);

    /**
     * 根据默认参保方案表id查询
     * 默认参保方案名称数据
     * 参保方案表数据
     */
    @Select("select * from DEF_INSURED ${ew.customSqlSegment}")
    DefInsureds selectDefInsuredname(@Param(Constants.WRAPPER) QueryWrapper<DefInsureds> queryWrapper);

    /**
     * 查询方案名称
     */
    @Select("select * from DEF_INSURED ${ew.customSqlSegment}")
    List<DefInsureds> selectName(@Param(Constants.WRAPPER) QueryWrapper<DefInsureds> queryWrapper);

}
