package com.trkj.system.staff_management.service;

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


}
