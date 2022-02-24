package com.trkj.system.workbench.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.workbench.entity.*;
import com.trkj.system.workbench.mapper.AdattendanceSheetMapper;
import com.trkj.system.workbench.mapper.AdclockRecordMapper;
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
    //公告mapper
    @Autowired
    private workNoticeMapper mapper;
    //考勤mapper
    @Autowired
    private AdattendanceSheetMapper mappershee;
    //打卡记录mapper
    @Autowired
    private AdclockRecordMapper mapperrecord;

    //查询工作台公告
    @Override
    public IPage<workNotice> findallno(workNotice workNotice) {
        Page<workNotice> page = new Page<>(workNotice.getCurrenPage(), workNotice.getPagesize());
        QueryWrapper<workNotice> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("S.STAFF_ID",workNotice.getStaffId());
        queryWrapper.eq("N.IS_DELETED",0).orderByDesc("N.CREATED_TIME");
        return mapper.selectAllNo(page,queryWrapper);
    }

    //查看公告后公告状态该为已读
    @Override
    @Transactional
    public int updategg(workNoticeStaff workNoticeStaff) {
        return mapper.updateById(workNoticeStaff);
    }

    //判断当前用户当天是否有打卡记录
    @Override
    public GclockRecord dakwork(Integer id) {
        return mapper.demodagowork(id);
    }

    //查询当前启用班次
    @Override
    @Transactional
    public Gclasses queryClasses() {
        return mapper.queryallclasses();
    }

    //打卡记录表数据新增：员工打卡
    @Override
    public int addClock(AdclockRecord adclockRecord) {
        return mapperrecord.insert(adclockRecord);
    }

    //考勤表数据新增：员工打卡
    @Override
    @Transactional
    public int addSheet(AdattendanceSheet adattendanceSheet) {
        return mappershee.insert(adattendanceSheet);
    }

    //查询当前用户当天的打卡记录
    @Override
    public AdclockRecord querybyiddays(Integer id) {
        return mapperrecord.querybyidday(id);
    }

    //打卡记录表数据修改
    @Transactional
    @Override
    public int updatedk(AdclockRecord adclockRecord) {
        return mapperrecord.updateById(adclockRecord);
    }
}
