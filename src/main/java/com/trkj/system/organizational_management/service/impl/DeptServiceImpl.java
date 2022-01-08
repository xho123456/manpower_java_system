package com.trkj.system.organizational_management.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.organizational_management.entity.Staff;
import com.trkj.system.organizational_management.mapper.StaffMapper;
import com.trkj.system.organizational_management.entity.Dept;
import com.trkj.system.organizational_management.entity.DeptStaff;
import com.trkj.system.organizational_management.mapper.DeptMapper;
import com.trkj.system.organizational_management.mapper.DeptOneMapper;
import com.trkj.system.organizational_management.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  * 部门表 服务实现类
 *  * </p>
 *  * * @author 谢海欧
 * @since 2021-12-28 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
     @Autowired
     private DeptOneMapper deptOneMapper;
    @Autowired
    private StaffMapper staffMapper;
    @Override
    public IPage<DeptStaff> selectpage(Page<DeptStaff> page) {
        return deptMapper.selectpage(page);
    }

    @Override
    @Transactional//事务注解 解决前台 修改成功 但是后台没数据
    public int updateUser(int deptid) {
        return deptOneMapper.updateById(deptid);
    }

    @Override
    public List<Staff> findAll() {
        return staffMapper.selectList();
    }

    @Override
    @Transactional
    public int addDept(Dept dept) {
        return deptOneMapper.insert(dept);
    }

}
