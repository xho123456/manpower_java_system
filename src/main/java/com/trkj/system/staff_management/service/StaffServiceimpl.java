package com.trkj.system.staff_management.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.staff_management.entity.*;
import com.trkj.system.staff_management.mapper.FixedwageStaffMapper;
import com.trkj.system.staff_management.mapper.ResumeStaffMapper;
import com.trkj.system.staff_management.mapper.Staffmapper;
import com.trkj.system.staff_management.mapper.StafftowMapper;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StaffServiceimpl implements StaffService {
    @Autowired
    private Staffmapper mapper;

    @Autowired
    private StafftowMapper towMapper;

    @Autowired
    private ResumeStaffMapper resumeStaffMapper;

    @Autowired
    private FixedwageStaffMapper fixedwageStaffMapper;


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
        queryWrapper.like("r.RESUME_NAME",staff.getResumeName());
        queryWrapper.eq(" r.RESUME_ZT",8);
        return mapper.findInductionStaffById(page,queryWrapper);
    }

    @Override
    public IPage<StaffGiveupInductionEntity> findgiveupInductionStaffLikeByName(StaffGiveupInductionEntity staff) {
        Page<StaffGiveupInductionEntity> page =new Page<>(staff.getCurrentPage(),staff.getPagesize());
        QueryWrapper<StaffGiveupInductionEntity> queryWrapper=new QueryWrapper<>();

        //分页查询条件
        queryWrapper.like("r.RESUME_NAME",staff.getRESUMENAME());
        queryWrapper.eq("r.RESUME_ZT",11);
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

    @Override
    public int updateResume(StaffGiveupInductionEntity resume) {
        System.out.println("=========================-==============================");
        return mapper.updateResume(new QueryWrapper<StaffGiveupInductionEntity>().eq("RESUME_ID",resume.getRESUMEID()));
    }

    @Override
    public int addwhy(StaffGiveupInductionEntity resume) {
        UpdateWrapper<StaffGiveupInductionEntity> ew = new UpdateWrapper<>();
        return mapper.addwhy(ew.set("waive_reason",resume.getWaivereason()).in("RESUME_ID",resume.getRESUMEID()));
    }

    @Override
    public int addStaff(StaffInductionEntity staff) throws ArithmeticException {
        StaffEntity staff1 = new StaffEntity();
        staff1.setStaffBirthday(staff.getResumeBirthday());
        staff1.setStaffName(staff.getResumeName());
        staff1.setDeptId(staff.getDeptId());
        staff1.setDeptPostId(staff.getDeptPostId());
        staff1.setStaffPhone(staff.getResumePhone());
        staff1.setStaffOutlook(staff.getResumePoliticalOutlook());
        staff1.setStaffMajor(staff.getResumeHy());
        staff1.setStaffSex(staff.getResumeSex());
        staff1.setStaffEducation(staff.getResumeEducation());
        staff1.setStaffRegistered(staff.getResumeResidence());
        staff1.setStaffEmail(staff.getResumeMailbox());
        staff1.setStaffPicture(staff.getResumePhoto());
        staff1.setStaffPass("123456");
        staff1.setStaffHiredate(new Date());
        staff1.setCreatedTime(new Date());
        staff1.setUpdatedTime(new Date());
        final var i =mapper.insert(staff1);
        if (i==1){
            FixedwageEntity fixedwage = new FixedwageEntity();
            fixedwage.setFixedwagePeriodmoney(staff.getProbationary());
            fixedwage.setFixedwageOfficialmoney(staff.getPositiveMonthly());
            fixedwage.setStaffId(staff1.getStaffId());
            fixedwage.setUpdatedTime(new Date());
            fixedwage.setCreatedTime(new Date());

            final var a =fixedwageStaffMapper.insert(fixedwage);
            if (a==1){
                ResumeEntity resumeEntity =new ResumeEntity();
                resumeEntity.setResumeId(staff.getResumeId());
                resumeEntity.setResumeZt(9L);
                final var b = resumeStaffMapper.updateById(resumeEntity);
                if (b==1){
                    return 1111;
                }else {
                    throw new ArithmeticException("0");
                }
            }else {
                throw new ArithmeticException("0");
            }
        }else {
            throw new ArithmeticException("0");
        }
    }

    @Override
    public List<StaffEntity> basicstaff(Integer id) {
        return mapper.staff(id);
    }

    @Override
    public int positive(StaffEntity staff){
        return mapper.positive(new QueryWrapper<StaffEntity>().eq("STAFF_ID",staff.getStaffId()));
    }

    @Override
    public StaffEntity postName(Integer id) {
        return mapper.postName(id);
    }

}
