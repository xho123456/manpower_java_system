package com.trkj.system.attendance_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.attendance_management.entity.Classes;
import com.trkj.system.attendance_management.entity.ClassesVo;
import com.trkj.system.attendance_management.mapper.ClassesMapper;
import com.trkj.system.attendance_management.service.ShiftAllService;
import com.trkj.system.recruit_modular.entity.InterviewVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 班次方案表 服务实现类
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-10
 */
@Service
public class ShiftAllServiceImpl implements ShiftAllService {

    @Autowired
    private ClassesMapper mapper;

    //查询所有班次
    @Override
    public IPage<Classes> selectAllPage(Classes classes) {
        Page<Classes> page = new Page<>(classes.getCurrenPage(), classes.getPagesize());
        QueryWrapper<Classes> clawrapper = new QueryWrapper<>();
        if (classes.getClassesName()!=null && !classes.getClassesName().equals("")){
            clawrapper.like("CLASSES_NAME",classes.getClassesName());
        }
        clawrapper.eq("IS_DELETED",0);
        return mapper.selectAllPage(page,clawrapper);
    }

    //通过id删除班次
    @Override
    public int isdeletedCl(Integer id) {
        return mapper.deleteById(id);
    }

    //班次新增
    @Override
    public int addClases(ClassesVo classes) {
        return mapper.insert(classes);
    }

    //通过id查询班次
    @Override
    public ClassesVo isfindByid(Integer id) {
        return mapper.selectById(id);
    }
    //班次编辑
    @Override
    public int isupdateClases(ClassesVo classesVo) {
        return mapper.updateById(classesVo);
    }
}
