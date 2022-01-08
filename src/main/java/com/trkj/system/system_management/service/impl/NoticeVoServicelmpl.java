package com.trkj.system.system_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.system.system_management.entity.NoticeVo;
import com.trkj.system.system_management.mapper.NoticeVoMapper;
import com.trkj.system.system_management.service.NoticeVoService;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

@Service
public class NoticeVoServicelmpl implements NoticeVoService {

    @Autowired
    private NoticeVoMapper noticeVoMapper;

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
}
