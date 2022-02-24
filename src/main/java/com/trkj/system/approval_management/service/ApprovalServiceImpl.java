package com.trkj.system.approval_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.approval_management.entity.MoveEntity;
import com.trkj.system.approval_management.entity.PositiveEntity;
import com.trkj.system.approval_management.entity.SalaryincreaseEntity;
import com.trkj.system.approval_management.mapper.AuditflowMapper;
import com.trkj.system.approval_management.mapper.MoveMapper;
import com.trkj.system.approval_management.mapper.SalarymeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApprovalServiceImpl implements ApprovalService {
    @Autowired
    private AuditflowMapper mapper;

    @Autowired
    private MoveMapper moveMapper;

    @Autowired
    private SalarymeMapper salarymeMapper;

    @Override
    public IPage<PositiveEntity> positveme(Page<PositiveEntity> page) {
        return mapper.positveme(page);
    }

    @Override
    public IPage<PositiveEntity> positveed(Page<PositiveEntity> page) {
        return mapper.positveed(page);
    }

    @Override
    public IPage<MoveEntity> Moveapperme(Page<MoveEntity> page) {
        return moveMapper.Moveapperme(page);
    }

    @Override
    public IPage<MoveEntity> Moveappered(Page<MoveEntity> page) {
        return moveMapper.Moveappered(page);
    }

    @Override
    public IPage<SalaryincreaseEntity> Salaryme(Page<SalaryincreaseEntity> page) {
        return salarymeMapper.Salaryme(page);
    }

    @Override
    public IPage<SalaryincreaseEntity> Salaryed(Page<SalaryincreaseEntity> page) {
        return salarymeMapper.Salaryed(page);
    }
}
