package com.trkj.system.system_management.controller;


import com.trkj.system.system_management.entity.Depts;
import com.trkj.system.system_management.service.DeptsService;
import com.trkj.system.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-04
 */
@RestController
public class DeptsController {
    @Autowired
    private DeptsService deptsService;
    /**
     * 对话框查询所有部门名称
     * @return
     */
    @GetMapping("/depts/selectDepts")
    public AjaxResponse slectDepts(){
        return AjaxResponse.success(deptsService.selectDepts());
    }
}

