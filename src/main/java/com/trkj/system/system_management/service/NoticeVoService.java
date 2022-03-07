package com.trkj.system.system_management.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.system.system_management.entity.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public interface NoticeVoService{
    /**
     * 分页条件构造器查询公告表
     */
    IPage<NoticeVo> selectPaer(NoticeVo noticeVo);


    /**
     * 公告修改方法
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

    /**
     * 根据公告id查询公告部门id
     */
    List<NoticeDept> selectNoticeDeptID(NoticeDept noticeDept);

    /**
     * 根据部门id查询员工数据
     */
    List<Staffs> selectStaffId(Long deptId);

    /**
     * 通过员工id查询公告员工表已读
     */
    List<NoticeStaff> selectNotice(Long staffId);

    /**
     * 通过员工查询员工数据
     */
    List<Staffs> selectStaff(Long staffId);

    /**
     * 通过员工id查询公告员工表未读
     * @param
     * @return
     */
    List<NoticeStaff> selectUnread (Long staffId);

    /**
     * 判断登录数据是否和数据库一致
     */
    Staffs longs(Staffs staffs);

    /**
     * 添加公告
     */
    int insert(Map<String, Object> map);



//    /**
//     * 通过公告发布时间查看公告id
//     */
//    NoticeVo selectTime(NoticeVo noticeVo);
}
