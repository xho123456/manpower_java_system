package com.trkj.system.workbench.controller;


import com.trkj.system.recruit_modular.entity.RecruitmentPlan;
import com.trkj.system.recruit_modular.entity.Resume;
import com.trkj.system.recruit_modular.entity.ResumeVo;
import com.trkj.system.vo.AjaxResponse;
import com.trkj.system.workbench.entity.AdattendanceSheet;
import com.trkj.system.workbench.entity.AdclockRecord;
import com.trkj.system.workbench.entity.workNotice;
import com.trkj.system.workbench.entity.workNoticeStaff;
import com.trkj.system.workbench.service.workNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    //公告表service
    @Autowired
    private workNoticeService service;

    //查询工作台公告
    @PostMapping("/workno/selectAllnos")
    public AjaxResponse selectAllnos(@RequestBody workNotice workNotice){
        return AjaxResponse.success(service.findallno(workNotice));
    }

    //查看公告后公告状态该为已读
    @PostMapping("/workno/updatedno")
    public AjaxResponse updatedno(@RequestBody workNoticeStaff workNoticeStaff) {
        if (service.updategg(workNoticeStaff)>=1){
            return AjaxResponse.success("成功");
        }else{
            return AjaxResponse.success("失败");
        }
    }

    //判断当前用户当天是否有打卡记录
    @GetMapping("/works/dakaworks")
    public AjaxResponse dakaworks(@RequestParam("id") Integer id){
            return AjaxResponse.success(service.dakwork(id));
    }

    //查询当前启用班次
    @GetMapping("/gclasses/allclasses")
    public AjaxResponse allclasses(){
        return AjaxResponse.success(service.queryClasses());
    }

    //打卡记录表数据新增：员工打卡
    @PostMapping("/record/addrecord")
    public AjaxResponse addrecord(@RequestBody AdclockRecord adclockRecord){
        if (service.addClock(adclockRecord)>=1){
            return AjaxResponse.success("成功");
        }else {
            return AjaxResponse.success("失败");
        }
    }

    //考勤表数据新增：员工打卡
    @PostMapping("/shee/addshee")
    public AjaxResponse addshee(@RequestBody AdattendanceSheet adattendanceSheet){
        if (service.addSheet(adattendanceSheet)>=1){
            return AjaxResponse.success("成功");
        }else {
            return AjaxResponse.success("失败");
        }
    }

    //查询当前用户当天的打卡记录
    @GetMapping("/works/querydkday")
    public AjaxResponse querydkday(@RequestParam("id") Integer id){
            return AjaxResponse.success(service.querybyiddays(id));
    }

    //打卡记录表数据修改
    @PostMapping("/works/isupdateddk")
    public AjaxResponse isupdateddk(@RequestBody AdclockRecord adclockRecord) {
        if (service.updatedk(adclockRecord)>=1){
            return AjaxResponse.success("成功");
        }else{
            return AjaxResponse.success("失败");
        }
    }
}

