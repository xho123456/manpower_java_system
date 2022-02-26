package com.trkj.system.approval_management.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.approval_management.entity.*;
import com.trkj.system.approval_management.mapper.*;
import lombok.val;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ApprovalServiceImpl implements ApprovalService {
    @Autowired
    private AuditflowMapper mapper;

    @Autowired
    private AuditflowOneMapper oneMapper;

    @Autowired
    private AuditflowTowMapper towMapper;

    @Autowired
    private WorkerMapper workerMapper;

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

    /**
     * 根据名字查询转正
     */
    @Override
    public IPage<PositiveEntity> positvemeByname(PositiveEntity positive) {
        Page<PositiveEntity> page =new Page<>(positive.getCurrentPage(),positive.getPagesize());
        QueryWrapper<PositiveEntity> queryWrapper=new QueryWrapper<>();

        //分页查询条件
        queryWrapper.like("s.STAFF_NAME",positive.getStaffname1());
        queryWrapper.eq("ae.AUDITFLOWDETAI_STATE",1);
        return mapper.positvemeByname(page,queryWrapper);
    }

    @Override
    public IPage<PositiveEntity> positveedByname(PositiveEntity positive) {
        Page<PositiveEntity> page =new Page<>(positive.getCurrentPage(),positive.getPagesize());
        QueryWrapper<PositiveEntity> queryWrapper=new QueryWrapper<>();

        //分页查询条件
        queryWrapper.like("s.STAFF_NAME",positive.getStaffname1());
        queryWrapper.eq("ae.AUDITFLOWDETAI_STATE",2);
        return mapper.positvemeByname(page,queryWrapper);
    }

    @Override
    public IPage<PositiveEntity> positvemyid(PositiveEntity positive) {
        Page<PositiveEntity> page =new Page<>(positive.getCurrentPage(),positive.getPagesize());
        QueryWrapper<PositiveEntity> queryWrapper=new QueryWrapper<>();

        //分页查询条件
        queryWrapper.eq("s.STAFF_ID",positive.getStaffid());
       // queryWrapper.eq("ae.AUDITFLOWDETAI_STATE",2);
        return mapper.positvemyid(page,queryWrapper);
    }

    @Override
    public int addpositve(WorkerVo workerVo) {
        // 添加审批主表
        Auditflow auditflow = new Auditflow();
        //审批主表-标题
        auditflow.setAuditFlowTitle(workerVo.getAuditflowTitle());
        // 审批主表-审批类型
        auditflow.setAuditFlowType(workerVo.getAuditflowType());
        // 审批主表-申请人
        auditflow.setStaffName(workerVo.getStaffName());

        final var i = oneMapper.insert(auditflow);


        // 如果添加审批主表添加成功，则再去添加审批明细表
        if (i == 1) {
            // 根据员工名称（申请人）以及审批标题 查询已添加的审批主表编号
             Auditflow auditflow1 = oneMapper.selectOne(new QueryWrapper<Auditflow>()
                    .eq("STAFF_NAME", workerVo.getStaffName())
                    .eq("AUDITFLOW_TITLE", workerVo.getAuditflowTitle())
                    .eq("IS_DELETED", 0));

            // 添加审批明细表1
            Auditflowdetail auditflowdetail1 = new Auditflowdetail();
            // 审批明细表1-审批编号
            auditflowdetail1.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表1-审批人
            auditflowdetail1.setStaffName(workerVo.getStaffName1());
            // 审批明细表1-审核状态-待我审批
            auditflowdetail1.setAuditflowdetaiState(1);
            //审批明细表1-审核时间
            auditflowdetail1.setAuditflowdetaiDate(new Date());
            final var i1 = towMapper.insert(auditflowdetail1);

            // 添加审批明细表2
            Auditflowdetail auditflowdetail2 = new Auditflowdetail();
            // 审批明细表2-审批编号
            auditflowdetail2.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表2-审批人
            auditflowdetail2.setStaffName(workerVo.getStaffName2());
            //审批明细表2-审核时间
            auditflowdetail2.setAuditflowdetaiDate(new Date());
            final var i2 = towMapper.insert(auditflowdetail2);

            // 添加审批明细表3
            Auditflowdetail auditflowdetail3 = new Auditflowdetail();
            // 审批明细表3-审批编号
            auditflowdetail3.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表3-审批人
            auditflowdetail3.setStaffName(workerVo.getStaffName3());
            //审批明细表3-审核时间
            auditflowdetail3.setAuditflowdetaiDate(new Date());
            final var i3 = towMapper.insert(auditflowdetail3);
            // 如果三个审批明细表添加成功，则添加转正表
            if (i1 == 1 && i2 == 1 && i3 == 1) {
                Worker worker = new Worker();
                // 转正表-审批编号
                worker.setAuditflowId(auditflow1.getAuditFlowId());
                // 转正表-员工名称
                worker.setStaffName(workerVo.getStaffName());
                // 转正表-部门名称
                worker.setDeptname(workerVo.getDeptname());
                // 转正表-转正备注
                worker.setWorkerRemarks(workerVo.getAuditflowdetaiRemarks());
                // 转正表-转正类型
                worker.setWorkerType(workerVo.getAuditflowType());
                // 转正表-转正日期
                worker.setWorkerDate(workerVo.getWorkerdate());
                final val i4 = workerMapper.insert(worker);
                System.out.println("service2worker:  "+worker);
                if (i4 == 1) {
                    return 1111;
                } else {
                    throw new ArithmeticException("0");
                }
            } else {
                throw new ArithmeticException("0");
            }
        } else {
            throw new ArithmeticException("0");
        }
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
