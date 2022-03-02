package com.trkj.system.approval_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.approval_management.entity.*;

import java.util.List;


public interface ApprovalService {
    IPage<PositiveEntity> positveme(Page<PositiveEntity> page);
    IPage<PositiveEntity> positveed(Page<PositiveEntity> page);

    IPage<PositiveEntity> positvemeByname(PositiveEntity positive);
    IPage<PositiveEntity> positveedByname(PositiveEntity positive);
    IPage<PositiveEntity> positvemyid(PositiveEntity positive);

    int addpositve(WorkerVo workerVo);

    IPage<MoveEntity> Moveapperme(MoveEntity move);
    IPage<MoveEntity> Moveappered(MoveEntity move);
    IPage<MoveEntity> Moveappermy(MoveEntity move);
    int addmove(MoveEntity move);
    MoveEntity MoveDeptName (Integer id);
    List<MoveEntity> allDeptName ();

    IPage<SalaryincreaseEntity> Salaryme(SalaryincreaseEntity salaryincrease);
    IPage<SalaryincreaseEntity> Salaryed(SalaryincreaseEntity salaryincrease);
    IPage<SalaryincreaseEntity> Salarymy(SalaryincreaseEntity salaryincrease);
    int addsalary(SalaryincreaseEntity salaryincrease);
    SalaryincreaseEntity salaryFixed (Integer id);

    IPage<DepartureEntity> departureMe(DepartureEntity departure);
    IPage<DepartureEntity> departureLikeName(DepartureEntity departure);
    IPage<DepartureEntity> departureMy(DepartureEntity departure);
    int adddeparture(DepartureEntity departure);

    IPage<WorkovertimeEntity> workoverMe(WorkovertimeEntity workovertime);
    IPage<WorkovertimeEntity> workoverLikeName(WorkovertimeEntity workovertime);
    IPage<WorkovertimeEntity> workoverMy(WorkovertimeEntity workovertime);
    int adddworkover(WorkovertimeEntity workovertime);

    IPage<FillclockEntity> fillclockMe(FillclockEntity fillclock);
    IPage<FillclockEntity> fillclockLikeName(FillclockEntity fillclock);
    IPage<FillclockEntity> fillclockMy(FillclockEntity fillclock);
    int addfillclock(FillclockEntity fillclock);

    IPage<ErectionEntity> erectionMe(ErectionEntity erection);
    IPage<ErectionEntity> erectionLikeName(ErectionEntity erection);
    IPage<ErectionEntity> erectionMy(ErectionEntity erection);
    int adderection(ErectionEntity erection);

    IPage<LeaveEntity> leaverMe(LeaveEntity leave);
    IPage<LeaveEntity> leaverLikeName(LeaveEntity leave);
    IPage<LeaveEntity> leaverMy(LeaveEntity leave);
    int addleaver(LeaveEntity leave);

}
