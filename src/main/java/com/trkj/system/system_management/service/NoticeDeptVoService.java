package com.trkj.system.system_management.service;

import com.trkj.system.system_management.entity.NoticeDeptVo;

import java.util.List;

public interface NoticeDeptVoService {
    /**
     * 公告部门表查询公告部门名称
     * @param noticeId
     * @return
     */
    List<NoticeDeptVo> selectDeptName( NoticeDeptVo noticeId);



}
