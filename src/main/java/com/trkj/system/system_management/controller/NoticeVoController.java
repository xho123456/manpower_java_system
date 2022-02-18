package com.trkj.system.system_management.controller;

import com.trkj.system.system_management.entity.*;
import com.trkj.system.system_management.service.NoticeVoService;
import com.trkj.system.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.filter.OrderedHiddenHttpMethodFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NoticeVoController {

    @Bean
    public OrderedHiddenHttpMethodFilter hiddenHttpMethodFilter(){
        return new OrderedHiddenHttpMethodFilter();
    }

    @Autowired
    private NoticeVoService noticeVoService;



    /**
     * 分页查询
     */
    @PostMapping("/a/noticeVoServicelmpl")
    public AjaxResponse selectPage(@RequestBody NoticeVo noticeVo){
        return AjaxResponse.success(noticeVoService.selectPaer(noticeVo));
    }
    /**
     * 公告修改方法
     * @param notice
     * @return
     */

    @PutMapping("/notice/noticeId")
    public AjaxResponse updateNotice(@RequestBody Notice notice){
        if(noticeVoService.updateNotice(notice)>0){
            return AjaxResponse.success("修改成功");
        }else {
            return AjaxResponse.success("修改失败");
        }
    }


    /**
     * 表格删除公告
     */
    @DeleteMapping("/notice/{id}")
    public AjaxResponse deleteNotice(@PathVariable("id") Long id){
        if(noticeVoService.deleteNotice(id)>0) {
            return AjaxResponse.success("删除成功");
        }else {
            return AjaxResponse.success("删除失败");
        }
    }

    /**
     * 批量删除
     * @param id
     * @return
     */
    @DeleteMapping("/notice/list")
    public AjaxResponse deleteNoticeDeptList(@RequestBody ArrayList<Integer> id){
      if(noticeVoService.deleteNoticeDeptList(id)>0){
          return AjaxResponse.success("删除成功");
      }else {
          return AjaxResponse.success("删除失败");
      }
    }


    /**
     * 查询未看员工
     * @param noticeDept
     * @return
     */
    @PostMapping("/notice/selectNoticeID")
    public AjaxResponse selectNoticeDeptID(@RequestBody NoticeDept noticeDept){
        //声明员工集合存放员工编号
        ArrayList<Staffs> staffs = new ArrayList<>();
        ArrayList<Staffs> staffss = new ArrayList<>();
        //声明公告员工集合存放员工编号
        ArrayList<NoticeStaff> noticeStaffs= new ArrayList<>();
        List list =noticeVoService.selectNoticeDeptID(noticeDept);
        //循环出部门id
        for (int i = 0; i<list.size();i++){
            NoticeDept noticeDept1= (NoticeDept) list.get(i);
            int deptId =noticeDept1.getDeptId();
            //将员工id添加list集合
            List<Staffs> Staffs =noticeVoService.selectStaffId((long) deptId);
            //通过员工id循环出员工数据
            for (Staffs one: Staffs) {
                //将员工数据添加到 ArrayList<Staffs>
                staffs.add( one);
            }
        }
        for(Staffs two : staffs){
            Long noticeStaffs1=two.getStaffId();
            List<NoticeStaff> listNoticeStaff=noticeVoService.selectNotice(noticeStaffs1);
            for(NoticeStaff three : listNoticeStaff){
                noticeStaffs.add(three);
            }
        }
        for(NoticeStaff staff : noticeStaffs){
            Long staffs1=staff.getStaffId();
            List<Staffs> listStaff=noticeVoService.selectStaff(staffs1);
            for(Staffs six : listStaff){
                staffss.add(six);
            }
        }
        return AjaxResponse.success(staffss);
    }

    /**
     * 查询已看员工
     * @param noticeDept
     * @return
     */
    @PostMapping("/notice/selectUnread")
    public AjaxResponse selectUnread(@RequestBody NoticeDept noticeDept){
        //声明员工集合存放员工编号
        ArrayList<Staffs> staffs = new ArrayList<>();
        ArrayList<Staffs> staffss = new ArrayList<>();
        //声明公告员工集合存放员工编号
        ArrayList<NoticeStaff> noticeStaffs= new ArrayList<>();
        List list =noticeVoService.selectNoticeDeptID(noticeDept);
        //循环出部门id
        for (int i = 0; i<list.size();i++){
            NoticeDept noticeDept1= (NoticeDept) list.get(i);
            int deptId =noticeDept1.getDeptId();
            //将员工id添加list集合
            List<Staffs> Staffs =noticeVoService.selectStaffId((long) deptId);
            //通过员工id循环出员工数据
            for (Staffs one: Staffs) {
                //将员工数据添加到 ArrayList<Staffs>
                staffs.add( one);
            }
        }
        for(Staffs two : staffs){
            Long noticeStaffs1=two.getStaffId();
            List<NoticeStaff> listNoticeStaff=noticeVoService.selectUnread(noticeStaffs1);
            for(NoticeStaff three : listNoticeStaff){
                noticeStaffs.add(three);
            }
        }
        for(NoticeStaff staff : noticeStaffs){
            Long staffs1=staff.getStaffId();
            List<Staffs> listStaff=noticeVoService.selectStaff(staffs1);
            for(Staffs six : listStaff){
                staffss.add(six);
            }
        }
        return AjaxResponse.success(staffss);
    }

    /**
     * 判断登录数据是否和数据库一致
     */
        @PostMapping("/staffs/login")
    public AjaxResponse selectStaffs(@RequestBody Staffs staffs){
        Staffs staffs1=noticeVoService.selectStaffs(staffs);
            System.out.println(staffs1);
        if(staffs1.getStaffPass().equals(staffs.getStaffPass())){
            return AjaxResponse.success(staffs1);
        }else {
            return AjaxResponse.success("失败");
        }
    }

    /**
     * 公告新增
     */
    @PostMapping("/notices/insert")
    public AjaxResponse inserts(@RequestBody Notices notices){
        if(noticeVoService.insert(notices)>0){
            return AjaxResponse.success("新增成功");
        }else {
            return AjaxResponse.success("新增失败");
        }

    }

}



