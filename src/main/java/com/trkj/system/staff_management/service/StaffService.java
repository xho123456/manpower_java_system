package com.trkj.system.staff_management.service;



import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.staff_management.entity.*;

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

}
