package com.trkj.system.system_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.system.system_management.entity.NoticeDeptVo;
import com.trkj.system.system_management.entity.NoticeStaff;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.system.system_management.entity.Staffs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 公告员工表 Mapper 接口
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-05
 */
@Mapper
public interface NoticeStaffMapper extends BaseMapper<NoticeStaff> {
    /**
     * 删除公告员工表数据
     * @param queryWrapper
     * @return
     */
    @Delete("DELETE FROM NOTICE_STAFF ${ew.customSqlSegment}")
    int deleteNoticeStaff(@Param(Constants.WRAPPER) QueryWrapper<NoticeStaff> queryWrapper);

    /**
     * 批量删除公告部门数据
     * @param queryWrapper
     * @return
     */
    @Delete("DELETE FROM NOTICE_STAFF ${ew.customSqlSegment}")
    int deleteNoticeStaffList(@Param(Constants.WRAPPER) QueryWrapper<NoticeStaff> queryWrapper);


}
