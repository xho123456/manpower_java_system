package com.trkj.system.insurance_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.system.insurance_management.entity.DefinsuredDefSchemeVo;
import com.trkj.system.insurance_management.entity.InsuredDetail;
import com.trkj.system.insurance_management.entity.InsuredPayment;

import java.util.Map;

public interface InsuredPaymentService {

        /**
         * 参保人员管理分页查询
         */
        IPage<DefinsuredDefSchemeVo> selectPaerss(DefinsuredDefSchemeVo definsuredDefSchemeVo);

        /**
         * 社保缴纳添加
         */
        int insertInsuredPaymentss(Map<String, Object> map);
        /**
         * 更改方案
         */
        int deletescheme(InsuredPayment insuredPayment);

}
