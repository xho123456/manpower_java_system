package com.trkj.system.insurance_management.controller;


import com.trkj.system.insurance_management.entity.DefinsuredDefSchemeVo;
import com.trkj.system.insurance_management.entity.InsuredDetail;
import com.trkj.system.insurance_management.entity.InsuredPayment;
import com.trkj.system.insurance_management.service.InsuredPaymentService;
import com.trkj.system.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 参保方案表 前端控制器
 * </p>
 *
 * @author 谢海欧
 * @since 2022-02-22
 */
@RestController
public class InsuredPaymentController {

    @Autowired
    private InsuredPaymentService insuredPaymentService;

    /**
     * 参保人员管理分页查询
     * @param definsuredDefSchemeVo
     * @return
     */
    @PostMapping("/insuredPayment/page")
    public AjaxResponse selectPaerss(@RequestBody DefinsuredDefSchemeVo definsuredDefSchemeVo){
        return AjaxResponse.success(insuredPaymentService.selectPaerss(definsuredDefSchemeVo));
    }

    /**
     * 社保缴纳添加
     */
    @PostMapping("/insuredPayment/insert")
    public AjaxResponse insertDefInsured(@RequestBody Map<String, Object> map){
        if(insuredPaymentService.insertInsuredPaymentss(map)>0){
            return AjaxResponse.success("新增成功");
        }else {
            return AjaxResponse.success("新增失败");
        }

    }

    /**
     * 更改参保方案
     */
    @PostMapping("/insuredPayment/change")
    public AjaxResponse deletescheme(@RequestBody InsuredPayment insuredPayment){
        System.out.println("+++++++"+insuredPayment);
        if(insuredPaymentService.deletescheme(insuredPayment)>0){
            return AjaxResponse.success("更改成功");
        }else{
            return AjaxResponse.success("更改失败");
        }

    }

    /**
     * 批量删除参保
     */
    @PostMapping ("/insuredPayment/delete")
    public AjaxResponse deleteList(@RequestBody Map<String, Object> map){
        if(insuredPaymentService.deleteList(map)>0){
            return AjaxResponse.success("删除成功");
        }else {
            return AjaxResponse.success("删除失败");
        }
    }

}

