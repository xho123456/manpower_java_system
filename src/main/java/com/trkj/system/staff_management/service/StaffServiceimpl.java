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

    /**   根据条件查询   */

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
        return mapper.findStaffById(page,queryWrapper);
    }

    @Override
    public IPage<StaffHistoryEntity> findHistoryStaffById(StaffHistoryEntity staff) {
        Page<StaffHistoryEntity> page =new Page<>(staff.getCurrentPage(),staff.getPagesize());
        QueryWrapper<StaffHistoryEntity> queryWrapper=new QueryWrapper<>();

        //分页查询条件
        queryWrapper.like("s.STAFF_ID",staff.getStaffId());
        queryWrapper.eq("s.IS_DELETED",1);
        return mapper.findHistoryStaffById(page,queryWrapper);
    }

    @Override
    public IPage<StaffHistoryEntity> findHistoryStaffLikeByName(StaffHistoryEntity staff) {
        Page<StaffHistoryEntity> page =new Page<>(staff.getCurrentPage(),staff.getPagesize());
        QueryWrapper<StaffHistoryEntity> queryWrapper=new QueryWrapper<>();

        //分页查询条件
        queryWrapper.like("s.STAFF_NAME",staff.getStaffName());
        queryWrapper.eq("s.IS_DELETED",1);
        return mapper.findHistoryStaffById(page,queryWrapper);
    }

    @Override
    public IPage<StaffPunishmentEntity> findPunishById(StaffPunishmentEntity staff) {
        Page<StaffPunishmentEntity> page =new Page<>(staff.getCurrentPage(),staff.getPagesize());
        QueryWrapper<StaffPunishmentEntity> queryWrapper=new QueryWrapper<>();

        //分页查询条件
        queryWrapper.like("s.STAFF_ID",staff.getStaffId());
        queryWrapper.eq("p.IS_REVOCATION",0);
        return mapper.findPunishById(page,queryWrapper);
    }

    @Override
    public IPage<StaffPunishmentEntity> findPunishLikeByName(StaffPunishmentEntity staff) {
        Page<StaffPunishmentEntity> page =new Page<>(staff.getCurrentPage(),staff.getPagesize());
        QueryWrapper<StaffPunishmentEntity> queryWrapper=new QueryWrapper<>();

        //分页查询条件
        queryWrapper.like("s.STAFF_NAME",staff.getStaffName());
        queryWrapper.eq("p.IS_REVOCATION",0);
        return mapper.findPunishById(page,queryWrapper);
    }

    @Override
    public IPage<StaffEliteEntity> findEliteStaffById(StaffEliteEntity staff) {
        Page<StaffEliteEntity> page =new Page<>(staff.getCurrentPage(),staff.getPagesize());
        QueryWrapper<StaffEliteEntity> queryWrapper=new QueryWrapper<>();

        //分页查询条件
        queryWrapper.like("s.STAFF_ID",staff.getStaffId());
        queryWrapper.ne("dp.POST_NAME","员工");
        return mapper.findEliteStaffById(page,queryWrapper);
    }

    @Override
    public IPage<StaffEliteEntity> findEliteStaffLikeByName(StaffEliteEntity staff) {
        Page<StaffEliteEntity> page =new Page<>(staff.getCurrentPage(),staff.getPagesize());
        QueryWrapper<StaffEliteEntity> queryWrapper=new QueryWrapper<>();

        //分页查询条件
        queryWrapper.like("s.STAFF_NAME",staff.getStaffName());
        queryWrapper.ne("dp.POST_NAME","员工");
        return mapper.findEliteStaffById(page,queryWrapper);
    }

    @Override
    public IPage<StaffRewardEntity> findRewardStaffById(StaffRewardEntity staff) {
        Page<StaffRewardEntity> page =new Page<>(staff.getCurrentPage(),staff.getPagesize());
        QueryWrapper<StaffRewardEntity> queryWrapper=new QueryWrapper<>();

        //分页查询条件
        queryWrapper.like("s.STAFF_ID",staff.getStaffId());
        queryWrapper.eq("s.IS_DELETED",0);
        return mapper.findRewardStaffById(page,queryWrapper);
    }

    @Override
    public IPage<StaffRewardEntity> findRewardStaffLikeByName(StaffRewardEntity staff) {
        Page<StaffRewardEntity> page =new Page<>(staff.getCurrentPage(),staff.getPagesize());
        QueryWrapper<StaffRewardEntity> queryWrapper=new QueryWrapper<>();

        //分页查询条件
        queryWrapper.like("s.STAFF_NAME",staff.getStaffName());
        queryWrapper.eq("s.IS_DELETED",0);
        return mapper.findRewardStaffById(page,queryWrapper);
    }

    @Override
    public IPage<StaffInductionEntity> findInductionStaffLikeByName(StaffInductionEntity staff) {
        Page<StaffInductionEntity> page =new Page<>(staff.getCurrentPage(),staff.getPagesize());
        QueryWrapper<StaffInductionEntity> queryWrapper=new QueryWrapper<>();

        //分页查询条件
        queryWrapper.like("r.RESUME_NAME",staff.getRESUMENAME());
        queryWrapper.eq(" r.RESUME_ZT",6);
        return mapper.findInductionStaffById(page,queryWrapper);
    }

    @Override
    public IPage<StaffGiveupInductionEntity> findgiveupInductionStaffLikeByName(StaffGiveupInductionEntity staff) {
        Page<StaffGiveupInductionEntity> page =new Page<>(staff.getCurrentPage(),staff.getPagesize());
        QueryWrapper<StaffGiveupInductionEntity> queryWrapper=new QueryWrapper<>();

        //分页查询条件
        queryWrapper.like("r.RESUME_NAME",staff.getRESUMENAME());
        queryWrapper.eq("r.RESUME_ZT",4);
        return mapper.findgiveupInductionStaffById(page,queryWrapper);
    }

    @Override
    public IPage<StaffEntity> findTurnrightStaffById(StaffEntity staff) {
        Page<StaffEntity> page =new Page<>(staff.getCurrentPage(),staff.getPagesize());
        QueryWrapper<StaffEntity> queryWrapper=new QueryWrapper<>();

        //分页查询条件
        queryWrapper.like("s.STAFF_ID",staff.getStaffId());
        queryWrapper.eq("s.IS_DELETED",0);
        queryWrapper.eq("s.STAFF_STATE",0);
        return mapper.findTurnrightStaffById(page,queryWrapper);
    }

    @Override
    public IPage<StaffEntity> findTurnrightStaffByName(StaffEntity staff) {
        Page<StaffEntity> page =new Page<>(staff.getCurrentPage(),staff.getPagesize());
        QueryWrapper<StaffEntity> queryWrapper=new QueryWrapper<>();

        //分页查询条件
        queryWrapper.like("s.STAFF_NAME",staff.getStaffName());
        queryWrapper.eq("s.IS_DELETED",0);
        queryWrapper.eq("s.STAFF_STATE",0);
        return mapper.findTurnrightStaffById(page,queryWrapper);
    }

    @Override
    public IPage<StaffTransferEntity> findTransferStaffById(StaffTransferEntity staff) {
        Page<StaffTransferEntity> page =new Page<>(staff.getCurrentPage(),staff.getPagesize());
        QueryWrapper<StaffTransferEntity> queryWrapper=new QueryWrapper<>();

        //分页查询条件
        queryWrapper.like("s.STAFF_ID",staff.getStaffId());
        queryWrapper.eq("s.IS_DELETED",0);
        return mapper.findTransferStaffById(page,queryWrapper);
    }

    @Override
    public IPage<StaffTransferEntity> findTransferStaffLikeByName(StaffTransferEntity staff) {
        Page<StaffTransferEntity> page =new Page<>(staff.getCurrentPage(),staff.getPagesize());
        QueryWrapper<StaffTransferEntity> queryWrapper=new QueryWrapper<>();

        //分页查询条件
        queryWrapper.like("s.STAFF_NAME",staff.getStaffName());
        queryWrapper.eq("s.IS_DELETED",0);
        return mapper.findTransferStaffById(page,queryWrapper);
    }


}
