package com.trkj.system.salary_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.salary_management.mapper.entity.Wagenotfiledd;

import com.trkj.system.salary_management.mapper.WagenotfileddMapper;
import com.trkj.system.salary_management.service.WagenotfileddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WagenotfileddServiceImpl implements WagenotfileddService {
    @Autowired
    private WagenotfileddMapper wagenotfileddMapper;
    @Override
    public IPage<Wagenotfiledd> selectPaer(Wagenotfiledd wagenotfiledd) {
        Page<Wagenotfiledd> page=new Page<>(wagenotfiledd.getCurrentPage(),wagenotfiledd.getPageSize());
        QueryWrapper<Wagenotfiledd> queryWrapper=new QueryWrapper<>();

        if(wagenotfiledd.getCreatedTime() !=null && !wagenotfiledd.getCreatedTime().equals("")){
            queryWrapper.like("CREATED_TIME" ,wagenotfiledd.getCreatedTime());
        }

        queryWrapper.eq("IS_DELETED",0);
        return wagenotfileddMapper.selectPaer(page,queryWrapper);
    }

}
