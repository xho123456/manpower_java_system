package com.trkj.system.insurance_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.system.insurance_management.entity.DefScheme;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 默认方案表 Mapper 接口
 * </p>
 *
 * @author 谢海欧
 * @since 2022-02-20
 */
@Mapper
public interface DefSchemeMapper extends BaseMapper<DefScheme> {
    /**
     * 根据默认参保方案表id查询
     * 默认参保方案名称数据
     * 参保方案表数据
     *
     * 和根据默认参保方案表id查询对应的参保方案数据
     */
     @Select("select * from DEF_SCHEME ${ew.customSqlSegment}")
    List<DefScheme> selectDefScheme(@Param(Constants.WRAPPER)QueryWrapper<DefScheme> queryWrapper);

    /**
     * 查询参保方案表ID做删除
     */
    @Select("select DEF_SCHEME_ID from DEF_SCHEME ${ew.customSqlSegment}")
    List<DefScheme> selectDefSchemeID(@Param(Constants.WRAPPER)QueryWrapper<DefScheme> queryWrapper);

    /**
     * 根据参保方案id查询默认方案数据
     */
    @Select("select * from DEF_SCHEME ${ew.customSqlSegment}")
    List<DefScheme> selectDefSchemeshuju(@Param(Constants.WRAPPER)QueryWrapper<DefScheme> queryWrapper);
}
