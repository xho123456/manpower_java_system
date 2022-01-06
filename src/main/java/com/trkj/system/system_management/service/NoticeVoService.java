package com.trkj.system.system_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.system.system_management.entity.NoticeVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

public interface NoticeVoService{
    IPage<NoticeVo> selectPaer(NoticeVo noticeVo);
}
