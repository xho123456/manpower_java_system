package com.trkj.system.insurance_management.controller;


import com.trkj.system.insurance_management.entity.DefInsured;
import com.trkj.system.insurance_management.service.DefInsuredService;
import com.trkj.system.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 默认参保方案表 前端控制器
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-19
 */
@RestController
public class DefInsuredController {

    @Autowired
    private DefInsuredService defInsuredService;

    @PostMapping("/defInsured/page")
    public AjaxResponse selectPage(@RequestBody DefInsured defInsured){
        return AjaxResponse.success(defInsuredService.selectPaer(defInsured));
    }
}

