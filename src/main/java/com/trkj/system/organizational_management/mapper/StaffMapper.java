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
    @Select("SELECT case when  STAFF_STATE=0 then '未离职' when  STAFF_STATE=1 then '已离职' when  STAFF_STATE=2 then '正式员工' when  STAFF_STATE=3 then '试用员工'  end as zt,count(*) as rs  FROM STAFF GROUP BY  case when  STAFF_STATE=0 then '未离职'  when  STAFF_STATE=1 then '已离职' when  STAFF_STATE=2 then '正式员工' when  STAFF_STATE=3 then '试用员工' end")
    List<Map<String, Object>> selectygzt();

    //员工年代分析
    @Select("  select case   when   TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) >=20   and TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) <=30     then '90后'  when  TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) >=30 and TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) <=40       then '80后'  when     TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) >=40 and TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) <=50   then '70后' when     TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) <=20   then '00后以下' when   TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) >=20  then '70后以上'   end as nld, count(*) as rs  from STAFF group by case when    TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) >=20  and TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) <=30     then '90后' when  TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) >=30 and TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) <=40        then '80后' when   TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) >=40  and TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) <=50  then '70后' when   TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) <=20  then '00后以下' when   TRUNC((to_char(sysdate, 'yyyyMMdd') - to_char(STAFF_BIRTHDAY, 'yyyyMMdd')) /10000) >=20  then '70后以上' end")
    List<Map<String, Object>> selectnd();



    //人员数量分析页面
    //员工入职人数
    @Select("\n" +
            "select to_char(STAFF_HIREDATE,'yyyy-MM') year,count(*) as rs from STAFF where to_char(STAFF_HIREDATE,'yyyy-MM') <= TO_CHAR(SYSDATE,'yyyy-MM') and to_char(STAFF_HIREDATE,'yyyy-MM') >= to_char(add_months(trunc(sysdate),-6),'yyyy-mm') group by to_char(STAFF_HIREDATE,'yyyy-MM') ORDER BY year")
    List<Map<String, Object>> selectrz();
}
