package com.trkj.system.attendance_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.system.attendance_management.entity.Classes;
import com.trkj.system.attendance_management.entity.ClassesVo;

/**
 * <p>
 * 班次管理 服务类
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-10
 */
public interface ShiftAllService {
    //查询所有班次
    IPage<Classes> selectAllPage(Classes classes);
    //通过id删除班次
    int isdeletedCl(Integer id);
    //班次新增
    int addClases(ClassesVo classes);
    //通过id查询班次
    ClassesVo isfindByid(Integer id);
    //班次编辑
    int isupdateClases(ClassesVo classesVo);

    //禁用所有班次
    int updateclasesall();
}
