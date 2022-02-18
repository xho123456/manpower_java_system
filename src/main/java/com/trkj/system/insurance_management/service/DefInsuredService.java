package com.trkj.system.insurance_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.system.insurance_management.entity.DefInsured;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 默认参保方案表 服务类
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-19
 */
public interface DefInsuredService {
    /**
     * 分页条件构造器查询参保方案表
     */
    IPage<DefInsured> selectPaer(DefInsured defInsured);
}
