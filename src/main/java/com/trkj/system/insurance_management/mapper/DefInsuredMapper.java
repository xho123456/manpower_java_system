package com.trkj.system.insurance_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.insurance_management.entity.DefInsured;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 默认参保方案表 Mapper 接口
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-19
 */
@Mapper
public interface DefInsuredMapper extends BaseMapper<DefInsured> {
    /**
     * 参保方案分页查询
     * @param defInsured
     * @param queryWrapper
     * @return
     */
    @Select("select * from DEF_INSURED  ${ew.customSqlSegment}")
    IPage<DefInsured> selectPaer(Page<DefInsured> defInsured, @Param(Constants.WRAPPER)QueryWrapper<DefInsured> queryWrapper);

    /**
     * 查询参保方案名称是否唯一
     */
    @Select("select DEF_INSURED_NAME from DEF_INSURED ${ew.customSqlSegment}")
   DefInsured selectDefInsuredName(@Param(Constants.WRAPPER)QueryWrapper<DefInsured> queryWrapper);


}
