package com.trkj.system.insurance_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.system.insurance_management.entity.DefInsured;
import com.trkj.system.insurance_management.entity.DefinsuredDefSchemeVo;
import com.trkj.system.insurance_management.entity.InsuredDetail;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 参保明细表 服务类
 * </p>
 *
 * @author 谢海欧
 * @since 2022-02-23
 */
public interface InsuredDetailService  {
    /**
     * 参保明细分页
     */
    IPage<DefinsuredDefSchemeVo> selectPaers(DefinsuredDefSchemeVo definsuredDefSchemeVo);

    /**
     * 参保明细数据
     */
    List<DefinsuredDefSchemeVo> selectPaerzsj(DefinsuredDefSchemeVo definsuredDefSchemeVo);

    /**
     * 参保明细数据
     */
    DefinsuredDefSchemeVo selectDatas(DefinsuredDefSchemeVo definsuredDefSchemeVo);

    /**
     * 查询个人参保明细页面的默认方案数据数据
     */
    List<DefinsuredDefSchemeVo> selectScheme(DefinsuredDefSchemeVo definsuredDefSchemeVo);


}
