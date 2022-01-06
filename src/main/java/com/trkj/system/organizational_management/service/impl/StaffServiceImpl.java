package com.trkj.system.organizational_management.service.impl;

import com.trkj.system.organizational_management.entity.Staff;
import com.trkj.system.organizational_management.mapper.StaffMapper;
import com.trkj.system.organizational_management.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 员工表 服务实现类
 * </p>
 *
 * @author 谢海欧
 * @since 2021-12-24
 */
@Service
public class StaffServiceImpl  implements StaffService {
    @Autowired
    private StaffMapper mapper;


    @Override
    public Staff selectstaff(Long id) {
        return mapper.selectById(id);
    }
           //查询员工性别分布
    @Override
    public List<Map<String, Object>> selectSex() {
        return mapper.selectSex();
    }
    //查询员工婚姻分布
    @Override
    public List<Map<String, Object>> selecthy() {
        return mapper.selecthy();
    }
    //查询员工工龄小于一年的
    @Override
    public List<Map<String, Object>> selectgl1() {
        return mapper.selectgl1();
    }
    //查询员工工龄等于一年的
    @Override
    public List<Map<String, Object>> selectgl11() {
        return mapper.selectgl11();
    }
    //查询员工工龄等于二年的
    @Override
    public List<Map<String, Object>> selectgl2() {
        return mapper.selectgl2();
    }
    //查询员工工龄等于三年的
    @Override
    public List<Map<String, Object>> selectgl3() {
        return mapper.selectgl3();
    }
    //查询员工工龄等于四年的
    @Override
    public List<Map<String, Object>> selectgl4() {
        return mapper.selectgl4();
    }
    //查询员工工龄等于四年的
    @Override
    public List<Map<String, Object>> selectgl5() {
        return mapper.selectgl5();
    }
    //查询员工学历
    @Override
    public List<Map<String, Object>> selectxl() {
        return mapper.selectxl();
    }
    //查询员工年龄
    @Override
    public List<Map<String, Object>> selectnl() {
        return mapper.selectnl();
    }
    //查询员工星座
    @Override
    public List<Map<String, Object>> selectxz() {
        return mapper.selectxz();
    }
    //查询在职状态
    @Override
    public List<Map<String, Object>> selectygzt() {
        return mapper.selectygzt();
    }
    //查询员工年代
    @Override
    public List<Map<String, Object>> selectnd() {
        return mapper.selectnd();
    }
    //////////////////////////////////////////////////////////////////////////////////
    //人员数量分析页面
    //查询每月入职人数
    @Override
    public List<Map<String, Object>> selectrz() {
        return mapper.selectrz();
    }
}

