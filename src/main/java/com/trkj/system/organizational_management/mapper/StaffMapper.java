package com.trkj.system.organizational_management.mapper;

import com.trkj.system.organizational_management.entity.Staff;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 员工表 Mapper 接口
 * </p>
 *
 * @author 谢海欧
 * @since 2021-12-24
 */
@Mapper
public interface StaffMapper extends BaseMapper<Staff> {
    @Select("select *from staff")
    List<Staff> selectList();
    @Select("select STAFF_SEX,count(STAFF_SEX)as zonshu from STAFF  GROUP BY STAFF_SEX")
    List<Map<String, Object>> selectSex();
    @Select("select STAFF_MARITAL,count(STAFF_MARITAL)as zonshu from STAFF  GROUP BY STAFF_MARITAL")
    List<Map<String, Object>> selecthy();
    @Select("select COUNT(STAFF_ID)as gl from STAFF where TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_HIREDATE, 'yyyyMMdd')) /10000) <=0")
    List<Map<String, Object>> selectgl1();
    @Select("select COUNT(STAFF_ID)as gl from STAFF where TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_HIREDATE, 'yyyyMMdd')) /10000) =1")
    List<Map<String, Object>> selectgl11();
    @Select("select COUNT(STAFF_ID)as gl from STAFF where TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_HIREDATE, 'yyyyMMdd')) /10000) =2")
    List<Map<String, Object>> selectgl2();
    @Select("select COUNT(STAFF_ID)as gl from STAFF where TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_HIREDATE, 'yyyyMMdd')) /10000) =3")
    List<Map<String, Object>> selectgl3();
    @Select("select COUNT(STAFF_ID)as gl from STAFF where TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_HIREDATE, 'yyyyMMdd')) /10000) =4")
    List<Map<String, Object>> selectgl4();
    @Select("select COUNT(STAFF_ID)as gl from STAFF where TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_HIREDATE, 'yyyyMMdd')) /10000) >=5")
    List<Map<String, Object>> selectgl5();
    //员工学历分析
    @Select("select STAFF_EDUCATION,count(*) as rs from STAFF  GROUP BY STAFF_EDUCATION")
    List<Map<String, Object>> selectxl();
    //员工年龄分析
    @Select(" select case   when   TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) >=20   and TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) <=30     then '20-30岁'  when  TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) >=30 and TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) <=40       then '30-40岁'  when     TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) >=40 and TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) <=50   then '40-50岁' when     TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) <=20   then '20岁以下' when   TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) >=20  then '50岁以上'   end as nld, count(*) as rs  from STAFF group by case when    TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) >=20  and TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) <=30     then '20-30岁' when  TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) >=30 and TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) <=40        then '30-40岁' when   TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) >=40  and TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) <=50  then '40-50岁' when   TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) <=20  then '20岁以下' when   TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) >=20  then '50岁以上' end")
    List<Map<String,Object>> selectnl();
    //员工星座分析
    @Select("select STAFF_SIGN,count(*) as rs from STAFF  GROUP BY STAFF_SIGN")
    List<Map<String, Object>> selectxz();
    //员工在职状态
    @Select("SELECT case  when  IS_DELETED=1 then '已离职' when  STAFF_STATE=1 then '正式员工' when  STAFF_STATE=0 then '试用员工'  end as zt,count(*) as rs  FROM STAFF GROUP BY  case  when  IS_DELETED=1 then '已离职' when  STAFF_STATE=1 then '正式员工' when  STAFF_STATE=0 then '试用员工' end")
    List<Map<String, Object>> selectygzt();

    //员工年代分析
    @Select("  select case   when   TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) >=20   and TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) <=30     then '90后'  when  TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) >=30 and TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) <=40       then '80后'  when     TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) >=40 and TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) <=50   then '70后' when     TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) <=20   then '00后以下' when   TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) >=20  then '70后以上'   end as nld, count(*) as rs  from STAFF group by case when    TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) >=20  and TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) <=30     then '90后' when  TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) >=30 and TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) <=40        then '80后' when   TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) >=40  and TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) <=50  then '70后' when   TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) <=20  then '00后以下' when   TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) >=20  then '70后以上' end")
    List<Map<String, Object>> selectnd();



    //人员数量分析页面
    //每月员工入职人数
    @Select("select to_char(STAFF_HIREDATE,'yyyy-MM') year,count(*) as rs from STAFF where to_char(STAFF_HIREDATE,'yyyy-MM') <= TO_CHAR(SYSDATE,'yyyy-MM') and to_char(STAFF_HIREDATE,'yyyy-MM') >= to_char(add_months(trunc(sysdate),-6),'yyyy-mm') group by to_char(STAFF_HIREDATE,'yyyy-MM') ORDER BY year")
    List<Map<String, Object>> selectrz();
    //本月员工入职人数
    @Select("select to_char(STAFF_HIREDATE,'yyyy-MM') year,count(*) as rs from STAFF where to_char(STAFF_HIREDATE,'yyyy-MM') = to_char(add_months(trunc(sysdate),0),'yyyy-mm') group by to_char(STAFF_HIREDATE,'yyyy-MM') ORDER BY year")
    List<Map<String, Object>> selectbyrz();
    //上月员工入职人数
    @Select("select to_char(STAFF_HIREDATE,'yyyy-MM') year,count(*) as rs from STAFF where to_char(STAFF_HIREDATE,'yyyy-MM') = to_char(add_months(trunc(sysdate),-1),'yyyy-mm') group by to_char(STAFF_HIREDATE,'yyyy-MM') ORDER BY year")
    List<Map<String, Object>> selectsyrz();

    //每月员工离职人数
    @Select(" select to_char(FORMAL_QUIT_DATE,'yyyy-MM') year,count(STAFF_ID) as rs from QUIT where to_char(FORMAL_QUIT_DATE,'yyyy-MM') <= TO_CHAR(SYSDATE,'yyyy-MM')  and to_char(FORMAL_QUIT_DATE,'yyyy-MM') >= to_char(add_months(trunc(sysdate),-6),'yyyy-mm') and QUIT_STATE=1 group by to_char(FORMAL_QUIT_DATE,'yyyy-MM') ORDER BY year ")
    List<Map<String, Object>> selectyglz();
    //当月员工离职人数
    @Select("  select to_char(FORMAL_QUIT_DATE,'yyyy-MM') year,count(STAFF_ID) as rs from QUIT where to_char(FORMAL_QUIT_DATE,'yyyy-MM') = TO_CHAR(SYSDATE,'yyyy-MM')  and QUIT_STATE=1 group by to_char(FORMAL_QUIT_DATE,'yyyy-MM')   ")
    List<Map<String, Object>> selectdylz();

    //上月员工离职人数
    @Select(" select to_char(FORMAL_QUIT_DATE,'yyyy-MM') year,count(STAFF_ID) as rs from QUIT where    to_char(FORMAL_QUIT_DATE,'yyyy-MM') = to_char(add_months(trunc(sysdate),-1),'yyyy-mm') and QUIT_STATE=1 group by to_char(FORMAL_QUIT_DATE,'yyyy-MM')  ")
    List<Map<String, Object>> selectsylz();

    //每月员工转正人数
    @Select(" select to_char(WORKER_DATE,'yyyy-MM') year,count(STAFF_ID) as rs from WORKER where to_char(WORKER_DATE,'yyyy-MM') <= TO_CHAR(SYSDATE,'yyyy-MM')  and to_char(WORKER_DATE,'yyyy-MM') >= to_char(add_months(trunc(sysdate),-6),'yyyy-mm') and WORKER_STATE=1 group by to_char(WORKER_DATE,'yyyy-MM') ORDER BY year  ")
    List<Map<String, Object>> selectygzz();
    //本月员工转正人数
    @Select("select to_char(WORKER_DATE,'yyyy-MM') year,count(STAFF_ID) as rs from WORKER where  to_char(WORKER_DATE,'yyyy-MM') = to_char(add_months(trunc(sysdate),0),'yyyy-mm') and WORKER_STATE=1 group by to_char(WORKER_DATE,'yyyy-MM') ORDER BY year  ")
    List<Map<String, Object>> selectbyygzz();
    //上月员工转正人数
    @Select("select to_char(WORKER_DATE,'yyyy-MM') year,count(STAFF_ID) as rs from WORKER where  to_char(WORKER_DATE,'yyyy-MM') = to_char(add_months(trunc(sysdate),-1),'yyyy-mm') and WORKER_STATE=1 group by to_char(WORKER_DATE,'yyyy-MM') ORDER BY year  ")
    List<Map<String, Object>> selectsyygzz();
    //部门员工top榜
    @Select(" SELECT  D.DEPT_NAME, COUNT(s.STAFF_ID) as rs FROM  staff s, DEPT D WHERE s.DEPT_ID = D.DEPT_ID  GROUP BY  d.DEPT_NAME ORDER BY   rs desc   ")
    List<Map<String, Object>> selectbdepttop();


    //员工新进律
    @Select(" select MONEYPIGEONHOLE_ASKPERSON as rs,to_char(MONEYPIGEONHOLE_DATE,'yyyy-MM') year from MONEYPIGEONHOLE WHERE  to_char(MONEYPIGEONHOLE_DATE,'yyyy-MM') >=to_char(add_months(trunc(sysdate),-5),'yyyy-mm') ORDER BY year ")
    List<Map<String, Object>> selectygxj();
    //每月员工离职
    @Select(" select to_char(FORMAL_QUIT_DATE,'yyyy-MM') year,count(STAFF_ID) as rs from QUIT where to_char(FORMAL_QUIT_DATE,'yyyy-MM') <= TO_CHAR(SYSDATE,'yyyy-MM')  and to_char(FORMAL_QUIT_DATE,'yyyy-MM') >= to_char(add_months(trunc(sysdate),-6),'yyyy-mm') and QUIT_STATE=1 group by to_char(FORMAL_QUIT_DATE,'yyyy-MM') ORDER BY year ")
    List<Map<String, Object>> selectyglz1();
    @Select(" select to_char(FORMAL_QUIT_DATE,'yyyy-MM') year,count(STAFF_ID) as rs from QUIT where to_char(FORMAL_QUIT_DATE,'yyyy-MM') <= TO_CHAR(SYSDATE,'yyyy-MM')  and to_char(FORMAL_QUIT_DATE,'yyyy-MM') >= to_char(add_months(trunc(sysdate),0),'yyyy-mm') and QUIT_STATE=1 group by to_char(FORMAL_QUIT_DATE,'yyyy-MM') ORDER BY year ")
    List<Map<String, Object>> selectyglz11();
    //每月请假人数
    @Select("SELECT case when to_char(LEAVE_S_DATE,'yyyy-MM') = to_char(add_months(trunc(sysdate),0),'yyyy-mm') then  to_char(add_months(trunc(sysdate),0),'yyyy-mm') when to_char(LEAVE_S_DATE,'yyyy-MM') = to_char(add_months(trunc(sysdate),-1),'yyyy-mm')  then to_char(add_months(trunc(sysdate),-1),'yyyy-mm')  when to_char(LEAVE_S_DATE,'yyyy-MM') = to_char(add_months(trunc(sysdate),-2),'yyyy-mm') then to_char(add_months(trunc(sysdate),-2),'yyyy-mm') when to_char(LEAVE_S_DATE,'yyyy-MM') = to_char(add_months(trunc(sysdate),-3),'yyyy-mm') then to_char(add_months(trunc(sysdate),-3),'yyyy-mm') when to_char(LEAVE_S_DATE,'yyyy-MM') = to_char(add_months(trunc(sysdate),-4),'yyyy-mm') then to_char(add_months(trunc(sysdate),-4),'yyyy-mm') when to_char(LEAVE_S_DATE,'yyyy-MM') = to_char(add_months(trunc(sysdate),-5),'yyyy-mm') then to_char(add_months(trunc(sysdate),-5),'yyyy-mm') end as zt,count(*) as rs  FROM LEAVE  WHERE LEAVE_STATE=1 GROUP BY  case when  to_char(LEAVE_S_DATE,'yyyy-MM') = to_char(add_months(trunc(sysdate),0),'yyyy-mm')   then  to_char(add_months(trunc(sysdate),0),'yyyy-mm') when to_char(LEAVE_S_DATE,'yyyy-MM') = to_char(add_months(trunc(sysdate),-1),'yyyy-mm') then to_char(add_months(trunc(sysdate),-1),'yyyy-mm') when to_char(LEAVE_S_DATE,'yyyy-MM') = to_char(add_months(trunc(sysdate),-2),'yyyy-mm') then to_char(add_months(trunc(sysdate),-2),'yyyy-mm') when to_char(LEAVE_S_DATE,'yyyy-MM') = to_char(add_months(trunc(sysdate),-3),'yyyy-mm') then to_char(add_months(trunc(sysdate),-3),'yyyy-mm') when to_char(LEAVE_S_DATE,'yyyy-MM') = to_char(add_months(trunc(sysdate),-4),'yyyy-mm') then to_char(add_months(trunc(sysdate),-4),'yyyy-mm')  when to_char(LEAVE_S_DATE,'yyyy-MM') = to_char(add_months(trunc(sysdate),-5),'yyyy-mm') then to_char(add_months(trunc(sysdate),-5),'yyyy-mm') end   ")
    List<Map<String, Object>> selectqjrs();

    //本月请假人数
    @Select("select to_char(LEAVE_S_DATE,'yyyy-MM') year,count(*) as rs from LEAVE where to_char(LEAVE_S_DATE,'yyyy-MM') = to_char(add_months(trunc(sysdate),0),'yyyy-mm') group by to_char(LEAVE_S_DATE,'yyyy-MM') ORDER BY year ")
    List<Map<String, Object>> selectdyqjrs();
    //每月出差人数
    @Select("SELECT case when to_char(TRAVEL_S_DATE,'yyyy-MM') = to_char(add_months(trunc(sysdate),0),'yyyy-mm') then  to_char(add_months(trunc(sysdate),0),'yyyy-mm') when to_char(TRAVEL_S_DATE,'yyyy-MM') = to_char(add_months(trunc(sysdate),-1),'yyyy-mm')  then to_char(add_months(trunc(sysdate),-1),'yyyy-mm')  when to_char(TRAVEL_S_DATE,'yyyy-MM') = to_char(add_months(trunc(sysdate),-2),'yyyy-mm') then to_char(add_months(trunc(sysdate),-2),'yyyy-mm') when to_char(TRAVEL_S_DATE,'yyyy-MM') = to_char(add_months(trunc(sysdate),-3),'yyyy-mm') then to_char(add_months(trunc(sysdate),-3),'yyyy-mm') when to_char(TRAVEL_S_DATE,'yyyy-MM') = to_char(add_months(trunc(sysdate),-4),'yyyy-mm') then to_char(add_months(trunc(sysdate),-4),'yyyy-mm') when to_char(TRAVEL_S_DATE,'yyyy-MM') = to_char(add_months(trunc(sysdate),-5),'yyyy-mm') then to_char(add_months(trunc(sysdate),-5),'yyyy-mm') end as time,count(*) as rs  FROM TRAVEL  WHERE TRAVEL_STATE=1 GROUP BY  case when  to_char(TRAVEL_S_DATE,'yyyy-MM') = to_char(add_months(trunc(sysdate),0),'yyyy-mm')   then  to_char(add_months(trunc(sysdate),0),'yyyy-mm') when to_char(TRAVEL_S_DATE,'yyyy-MM') = to_char(add_months(trunc(sysdate),-1),'yyyy-mm') then to_char(add_months(trunc(sysdate),-1),'yyyy-mm') when to_char(TRAVEL_S_DATE,'yyyy-MM') = to_char(add_months(trunc(sysdate),-2),'yyyy-mm') then to_char(add_months(trunc(sysdate),-2),'yyyy-mm') when to_char(TRAVEL_S_DATE,'yyyy-MM') = to_char(add_months(trunc(sysdate),-3),'yyyy-mm') then to_char(add_months(trunc(sysdate),-3),'yyyy-mm') when to_char(TRAVEL_S_DATE,'yyyy-MM') = to_char(add_months(trunc(sysdate),-4),'yyyy-mm') then to_char(add_months(trunc(sysdate),-4),'yyyy-mm')  when to_char(TRAVEL_S_DATE,'yyyy-MM') = to_char(add_months(trunc(sysdate),-5),'yyyy-mm') then to_char(add_months(trunc(sysdate),-5),'yyyy-mm') end   ")
    List<Map<String, Object>> selectccrs();
    //本月月出差人数
    @Select(" select to_char(TRAVEL_S_DATE,'yyyy-MM') year,count(*) as rs from TRAVEL where to_char(TRAVEL_S_DATE,'yyyy-MM') = to_char(add_months(trunc(sysdate),0),'yyyy-mm') and TRAVEL_STATE=1  group by to_char(TRAVEL_S_DATE,'yyyy-MM') ORDER BY year")
    List<Map<String, Object>> selectdyccrs();
    //每月员工加班总小时
    @Select(" SELECT case when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),0),'yyyy-mm') then  to_char(add_months(trunc(sysdate),0),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-1),'yyyy-mm')  then to_char(add_months(trunc(sysdate),-1),'yyyy-mm')  when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-2),'yyyy-mm') then to_char(add_months(trunc(sysdate),-2),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-3),'yyyy-mm') then to_char(add_months(trunc(sysdate),-3),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-4),'yyyy-mm') then to_char(add_months(trunc(sysdate),-4),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-5),'yyyy-mm') then to_char(add_months(trunc(sysdate),-5),'yyyy-mm') end as time,SUM(OVERTIMEASK_TOTAL_DATE) as sj  FROM OVERTIMEASK  WHERE OVERTIMEASK_STATE=1 GROUP BY  case when  to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),0),'yyyy-mm')   then  to_char(add_months(trunc(sysdate),0),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-1),'yyyy-mm') then to_char(add_months(trunc(sysdate),-1),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-2),'yyyy-mm') then to_char(add_months(trunc(sysdate),-2),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-3),'yyyy-mm') then to_char(add_months(trunc(sysdate),-3),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-4),'yyyy-mm') then to_char(add_months(trunc(sysdate),-4),'yyyy-mm')  when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-5),'yyyy-mm') then to_char(add_months(trunc(sysdate),-5),'yyyy-mm') end ")
    List<Map<String, Object>> selectjbtime();

    //本月加班总时长1
    @Select("select to_char(CREATED_TIME,'yyyy-MM') year,SUM(OVERTIMEASK_TOTAL_DATE) as time from OVERTIMEASK where to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),0),'yyyy-mm') and OVERTIMEASK_STATE=1  group by to_char(CREATED_TIME,'yyyy-MM') ORDER BY year ")
    List<Map<String, Object>> selectbyjbtime();




    //员工总数
    @Select("select count(*) as rs from staff ")
    List<Map<String, Object>> selectStaffrs();


    @Select("   SELECT case when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),0),'yyyy-mm') then  to_char(add_months(trunc(sysdate),0),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-1),'yyyy-mm')  then to_char(add_months(trunc(sysdate),-1),'yyyy-mm')  when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-2),'yyyy-mm') then to_char(add_months(trunc(sysdate),-2),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-3),'yyyy-mm') then to_char(add_months(trunc(sysdate),-3),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-4),'yyyy-mm') then to_char(add_months(trunc(sysdate),-4),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-5),'yyyy-mm') then to_char(add_months(trunc(sysdate),-5),'yyyy-mm') end as time,SUM(moneypigeonhole_askperson)AS RS FROM MONEYPIGEONHOLE  WHERE IS_DELETED=0 GROUP BY  case when  to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),0),'yyyy-mm')   then  to_char(add_months(trunc(sysdate),0),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-1),'yyyy-mm') then to_char(add_months(trunc(sysdate),-1),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-2),'yyyy-mm') then to_char(add_months(trunc(sysdate),-2),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-3),'yyyy-mm') then to_char(add_months(trunc(sysdate),-3),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-4),'yyyy-mm') then to_char(add_months(trunc(sysdate),-4),'yyyy-mm')  when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-5),'yyyy-mm') then to_char(add_months(trunc(sysdate),-5),'yyyy-mm') end ")
    List<Map<String, Object>> selectjxrs();
    //每月计薪人数


    //本月计薪人数
    @Select("select to_char(CREATED_TIME,'yyyy-MM') year,count(moneypigeonhole_askperson) as time from MONEYPIGEONHOLE where to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),0),'yyyy-mm')   group by to_char(CREATED_TIME,'yyyy-MM') ORDER BY year ")
    List<Map<String, Object>> selectbyjxrs();

    //每月人力成本
    @Select("  SELECT case when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),0),'yyyy-mm') then  to_char(add_months(trunc(sysdate),0),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-1),'yyyy-mm')  then to_char(add_months(trunc(sysdate),-1),'yyyy-mm')  when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-2),'yyyy-mm') then to_char(add_months(trunc(sysdate),-2),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-3),'yyyy-mm') then to_char(add_months(trunc(sysdate),-3),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-4),'yyyy-mm') then to_char(add_months(trunc(sysdate),-4),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-5),'yyyy-mm') then to_char(add_months(trunc(sysdate),-5),'yyyy-mm') end as time,SUM(moneypigeonhole_staffcost)AS RS FROM MONEYPIGEONHOLE  WHERE IS_DELETED=0 GROUP BY  case when  to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),0),'yyyy-mm')   then  to_char(add_months(trunc(sysdate),0),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-1),'yyyy-mm') then to_char(add_months(trunc(sysdate),-1),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-2),'yyyy-mm') then to_char(add_months(trunc(sysdate),-2),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-3),'yyyy-mm') then to_char(add_months(trunc(sysdate),-3),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-4),'yyyy-mm') then to_char(add_months(trunc(sysdate),-4),'yyyy-mm')  when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-5),'yyyy-mm') then to_char(add_months(trunc(sysdate),-5),'yyyy-mm') end ")
    List<Map<String, Object>> selectrlcb();
    //本月人力成本
    @Select(" select to_char(CREATED_TIME,'yyyy-MM') year,SUM(moneypigeonhole_staffcost) as time from MONEYPIGEONHOLE where to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),0),'yyyy-mm')   group by to_char(CREATED_TIME,'yyyy-MM') ORDER BY year      ")
    List<Map<String, Object>> selectbyrlcb();

    //每月参保人数
    @Select(" SELECT case when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),0),'yyyy-mm') then  to_char(add_months(trunc(sysdate),0),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-1),'yyyy-mm')  then to_char(add_months(trunc(sysdate),-1),'yyyy-mm')  when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-2),'yyyy-mm') then to_char(add_months(trunc(sysdate),-2),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-3),'yyyy-mm') then to_char(add_months(trunc(sysdate),-3),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-4),'yyyy-mm') then to_char(add_months(trunc(sysdate),-4),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-5),'yyyy-mm') then to_char(add_months(trunc(sysdate),-5),'yyyy-mm') end as time,count(STAFF_ID)AS RS FROM INSURED_PAYMENT    GROUP BY  case when  to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),0),'yyyy-mm')   then  to_char(add_months(trunc(sysdate),0),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-1),'yyyy-mm') then to_char(add_months(trunc(sysdate),-1),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-2),'yyyy-mm') then to_char(add_months(trunc(sysdate),-2),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-3),'yyyy-mm') then to_char(add_months(trunc(sysdate),-3),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-4),'yyyy-mm') then to_char(add_months(trunc(sysdate),-4),'yyyy-mm')  when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-5),'yyyy-mm') then to_char(add_months(trunc(sysdate),-5),'yyyy-mm') end ")   List<Map<String, Object>> selectbxrs();
    //本月参保人数
    @Select(" select to_char(CREATED_TIME,'yyyy-MM') year,count(STAFF_ID) as rs from INSURED_PAYMENT where to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),0),'yyyy-mm')   group by to_char(CREATED_TIME,'yyyy-MM') ORDER BY year ")
    List<Map<String, Object>> selectbybxrs();
    //每月员工社保金额
    @Select(" SELECT case when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),0),'yyyy-mm') then  to_char(add_months(trunc(sysdate),0),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-1),'yyyy-mm')  then to_char(add_months(trunc(sysdate),-1),'yyyy-mm')  when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-2),'yyyy-mm') then to_char(add_months(trunc(sysdate),-2),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-3),'yyyy-mm') then to_char(add_months(trunc(sysdate),-3),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-4),'yyyy-mm') then to_char(add_months(trunc(sysdate),-4),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-5),'yyyy-mm') then to_char(add_months(trunc(sysdate),-5),'yyyy-mm') end as time,sum(INS_ARCHIVE_SOCIAL_PERSON_PAY)AS rmb FROM  INSURED_ARCHIVE  WHERE IS_DELETED=0 GROUP BY  case when  to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),0),'yyyy-mm')   then  to_char(add_months(trunc(sysdate),0),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-1),'yyyy-mm') then to_char(add_months(trunc(sysdate),-1),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-2),'yyyy-mm') then to_char(add_months(trunc(sysdate),-2),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-3),'yyyy-mm') then to_char(add_months(trunc(sysdate),-3),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-4),'yyyy-mm') then to_char(add_months(trunc(sysdate),-4),'yyyy-mm')  when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-5),'yyyy-mm') then to_char(add_months(trunc(sysdate),-5),'yyyy-mm') end ")
    List<Map<String, Object>> selectygsbje();
    //本月员工社保金额
    @Select("  select to_char(CREATED_TIME,'yyyy-MM') year,sum(INS_ARCHIVE_SOCIAL_PERSON_PAY) as rmb from INSURED_ARCHIVE where to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),0),'yyyy-mm') and IS_DELETED=0  group by to_char(CREATED_TIME,'yyyy-MM') ORDER BY year ")
    List<Map<String, Object>> selectbyygsbje();

    //每月公司社保金额
    @Select("  SELECT case when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),0),'yyyy-mm') then  to_char(add_months(trunc(sysdate),0),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-1),'yyyy-mm')  then to_char(add_months(trunc(sysdate),-1),'yyyy-mm')  when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-2),'yyyy-mm') then to_char(add_months(trunc(sysdate),-2),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-3),'yyyy-mm') then to_char(add_months(trunc(sysdate),-3),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-4),'yyyy-mm') then to_char(add_months(trunc(sysdate),-4),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-5),'yyyy-mm') then to_char(add_months(trunc(sysdate),-5),'yyyy-mm') end as time,sum(INS_ARCHIVE_SOCIAL_FIRM_PAY)AS rmb FROM  INSURED_ARCHIVE  WHERE IS_DELETED=0 GROUP BY  case when  to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),0),'yyyy-mm')   then  to_char(add_months(trunc(sysdate),0),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-1),'yyyy-mm') then to_char(add_months(trunc(sysdate),-1),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-2),'yyyy-mm') then to_char(add_months(trunc(sysdate),-2),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-3),'yyyy-mm') then to_char(add_months(trunc(sysdate),-3),'yyyy-mm') when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-4),'yyyy-mm') then to_char(add_months(trunc(sysdate),-4),'yyyy-mm')  when to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),-5),'yyyy-mm') then to_char(add_months(trunc(sysdate),-5),'yyyy-mm') end  ")
    List<Map<String, Object>> selectgssbje();
    //本月月公司社保金额
    @Select(" select to_char(CREATED_TIME,'yyyy-MM') year,sum(INS_ARCHIVE_SOCIAL_FIRM_PAY) as rs from INSURED_ARCHIVE where to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),0),'yyyy-mm') and IS_DELETED=0  group by to_char(CREATED_TIME,'yyyy-MM') ORDER BY year")
    List<Map<String, Object>> selectbygssbje();

    //本月试用基本工资
    @Select(" select to_char(CREATED_TIME,'yyyy-MM') year,sum(FIXEDWAGE_PERIODMONEY) as rmb from  FIXEDWAGE where to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),0),'yyyy-mm') and IS_DELETED=0  group by to_char(CREATED_TIME,'yyyy-MM') ORDER BY year")
    List<Map<String, Object>> selectbysyjbgz();

    //本月正式基本工资
    @Select("  select to_char(CREATED_TIME,'yyyy-MM') year,sum(FIXEDWAGE_OFFICIALMONEY) as rmb from  FIXEDWAGE where to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),0),'yyyy-mm') and IS_DELETED=0  group by to_char(CREATED_TIME,'yyyy-MM') ORDER BY year")
    List<Map<String, Object>> selectbyzsjbgz();
    //本月基本工资
    @Select("  select to_char(CREATED_TIME,'yyyy-MM') year,sum(moneypigeonhole_basepay) as rmb from  MONEYPIGEONHOLE where to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),0),'yyyy-mm') and IS_DELETED=0  group by to_char(CREATED_TIME,'yyyy-MM') ORDER BY year")
    List<Map<String, Object>> selectbyzsjbgzz();
    //本月个人缴公积金
    @Select(" select to_char(CREATED_TIME,'yyyy-MM') year,sum(PERSONAGE_ACCUMULATION) as rmb from  MONEYPIGEONHOLE where to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),0),'yyyy-mm') and IS_DELETED=0  group by to_char(CREATED_TIME,'yyyy-MM') ORDER BY year")
    List<Map<String, Object>> selectbygrgjj();
    //本月个人缴社保
    @Select("select to_char(CREATED_TIME,'yyyy-MM') year,sum(PERSONAGE_SOCIAL) as rmb from  MONEYPIGEONHOLE where to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),0),'yyyy-mm') and IS_DELETED=0  group by to_char(CREATED_TIME,'yyyy-MM') ORDER BY year")
    List<Map<String, Object>> selectbygrsb();
    //本月 公司缴社保
    @Select("select to_char(CREATED_TIME,'yyyy-MM') year,sum(COMPANY_SOCIAL) as rmb from  MONEYPIGEONHOLE where to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),0),'yyyy-mm') and IS_DELETED=0  group by to_char(CREATED_TIME,'yyyy-MM') ORDER BY year")
    List<Map<String, Object>> selectbygssb();
    //本月 公司缴公积金
    @Select("select to_char(CREATED_TIME,'yyyy-MM') year,sum( COMPANY_ACCUMULATION) as rmb from  MONEYPIGEONHOLE where to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),0),'yyyy-mm') and IS_DELETED=0  group by to_char(CREATED_TIME,'yyyy-MM') ORDER BY year")
    List<Map<String, Object>> selectbygsgjj();
    //部门工资top榜
    @Select("SELECT  D.DEPT_NAME, sum(FIXEDWAGE_OFFICIALMONEY) as rmb FROM  staff s, DEPT D ,STAFFWAG w ,FIXEDWAGE f WHERE w.STAFF_ID=s.STAFF_ID AND s.DEPT_ID=d.DEPT_ID   AND w.STAFF_ID=f.STAFF_ID GROUP BY  d.DEPT_NAME ORDER BY   rmb desc  ")
    List<Map<String, Object>> selectbmgztop();
    //部门工资平均榜
    @Select(" SELECT  D.DEPT_NAME, sum(FIXEDWAGE_OFFICIALMONEY) as rmb,count(s.STAFF_ID) as rs FROM  staff s, DEPT D ,STAFFWAG w ,FIXEDWAGE f WHERE w.STAFF_ID=s.STAFF_ID AND s.DEPT_ID=d.DEPT_ID   AND w.STAFF_ID=f.STAFF_ID GROUP BY  d.DEPT_NAME ORDER BY   rmb desc  ")
    List<Map<String, Object>> selectbmgzpj();


}
