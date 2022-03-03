package com.trkj.system.salary_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.salary_management.mapper.entity.Attendandce;
import com.trkj.system.salary_management.mapper.entity.Attendandcee;
import com.trkj.system.salary_management.mapper.AttendandceMapper;
import com.trkj.system.salary_management.mapper.AttendandceeMapper;
import com.trkj.system.salary_management.service.AttendandceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendandceServiceImpl implements AttendandceService {
    @Autowired
    private AttendandceMapper attendandceMapper;
    @Autowired
    private AttendandceeMapper attendandceeMapper;
    @Override
    public IPage<Attendandce> selectPaer(Attendandce attendandce) {
        Page<Attendandce> page=new Page<>(attendandce.getCurrentPage(),attendandce.getPageSize());
        QueryWrapper<Attendandce> queryWrapper=new QueryWrapper<>();

        if(attendandce.getAttendandceName() !=null && !attendandce.getAttendandceName().equals("")){
            queryWrapper.like("ATTENDANDCE_NAME" ,attendandce.getAttendandceName());
        }

        queryWrapper.eq("IS_DELETED",0);
        return attendandceMapper.selectPaer(page,queryWrapper);
    }
    @Override
    public int addAttendandcee(Attendandcee attendandcee) {
        //添加考勤方案表
        return attendandceeMapper.insert(attendandcee);

    }
    @Override
    public int updateAttendandcee(Attendandcee attendandcee) {
        //修改考勤方案表
        return attendandceeMapper.updateById(attendandcee);
    }
    //删除考勤方案表
    @Override
    public int deleteAttendandcee(Integer id) {
        return attendandceeMapper.deleteById( id );
    }
}
