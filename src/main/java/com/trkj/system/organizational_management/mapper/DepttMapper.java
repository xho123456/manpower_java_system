package com.trkj.system.organizational_management.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.system.organizational_management.entity.Dept;
import com.trkj.system.organizational_management.entity.DeptStaff;
import com.trkj.system.organizational_management.entity.Depta;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DepttMapper extends BaseMapper<Depta> {
    @Select("select  d.*, s.STAFF_NAME  from  DEPT d left join STAFF s on d.STAFF_ID= s.STAFF_ID WHERE d.IS_DELETED=0")
    List<Depta> queryList();
}
