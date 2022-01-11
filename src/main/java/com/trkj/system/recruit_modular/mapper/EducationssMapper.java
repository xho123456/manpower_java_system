package com.trkj.system.recruit_modular.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.system.recruit_modular.entity.Educationss;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 受教育经历表 Mapper 接口
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-06
 */
@Mapper
public interface EducationssMapper extends BaseMapper<Educationss> {

    //个人简历详情页面受教育经历信息查询
    @Select("select * from EDUCATIONSS ${ew.customSqlSegment}")
    List<Educationss> findByidEds(@Param(Constants.WRAPPER) QueryWrapper queryWrapper);
}
