package com.trkj.system.organizational_management.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.system.organizational_management.entity.Dept;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptOneMapper extends BaseMapper<Dept> {
    @Select("UPDATE DEPT set DEPT_STATE=1 WHERE DEPT_id=?")
    int updateById(int deptid);

    /* @Insert("insert into DEPT(DEPT_ID,DEPT_STATE,DEPT_NAME,STAFF_ID,CREATED_TIME,UPDATED_TIME,REVISION,IS_DELETED)  VALUES(DEPT_ID.nextval,0,?,?,SYSDATE,SYSDATE,1,1)")
     int addDept(Dept dept);*/
    @Select("select * from dept")
    List<Dept> selectList();
}
