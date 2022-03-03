package com.trkj.system.salary_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.salary_management.mapper.entity.Moneypigeonhole;
import com.trkj.system.salary_management.mapper.entity.StaffSalary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface MoneypigeonholeMapper extends BaseMapper<Moneypigeonhole> {
    //查询本月工资表id
    @Select("SELECT MONEYPIGEONHOLE_ID FROM MONEYPIGEONHOLE WHERE TO_CHAR(CREATED_TIME,'YYYY-MM')=TO_CHAR(SYSDATE,'YYYY-MM')")
    List<Map<String, Object>> selectbyid();

    //查询本月工资表是否有
    @Select(" select to_char(CREATED_TIME,'yyyy-MM') year,sum(MONEYPIGEONHOLE_ID) as id from  MONEYPIGEONHOLE where to_char(CREATED_TIME,'yyyy-MM') = to_char(add_months(trunc(sysdate),0),'yyyy-mm') and IS_DELETED=0  group by to_char(CREATED_TIME,'yyyy-MM') ORDER BY year")
    List<Map<String, Object>> selectbyyf();

    @Select("   select * from  MONEYPIGEONHOLE  ORDER BY CREATED_TIME DESC ${ew.customSqlSegment}")
    IPage<Moneypigeonhole> selectPaer(Page<Moneypigeonhole> moneypigeonholePage, @Param(Constants.WRAPPER) QueryWrapper<Moneypigeonhole> queryWrapper);

    @Select("SELECT MAX(MONEYPIGEONHOLE_ID) FROM MONEYPIGEONHOLE")
    Long maxId();
}
