package com.trkj.system.system_management.controller;

import com.trkj.system.system_management.entity.NoticeVo;
import com.trkj.system.system_management.service.NoticeVoService;
import com.trkj.system.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class NoticeVoController {

    @Autowired
    private NoticeVoService noticeVoService;
    /*
    *公告分页查询
     */
    @PostMapping("/a/noticeVoServicelmpl")
    public AjaxResponse selectPage(@RequestBody NoticeVo noticeVo){
        return AjaxResponse.success(noticeVoService.selectPaer(noticeVo));
    }
}
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