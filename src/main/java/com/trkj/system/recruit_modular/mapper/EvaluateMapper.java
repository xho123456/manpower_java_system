package com.trkj.system.recruit_modular.mapper;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.system.recruit_modular.entity.Educationss;
import com.trkj.system.recruit_modular.entity.Evaluate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 面试评论 Mapper 接口
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-08
 */
@Mapper
public interface EvaluateMapper extends BaseMapper<Evaluate> {

    //通过面试ID查询所有面试者的面试评论
    @Select("select * from Evaluate ${ew.customSqlSegment}")
    List<Evaluate> findallpl(@Param(Constants.WRAPPER) QueryWrapper queryWrapper);

}
