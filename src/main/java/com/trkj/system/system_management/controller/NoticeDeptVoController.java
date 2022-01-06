package com.trkj.system.system_management.controller;

import com.trkj.system.system_management.entity.NoticeDeptVo;
import com.trkj.system.system_management.service.NoticeDeptVoService;
import com.trkj.system.system_management.service.NoticeVoService;
import com.trkj.system.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeDeptVoController {

    @Autowired
    private NoticeDeptVoService noticeDeptVoService;

    @PostMapping("/noticeDept/noticeDeptId")
    public AjaxResponse selectDeptName(@RequestBody NoticeDeptVo noticeDeptVo){
        return  AjaxResponse.success(noticeDeptVoService.selectDeptName(noticeDeptVo));
    }

}
