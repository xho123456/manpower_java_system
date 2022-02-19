package com.trkj.system.workbench.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.recruit_modular.entity.ResumeVo;
import com.trkj.system.workbench.entity.workNotice;
import com.trkj.system.workbench.entity.workNoticeStaff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 公告表 Mapper 接口
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-16
 */
@Mapper
public interface workNoticeMapper extends BaseMapper<workNoticeStaff> {

    //查询工作台公告
    @Select("select N.*,S.NOTICE_STAFF_ID,S.NOTICE_STATE as noticeState1,S.STAFF_ID as staffId1 from NOTICE N LEFT JOIN NOTICE_STAFF S on N.NOTICE_ID = S.NOTICE_ID ${ew.customSqlSegment}")
    IPage<workNotice> selectAllNo(Page<workNotice> page, @Param(Constants.WRAPPER) QueryWrapper queryWrapper);

}
