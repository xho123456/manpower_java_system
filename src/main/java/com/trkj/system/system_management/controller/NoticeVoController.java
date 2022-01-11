package com.trkj.system.system_management.controller;

import com.trkj.system.system_management.entity.Notice;
import com.trkj.system.system_management.entity.NoticeDeptVo;
import com.trkj.system.system_management.entity.NoticeVo;
import com.trkj.system.system_management.service.NoticeDeptVoService;
import com.trkj.system.system_management.service.NoticeVoService;
import com.trkj.system.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.filter.OrderedHiddenHttpMethodFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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


    @DeleteMapping("/notice/list")
    public AjaxResponse deleteNoticeDeptList(@RequestBody ArrayList<Integer> id){
      if(noticeVoService.deleteNoticeDeptList(id)>0){
          return AjaxResponse.success("删除成功");
      }else {
          return AjaxResponse.success("删除失败");
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