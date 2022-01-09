package com.trkj.system.staff_management.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.staff_management.entity.*;
import com.trkj.system.staff_management.mapper.Staffmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceimpl implements StaffService {
    @Autowired
    private Staffmapper mapper;

    @Override
    public IPage<StaffEntity> findStaff(Page<StaffEntity> page) {
        return mapper.findStaff(page);
    }

    @Override
    public IPage<StaffHistoryEntity> findHistoryStaff(Page<StaffHistoryEntity> page) {
        return mapper.findHistoryStaff(page);
    }

    @Override
    public IPage<StaffEliteEntity> findEliteStaff(Page<StaffEliteEntity> page) {
        return mapper.findEliteStaff(page);
    }

    @Override
    public IPage<StaffPunishmentEntity> findPunishmentStaff(Page<StaffPunishmentEntity> page) {
        return mapper.findPunishmentStaff(page);
    }

    @Override
    public IPage<StaffRewardEntity> findRewardStaff(Page<StaffRewardEntity> page) {
        return mapper.findRewardStaff(page);
    }

    @Override
    public IPage<StaffInductionEntity> findInductionStaff(Page<StaffInductionEntity> page) {
        return mapper.findInductionStaff(page);
    }

    @Override
    public IPage<StaffGiveupInductionEntity> findgiveupInductionStaff(Page<StaffGiveupInductionEntity> page) {
        return mapper.findgiveupInductionStaff(page);
    }

    @Override
    public IPage<StaffEntity> findTurnrightStaff(Page<StaffEntity> page) {
        return mapper.findTurnrightStaff(page);
    }

    @Override
    public IPage<StaffTransferEntity> findTransferStaff(Page<StaffTransferEntity> page) {
        return mapper.findTransferStaff(page);
    }

    @Override
    public IPage<StaffEntity> findStaffById(StaffEntity staff) {
        Page<StaffEntity> page =new Page<>(staff.getCurrentPage(),staff.getPagesize());
        QueryWrapper<StaffEntity> queryWrapper=new QueryWrapper<>();

        //分页查询条件
        queryWrapper.like("s.STAFF_ID",staff.getStaffId());
        queryWrapper.eq("s.IS_DELETED",0);
        return mapper.findStaffById(page,queryWrapper);
    }

    @Override
    public IPage<StaffEntity> findStaffLikeByName(StaffEntity staff) {
        Page<StaffEntity> page =new Page<>(staff.getCurrentPage(),staff.getPagesize());
        QueryWrapper<StaffEntity> queryWrapper=new QueryWrapper<>();

        //分页查询条件
        queryWrapper.like("s.STAFF_NAME",staff.getStaffName());
        queryWrapper.eq("s.IS_DELETED",0);
        return mapper.findStaffLikeByName(page,queryWrapper);
    }


}
