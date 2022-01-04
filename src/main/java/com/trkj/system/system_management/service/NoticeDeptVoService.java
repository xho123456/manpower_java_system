package com.trkj.system.system_management.service;

import com.trkj.system.system_management.entity.NoticeDeptVo;

import java.util.List;

public interface NoticeDeptVoService {
    List<NoticeDeptVo> selectDeptName( NoticeDeptVo noticeId);
}
