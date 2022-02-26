package com.trkj.system.organizational_management.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.system.organizational_management.entity.StaffWag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface StaffWagMapper extends BaseMapper<StaffWag> {
   //查询本月是否生成了员工工资表
    @Select("select to_char(CREATED_TIME,'yyyy-MM') year,count(*) as rs from STAFFWAG where to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),0),'yyyy-mm') group by to_char(CREATED_TIME,'yyyy-MM') ORDER BY year")
    List<Map<String, Object>> selecbynogz();
}
