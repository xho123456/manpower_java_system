package com.trkj.system.system_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.system_management.entity.NoticeDeptVo;
import com.trkj.system.system_management.entity.NoticeVo;
import com.trkj.system.system_management.mapper.NoticeDeptVoMapper;
import com.trkj.system.system_management.mapper.NoticeVoMapper;
import com.trkj.system.system_management.service.NoticeDeptVoService;
import com.trkj.system.system_management.service.NoticeVoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoticeDeptVoServicelmpl implements NoticeDeptVoService {
    @Autowired
    private NoticeDeptVoMapper noticeDeptVoMapper;

    /**
     * 公告部门表查询公告部门名称
     * @param noticeId
     * @return
     */
    @Override
    public List<NoticeDeptVo> selectDeptName(NoticeDeptVo noticeId) {
        QueryWrapper<NoticeDeptVo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("NOTICE_ID",noticeId.getNoticeId());
        return noticeDeptVoMapper.selectDeptName(queryWrapper);
    }


}


