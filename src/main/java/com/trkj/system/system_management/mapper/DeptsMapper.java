package com.trkj.system.system_management.mapper;

import com.trkj.system.system_management.entity.Depts;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 部门表 Mapper 接口
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-04
 */
@Mapper
public interface DeptsMapper extends BaseMapper<Depts> {
    @Select("select DEPT_NAME from DEPT")
    List<Depts> selectDepts();
}
