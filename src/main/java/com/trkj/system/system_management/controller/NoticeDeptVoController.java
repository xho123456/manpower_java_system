package com.trkj.system.system_management.controller;

import com.trkj.system.system_management.entity.NoticeDeptVo;
import com.trkj.system.system_management.service.NoticeDeptVoService;
import com.trkj.system.system_management.service.NoticeVoService;
import com.trkj.system.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class NoticeDeptVoController {

    @Autowired
    private NoticeDeptVoService noticeDeptVoService;
    /**
     * 公告部门表查询公告部门名称
     * @return
     */
    @PostMapping("/noticeDept/noticeDeptId")
    public AjaxResponse selectDeptName(@RequestBody NoticeDeptVo noticeDeptVo){
        return  AjaxResponse.success(noticeDeptVoService.selectDeptName(noticeDeptVo));
    }

//    /**
//     * 删除公告部门表数据
//     *
//     */
//    @GetMapping("/noticeDept/deleteNoticeDept")
//    public AjaxResponse deleteNoticeDept( int id){
//        System.out.println("前台相应数据"+id);
//        if(noticeDeptVoService.deleteNoticeDept(id)>0){
//            return AjaxResponse.success("删除成功");
//        }else {
//            return AjaxResponse.success("删除失败");
//        }
//    }

}
