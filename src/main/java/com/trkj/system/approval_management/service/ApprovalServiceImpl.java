package com.trkj.system.approval_management.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.approval_management.entity.*;
import com.trkj.system.approval_management.mapper.*;
import com.trkj.system.staff_management.entity.StaffEntity;
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
    private MoveOneMapper moveOneMapper;

    @Autowired
    private SalarymeMapper salarymeMapper;
    @Autowired
    private SalaryOneMapper salaryOneMapper;

    @Autowired
    private DepartureMapper departureMapper;

    @Autowired
    private DepartureOneMapper departureOneMapper;

    @Autowired
    private WorkovertimeMapper workovertimeMapper;

    @Autowired
    private WorkovertimeOneMapper workovertimeOneMapper;

    @Autowired
    private FillclockMapper fillclockMapper;

    @Autowired
    private FillclockOneMapper fillclockOneMapper;

    @Autowired
    private ErectionMapper erectionMapper;

    @Autowired
    private ErectionOneMapper erectionOneMapper;

    @Autowired
    private LeaveAudMapper leaveAudMapper;

    @Autowired
    private LeaveOneMapper leaveOneMapper;

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
        // 审批主表-申请人编号
        auditflow.setStaffId(workerVo.getStaffId());

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
                worker.setDeptId(workerVo.getDeptId());
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
    public IPage<MoveEntity> Moveapperme(MoveEntity move) {
        Page<MoveEntity> page =new Page<>(move.getCurrentPage(),move.getPageSize());
        QueryWrapper<MoveEntity> queryWrapper=new QueryWrapper<>();

        //分页查询条件
        queryWrapper.eq("ae.STAFF_NAME",move.getStaffName());
        queryWrapper.ne("au.AUDITFLOW_STATE",3);
        queryWrapper.eq("ae.AUDITFLOWDETAI_STATE",move.getAuditflowdetaiState());
        return moveMapper.Moveapperme(page,queryWrapper);
    }

    @Override
    public IPage<MoveEntity> Moveappered(MoveEntity move) {
        Page<MoveEntity> page =new Page<>(move.getCurrentPage(),move.getPageSize());
        QueryWrapper<MoveEntity> queryWrapper=new QueryWrapper<>();

        //分页查询条件
        queryWrapper.like("s.STAFF_NAME",move.getStaffName1());
        queryWrapper.eq("ae.STAFF_NAME",move.getStaffName());
        queryWrapper.ne("au.AUDITFLOW_STATE",3);
        queryWrapper.eq("ae.AUDITFLOWDETAI_STATE",move.getAuditflowdetaiState());
        return moveMapper.Moveapperme(page,queryWrapper);
    }

    @Override
    public IPage<MoveEntity> Moveappermy(MoveEntity move) {
        Page<MoveEntity> page =new Page<>(move.getCurrentPage(),move.getPageSize());
        QueryWrapper<MoveEntity> queryWrapper=new QueryWrapper<>();

        //分页查询条件
        queryWrapper.eq("s.STAFF_NAME",move.getStaffName());
        return moveMapper.Moveapperme(page,queryWrapper);
    }

    @Override
    public int addmove(MoveEntity move) {
        // 添加审批主表
        Auditflow auditflow = new Auditflow();
        //审批主表-标题
        auditflow.setAuditFlowTitle(move.getAuditflowTitle());
        // 审批主表-审批类型
        auditflow.setAuditFlowType(move.getAuditflowType());
        // 审批主表-申请人
        auditflow.setStaffName(move.getStaffName());
        // 审批主表-申请人编号
        auditflow.setStaffId(move.getStaffId());

        final var i = oneMapper.insert(auditflow);


        // 如果添加审批主表添加成功，则再去添加审批明细表
        if (i == 1) {
            // 根据员工名称（申请人）以及审批标题 查询已添加的审批主表编号
            Auditflow auditflow1 = oneMapper.selectOne(new QueryWrapper<Auditflow>()
                    .eq("STAFF_NAME", move.getStaffName())
                    .eq("AUDITFLOW_TITLE", move.getAuditflowTitle())
                    .eq("IS_DELETED", 0));

            // 添加审批明细表1
            Auditflowdetail auditflowdetail1 = new Auditflowdetail();
            // 审批明细表1-审批编号
            auditflowdetail1.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表1-审批人
            auditflowdetail1.setStaffName(move.getStaffName1());
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
            auditflowdetail2.setStaffName(move.getStaffName2());
            //审批明细表2-审核时间
            auditflowdetail2.setAuditflowdetaiDate(new Date());
            final var i2 = towMapper.insert(auditflowdetail2);

            // 添加审批明细表3
            Auditflowdetail auditflowdetail3 = new Auditflowdetail();
            // 审批明细表3-审批编号
            auditflowdetail3.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表3-审批人
            auditflowdetail3.setStaffName(move.getStaffName3());
            //审批明细表3-审核时间
            auditflowdetail3.setAuditflowdetaiDate(new Date());
            final var i3 = towMapper.insert(auditflowdetail3);
            // 如果三个审批明细表添加成功，则添加转正表
            if (i1 == 1 && i2 == 1 && i3 == 1) {
                Move move1 = new Move();
                // 调动表-审批编号
                move1.setAuditflowId(auditflow1.getAuditFlowId());
                // 调动表-员工名称
                move1.setStaffId(move.getStaffId());

                // 调动表-调动类型
                move1.setTransferType(move.getTransferType());
                // 调动前部门名称
                move1.setCreatedDeptName(move.getCreatedDeptName());
                // 调动后部门名称
                move1.setUpdatedDeptName(move.getUpdatedDeptName());
                //生效时间
                move1.setTakeEffectDate(new Date());

                move1.setCreatedTime(new Date());
                move1.setUpdatedTime(new Date());
                final val i4 = moveOneMapper.insert(move1);
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
    public MoveEntity MoveDeptName(Integer id) {
        return moveMapper.MoveDeptName(id);
    }

    @Override
    public List<MoveEntity> allDeptName() {
        return moveMapper.allDeptName();
    }

    @Override
    public IPage<SalaryincreaseEntity> Salaryme(SalaryincreaseEntity salaryincrease) {
        Page<SalaryincreaseEntity> page =new Page<>(salaryincrease.getCurrentPage(),salaryincrease.getPageSize());
        QueryWrapper<SalaryincreaseEntity> queryWrapper=new QueryWrapper<>();

        //分页查询条件
        queryWrapper.ne("au.AUDITFLOW_STATE",3);
        queryWrapper.eq("ae.STAFF_NAME",salaryincrease.getStaffName());
        queryWrapper.eq("ae.AUDITFLOWDETAI_STATE",salaryincrease.getAuditflowdetaiState());
        return salarymeMapper.Moveapperme(page,queryWrapper);
    }

    @Override
    public IPage<SalaryincreaseEntity> Salaryed(SalaryincreaseEntity salaryincrease) {
        Page<SalaryincreaseEntity> page =new Page<>(salaryincrease.getCurrentPage(),salaryincrease.getPageSize());
        QueryWrapper<SalaryincreaseEntity> queryWrapper=new QueryWrapper<>();

        //分页查询条件
        queryWrapper.like("s.STAFF_NAME",salaryincrease.getStaffName1());
        queryWrapper.ne("au.AUDITFLOW_STATE",3);
        queryWrapper.eq("ae.STAFF_NAME",salaryincrease.getStaffName());
        queryWrapper.eq("ae.AUDITFLOWDETAI_STATE",salaryincrease.getAuditflowdetaiState());
        return salarymeMapper.Moveapperme(page,queryWrapper);
    }

    @Override
    public IPage<SalaryincreaseEntity> Salarymy(SalaryincreaseEntity salaryincrease) {
        Page<SalaryincreaseEntity> page =new Page<>(salaryincrease.getCurrentPage(),salaryincrease.getPageSize());
        QueryWrapper<SalaryincreaseEntity> queryWrapper=new QueryWrapper<>();

        queryWrapper.eq("s.STAFF_NAME",salaryincrease.getStaffName());
        return salarymeMapper.Moveapperme(page,queryWrapper);
    }

    @Override
    public int addsalary(SalaryincreaseEntity salaryincrease) {
        // 添加审批主表
        Auditflow auditflow = new Auditflow();
        //审批主表-标题
        auditflow.setAuditFlowTitle(salaryincrease.getAuditflowTitle());
        // 审批主表-审批类型
        auditflow.setAuditFlowType(salaryincrease.getAuditflowType());
        // 审批主表-申请人
        auditflow.setStaffName(salaryincrease.getStaffName());
        // 审批主表-申请人编号
        auditflow.setStaffId(salaryincrease.getStaffId());

        final var i = oneMapper.insert(auditflow);


        // 如果添加审批主表添加成功，则再去添加审批明细表
        if (i == 1) {
            // 根据员工名称（申请人）以及审批标题 查询已添加的审批主表编号
            Auditflow auditflow1 = oneMapper.selectOne(new QueryWrapper<Auditflow>()
                    .eq("STAFF_NAME", salaryincrease.getStaffName())
                    .eq("AUDITFLOW_TITLE", salaryincrease.getAuditflowTitle())
                    .eq("IS_DELETED", 0));

            // 添加审批明细表1
            Auditflowdetail auditflowdetail1 = new Auditflowdetail();
            // 审批明细表1-审批编号
            auditflowdetail1.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表1-审批人
            auditflowdetail1.setStaffName(salaryincrease.getStaffName1());
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
            auditflowdetail2.setStaffName(salaryincrease.getStaffName2());
            //审批明细表2-审核时间
            auditflowdetail2.setAuditflowdetaiDate(new Date());
            final var i2 = towMapper.insert(auditflowdetail2);

            // 添加审批明细表3
            Auditflowdetail auditflowdetail3 = new Auditflowdetail();
            // 审批明细表3-审批编号
            auditflowdetail3.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表3-审批人
            auditflowdetail3.setStaffName(salaryincrease.getStaffName3());
            //审批明细表3-审核时间
            auditflowdetail3.setAuditflowdetaiDate(new Date());
            final var i3 = towMapper.insert(auditflowdetail3);
            // 如果三个审批明细表添加成功，则添加转正表
            if (i1 == 1 && i2 == 1 && i3 == 1) {
                Salary salaryincrease1 = new Salary();
                // 调薪表-审批编号
                salaryincrease1.setAuditflowId(auditflow1.getAuditFlowId());
                // 调薪表-员工名称
                salaryincrease1.setStaffName(salaryincrease.getStaffName());
                // 调薪表-部门名称
                salaryincrease1.setDeptId(salaryincrease.getDeptId());
                // 调薪表-调薪前基本工资
                salaryincrease1.setFrontSalary(salaryincrease.getFrontSalary());
                // 调薪表-调薪后基本工资
                salaryincrease1.setAfterSalary(salaryincrease.getAfterSalary());
                //调薪表-调薪生效日期
                salaryincrease1.setTakeEffectDate(salaryincrease.getTakeEffectDate());
                //备注
                salaryincrease1.setSalaryRemarks(salaryincrease.getSalaryRemarks());

                salaryincrease1.setCreatedTime(new Date());
                salaryincrease1.setUpdatedTime(new Date());
                final val i4 = salaryOneMapper.insert(salaryincrease1);

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
    public SalaryincreaseEntity salaryFixed(Integer id) {
        return salarymeMapper.salaryFixed(id);
    }


    @Override
    public IPage<DepartureEntity> departureMe(DepartureEntity departure) {
        Page<DepartureEntity> page =new Page<>(departure.getCurrentPage(),departure.getPageSize());
        QueryWrapper<DepartureEntity> queryWrapper=new QueryWrapper<>();

        //分页查询条件
        queryWrapper.eq("ae.STAFF_NAME",departure.getStaffName());
        queryWrapper.ne("au.AUDITFLOW_STATE",3);
        queryWrapper.eq("ae.AUDITFLOWDETAI_STATE",departure.getAuditflowdetaiState());
        return departureMapper.DepartureMe(page,queryWrapper);
    }

    @Override
    public IPage<DepartureEntity> departureLikeName(DepartureEntity departure) {
        Page<DepartureEntity> page =new Page<>(departure.getCurrentPage(),departure.getPageSize());
        QueryWrapper<DepartureEntity> queryWrapper=new QueryWrapper<>();

        //分页查询条件
        queryWrapper.like("s.STAFF_NAME",departure.getStaffName1());
        queryWrapper.ne("au.AUDITFLOW_STATE",3);
        queryWrapper.eq("ae.STAFF_NAME",departure.getStaffName());
        queryWrapper.eq("ae.AUDITFLOWDETAI_STATE",departure.getAuditflowdetaiState());
        return departureMapper.DepartureMe(page,queryWrapper);
    }

    @Override
    public IPage<DepartureEntity> departureMy(DepartureEntity departure) {
        Page<DepartureEntity> page =new Page<>(departure.getCurrentPage(),departure.getPageSize());
        QueryWrapper<DepartureEntity> queryWrapper=new QueryWrapper<>();

        //分页查询条件
        queryWrapper.eq("s.STAFF_NAME",departure.getStaffName());
        return departureMapper.DepartureMe(page,queryWrapper);
    }

    @Override
    public int adddeparture(DepartureEntity departure) {
        // 添加审批主表
        Auditflow auditflow = new Auditflow();
        //审批主表-标题
        auditflow.setAuditFlowTitle(departure.getAuditflowTitle());
        // 审批主表-审批类型
        auditflow.setAuditFlowType(departure.getAuditflowType());
        // 审批主表-申请人
        auditflow.setStaffName(departure.getStaffName());
        // 审批主表-申请人编号
        auditflow.setStaffId(departure.getStaffId());

        final var i = oneMapper.insert(auditflow);


        // 如果添加审批主表添加成功，则再去添加审批明细表
        if (i == 1) {
            // 根据员工名称（申请人）以及审批标题 查询已添加的审批主表编号
            Auditflow auditflow1 = oneMapper.selectOne(new QueryWrapper<Auditflow>()
                    .eq("STAFF_NAME", departure.getStaffName())
                    .eq("AUDITFLOW_TITLE", departure.getAuditflowTitle())
                    .eq("IS_DELETED", 0));

            // 添加审批明细表1
            Auditflowdetail auditflowdetail1 = new Auditflowdetail();
            // 审批明细表1-审批编号
            auditflowdetail1.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表1-审批人
            auditflowdetail1.setStaffName(departure.getStaffName1());
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
            auditflowdetail2.setStaffName(departure.getStaffName2());
            //审批明细表2-审核时间
            auditflowdetail2.setAuditflowdetaiDate(new Date());
            final var i2 = towMapper.insert(auditflowdetail2);

            // 添加审批明细表3
            Auditflowdetail auditflowdetail3 = new Auditflowdetail();
            // 审批明细表3-审批编号
            auditflowdetail3.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表3-审批人
            auditflowdetail3.setStaffName(departure.getStaffName3());
            //审批明细表3-审核时间
            auditflowdetail3.setAuditflowdetaiDate(new Date());
            final var i3 = towMapper.insert(auditflowdetail3);
            // 如果三个审批明细表添加成功，则添加离职表
            if (i1 == 1 && i2 == 1 && i3 == 1) {
                Departure departure1 = new Departure();
                // 离职表-审批编号
                departure1.setAuditflowId(auditflow1.getAuditFlowId());
                // 离职表-员工名称
                departure1.setStaffName(departure.getStaffName());
                // 离职表-部门名称
                departure1.setDeptId(departure.getDeptId());
                // 离职表-离职说明
                departure1.setQuitExplain(departure.getQuitExplain());
                // 离职表-离职类型
                departure1.setQuitType(departure.getQuitType());
                //离职申请日期
                departure1.setApplyQuitDate(new Date());
                // 转正表-转正日期
                departure1.setFormalQuitDate(departure.getFormalQuitDate());

                departure1.setCreatedTime(new Date());
                departure1.setUpdatedTime(new Date());
                final val i4 = departureOneMapper.insert(departure1);
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
    public IPage<WorkovertimeEntity> workoverMe(WorkovertimeEntity workovertime) {
        Page<WorkovertimeEntity> page =new Page<>(workovertime.getCurrentPage(),workovertime.getPageSize());
        QueryWrapper<WorkovertimeEntity> queryWrapper=new QueryWrapper<>();

        //分页查询条件
        queryWrapper.eq("ae.STAFF_NAME",workovertime.getStaffName());
        queryWrapper.ne("au.AUDITFLOW_STATE",3);
        queryWrapper.eq("ae.AUDITFLOWDETAI_STATE",workovertime.getAuditflowdetaiState());
        return workovertimeMapper.workoverMe(page,queryWrapper);
    }

    @Override
    public IPage<WorkovertimeEntity> workoverMy(WorkovertimeEntity workovertime) {
        Page<WorkovertimeEntity> page =new Page<>(workovertime.getCurrentPage(),workovertime.getPageSize());
        QueryWrapper<WorkovertimeEntity> queryWrapper=new QueryWrapper<>();

        //分页查询条件
        queryWrapper.eq("s.STAFF_NAME",workovertime.getStaffName());
        return workovertimeMapper.workoverMe(page,queryWrapper);
    }

    @Override
    public int adddworkover(WorkovertimeEntity workovertime) {
        // 添加审批主表
        Auditflow auditflow = new Auditflow();
        //审批主表-标题
        auditflow.setAuditFlowTitle(workovertime.getAuditflowTitle());
        // 审批主表-审批类型
        auditflow.setAuditFlowType(workovertime.getAuditflowType());
        // 审批主表-申请人
        auditflow.setStaffName(workovertime.getStaffName());
        // 审批主表-申请人编号
        auditflow.setStaffId(workovertime.getStaffId());

        final var i = oneMapper.insert(auditflow);


        // 如果添加审批主表添加成功，则再去添加审批明细表
        if (i == 1) {
            // 根据员工名称（申请人）以及审批标题 查询已添加的审批主表编号
            Auditflow auditflow1 = oneMapper.selectOne(new QueryWrapper<Auditflow>()
                    .eq("STAFF_NAME", workovertime.getStaffName())
                    .eq("AUDITFLOW_TITLE", workovertime.getAuditflowTitle())
                    .eq("IS_DELETED", 0));

            // 添加审批明细表1
            Auditflowdetail auditflowdetail1 = new Auditflowdetail();
            // 审批明细表1-审批编号
            auditflowdetail1.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表1-审批人
            auditflowdetail1.setStaffName(workovertime.getStaffName1());
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
            auditflowdetail2.setStaffName(workovertime.getStaffName2());
            //审批明细表2-审核时间
            auditflowdetail2.setAuditflowdetaiDate(new Date());
            final var i2 = towMapper.insert(auditflowdetail2);

            // 添加审批明细表3
            Auditflowdetail auditflowdetail3 = new Auditflowdetail();
            // 审批明细表3-审批编号
            auditflowdetail3.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表3-审批人
            auditflowdetail3.setStaffName(workovertime.getStaffName3());
            //审批明细表3-审核时间
            auditflowdetail3.setAuditflowdetaiDate(new Date());
            final var i3 = towMapper.insert(auditflowdetail3);
            // 如果三个审批明细表添加成功，则添加离职表
            if (i1 == 1 && i2 == 1 && i3 == 1) {
                Workovertime workovertime1 = new Workovertime();
                // 加班表-审批编号
                workovertime1.setAuditflowId(auditflow1.getAuditFlowId());
                // 加班表-员工名称
                workovertime1.setStaffName(workovertime.getStaffName());
                // 加班表-部门名称
                workovertime1.setDeptId(workovertime.getDeptId());
                // 加班表-加班事由
                workovertime1.setOvertimeaskMatter(workovertime.getOvertimeaskMatter());
                // 加班表-加班类型
                workovertime1.setOvertimeaskType(workovertime.getOvertimeaskType());
                //加班申请开始日期
                workovertime1.setOvertimeaskSDate(workovertime.getOvertimeaskSDate());
                //加班申请结束日期
                workovertime1.setOvertimeaskEDate(workovertime.getOvertimeaskEDate());
                // 加班总小时
                workovertime1.setOvertimeaskTotalDate(workovertime.getOvertimeaskTotalDate());

                workovertime1.setCreatedTime(new Date());
                workovertime1.setUpdatedTime(new Date());
                final val i4 = workovertimeOneMapper.insert(workovertime1);
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
    public IPage<WorkovertimeEntity> workoverLikeName(WorkovertimeEntity workovertime) {
        Page<WorkovertimeEntity> page =new Page<>(workovertime.getCurrentPage(),workovertime.getPageSize());
        QueryWrapper<WorkovertimeEntity> queryWrapper=new QueryWrapper<>();

        //分页查询条件
        queryWrapper.like("s.STAFF_NAME",workovertime.getStaffName1());
        queryWrapper.eq("ae.STAFF_NAME",workovertime.getStaffName());
        queryWrapper.ne("au.AUDITFLOW_STATE",3);
        queryWrapper.eq("ae.AUDITFLOWDETAI_STATE",workovertime.getAuditflowdetaiState());
        return workovertimeMapper.workoverMe(page,queryWrapper);
    }

    @Override
    public IPage<FillclockEntity> fillclockMe(FillclockEntity fillclock) {
        Page<FillclockEntity> page =new Page<>(fillclock.getCurrentPage(),fillclock.getPageSize());
        QueryWrapper<FillclockEntity> queryWrapper=new QueryWrapper<>();

        //分页查询条件
        queryWrapper.eq("ae.STAFF_NAME",fillclock.getStaffName());
        queryWrapper.ne("au.AUDITFLOW_STATE",3);
        queryWrapper.eq("ae.AUDITFLOWDETAI_STATE",fillclock.getAuditflowdetaiState());
        return fillclockMapper.fillclockMe(page,queryWrapper);
    }

    @Override
    public IPage<FillclockEntity> fillclockLikeName(FillclockEntity fillclock) {
        Page<FillclockEntity> page =new Page<>(fillclock.getCurrentPage(),fillclock.getPageSize());
        QueryWrapper<FillclockEntity> queryWrapper=new QueryWrapper<>();

        //分页查询条件
        queryWrapper.like("s.STAFF_NAME",fillclock.getStaffName1());
        queryWrapper.eq("ae.STAFF_NAME",fillclock.getStaffName());
        queryWrapper.ne("au.AUDITFLOW_STATE",3);
        queryWrapper.eq("ae.AUDITFLOWDETAI_STATE",fillclock.getAuditflowdetaiState());
        return fillclockMapper.fillclockMe(page,queryWrapper);
    }

    @Override
    public IPage<FillclockEntity> fillclockMy(FillclockEntity fillclock) {
        Page<FillclockEntity> page =new Page<>(fillclock.getCurrentPage(),fillclock.getPageSize());
        QueryWrapper<FillclockEntity> queryWrapper=new QueryWrapper<>();

        //分页查询条件
        queryWrapper.eq("s.STAFF_NAME",fillclock.getStaffName());
        return fillclockMapper.fillclockMe(page,queryWrapper);
    }

    @Override
    public int addfillclock(FillclockEntity fillclock) {
        // 添加审批主表
        Auditflow auditflow = new Auditflow();
        //审批主表-标题
        auditflow.setAuditFlowTitle(fillclock.getAuditflowTitle());
        // 审批主表-审批类型
        auditflow.setAuditFlowType(fillclock.getAuditflowType());
        // 审批主表-申请人
        auditflow.setStaffName(fillclock.getStaffName());
        // 审批主表-申请人编号
        auditflow.setStaffId(fillclock.getStaffId());

        final var i = oneMapper.insert(auditflow);


        // 如果添加审批主表添加成功，则再去添加审批明细表
        if (i == 1) {
            // 根据员工名称（申请人）以及审批标题 查询已添加的审批主表编号
            Auditflow auditflow1 = oneMapper.selectOne(new QueryWrapper<Auditflow>()
                    .eq("STAFF_NAME", fillclock.getStaffName())
                    .eq("AUDITFLOW_TITLE", fillclock.getAuditflowTitle())
                    .eq("IS_DELETED", 0));

            // 添加审批明细表1
            Auditflowdetail auditflowdetail1 = new Auditflowdetail();
            // 审批明细表1-审批编号
            auditflowdetail1.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表1-审批人
            auditflowdetail1.setStaffName(fillclock.getStaffName1());
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
            auditflowdetail2.setStaffName(fillclock.getStaffName2());
            //审批明细表2-审核时间
            auditflowdetail2.setAuditflowdetaiDate(new Date());
            final var i2 = towMapper.insert(auditflowdetail2);

            // 添加审批明细表3
            Auditflowdetail auditflowdetail3 = new Auditflowdetail();
            // 审批明细表3-审批编号
            auditflowdetail3.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表3-审批人
            auditflowdetail3.setStaffName(fillclock.getStaffName3());
            //审批明细表3-审核时间
            auditflowdetail3.setAuditflowdetaiDate(new Date());
            final var i3 = towMapper.insert(auditflowdetail3);
            // 如果三个审批明细表添加成功，则添加离职表
            if (i1 == 1 && i2 == 1 && i3 == 1) {
                Fillclock fillclock1 = new Fillclock();
                // 补打卡表-审批编号
                fillclock1.setAuditflowId(auditflow1.getAuditFlowId());
                // 补打卡表-员工名称
                fillclock1.setStaffName(fillclock.getStaffName());
                // 补打卡表-补打卡类型
                fillclock1.setCardType(fillclock.getCardType());
                //补打卡表时间
                fillclock1.setCardDate(fillclock.getCardDate());

                fillclock1.setCreatedTime(new Date());
                fillclock1.setUpdatedTime(new Date());
                final val i4 = fillclockOneMapper.insert(fillclock1);
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
    public IPage<ErectionEntity> erectionMe(ErectionEntity erection) {
        Page<ErectionEntity> page =new Page<>(erection.getCurrentPage(),erection.getPageSize());
        QueryWrapper<ErectionEntity> queryWrapper=new QueryWrapper<>();

        //分页查询条件
        queryWrapper.eq("ae.STAFF_NAME",erection.getStaffName());
        queryWrapper.ne("au.AUDITFLOW_STATE",3);
        queryWrapper.eq("ae.AUDITFLOWDETAI_STATE",erection.getAuditflowdetaiState());
        return erectionMapper.erectionMe(page,queryWrapper);
    }

    @Override
    public IPage<ErectionEntity> erectionLikeName(ErectionEntity erection) {
        Page<ErectionEntity> page =new Page<>(erection.getCurrentPage(),erection.getPageSize());
        QueryWrapper<ErectionEntity> queryWrapper=new QueryWrapper<>();

        //分页查询条件
        queryWrapper.like("s.STAFF_NAME",erection.getStaffName1());
        queryWrapper.eq("ae.STAFF_NAME",erection.getStaffName());
        queryWrapper.ne("au.AUDITFLOW_STATE",3);
        queryWrapper.eq("ae.AUDITFLOWDETAI_STATE",erection.getAuditflowdetaiState());
        return erectionMapper.erectionMe(page,queryWrapper);
    }

    @Override
    public IPage<ErectionEntity> erectionMy(ErectionEntity erection) {
        Page<ErectionEntity> page =new Page<>(erection.getCurrentPage(),erection.getPageSize());
        QueryWrapper<ErectionEntity> queryWrapper=new QueryWrapper<>();

        //分页查询条件
        queryWrapper.eq("s.STAFF_NAME",erection.getStaffName());
        return erectionMapper.erectionMe(page,queryWrapper);
    }

    @Override
    public int adderection(ErectionEntity erection) {
        // 添加审批主表
        Auditflow auditflow = new Auditflow();
        //审批主表-标题
        auditflow.setAuditFlowTitle(erection.getAuditflowTitle());
        // 审批主表-审批类型
        auditflow.setAuditFlowType(erection.getAuditflowType());
        // 审批主表-申请人
        auditflow.setStaffName(erection.getStaffName());
        // 审批主表-申请人编号
        auditflow.setStaffId(erection.getStaffId());

        final var i = oneMapper.insert(auditflow);


        // 如果添加审批主表添加成功，则再去添加审批明细表
        if (i == 1) {
            // 根据员工名称（申请人）以及审批标题 查询已添加的审批主表编号
            Auditflow auditflow1 = oneMapper.selectOne(new QueryWrapper<Auditflow>()
                    .eq("STAFF_NAME", erection.getStaffName())
                    .eq("AUDITFLOW_TITLE", erection.getAuditflowTitle())
                    .eq("IS_DELETED", 0));

            // 添加审批明细表1
            Auditflowdetail auditflowdetail1 = new Auditflowdetail();
            // 审批明细表1-审批编号
            auditflowdetail1.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表1-审批人
            auditflowdetail1.setStaffName(erection.getStaffName1());
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
            auditflowdetail2.setStaffName(erection.getStaffName2());
            //审批明细表2-审核时间
            auditflowdetail2.setAuditflowdetaiDate(new Date());
            final var i2 = towMapper.insert(auditflowdetail2);

            // 添加审批明细表3
            Auditflowdetail auditflowdetail3 = new Auditflowdetail();
            // 审批明细表3-审批编号
            auditflowdetail3.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表3-审批人
            auditflowdetail3.setStaffName(erection.getStaffName3());
            //审批明细表3-审核时间
            auditflowdetail3.setAuditflowdetaiDate(new Date());
            final var i3 = towMapper.insert(auditflowdetail3);
            // 如果三个审批明细表添加成功，则添加离职表
            if (i1 == 1 && i2 == 1 && i3 == 1) {
                Erection erection1 = new Erection();
                // 出差表-审批编号
                erection1.setAuditflowId(auditflow1.getAuditFlowId());
                // 出差表-员工名称
                erection1.setStaffName(erection.getStaffName());
                // 出差表-部门编号
                erection1.setDeptId(erection.getDeptId());
                // 出差表-出差地点
                erection1.setTravelPlace(erection.getTravelPlace());
                //出差事由
                erection1.setTravelMatter(erection.getTravelMatter());
                //出差开始时间
                erection1.setTravelSDate(erection.getTravelSDate());
                //出差结束时间
                erection1.setTravelEDate(erection.getTravelEDate());
                //出差总时长
                erection1.setTravelTotalDate(erection.getTravelTotalDate());

                erection1.setCreatedTime(new Date());
                erection1.setUpdatedTime(new Date());
                final val i4 = erectionOneMapper.insert(erection1);
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
    public IPage<LeaveEntity> leaverMe(LeaveEntity leave) {
        Page<LeaveEntity> page =new Page<>(leave.getCurrentPage(),leave.getPageSize());
        QueryWrapper<LeaveEntity> queryWrapper=new QueryWrapper<>();

        //分页查询条件
        queryWrapper.eq("ae.STAFF_NAME",leave.getStaffName());
        queryWrapper.ne("au.AUDITFLOW_STATE",3);
        queryWrapper.eq("ae.AUDITFLOWDETAI_STATE",leave.getAuditflowdetaiState());
        return leaveAudMapper.leaverMe(page,queryWrapper);
    }

    @Override
    public IPage<LeaveEntity> leaverLikeName(LeaveEntity leave) {
        Page<LeaveEntity> page =new Page<>(leave.getCurrentPage(),leave.getPageSize());
        QueryWrapper<LeaveEntity> queryWrapper=new QueryWrapper<>();

        //分页查询条件
        queryWrapper.like("s.STAFF_NAME",leave.getStaffName1());
        queryWrapper.eq("ae.STAFF_NAME",leave.getStaffName());
        queryWrapper.ne("au.AUDITFLOW_STATE",3);
        queryWrapper.eq("ae.AUDITFLOWDETAI_STATE",leave.getAuditflowdetaiState());
        return leaveAudMapper.leaverMe(page,queryWrapper);
    }

    @Override
    public IPage<LeaveEntity> leaverMy(LeaveEntity leave) {
        Page<LeaveEntity> page =new Page<>(leave.getCurrentPage(),leave.getPageSize());
        QueryWrapper<LeaveEntity> queryWrapper=new QueryWrapper<>();

        //分页查询条件
        queryWrapper.eq("s.STAFF_NAME",leave.getStaffName());
        return leaveAudMapper.leaverMe(page,queryWrapper);
    }

    @Override
    public int addleaver(LeaveEntity leave) {
        // 添加审批主表
        Auditflow auditflow = new Auditflow();
        //审批主表-标题
        auditflow.setAuditFlowTitle(leave.getAuditflowTitle());
        // 审批主表-审批类型
        auditflow.setAuditFlowType(leave.getAuditflowType());
        // 审批主表-申请人
        auditflow.setStaffName(leave.getStaffName());
        // 审批主表-申请人编号
        auditflow.setStaffId(leave.getStaffId());

        final var i = oneMapper.insert(auditflow);

        // 如果添加审批主表添加成功，则再去添加审批明细表
        if (i == 1) {
            // 根据员工名称（申请人）以及审批标题 查询已添加的审批主表编号
            Auditflow auditflow1 = oneMapper.selectOne(new QueryWrapper<Auditflow>()
                    .eq("STAFF_NAME", leave.getStaffName())
                    .eq("AUDITFLOW_TITLE", leave.getAuditflowTitle())
                    .eq("IS_DELETED", 0));

            // 添加审批明细表1
            Auditflowdetail auditflowdetail1 = new Auditflowdetail();
            // 审批明细表1-审批编号
            auditflowdetail1.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表1-审批人
            auditflowdetail1.setStaffName(leave.getStaffName1());
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
            auditflowdetail2.setStaffName(leave.getStaffName2());
            //审批明细表2-审核时间
            auditflowdetail2.setAuditflowdetaiDate(new Date());
            final var i2 = towMapper.insert(auditflowdetail2);

            // 添加审批明细表3
            Auditflowdetail auditflowdetail3 = new Auditflowdetail();
            // 审批明细表3-审批编号
            auditflowdetail3.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表3-审批人
            auditflowdetail3.setStaffName(leave.getStaffName3());
            //审批明细表3-审核时间
            auditflowdetail3.setAuditflowdetaiDate(new Date());
            final var i3 = towMapper.insert(auditflowdetail3);
            // 如果三个审批明细表添加成功，则添加离职表
            if (i1 == 1 && i2 == 1 && i3 == 1) {
                Leave leave1 = new Leave();
                // 请假表-审批编号
                leave1.setAuditflowId(auditflow1.getAuditFlowId());
                // 请假表-员工名称
                leave1.setStaffName(leave.getStaffName());
                // 请假表-部门编号
                leave1.setDeptId(leave.getDeptId());
                // 请假表-请假类型
                leave1.setLeaveType(leave.getLeaveType());
                //请假事由
                leave1.setLeaveMatter(leave.getLeaveMatter());
                //请假开始时间
                leave1.setLeaveSDate(leave.getLeaveSDate());
                //请假结束时间
                leave1.setLeaveEDate(leave.getLeaveEDate());
                //请假总时长
                leave1.setLeaveTotalDate(leave.getLeaveTotalDate());

                leave1.setCreatedTime(new Date());
                leave1.setUpdatedTime(new Date());
                final val i4 = leaveOneMapper.insert(leave1);
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
    public int undo(Auditflow auditflow) {
        Auditflow auditflow1 = new Auditflow();
        auditflow1.setAuditFlowId(auditflow.getAuditFlowId());
        auditflow1.setAuditFlowState(3L);

        final val i =  oneMapper.updateById(auditflow);
        if (i == 1) {
            return 1111;
        } else {
            throw new ArithmeticException("0");
        }
    }

    @Override
    public int updataAuddetail(Auditflowdetail auditflowdetail) {
        UpdateWrapper<Auditflowdetail> ew = new UpdateWrapper<>();

        final val i =  towMapper.positive(ew.set("AUDITFLOWDETAI_STATE",2).in("AUDITFLOWDETAIL_ID",auditflowdetail.getAuditflowdetailId()));
        if (i == 1) {
            UpdateWrapper<Auditflowdetail> ew1 = new UpdateWrapper<>();
            final val i2 =  towMapper.positive(ew1.set("AUDITFLOWDETAI_STATE",1).in("AUDITFLOWDETAIL_ID",auditflowdetail.getAuditflowdetailId()+1));
            if (i2 == 1) {
                return 1111;
            }else {
                throw new ArithmeticException("0");
            }
        } else {
            throw new ArithmeticException("0");
        }
    }

    @Override
    public int updataAuddetailend(Auditflowdetail auditflowdetail) {
        UpdateWrapper<Auditflowdetail> ew = new UpdateWrapper<>();

        final val i =  towMapper.positive(ew.set("AUDITFLOWDETAI_STATE",2).in("AUDITFLOWDETAIL_ID",auditflowdetail.getAuditflowdetailId()));

        if(i==1){
            UpdateWrapper<Auditflow> au = new UpdateWrapper<>();
            final val i2 = oneMapper.positive(au.set("AUDITFLOW_STATE",1).in("AUDITFLOW_ID",auditflowdetail.getAuditflowId()));
            if (i2==1){
                return 1111;
            }else {
                throw new ArithmeticException("0");
            }
        }else {
            throw new ArithmeticException("0");
        }
    }

    @Override
    public int rejected(Auditflowdetail auditflowdetail) {
        UpdateWrapper<Auditflowdetail> ew = new UpdateWrapper<>();

        final val i =  towMapper.positive(ew.set("AUDITFLOWDETAI_STATE",3).in("AUDITFLOWDETAIL_ID",auditflowdetail.getAuditflowdetailId()));

        if(i==1){
            UpdateWrapper<Auditflow> au = new UpdateWrapper<>();
            final val i2 = oneMapper.positive(au.set("AUDITFLOW_STATE",2).in("AUDITFLOW_ID",auditflowdetail.getAuditflowId()));
            if (i2==1){
                return 1111;
            }else {
                throw new ArithmeticException("0");
            }
        }else {
            throw new ArithmeticException("0");
        }
    }


}
