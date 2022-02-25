package com.trkj.system.salary_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.salary_management.entity.Businesss;
import com.trkj.system.salary_management.mapper.BusinesssMapper;
import com.trkj.system.salary_management.service.BusinesssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinesssServiceImpl implements BusinesssService {
    @Autowired
    private BusinesssMapper businesssMapper;
    @Override
    public IPage<Businesss> selectPaer(Businesss businesss) {
        Page<Businesss> page=new Page<>(businesss.getCurrentPage(),businesss.getPageSize());
        QueryWrapper<Businesss> queryWrapper=new QueryWrapper<>();

        if(businesss.getBusinessName() !=null && !businesss.getBusinessName().equals("")){
            queryWrapper.like("BUSINESS_NAME" ,businesss.getBusinessName());
        }

        queryWrapper.eq("IS_DELETED",0);
        return businesssMapper.selectPaer(page,queryWrapper);
    }

}
