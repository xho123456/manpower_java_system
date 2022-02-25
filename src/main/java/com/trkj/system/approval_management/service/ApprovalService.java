package com.trkj.system.approval_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.approval_management.entity.MoveEntity;
import com.trkj.system.approval_management.entity.PositiveEntity;
import com.trkj.system.approval_management.entity.SalaryincreaseEntity;
import com.trkj.system.approval_management.entity.WorkerVo;


public interface ApprovalService {
    IPage<PositiveEntity> positveme(Page<PositiveEntity> page);
    IPage<PositiveEntity> positveed(Page<PositiveEntity> page);

    IPage<PositiveEntity> positvemeByname(PositiveEntity positive);
    IPage<PositiveEntity> positveedByname(PositiveEntity positive);
    IPage<PositiveEntity> positvemyid(PositiveEntity positive);

    int addpositve(WorkerVo workerVo);


    IPage<MoveEntity> Moveapperme(Page<MoveEntity> page);
    IPage<MoveEntity> Moveappered(Page<MoveEntity> page);

    IPage<SalaryincreaseEntity> Salaryme(Page<SalaryincreaseEntity> page);
    IPage<SalaryincreaseEntity> Salaryed(Page<SalaryincreaseEntity> page);

}
