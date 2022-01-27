package com.trkj.system.recruit_modular.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.system.recruit_modular.entity.EmploymentTableVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 录用表 服务类
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-13
 */
public interface EmploymentTableServiceVo {
    /**
     * 查询 以录用待接受信息
     */
    IPage<EmploymentTableVo> findAllemployment(EmploymentTableVo employmentTableVo);

    /**
     * 录用放弃原因
     */
    int updatefq(EmploymentTableVo employmentTableVo);


}
