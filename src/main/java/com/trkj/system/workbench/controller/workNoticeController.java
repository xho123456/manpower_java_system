package com.trkj.system.workbench.controller;


import com.trkj.system.recruit_modular.entity.RecruitmentPlan;
import com.trkj.system.recruit_modular.entity.ResumeVo;
import com.trkj.system.vo.AjaxResponse;
import com.trkj.system.workbench.entity.workNotice;
import com.trkj.system.workbench.entity.workNoticeStaff;
import com.trkj.system.workbench.service.workNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 公告表 前端控制器
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-16
 */
@RestController
public class workNoticeController {

    @Autowired
    private workNoticeService service;

    //查询工作台公告
    @PostMapping("/workno/selectAllnos")
    public AjaxResponse selectAllnos(@RequestBody workNotice workNotice){
        return AjaxResponse.success(service.findallno(workNotice));
    }

    //关闭计划修改状态
    @PostMapping("/workno/updatedno")
    public AjaxResponse updatedno(@RequestBody workNoticeStaff workNoticeStaff) {
        if (service.updategg(workNoticeStaff)>=1){
            return AjaxResponse.success("成功");
        }else{
            return AjaxResponse.success("失败");
        }
    }
}

