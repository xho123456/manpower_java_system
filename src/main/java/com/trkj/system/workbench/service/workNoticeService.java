package com.trkj.system.workbench.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.system.workbench.entity.*;

/**
 * <p>
 * 公告表 服务类
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-16
 */
public interface workNoticeService {

    //查询工作台公告
    IPage<workNotice> findallno(workNotice workNotice);
    //查看公告后公告状态该为已读
    int updategg(workNoticeStaff workNoticeStaff);

    //判断当前用户当天是否有打卡记录
    GclockRecord dakwork(Integer id);

    //查询当前启用班次
    Gclasses queryClasses();

    //打卡记录表数据新增：员工打卡
    int addClock(AdclockRecord adclockRecord);

    //考勤表数据新增：员工打卡
    int addSheet(AdattendanceSheet adattendanceSheet);

    //查询当前用户当天的打卡记录
    AdclockRecord querybyiddays(Integer id);

    //打卡记录表数据修改
    int updatedk(AdclockRecord adclockRecord);
}
