package com.trkj.system.salary_management.mapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.salary_management.mapper.entity.Businesss;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BusinesssMapper extends BaseMapper<Businesss> {
    @Select("select *from BUSINESS  ${ew.customSqlSegment}")
    IPage<Businesss> selectPaer(Page<Businesss> businesss, @Param(Constants.WRAPPER) QueryWrapper<Businesss> queryWrapper);
}
