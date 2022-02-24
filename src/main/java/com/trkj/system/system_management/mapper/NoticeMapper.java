package com.trkj.system.system_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.system.system_management.entity.Depts;
import com.trkj.system.system_management.entity.Notice;
import com.trkj.system.system_management.entity.Notices;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface NoticeMapper extends BaseMapper<Notice> {
@Select("select NOTICE_ID from NOTICE ${ew.customSqlSegment}")
    Notice selectNotice(@Param(Constants.WRAPPER) QueryWrapper<Notice> queryWrapper);
}
