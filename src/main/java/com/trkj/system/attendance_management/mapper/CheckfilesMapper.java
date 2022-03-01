package com.trkj.system.attendance_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.attendance_management.entity.Checkfiles;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.system.attendance_management.entity.Classes;
import com.trkj.system.recruit_modular.entity.DeptPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-25
 */
@Mapper
public interface CheckfilesMapper extends BaseMapper<Checkfiles> {

    //通过日期查询归档数据
    @Select("select * from CHECKFILES Where TO_CHAR(YEARS,'yyyy-MM') = #{datesgd}")
    IPage<Checkfiles> querygd(Page<Checkfiles> page,@Param("datesgd") String datesgd);


    //归档数据月份查询
    @Select("SELECT  distinct(O.YEARS) FROM CHECKFILES O ${ew.customSqlSegment} ORDER BY O.YEARS desc  ")
    List<Checkfiles> selectAllsDay(@Param(Constants.WRAPPER) QueryWrapper queryWrapper);

    //通过日期查询归档数据
    @Select("select * from CHECKFILES ${ew.customSqlSegment} and TO_CHAR(YEARS,'yyyy-MM') = TO_CHAR(TO_DATE(#{datesgd},'yyyy-MM'),'yyyy-MM')")
    IPage<Checkfiles> queryAllgd(Page<Checkfiles> page,@Param(Constants.WRAPPER) QueryWrapper queryWrapper,@Param("datesgd") String datesgd);
}
