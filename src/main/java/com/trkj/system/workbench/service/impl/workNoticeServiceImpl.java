package com.trkj.system.workbench.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.recruit_modular.entity.ResumeVo;
import com.trkj.system.workbench.entity.workNotice;
import com.trkj.system.workbench.entity.workNoticeStaff;
import com.trkj.system.workbench.mapper.workNoticeMapper;
import com.trkj.system.workbench.service.workNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 公告表 服务实现类
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-16
 */
@Service
public class workNoticeServiceImpl implements workNoticeService {
    @Autowired
    private workNoticeMapper mapper;
    //查询工作台公告
    @Override
    public IPage<workNotice> findallno(workNotice workNotice) {
        Page<workNotice> page = new Page<>(workNotice.getCurrenPage(), workNotice.getPagesize());
        QueryWrapper<workNotice> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("S.STAFF_ID",workNotice.getStaffId());
        queryWrapper.eq("N.IS_DELETED",0).orderByDesc("N.CREATED_TIME");
        return mapper.selectAllNo(page,queryWrapper);
    }

    //修改员工公告状态
    @Override
    @Transactional
    public int updategg(workNoticeStaff workNoticeStaff) {
        return mapper.updateById(workNoticeStaff);
    }
}
