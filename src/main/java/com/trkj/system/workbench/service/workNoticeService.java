package com.trkj.system.workbench.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.system.workbench.entity.workNotice;
import com.trkj.system.workbench.entity.workNoticeStaff;

/**
 * <p>
 * 公告表 服务类
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-16
 */
public interface workNoticeService {

    //查询工作台公告
    IPage<workNotice> findallno(workNotice workNotice);

    //修改员工公告状态
    int updategg(workNoticeStaff workNoticeStaff);
}
