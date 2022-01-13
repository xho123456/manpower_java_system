package com.trkj.system.recruit_modular.controller;


import com.trkj.system.recruit_modular.entity.Dept;
import com.trkj.system.recruit_modular.service.DeptsumService;
import com.trkj.system.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-08
 */
@RestController
@RequestMapping("/dept")
public class DeptsumController {

    @Autowired
    private DeptsumService service;

    @PostMapping("dept/selectAlldept")
    public AjaxResponse selectAlldept(){
        List<Dept> list  =service.findAlldept();
        return AjaxResponse.success(list);
    }

}

