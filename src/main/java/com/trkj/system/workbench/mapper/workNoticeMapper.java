package com.trkj.system.workbench.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.recruit_modular.entity.ResumeVo;
import com.trkj.system.workbench.entity.Gclasses;
import com.trkj.system.workbench.entity.GclockRecord;
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

    //判断当前用户当天是否有打卡记录
    @Select("select d.CLASSES_TIMEONES,d.CLASSES_TIMEONEX,d.CLASSES_TIMETWOS,d.CLASSES_TIMETWOX,a.* from CLOCK_RECORD a \n" +
            "left join ATTENDANCE_SHEET b on a.CLOCK_RECORD_ID=b.CLOCK_RECORD_ID\n" +
            "left join STAFF c on b.STAFF_ID=c.STAFF_ID\n" +
            "left join CLASSES d on b.CLASSES_ID = d.CLASSES_ID\n" +
            "where c.STAFF_ID= #{id} and TO_CHAR(a.DAY_DATE,'yyyy-MM-dd')=TO_CHAR(sysdate,'yyyy-MM-dd')")
    GclockRecord demodagowork(Integer id);

    //查询当前启用班次
    @Select("select * from CLASSES where CLASSESSTATE = 1")
    Gclasses queryallclasses();


}
