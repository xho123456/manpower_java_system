package com.trkj.system.recruit_modular.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.system.recruit_modular.entity.WorkExperiencess;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 工作经历表 Mapper 接口
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-06
 */
@Mapper
public interface WorkExperiencessMapper extends BaseMapper<WorkExperiencess> {

    //个人简历信息页面：工作经历查询
    @Select("select * from WORK_EXPERIENCESS ${ew.customSqlSegment}")
    List<WorkExperiencess> findByidWork(@Param(Constants.WRAPPER) QueryWrapper queryWrapper);
}
