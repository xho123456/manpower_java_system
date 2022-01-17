package com.trkj.system.system_management.mapper;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.system_management.entity.NoticeStaff;
import com.trkj.system.system_management.entity.RegisterLogVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * <p>
 * 登录日志表 Mapper 接口
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-12
 */
@Mapper
public interface RegisterLogVoMapper extends BaseMapper<RegisterLogVO> {
    @Select("select t1.* ,t2.STAFF_NAME from REGISTER_LOG t1 LEFT JOIN STAFF t2 on t1.STAFF_ID = t2.STAFF_ID ${ew.customSqlSegment}")
    IPage<RegisterLogVO> selectPage(Page<RegisterLogVO> registerLogVOPage, @Param(Constants.WRAPPER) QueryWrapper<RegisterLogVO> queryWrapper);

    @Delete("DELETE FROM REGISTER_LOG ${ew.customSqlSegment}")
    int deletRegisterLog(@Param(Constants.WRAPPER) QueryWrapper<RegisterLogVO> queryWrapper);
}
