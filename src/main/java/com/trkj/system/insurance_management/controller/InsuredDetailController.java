package com.trkj.system.insurance_management.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.system.insurance_management.entity.DefinsuredDefSchemeVo;
import com.trkj.system.insurance_management.entity.InsuredDetail;
import com.trkj.system.insurance_management.service.InsuredDetailService;
import com.trkj.system.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 参保明细表 前端控制器
 * </p>
 *
 * @author 谢海欧
 * @since 2022-02-23
 */
@RestController
public class InsuredDetailController {
    @Autowired
    private InsuredDetailService insuredDetailService;

    /**
     * 参保明细分页
     */
    @PostMapping("/insuredDetail/page")
    public AjaxResponse selectPaers(@RequestBody DefinsuredDefSchemeVo definsuredDefSchemeVo){
        return AjaxResponse.success(insuredDetailService.selectPaers(definsuredDefSchemeVo));
    }

    /**
     * 参保明细数据
     */
    @GetMapping("/insuredDetail/detail")
    public AjaxResponse selectPaerzsj(){
        return AjaxResponse.success(insuredDetailService.selectPaerzsj(null));
    }
    /**
     * 参保明细页面数据
     */
    @PostMapping("/insuredDetail/datas")
    public AjaxResponse selectDatas(@RequestBody DefinsuredDefSchemeVo definsuredDefSchemeVo){
        return AjaxResponse.success(insuredDetailService.selectDatas(definsuredDefSchemeVo));
    }

    /**
     * 查询个人参保明细页面的默认方案数据数据
     */
    @PostMapping("/insuredDetail/scheme")
    public AjaxResponse selectScheme(@RequestBody DefinsuredDefSchemeVo definsuredDefSchemeVo){
        return AjaxResponse.success(insuredDetailService.selectScheme(definsuredDefSchemeVo));
    }



}

