package com.trkj.system.system_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.system.system_management.entity.*;

import java.util.ArrayList;
import java.util.List;


public interface NoticeVoService{
    /**
     * 分页条件构造器查询公告表
     * @param noticeVo
     * @return
     */
    IPage<NoticeVo> selectPaer(NoticeVo noticeVo);


    /**
     * 公告修改方法
     * @param notice
     * @return
     */
    int updateNotice(Notice notice);

    /**
     * 删除公告
     */
    int deleteNotice(Long id);

    /**
     * 公告批量删除
     * 批量删除公告部门数据
     */
    int deleteNoticeDeptList(ArrayList<Integer> id);

//    /**
//     * 查询某个部门下的所有员工
//     * @return
//     */
//    List<Staffs> selectStaffDeptID();
//
//    /**
//     * 删除公告部门数据
//     */
//    int deleteNoticeDept(int noticeDeptVo);
//    /**
//     * 添加公告数据
//     */
   // int insertNoticeDept(NoticeDeptVo noticeDeptVo);
//    /**
//     * 删除公告员工表数据
//     */
//    int deleteNoticeStaff(int id);
//
//    /**
//     * 添加公告员工表数据
//     * @param noticeStaff
//     * @return
//     */
//    int insertNoticeStaff(NoticeStaff noticeStaff);
}
