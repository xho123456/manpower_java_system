package com.trkj.system.salary_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.salary_management.mapper.MoneypigeonholeMapper;
import com.trkj.system.salary_management.mapper.entity.Attendandcee;
import com.trkj.system.salary_management.mapper.entity.Moneypigeonhole;
import com.trkj.system.salary_management.mapper.entity.StaffSalary;
import com.trkj.system.salary_management.service.MoneypigeonholeService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MoneypigeonholeServiceImpl implements MoneypigeonholeService {

@Autowired
private MoneypigeonholeMapper moneypigeonholeMapper;
    @Override
    public int guidanwag(Moneypigeonhole moneypigeonhole) {
        return moneypigeonholeMapper.insert(moneypigeonhole);
    }
    //查询本月工资表id
    @Override
    public List<Map<String, Object>> selectbyid() {
        return moneypigeonholeMapper.selectbyid();
    }
//  //查询本月工资表是否有
    @Override
    public List<Map<String, Object>> selectbyyf() {
        return moneypigeonholeMapper.selectbyyf();
    }



    //查询所有工资归档表
    @Override
    public IPage<Moneypigeonhole> selectPaer(Moneypigeonhole moneypigeonhole) {
        Page<Moneypigeonhole> page=new Page<>(moneypigeonhole.getCurrentPage(),moneypigeonhole.getPageSize());
        QueryWrapper<Moneypigeonhole> queryWrapper=new QueryWrapper<>();

      /*  if(moneypigeonhole.getCreatedTime() !=null && !moneypigeonhole.getCreatedTime().equals("")){
            queryWrapper.like("CREATED_TIME" ,moneypigeonhole.getCreatedTime());
        }*/
        return moneypigeonholeMapper.selectPaer(page,queryWrapper);
    }

}
