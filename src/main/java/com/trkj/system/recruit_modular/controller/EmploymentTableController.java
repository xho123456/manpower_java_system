package com.trkj.system.recruit_modular.controller;

import com.trkj.system.recruit_modular.entity.EmploymentTableVo;
import com.trkj.system.recruit_modular.entity.Resume;
import com.trkj.system.recruit_modular.service.EmploymentTableServiceVo;
import com.trkj.system.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 录用表 前端控制器
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-13
 */
@RestController
public class EmploymentTableController {

    @Autowired
    private EmploymentTableServiceVo serviceVo;

    /**
     * 查询 以录用待接受信息
     */
    @PostMapping("/employment/selectdjs")
    public AjaxResponse findalldjs(@RequestBody EmploymentTableVo employmentTableVo){
        return AjaxResponse.success(serviceVo.findAllemployment(employmentTableVo));
    }


    /**
     * 通用：录用放弃原因
     */
    @PostMapping("/employment/updatelvy")
    public AjaxResponse updatehz(@RequestBody EmploymentTableVo employmentTableVo) {
        if (serviceVo.updatefq(employmentTableVo)>=1){
            return AjaxResponse.success("成功");
        }else{
            return AjaxResponse.success("失败");
        }
    }

}

