package com.trkj.system.organizational_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.organizational_management.entity.DeptDeptPost;
import com.trkj.system.organizational_management.entity.Staff;
import com.trkj.system.organizational_management.mapper.DeptPostMapper;
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

@Service

public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
     @Autowired
     private DeptOneMapper deptOneMapper;
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private DeptPostMapper deptPostMapper;
//    @Override
//    public IPage<DeptStaff> selectpage(Page<DeptStaff> page) {
//        return deptMapper.selectpage(page);
//    }

    @Override
    @Transactional//事务注解 解决前台 修改成功 但是后台没数据
    public int updateUser(int deptid) {
        return deptOneMapper.updateById(deptid);
    }

    @Override
    public IPage<DeptStaff> selectPaer(DeptStaff deptstaff) {
        Page<DeptStaff> page=new Page<>(deptstaff.getCurrentPage(),deptstaff.getPageSize());
        QueryWrapper<DeptStaff> queryWrapper=new QueryWrapper<>();

        if(deptstaff.getDeptName() !=null && !deptstaff.getDeptName().equals("")){
                queryWrapper.like("d.DEPT_NAME" ,deptstaff.getDeptName());
        }
        if(deptstaff.getDeptName() !=null && !deptstaff.getDeptName().equals("")){
            queryWrapper.like("d.DEPT_NAME" ,deptstaff.getDeptName());
        }
        queryWrapper.eq("d.IS_DELETED",0);
        return deptMapper.selectPaer(page,queryWrapper);
    }

    @Override
    public IPage<DeptDeptPost> selectPaer1(DeptDeptPost deptDeptPost) {
        Page<DeptDeptPost> page=new Page<>(deptDeptPost.getCurrentPage(),deptDeptPost.getPageSize());
        QueryWrapper<DeptDeptPost> queryWrapper=new QueryWrapper<>();

        if(deptDeptPost.getPostName() !=null && !deptDeptPost.getPostName().equals("")){
            queryWrapper.like("p.POST_NAME" ,deptDeptPost.getPostName());
        }

        queryWrapper.eq("p.IS_DELETED",0);
        return deptPostMapper.selectPaer1(page,queryWrapper);
    }


    @Override
    @Transactional
    public List<Staff> findAll() {
        return staffMapper.selectList();
    }
    //删除部门、、逻辑删除
    @Override
    public Integer deleteList(List id) {
        return deptOneMapper.deleteBatchIds(id);
    }

    @Override
    @Transactional
    public int addDept(Dept dept) {
        return deptOneMapper.insert(dept);
    }

}
