package com.trkj.system.staff_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.staff_management.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface Staffmapper extends BaseMapper<StaffEntity> {
    /**
     * 查看所有员工
     * */
    @Select(" SELECT s.STAFF_NAME,s.STAFF_ID,s.STAFF_SEX,s.STAFF_IDENTITY,d.DEPT_NAME,dp.POST_NAME," +
            "  s.STAFF_PHONE,s.STAFF_OUTLOOK,s.STAFF_HIREDATE,s.STAFF_STATE " +
            "  FROM  STAFF s  LEFT JOIN dept d on d.DEPT_ID=s.DEPT_ID LEFT JOIN DEPT_POST dp on dp.DEPT_POST_ID=s.DEPT_POST_ID"+
            "  where s.IS_DELETED=0 " )
    IPage<StaffEntity> findStaff(Page<StaffEntity> page);

    /**
     * 查看离职员工
     */
    @Select(" SELECT s.STAFF_NAME,s.STAFF_ID,d.DEPT_NAME,dp.POST_NAME,s.STAFF_PHONE," +
            "s.staff_Email,s.STAFF_HIREDATE,q.FORMAL_QUIT_DATE,q.QUIT_EXPLAIN," +
            "TRUNC((TO_CHAR(q.FORMAL_QUIT_DATE,'yyyy')-TO_CHAR(s.STAFF_HIREDATE,'yyyy'))) as gl " +
            "FROM  QUIT q LEFT JOIN  STAFF s on q.STAFF_ID=s.STAFF_ID LEFT JOIN dept d on d.DEPT_ID=q.DEPT_ID " +
            "LEFT JOIN DEPT_POST dp on dp.DEPT_POST_ID=s.DEPT_POST_ID  where s.IS_DELETED=1 " )
    IPage<StaffHistoryEntity> findHistoryStaff(Page<StaffHistoryEntity> page);

    /**
     * 查看精英员工
     */
    @Select("SELECT s.STAFF_ID,s.STAFF_NAME,s.STAFF_HIREDATE,s.STAFF_PHONE,s.STAFF_EMAIL,s.STAFF_OUTLOOK,s.STAFF_EDUCATION," +
            "s.STAFF_SCHOOL,d.DEPT_NAME,dp.POST_NAME FROM STAFF s LEFT JOIN DEPT d on s.DEPT_ID=d.DEPT_ID LEFT JOIN " +
            "DEPT_POST dp on dp.DEPT_POST_ID=s.DEPT_POST_ID WHERE dp.POST_NAME != '员工' ")
    IPage<StaffEliteEntity> findEliteStaff(Page<StaffEliteEntity> page);

    /**
     * 查询所有获奖员工
     */
    @Select("SELECT g.GLORY_NAME,g.GLORY_UNITNAME,g.GLORY_REMARK,g.CREATED_TIME,s.STAFF_ID,s.STAFF_NAME,d.DEPT_NAME,dp.POST_NAME" +
            " FROM GLORY g,STAFF s,DEPT d,DEPT_POST dp WHERE " +
            " g.STAFF_ID=s.STAFF_ID and d.DEPT_ID=s.DEPT_ID and dp.DEPT_POST_ID=s.DEPT_POST_ID " )
    IPage<StaffRewardEntity> findRewardStaff(Page<StaffRewardEntity> page);

    /**
     * 查看所有惩罚的员工
     */
    @Select("SELECT p.CREATED_TIME,p.PUNISH_CAUSE,p.PUNISH_TYPE,p.PUNISH_UNIT,d.DEPT_NAME,s.STAFF_ID," +
            "s.STAFF_NAME,dp.POST_NAME FROM PUNISH p," +
            "dept d,STAFF s,DEPT_POST dp WHERE p.STAFF_ID=s.STAFF_ID and d.DEPT_ID=s.DEPT_ID and dp.DEPT_POST_ID=s.DEPT_POST_ID " +
            " and p.IS_REVOCATION=0 ")
    IPage<StaffPunishmentEntity> findPunishmentStaff(Page<StaffPunishmentEntity> page);

    /**
     * 查看所有待入职的员工
     */
    @Select("SELECT r.RESUME_ID,r.RESUME_PHOTO,r.RESUME_HY, r.RESUME_ZT,r.RESUME_NAME,r.RESUME_SEX,r.RESUME_EDUCATION," +
            "r.RESUME_PHONE,r.RESUME_MAILBOX," +
            "r.RESUME_BIRTHDAY,r.RESUME_RESIDENCE,r.RESUME_POLITICAL_OUTLOOK,d.DEPT_NAME,dp.POST_NAME " +
            "FROM EMPLOYMENT_TABLE et LEFT JOIN RESUME r on et.RESUME_ID=r.RESUME_ID LEFT JOIN RECRUITMENT_PLAN rp " +
            "on rp.RECRUITMENT_PLAN_ID=r.RECRUITMENT_PLAN_ID LEFT JOIN DEPT d on d.dept_id=rp.dept_id LEFT JOIN " +
            "DEPT_POST dp on dp.DEPT_POST_ID=rp.DEPT_POST_ID where r.RESUME_ZT=6")
    IPage<StaffInductionEntity> findInductionStaff(Page<StaffInductionEntity> page);

    /**
     * 查看所有放弃入职的员工
     */
    @Select("SELECT r.RESUME_ZT,et.waive_reason,r.RESUME_NAME,r.RESUME_SEX,r.RESUME_EDUCATION,r.RESUME_PHONE,r.RESUME_MAILBOX," +
            "r.RESUME_BIRTHDAY,r.RESUME_RESIDENCE,r.RESUME_POLITICAL_OUTLOOK,d.DEPT_NAME,dp.POST_NAME " +
            "FROM EMPLOYMENT_TABLE et LEFT JOIN RESUME r on et.RESUME_ID=r.RESUME_ID LEFT JOIN RECRUITMENT_PLAN rp " +
            "on rp.RECRUITMENT_PLAN_ID=r.RECRUITMENT_PLAN_ID LEFT JOIN DEPT d on d.dept_id=rp.dept_id LEFT JOIN " +
            "DEPT_POST dp on dp.DEPT_POST_ID=rp.DEPT_POST_ID where r.RESUME_ZT=4")
    IPage<StaffGiveupInductionEntity> findgiveupInductionStaff(Page<StaffGiveupInductionEntity> page);

    /**
     * 查看所有待转正员工
     * */
    @Select(" SELECT s.STAFF_NAME,s.STAFF_ID,s.STAFF_SEX,s.STAFF_IDENTITY,d.DEPT_NAME,dp.POST_NAME," +
            "  s.STAFF_PHONE,s.STAFF_OUTLOOK,s.STAFF_HIREDATE,s.STAFF_STATE " +
            "  FROM  STAFF s  LEFT JOIN dept d on d.DEPT_ID=s.DEPT_ID LEFT JOIN DEPT_POST dp on dp.DEPT_POST_ID=s.DEPT_POST_ID"+
            "  where s.IS_DELETED=0 and s.STAFF_STATE=0 " )
    IPage<StaffEntity> findTurnrightStaff(Page<StaffEntity> page);

    /**
     * 查看调动记录
     */
    @Select("select t.TRANSFER_TYPE,t.CREATED_DEPT_NAME,t.TRANSFER_STATE,t.UPDATED_DEPT_NAME,t.transfer_rawpost_NAME," +
            "t.transfer_afterpost_NAME,s.staff_id,s.staff_name from TRANSFER t left join staff s on t.staff_id=s.staff_id where s.is_deleted=0")
    IPage<StaffTransferEntity> findTransferStaff(Page<StaffTransferEntity> page);


    /**
     * 根据条件查询员工
     * @param id or name
     * @return
     */
    @Select(" SELECT s.STAFF_NAME,s.STAFF_ID,d.DEPT_NAME,dp.POST_NAME," +
            "  s.STAFF_PHONE,s.STAFF_OUTLOOK,s.STAFF_HIREDATE" +
            "  FROM  STAFF s  LEFT JOIN dept d on d.DEPT_ID=s.DEPT_ID LEFT JOIN DEPT_POST dp on dp.DEPT_POST_ID=s.DEPT_POST_ID"+
            "  ${ew.customSqlSegment} ")
    IPage<StaffEntity> findStaffById(Page<StaffEntity> staffEntityPage,@Param(Constants.WRAPPER) QueryWrapper<StaffEntity> queryWrapper);


    /**
     * 根据条件查询离职员工
     * @param id or name
     * @return
     */
    @Select(" SELECT s.STAFF_NAME,s.STAFF_ID,d.DEPT_NAME,dp.POST_NAME,s.STAFF_PHONE," +
            " s.staff_Email,s.STAFF_HIREDATE,q.FORMAL_QUIT_DATE,q.QUIT_EXPLAIN," +
            " TRUNC((TO_CHAR(q.FORMAL_QUIT_DATE,'yyyy')-TO_CHAR(s.STAFF_HIREDATE,'yyyy'))) as gl " +
            " FROM  QUIT q LEFT JOIN  STAFF s on q.STAFF_ID=s.STAFF_ID LEFT JOIN dept d on d.DEPT_ID=q.DEPT_ID " +
            " LEFT JOIN DEPT_POST dp on dp.DEPT_POST_ID=s.DEPT_POST_ID"+
            "  ${ew.customSqlSegment} ")
    IPage<StaffHistoryEntity> findHistoryStaffById(Page<StaffHistoryEntity> staffEntityPage,@Param(Constants.WRAPPER) QueryWrapper<StaffHistoryEntity> queryWrapper);


    /**
     * 根据条件查询所有惩罚的员工
     * @param id or name
     * @return
     */
    @Select(" SELECT p.CREATED_TIME,p.PUNISH_CAUSE,p.PUNISH_TYPE,p.PUNISH_UNIT,d.DEPT_NAME,s.STAFF_ID," +
            " s.STAFF_NAME,dp.POST_NAME FROM PUNISH p left join STAFF s on p.STAFF_ID=s.STAFF_ID left join " +
            "dept d on d.DEPT_ID=s.DEPT_ID left join dept_post dp on dp.DEPT_POST_ID=s.DEPT_POST_ID " +
            "${ew.customSqlSegment} ")
    IPage<StaffPunishmentEntity> findPunishById(Page<StaffPunishmentEntity> staffEntityPage,@Param(Constants.WRAPPER) QueryWrapper<StaffPunishmentEntity> queryWrapper);

    /**
     * 根据条件查询所有精英员工
     * @param id or name
     * @return
     */
    @Select(" SELECT s.STAFF_ID,s.STAFF_NAME,s.STAFF_HIREDATE,s.STAFF_PHONE,s.STAFF_EMAIL,s.STAFF_OUTLOOK,s.STAFF_EDUCATION," +
            " s.STAFF_SCHOOL,d.DEPT_NAME,dp.POST_NAME FROM STAFF s LEFT JOIN DEPT d on s.DEPT_ID=d.DEPT_ID LEFT JOIN " +
            " DEPT_POST dp on dp.DEPT_POST_ID=s.DEPT_POST_ID  " +
            "${ew.customSqlSegment} ")
    IPage<StaffEliteEntity> findEliteStaffById(Page<StaffEliteEntity> staffEntityPage,@Param(Constants.WRAPPER) QueryWrapper<StaffEliteEntity> queryWrapper);

    /**
     * 根据条件查询所有获奖的员工
     * @param id or name
     * @return
     */
    @Select("SELECT g.GLORY_NAME,g.GLORY_UNITNAME,g.GLORY_REMARK,g.CREATED_TIME,s.STAFF_ID,s.STAFF_NAME,d.DEPT_NAME,dp.POST_NAME " +
            " FROM GLORY g left join STAFF s on g.STAFF_ID=s.STAFF_ID left join DEPT d on d.DEPT_ID=s.DEPT_ID left join " +
            "DEPT_POST dp on dp.DEPT_POST_ID=s.DEPT_POST_ID " +
            "${ew.customSqlSegment} ")
    IPage<StaffRewardEntity> findRewardStaffById(Page<StaffRewardEntity> staffEntityPage,@Param(Constants.WRAPPER) QueryWrapper<StaffRewardEntity> queryWrapper);

    /**
     * 根据条件查询待入职的员工
     */
    @Select("SELECT r.RESUME_ID,r.RESUME_HY,r.RESUME_PHOTO,r.RESUME_ZT,r.RESUME_NAME,r.RESUME_SEX,r.RESUME_EDUCATION,r.RESUME_PHONE,r.RESUME_MAILBOX," +
            "r.RESUME_BIRTHDAY,r.RESUME_RESIDENCE,r.RESUME_POLITICAL_OUTLOOK,d.DEPT_NAME,dp.POST_NAME " +
            "FROM EMPLOYMENT_TABLE et LEFT JOIN RESUME r on et.RESUME_ID=r.RESUME_ID LEFT JOIN RECRUITMENT_PLAN rp " +
            "on rp.RECRUITMENT_PLAN_ID=r.RECRUITMENT_PLAN_ID LEFT JOIN DEPT d on d.dept_id=rp.dept_id LEFT JOIN " +
            "DEPT_POST dp on dp.DEPT_POST_ID=rp.DEPT_POST_ID " +
            "${ew.customSqlSegment}")
    IPage<StaffInductionEntity> findInductionStaffById(Page<StaffInductionEntity> staffEntityPage,@Param(Constants.WRAPPER) QueryWrapper<StaffInductionEntity> queryWrapper);

    /**
     * 根据条件查询放弃入职的员工
     */
    @Select("SELECT r.RESUME_ZT,et.waive_reason,r.RESUME_NAME,r.RESUME_SEX,r.RESUME_EDUCATION,r.RESUME_PHONE,r.RESUME_MAILBOX," +
            "r.RESUME_BIRTHDAY,r.RESUME_RESIDENCE,r.RESUME_POLITICAL_OUTLOOK,d.DEPT_NAME,dp.POST_NAME " +
            "FROM EMPLOYMENT_TABLE et LEFT JOIN RESUME r on et.RESUME_ID=r.RESUME_ID LEFT JOIN RECRUITMENT_PLAN rp " +
            "on rp.RECRUITMENT_PLAN_ID=r.RECRUITMENT_PLAN_ID LEFT JOIN DEPT d on d.dept_id=rp.dept_id LEFT JOIN " +
            "DEPT_POST dp on dp.DEPT_POST_ID=rp.DEPT_POST_ID " +
            "${ew.customSqlSegment}")
    IPage<StaffGiveupInductionEntity> findgiveupInductionStaffById(Page<StaffGiveupInductionEntity> staffEntityPage,@Param(Constants.WRAPPER) QueryWrapper<StaffGiveupInductionEntity> queryWrapper);

    /**
     * 查看所有待转正员工
     * */
    @Select(" SELECT s.STAFF_NAME,s.STAFF_ID,s.STAFF_SEX,s.STAFF_IDENTITY,d.DEPT_NAME,dp.POST_NAME," +
            "  s.STAFF_PHONE,s.STAFF_OUTLOOK,s.STAFF_HIREDATE,s.STAFF_STATE " +
            "  FROM  STAFF s  LEFT JOIN dept d on d.DEPT_ID=s.DEPT_ID LEFT JOIN DEPT_POST dp on dp.DEPT_POST_ID=s.DEPT_POST_ID"+
            "  ${ew.customSqlSegment}" )
    IPage<StaffEntity> findTurnrightStaffById(Page<StaffEntity> staffEntityPage,@Param(Constants.WRAPPER) QueryWrapper<StaffEntity> queryWrapper);

    /**
     * 查看调动记录
     */
    @Select("select t.TRANSFER_TYPE,t.CREATED_DEPT_NAME,t.TRANSFER_STATE,t.UPDATED_DEPT_NAME,t.transfer_rawpost_NAME," +
            "t.transfer_afterpost_NAME,s.staff_id,s.staff_name from TRANSFER t left join staff s on t.staff_id=s.staff_id" +
            " ${ew.customSqlSegment}")

    IPage<StaffTransferEntity> findTransferStaffById(Page<StaffTransferEntity> staffEntityPage,@Param(Constants.WRAPPER) QueryWrapper<StaffTransferEntity> queryWrapper);


    /**
     * 员工放弃入职
     */
    @Update("update RESUME set RESUME_ZT=4  ${ew.customSqlSegment}")
    int updateResume(@Param(Constants.WRAPPER) QueryWrapper<StaffGiveupInductionEntity> queryWrapper);
}
