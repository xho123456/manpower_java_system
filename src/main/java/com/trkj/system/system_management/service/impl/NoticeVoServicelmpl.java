package com.trkj.system.system_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.system.system_management.entity.*;
import com.trkj.system.system_management.mapper.*;
import com.trkj.system.system_management.service.NoticeVoService;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class NoticeVoServicelmpl implements NoticeVoService {

    @Autowired
    private NoticeVoMapper noticeVoMapper;

    @Autowired
    private NoticeDeptMapper noticeDeptMapper;
    @Autowired
    private NoticeDeptVoMapper noticeDeptVoMapper;
    @Autowired
    private NoticeStaffMapper noticeStaffMapper;
    @Autowired
    private DeptsMapper deptsMapper;
    @Autowired
    private StaffsMapper staffsMapper;
    @Autowired
    private NoticeMapper noticeMapper;
    @Autowired
    private NoticesMapper noticesMapper;


    /**
     * 分页条件构造器查询公告表
     * @param noticeVo
     * @return
     */
    @Override
    public IPage<NoticeVo> selectPaer(NoticeVo noticeVo) {
        Page<NoticeVo> page =new Page<>(noticeVo.getCurrentPage(),noticeVo.getPagesize());
        QueryWrapper<NoticeVo> queryWrapper=new QueryWrapper<>();
        if(noticeVo.getNoticeTitle() != null && !noticeVo.getNoticeTitle().equals("")){
            //公告标题模糊查询
            queryWrapper.like("NOTICE_TITLE",noticeVo.getNoticeTitle());
        }
        if(noticeVo.getNoticePeople() != null && !noticeVo.getNoticePeople().equals("")){
           //公告发布人查询
            queryWrapper.like("NOTICE_PEOPLE",noticeVo.getNoticePeople());
        }
        if(noticeVo.getNoticeType()!=null && !noticeVo.getNoticeType().equals("")){
            //公告类型查询
            queryWrapper.like("NOTICE_TYPE",noticeVo.getNoticeType());
        }

        //分页查询条件
        queryWrapper.eq("IS_DELETED",0);
        return noticeVoMapper.selectPaer(page,queryWrapper);
    }

    /**
     * 公告修改方法
     * @param notice
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateNotice(Notice notice)   {
        int a=0;
        int row=noticeMapper.update(notice,new QueryWrapper<Notice>().eq("NOTICE_ID",notice.getNoticeId())
                .eq("IS_DELETED",0));
        if(row>=1){
            //删除公告部门表数据
            if(noticeDeptVoMapper.deleteNoticeDept(new QueryWrapper<NoticeDeptVo>()
                    .eq("NOTICE_ID",notice.getNoticeId()))>0){
                //删除公告员工表数据
                noticeStaffMapper.deleteNoticeStaff(new QueryWrapper<NoticeStaff>().eq("NOTICE_ID",notice.getNoticeId()));

                for (String name: notice.getDeptName()) {
                    Depts depts= deptsMapper.selectDepts1(new QueryWrapper<Depts>().eq("DEPT_NAME",name).eq("IS_DELETED",0));
                    if(depts!=null){
                           // 添加公告表
                            NoticeDept noticeDept=new NoticeDept();
                                noticeDept.setNoticeId(notice.getNoticeId());
                                noticeDept.setDeptId(Math.toIntExact(depts.getDeptId()));
                            //判断数据是否添加进数据库
                            if(noticeDeptMapper.insert(noticeDept)>0){
                                List<Staffs> list=staffsMapper.selectStaffDeptID(new QueryWrapper<Staffs>()
                                        .eq("DEPT_ID",depts.getDeptId()).eq("IS_DELETED",0));
                                for (Staffs staffs : list){
                                    if(!notice.getStaffId().equals(staffs.getStaffId())) {
                                        NoticeStaff noticeStaff = new NoticeStaff();
                                        //公告编号
                                        noticeStaff.setNoticeId(notice.getNoticeId());
                                        //员工编号
                                        noticeStaff.setStaffId(staffs.getStaffId());
                                        //查看公告员工状态
                                        noticeStaff.setNoticeState(0l);
                                        if (noticeStaffMapper.insert(noticeStaff) > 0) {
                                            a=1;
                                        }
                                    }
                                    }
                                }
                       }
                }

           }

        }
        return a;
    }

    /**
     * 表格删除
     * @param id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteNotice(Long id) {
        int delete= noticeDeptVoMapper.deleteNoticeDept(new QueryWrapper<NoticeDeptVo>().eq("NOTICE_ID" ,id ));
        if(delete>0){
           int deletStaff=noticeStaffMapper.deleteNoticeStaff(new QueryWrapper<NoticeStaff>().eq("NOTICE_ID",id));
               if(deletStaff>0){
                   noticeMapper.deleteById(id);
               }
        }
        return delete;
    }


    /**
     * 公告批量删除
     * @param id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteNoticeDeptList(ArrayList<Integer> id) {
        int notice=0;
        for(int i=0;i<id.size();i++){
            //删除公告部门
            int rows=noticeDeptMapper.deleteNoticeDeptList(new QueryWrapper<NoticeDept>().eq("NOTICE_ID" ,id.get(i)));
            if(rows>0){
                //删除公告员工
               int noticestaffs=noticeStaffMapper.deleteNoticeStaffList(new QueryWrapper<NoticeStaff>().eq("NOTICE_ID",id.get(i)));
               if(noticestaffs>0){
                       //删除公告
                      int notices = noticeMapper.deleteBatchIds(Collections.singleton(id.get(i)));
                         if(notices>0){
                              notice=1;
                         }else {
                             notice= -1;
                         }
               }else {
                       notice= -1;
                }
            }else {
                notice= -1;
            }
        }
        return notice;
    }


    /**
     * 根据公告id查询公告部门id
     * @return
     */
    @Override
    public List<NoticeDept> selectNoticeDeptID(NoticeDept noticeDept) {
        QueryWrapper<NoticeDept> wrapper = new QueryWrapper<>();
        wrapper.eq("NOTICE_ID",noticeDept.getNoticeId());
        wrapper.eq("IS_DELETED",0);
        return noticeDeptMapper.selectNoticeDeptID1(wrapper);
    }
    /**
     * 根据部门id查询部门名称
     * @param
     */
    @Override
    public List<Staffs> selectStaffId(Long deptId) {
        QueryWrapper<Staffs> wrapper = new QueryWrapper<>();
        wrapper.eq("DEPT_ID",deptId);
        wrapper.eq("IS_DELETED",0);
        return staffsMapper.selectStaffId(wrapper);
    }
    /**
     * 通过员工id查询公告员工表已读
     */
    @Override
    public List<NoticeStaff> selectNotice(Long staffId) {
        QueryWrapper<NoticeStaff> wrapper=new QueryWrapper<>();
        wrapper.eq("STAFF_ID",staffId);
        wrapper.eq("NOTICE_STATE",0);
        wrapper.eq("IS_DELETED",0);
        return noticeStaffMapper.selectNotice(wrapper);
    }

    /**
     * 通过员工查询员工数据
     */
    @Override
    public List<Staffs> selectStaff(Long staffId) {
        QueryWrapper<Staffs> wrapper=new QueryWrapper<>();
        wrapper.eq("STAFF_ID",staffId);
        wrapper.eq("IS_DELETED",0);
        return staffsMapper.selectStaff(wrapper);
    }
    /**
     * 通过员工id查询公告员工表未读
     * @param
     * @return
     */
    @Override
    public List<NoticeStaff> selectUnread(Long staffId) {
        QueryWrapper<NoticeStaff> wrapper=new QueryWrapper<>();
        wrapper.eq("STAFF_ID",staffId);
        wrapper.eq("NOTICE_STATE",1);
        wrapper.eq("IS_DELETED",0);
        return noticeStaffMapper.selectNotice(wrapper);
    }

    /**
     * 登录
     * @param staffs
     * @return
     */
    @Override
    public Staffs longs(Staffs staffs) {
        return  staffsMapper.selectStaffs(new QueryWrapper<Staffs>()
                .eq("STAFF_PHONE",staffs.getStaffPhone())
                .eq("STAFF_PASS",staffs.getStaffPass()));
    }

    /**
     * 公告新增
     * @param notices
     * @return
     */
    @Override
    public int insert(Notices notices) {
        int a=0;
        //添加公告表数据
        Notices notices1=new Notices();
        notices1.setNoticeTitle(notices.getNoticeTitle());
        notices1.setNoticeState(notices.getNoticeState());
        notices1.setNoticeType(notices.getNoticeType());
        notices1.setNoticeMatter(notices.getNoticeMatter());
        notices1.setStaffId(notices.getStaffId());
        notices1.setNoticePost(notices.getNoticePost());
        notices1.setNoticePeople(notices.getNoticePeople());
        //判断
        if(noticesMapper.insert(notices1)>0){
            for(String name:notices.getDeptName()){
                Depts depts= deptsMapper.selectDepts1(new QueryWrapper<Depts>().eq("DEPT_NAME",name).eq("IS_DELETED",0));
                Notice notice=noticeMapper.selectNotice(new QueryWrapper<Notice>().eq("NOTICE_TITLE",notices.getNoticeTitle()).eq("IS_DELETED",0));
                //添加公告部门表数据
                NoticeDept noticeDept=new NoticeDept();
                noticeDept.setNoticeId(notice.getNoticeId());
                noticeDept.setDeptId(Math.toIntExact(depts.getDeptId()));
                if(noticeDeptMapper.insert(noticeDept)>0){
                    Notice notice1=noticeMapper.selectNotice(new QueryWrapper<Notice>().eq("NOTICE_TITLE",notices.getNoticeTitle()).eq("IS_DELETED",0));
                    //查询员工id
                    List<Staffs> staffs=staffsMapper.selectStaffsID(new QueryWrapper<Staffs>().eq("DEPT_ID",depts.getDeptId()).eq("IS_DELETED",0));
                    for(int i=0; i<staffs.size();i++){
                        //添加员工信息
                        NoticeStaff noticeStaff= new NoticeStaff();
                        noticeStaff.setNoticeId(notice1.getNoticeId());
                        noticeStaff.setStaffId(staffs.get(i).getStaffId());
                        if(noticeStaffMapper.insert(noticeStaff)>0){
                            a=1;
                        }
                    }

                }
            }

        }
        return a;
    }


}
