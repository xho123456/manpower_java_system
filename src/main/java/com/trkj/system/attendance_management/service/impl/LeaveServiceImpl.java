package com.trkj.system.attendance_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.attendance_management.entity.Classes;
import com.trkj.system.attendance_management.entity.Leave;
import com.trkj.system.attendance_management.mapper.LeaveMapper;
import com.trkj.system.attendance_management.service.LeaveService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 请假表 服务实现类
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-18
 */
@Service
public class LeaveServiceImpl implements LeaveService {
    @Autowired
    private LeaveMapper mapper;
    //查询所有请假信息
    @Override
    public IPage<Leave> selectAllqj(Leave leave) {
        Page<Leave> pageqj = new Page<>(leave.getCurrenPage(), leave.getPagesize());
        QueryWrapper<Leave> wrapperqj = new QueryWrapper<>();
        wrapperqj.eq("L.IS_DELETED",0);
        return mapper.queryallqj(pageqj,wrapperqj);
    }
    //统计请假次数
    @Override
    public int querynumber(Leave leave) {
        QueryWrapper<Leave> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("IS_DELETED",0);
        return mapper.leavenumber(wrapper1);
    }
}
