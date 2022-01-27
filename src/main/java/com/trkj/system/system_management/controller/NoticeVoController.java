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
        if(staffs1.getStaffPass().equals(staffs.getStaffPass())){
            return AjaxResponse.success(staffs1);
        }else {
            return AjaxResponse.success("失败");
        }
    }

}



//    @PutMapping("/notice/noticeId")
//    public int updataNotice(@RequestBody NoticeVo noticeVo){
//        System.out.println("飞机哈警方哈克"+noticeVo);
//        noticeVo.setNoticeTitle(noticeVo.getNoticeTitle());
//        noticeVo.setNoticeType(noticeVo.getNoticeType());
//        noticeVo.setNoticeState(noticeVo.getDeptState());
//        noticeVo.setNoticeMatter(noticeVo.getNoticeMatter());
//        int i = noticeVoService.updataNottce(noticeVo);
//        if (i>=4){
//            return 999;
//        }else {
//            return 666;
//        }
//    }




//@GetMapping("/a/noticeObjectVoServicelmpl")
//public AjaxResponse selePage(@RequestParam("currentPage") int page, @RequestParam("pagesize")int size,
//@RequestParam(defaultValue = "0") int type,
//@RequestParam(defaultValue = "''") String noticePeople,
//@RequestParam(defaultValue = "") String notice) {
//        System.out.println("type："+type+"\n"+"oticePeople："+noticePeople+"\n"+"notice："+notice);
//        QueryWrapper<Notice> wrapper=new QueryWrapper<>();
//        wrapper.like("notice_title",notice).or()
//        .like("notice_type",type).or().
//        like("notice_people",noticePeople);
//
////            wrapper.like("notice_type",type)
////                    .or().
////                    like("notice_title",notice).or().
////                    like("notice_people",oticePeople);
////        wrapper.eq("notice_title","重要公告");
//        return AjaxResponse.success(noticeVoService.selectPaer(new Page<Notice>(page,size),wrapper));
//        }