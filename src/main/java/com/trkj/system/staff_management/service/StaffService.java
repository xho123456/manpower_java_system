package com.trkj.system.staff_management.service;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.staff_management.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 29447
 */
public interface StaffService {
   IPage<StaffEntity> findStaff(Page<StaffEntity> page);
   IPage<StaffHistoryEntity> findHistoryStaff(Page<StaffHistoryEntity> page);
   IPage<StaffEliteEntity> findEliteStaff(Page<StaffEliteEntity> page);
   IPage<StaffPunishmentEntity> findPunishmentStaff(Page<StaffPunishmentEntity> page);
   IPage<StaffRewardEntity> findRewardStaff(Page<StaffRewardEntity> page);
   IPage<StaffInductionEntity> findInductionStaff(Page<StaffInductionEntity> page);
   IPage<StaffGiveupInductionEntity> findgiveupInductionStaff(Page<StaffGiveupInductionEntity> page);
   IPage<StaffEntity> findTurnrightStaff(Page<StaffEntity> page);
   IPage<StaffTransferEntity> findTransferStaff(Page<StaffTransferEntity> page);

   IPage<StaffEntity> findStaffById(StaffEntity staff);
   IPage<StaffEntity> findStaffLikeByName(StaffEntity staff);

   IPage<StaffHistoryEntity> findHistoryStaffById(StaffHistoryEntity staff);
   IPage<StaffHistoryEntity> findHistoryStaffLikeByName(StaffHistoryEntity staff);

   IPage<StaffPunishmentEntity> findPunishById(StaffPunishmentEntity staff);
   IPage<StaffPunishmentEntity> findPunishLikeByName(StaffPunishmentEntity staff);

   IPage<StaffEliteEntity> findEliteStaffById(StaffEliteEntity staff);
   IPage<StaffEliteEntity> findEliteStaffLikeByName(StaffEliteEntity staff);

   IPage<StaffRewardEntity> findRewardStaffById(StaffRewardEntity staff);
   IPage<StaffRewardEntity> findRewardStaffLikeByName(StaffRewardEntity staff);

   IPage<StaffInductionEntity> findInductionStaffLikeByName(StaffInductionEntity staff);

   IPage<StaffGiveupInductionEntity> findgiveupInductionStaffLikeByName(StaffGiveupInductionEntity staff);

   IPage<StaffEntity> findTurnrightStaffById(StaffEntity staff);
   IPage<StaffEntity> findTurnrightStaffByName(StaffEntity staff);

   IPage<StaffTransferEntity> findTransferStaffById(StaffTransferEntity staff);
   IPage<StaffTransferEntity> findTransferStaffLikeByName(StaffTransferEntity staff);
}
