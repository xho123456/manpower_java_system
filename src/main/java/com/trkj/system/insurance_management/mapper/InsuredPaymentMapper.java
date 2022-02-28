package com.trkj.system.insurance_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.system.insurance_management.entity.DefinsuredDefSchemeVo;
import com.trkj.system.insurance_management.entity.InsuredPayment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 参保方案表 Mapper 接口
 * </p>
 *
 * @author 谢海欧
 * @since 2022-02-22
 */
@Mapper
public interface InsuredPaymentMapper extends BaseMapper<InsuredPayment> {
    /**
     * 更改社保方案
     * @param queryWrapper
     * @return
     */
    @Select("select * from INSURED_PAYMENT ${ew.customSqlSegment}")
    InsuredPayment deletescheme(@Param(Constants.WRAPPER) QueryWrapper<InsuredPayment> queryWrapper);

}
