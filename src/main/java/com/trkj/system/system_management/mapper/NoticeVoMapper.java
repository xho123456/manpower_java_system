package com.trkj.system.system_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.system.system_management.entity.NoticeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
@Mapper
public interface NoticeVoMapper extends BaseMapper<NoticeVo> {
    @Select("select * from NOTICE ${ew.customSqlSegment}")
    IPage<NoticeVo> selectPaer(Page<NoticeVo> noticeVo,@Param(Constants.WRAPPER) QueryWrapper<NoticeVo> queryWrapper);
}
