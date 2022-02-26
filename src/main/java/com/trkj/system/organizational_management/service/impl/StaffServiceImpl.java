package com.trkj.system.organizational_management.service.impl;

import com.trkj.system.organizational_management.entity.Staff;
import com.trkj.system.organizational_management.mapper.StaffMapper;
import com.trkj.system.organizational_management.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


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

    //查询本月入职人数
    @Override
    public List<Map<String, Object>> selectbyrz() {
        return mapper.selectbyrz();
    }

    //查询上月入职人数
    @Override
    public List<Map<String, Object>> selectsyrz() {
        return mapper.selectsyrz();
    }


    //查询每月离职人数
    @Override
    public List<Map<String, Object>> selectyglz() {
        return mapper.selectyglz();
    }
    //查询每月离职人数
    @Override
    public List<Map<String, Object>> selectyglz1() {
        return mapper.selectyglz1();
    }
    //查询单月离职人数
    @Override
    public List<Map<String, Object>> selectdylz() {
        return mapper.selectdylz();
    }
    //查询上月离职人数
    @Override
    public List<Map<String, Object>> selectsylz() {
        return mapper.selectsylz();
    }
    //查询每月转正人数
    @Override
    public List<Map<String, Object>> selectygzz() {
        return mapper.selectygzz();
    }
    //查询本月转正人数
    @Override
    public List<Map<String, Object>> selectbyygzz() {
        return mapper.selectbyygzz();
    }
    //查询上月转正人数
    @Override
    public List<Map<String, Object>> selectsyygzz() {
        return mapper.selectsyygzz();
    }
    //查询部门人数top榜
    @Override
    public List<Map<String, Object>> selectdepttop() {
        return mapper.selectbdepttop();
    }
    //查询员工新进律
    @Override
    public List<Map<String, Object>> selectygxj() {
        return mapper.selectygxj();
    }
//查询每月请假人数
    @Override
    public List<Map<String, Object>> selectqjrs() {
        return mapper.selectqjrs();
    }
    //查询本月请假人数
    @Override
    public List<Map<String, Object>> selectdyqjrs() {
        return mapper.selectdyqjrs();
    }

    //每月出差人数
    @Override
    public List<Map<String, Object>> selectccrs() {
        return mapper.selectccrs();
    }
    //本月出差人数
    @Override
    public List<Map<String, Object>> selectdyccrs() {
        return mapper.selectdyccrs();
    }
    //每月员工加班总小时
    @Override
    public List<Map<String, Object>> selectjbtime() {
        return mapper.selectjbtime();
    }
    //本月月员工加班总小时
    @Override
    public List<Map<String, Object>> selectbyjbtime() {
        return mapper.selectbyjbtime();
    }


    //人员总数
    @Override
    public  List<Map<String, Object>> selectStaffrs(){
        return  mapper.selectStaffrs();
    }
    //每月计薪人数
    @Override
    public  List<Map<String, Object>> selectjxrs(){
        return  mapper.selectjxrs();
    }
    //本月计薪人数
    @Override
    public  List<Map<String, Object>> selectbyjxrs(){
        return  mapper.selectbyjxrs();
    }

    //每月人力成本
    @Override
    public  List<Map<String, Object>> selectrlcb(){
        return  mapper.selectrlcb();
    }
    //本月人力成本
    @Override
    public  List<Map<String, Object>> selectbyrlcb(){
        return  mapper.selectbyrlcb();
    }

    //每月参保人数
    @Override
    public  List<Map<String, Object>> selectbxrs(){
        return  mapper.selectbxrs();
    }
    //本月参保人数
    @Override
    public  List<Map<String, Object>> selectbybxrs(){
        return  mapper.selectbybxrs();
    }
    //每月员工社保金额
    @Override
    public  List<Map<String, Object>> selectygsbje(){
        return  mapper.selectygsbje();
    }

    //本月月员工社保金额
    @Override
    public  List<Map<String, Object>> selectbyygsbje(){
        return  mapper.selectbyygsbje();
    }
    //每月公司社保金额
    @Override
    public  List<Map<String, Object>> selectgssbje(){
        return  mapper.selectgssbje();
    }
    //本月公司社保金额
    @Override
    public  List<Map<String, Object>> selectbygssbje(){
        return  mapper.selectbygssbje();
    }
    //本月试用基本工资
    @Override
    public  List<Map<String, Object>> selectbysyjbgz(){
        return  mapper.selectbysyjbgz();
    }
    //本月正式基本工资
    @Override
    public  List<Map<String, Object>> selectbyzsjbgz(){
        return  mapper.selectbyzsjbgz();
    }
    //本月基本工资
    @Override
    public List<Map<String, Object>> selectbyzsjbgzz() {
        return  mapper.selectbyzsjbgzz();
    }
    //本月个人缴公积金
    @Override
    public List<Map<String, Object>> selectbygrgjj() {
        return  mapper.selectbygrgjj();
    }
    //本月 个人缴社保
    @Override
    public List<Map<String, Object>> selectbygrsb() {
        return  mapper.selectbygrsb();
    }
    //本月公司缴社保
    @Override
    public List<Map<String, Object>> selectbygssb() {
        return  mapper.selectbygssb();
    }
    //本月公司缴公积金
    @Override
    public List<Map<String, Object>> selectbygsgjj() {
        return  mapper.selectbygsgjj();
    }
    //部门工资top榜
    @Override
    public List<Map<String, Object>> selectbmgztop() {
        return  mapper.selectbmgztop();
    }

    @Override
    public List<Map<String, Object>> selectbmgzpj() {
        return  mapper.selectbmgzpj();
    }

    @Override
    public List<Map<String, Object>> selectyglz11() {
        return  mapper.selectyglz11();
    }
}

