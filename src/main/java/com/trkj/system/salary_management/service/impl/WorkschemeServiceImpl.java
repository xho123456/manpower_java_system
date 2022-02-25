package com.trkj.system.salary_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.salary_management.entity.Workscheme;
import com.trkj.system.salary_management.entity.Workschemee;
import com.trkj.system.salary_management.mapper.WorkschemeMapper;
import com.trkj.system.salary_management.mapper.WorkschemeeMapper;
import com.trkj.system.salary_management.service.WorkschemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkschemeServiceImpl implements WorkschemeService {
    @Autowired
    private WorkschemeMapper workschemeMapper;
    @Autowired
    private WorkschemeeMapper workschemeeMapper;
    @Override
    public IPage<Workscheme> selectPaer1(Workscheme workscheme) {
        Page<Workscheme> page=new Page<>(workscheme.getCurrentPage(),workscheme.getPageSize());
        QueryWrapper<Workscheme> queryWrapper=new QueryWrapper<>();

        if(workscheme.getWorkschemeName() !=null && !workscheme.getWorkschemeName().equals("")){
            queryWrapper.like("WORKSCHEME_NAME" ,workscheme.getWorkschemeName());
        }

        queryWrapper.eq("IS_DELETED",0);
        return workschemeMapper.selectPaer1(page,queryWrapper);
    }
    @Override
    public int updateWorkscheme(Workschemee workschemee) {
        //修改加班方案
            return workschemeeMapper.updateById(workschemee);
        }
        //删除加班方案表
    @Override
    public int deleteWorkscheme(Integer id) {
        return workschemeeMapper.deleteById( id );
    }

    @Override
    public int addWorkschemee(Workschemee workschemee) {


            return workschemeeMapper.insert(workschemee);

    }

}
