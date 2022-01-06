package com.trkj.system.organizational_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.organizational_management.entity.Staff;
import com.trkj.system.organizational_management.entity.Dept;
import com.trkj.system.organizational_management.entity.DeptStaff;

import java.util.List;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author 谢海欧
 * @since 2021-12-28
 */
public interface DeptService {
    IPage<DeptStaff> selectpage(Page<DeptStaff> page);
    int updateUser( int deptid);

    List<Staff> findAll();

    int addDept(Dept dept);
}