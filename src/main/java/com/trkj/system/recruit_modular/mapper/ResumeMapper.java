package com.trkj.system.recruit_modular.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.system.recruit_modular.entity.Resume;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 简历表 Mapper 接口
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-05
 */
@Mapper
public interface ResumeMapper extends BaseMapper<Resume> {

    @Select("select count(*) from RESUME ${ew.customSqlSegment}")
    int planhxr(@Param(Constants.WRAPPER) QueryWrapper queryWrapper);
}
