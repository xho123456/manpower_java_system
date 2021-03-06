package com.trkj.system.organizational_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.organizational_management.entity.DeptDeptPost;
import com.trkj.system.organizational_management.entity.Staff;
import com.trkj.system.organizational_management.entity.Dept;
import com.trkj.system.organizational_management.entity.DeptStaff;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
public interface DeptService {
//    IPage<DeptStaff> selectpage(Page<DeptStaff> page);
    // int updateUser( int deptid);


    @Transactional
//事务注解 解决前台 修改成功 但是后台没数据
    int updateUser(int deptid);

    IPage<DeptStaff> selectPaer(DeptStaff deptstaff);

    IPage<DeptDeptPost> selectPaer1(DeptDeptPost deptDeptPost);
    List<Staff> findAll();
    List<Dept> findAll11();
    int addDept(Dept dept);

    Integer deleteList( List id );
}