package com.trkj.system.recruit_modular.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.system.recruit_modular.entity.DeptPost;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 部门职位表 Mapper 接口
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-08
 */
@Mapper
public interface DeptPostsumeMapper extends BaseMapper<DeptPost> {

    //通过部门id 查询所属部门职位名称
    @Select("select * from DEPT_POST ${ew.customSqlSegment}")
    List<DeptPost> selectByiddepts(@Param(Constants.WRAPPER) QueryWrapper queryWrapper);

}
