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

import java.util.List;

@Mapper
public interface Staffmapper extends BaseMapper<StaffEntity> {
    /**
     * 查看所有员工
     * */
    @Select(" SELECT s.STAFF_NAME,s.STAFF_ID,d.DEPT_NAME,dp.POST_NAME," +
            "  s.STAFF_PHONE,s.STAFF_OUTLOOK,s.STAFF_HIREDATE" +
            "  FROM  STAFF s  LEFT JOIN dept d on d.DEPT_ID=s.DEPT_ID LEFT JOIN DEPT_POST dp on dp.DEPT_ID=d.DEPT_ID"+
            "  where s.IS_DELETED=0 " )
    IPage<StaffEntity> findStaff(Page<StaffEntity> page);

    /**
     * 查看离职员工
     */
    @Select(" SELECT s.STAFF_NAME,s.STAFF_ID,d.DEPT_NAME,dp.POST_NAME,s.STAFF_PHONE," +
            "s.staff_Email,s.STAFF_HIREDATE,q.FORMAL_QUIT_DATE,q.QUIT_EXPLAIN," +
            "TRUNC((TO_CHAR(q.FORMAL_QUIT_DATE,'yyyy')-TO_CHAR(s.STAFF_HIREDATE,'yyyy'))) as gl " +
            "FROM  QUIT q LEFT JOIN  STAFF s on q.STAFF_ID=s.STAFF_ID LEFT JOIN dept d on d.DEPT_ID=q.DEPT_ID " +
            "LEFT JOIN DEPT_POST dp on dp.DEPT_POST_ID=s.DEPT_POST_ID  where s.IS_DELETED=0 " )
    IPage<StaffHistoryEntity> findHistoryStaff(Page<StaffHistoryEntity> page);

    /**
     * 查看精英员工
     */
    @Select("SELECT s.STAFF_ID,s.STAFF_NAME,s.STAFF_HIREDATE,s.STAFF_PHONE,s.STAFF_EMAIL,s.STAFF_OUTLOOK,s.STAFF_EDUCATION," +
            "s.STAFF_SCHOOL,d.DEPT_NAME,dp.POST_NAME FROM STAFF s LEFT JOIN DEPT d on s.DEPT_ID=d.DEPT_ID LEFT JOIN " +
            "DEPT_POST dp on dp.DEPT_POST_ID=s.DEPT_POST_ID WHERE dp.POST_NAME='经理' ")
    IPage<StaffEliteEntity> findEliteStaff(Page<StaffEliteEntity> page);

    /**
     * 查询所有获奖员工
     */
    @Select("<script> "+
            "SELECT g.GLORY_NAME,g.GLORY_UNITNAME,g.GLORY_REMARK,g.CREATED_TIME,s.STAFF_ID,s.STAFF_NAME,d.DEPT_NAME,dp.POST_NAME" +
            " FROM GLORY g,STAFF s,DEPT d,DEPT_POST dp WHERE " +
            " g.STAFF_ID=s.STAFF_ID and d.DEPT_ID=s.DEPT_ID and dp.DEPT_POST_ID=s.DEPT_POST_ID " +
            "</script>")
    IPage<StaffRewardEntity> findRewardStaff(Page<StaffRewardEntity> page);

    /**
     * 查看所有惩罚的员工
     */
    @Select("SELECT p.CREATED_TIME,p.PUNISH_CAUSE,p.PUNISH_TYPE,p.PUNISH_UNIT,d.DEPT_ID,d.DEPT_NAME,s.STAFF_ID," +
            "s.STAFF_NAME,dp.POST_NAME FROM PUNISH p," +
            "dept d,STAFF s,DEPT_POST dp WHERE p.STAFF_ID=s.STAFF_ID and d.DEPT_ID=s.DEPT_ID and dp.DEPT_POST_ID=s.DEPT_POST_ID ")
    IPage<StaffPunishmentEntity> findPunishmentStaff(Page<StaffPunishmentEntity> page);

    /**
     * 查看所有待入职的员工
     */
    @Select("SELECT et.EMPLOYMENT_STATE,r.RESUME_NAME,r.RESUME_SEX,r.RESUME_EDUCATION,r.RESUME_PHONE,r.RESUME_MAILBOX," +
            "r.RESUME_BIRTHDAY,r.RESUME_RESIDENCE,r.RESUME_POLITICAL_OUTLOOK,d.DEPT_NAME,dp.POST_NAME " +
            "FROM EMPLOYMENT_TABLE et LEFT JOIN RESUME r on et.RESUME_ID=r.RESUME_ID LEFT JOIN RECRUITMENT_PLAN rp " +
            "on rp.RECRUITMENT_PLAN_ID=r.RECRUITMENT_PLAN_ID LEFT JOIN DEPT d on d.dept_id=rp.dept_id LEFT JOIN " +
            "DEPT_POST dp on dp.DEPT_POST_ID=rp.DEPT_POST_ID where et.EMPLOYMENT_STATE=0")
    IPage<StaffInductionEntity> findInductionStaff(Page<StaffInductionEntity> page);

    /**
     * 查看所有放弃入职的员工
     */
    @Select("SELECT et.EMPLOYMENT_STATE,et.waive_reason,r.RESUME_NAME,r.RESUME_SEX,r.RESUME_EDUCATION,r.RESUME_PHONE,r.RESUME_MAILBOX," +
            "r.RESUME_BIRTHDAY,r.RESUME_RESIDENCE,r.RESUME_POLITICAL_OUTLOOK,d.DEPT_NAME,dp.POST_NAME " +
            "FROM EMPLOYMENT_TABLE et LEFT JOIN RESUME r on et.RESUME_ID=r.RESUME_ID LEFT JOIN RECRUITMENT_PLAN rp " +
            "on rp.RECRUITMENT_PLAN_ID=r.RECRUITMENT_PLAN_ID LEFT JOIN DEPT d on d.dept_id=rp.dept_id LEFT JOIN " +
            "DEPT_POST dp on dp.DEPT_POST_ID=rp.DEPT_POST_ID where et.EMPLOYMENT_STATE=2")
    IPage<StaffGiveupInductionEntity> findgiveupInductionStaff(Page<StaffGiveupInductionEntity> page);

    /**
     * 根据ID查询员工
     * @param id
     * @return
     */
    @Select(" SELECT s.STAFF_NAME,s.STAFF_ID,d.DEPT_NAME,dp.POST_NAME," +
            "  s.STAFF_PHONE,s.STAFF_OUTLOOK,s.STAFF_HIREDATE" +
            "  FROM  STAFF s  LEFT JOIN dept d on d.DEPT_ID=s.DEPT_ID LEFT JOIN DEPT_POST dp on dp.DEPT_ID=d.DEPT_ID"+
            "  where s.IS_DELETED=0 and s.staff_id = ${id} ")
    List<StaffEntity> findStaffById(@Param(Constants.WRAPPER) QueryWrapper<StaffEntity> queryWrapper);

    /**
     * 根据名字查询员工
     * @param name
     * @return
     */
    @Select(" SELECT s.STAFF_NAME,s.STAFF_ID,d.DEPT_NAME,dp.POST_NAME," +
            "  s.STAFF_PHONE,s.STAFF_OUTLOOK,s.STAFF_HIREDATE" +
            "  FROM  STAFF s  LEFT JOIN dept d on d.DEPT_ID=s.DEPT_ID LEFT JOIN DEPT_POST dp on dp.DEPT_ID=d.DEPT_ID"+
            "  where s.IS_DELETED=0 and s.STAFF_NAME like #{name} ")
    List<StaffEntity> findStaffLikeByName(String name);



    /**
     * 根据ID查询所有惩罚的员工
     * @param id
     * @return
     */
//    @Select("<script>" +
//            " SELECT p.PUNISH_ID,p.PUNISH_CAUSE,d.DEPT_ID,d.DEPT_NAME,s.STAFF_ID,s.STAFF_SEX," +
//            "s.STAFF_NAME,s.STAFF_PHONE,s.POSITION_NAME FROM PUNISH p,dept d,STAFF s " +
//            "WHERE p.STAFF_ID=s.STAFF_ID and d.DEPT_ID=s.DEPT_ID and s.STAFF_ID = #{id}" +
//            "</script>")
//    List<StaffEntity> findPunishById(Long id);

    /**
     * 根据名字查询所有惩罚的员工
     * @param name
     * @return
     */
//    @Select("<script>" +
//            " SELECT p.PUNISH_ID,p.PUNISH_CAUSE,d.DEPT_ID,d.DEPT_NAME,s.STAFF_ID,s.STAFF_SEX," +
//            "s.STAFF_NAME,s.STAFF_PHONE,s.POSITION_NAME FROM PUNISH p,dept d,STAFF s " +
//            "WHERE p.STAFF_ID=s.STAFF_ID and d.DEPT_ID=s.DEPT_ID and s.STAFF_ID like #{name} " +
//            "</script>")
//    List<StaffEntity> findPunishLikeByName(String name);

}
