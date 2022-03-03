package com.trkj.system.organizational_management.service.impl;
//
import com.trkj.system.organizational_management.entity.Dept;
import com.trkj.system.organizational_management.entity.DeptDeptPost;
import com.trkj.system.organizational_management.entity.DeptPost;
import com.trkj.system.organizational_management.entity.DeptPostOne;
import com.trkj.system.organizational_management.mapper.DeptOneMapper;
import com.trkj.system.organizational_management.mapper.DeptPostMapper;
import com.trkj.system.organizational_management.mapper.DeptPostOneMapper;
import com.trkj.system.organizational_management.mapper.DeptPostSelectMapper;
import com.trkj.system.organizational_management.service.DeptPostSelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class DeptPostSelectServiceImpl implements DeptPostSelectService {
    @Autowired
    private DeptPostSelectMapper deptPostSelectMapper;
    @Autowired
    private DeptOneMapper deptOneMapper;
    @Autowired
    private DeptPostOneMapper deptPostOneMapper;
    @Autowired
    private DeptPostMapper deptPostMapper;
    @Override
    @Transactional
    public List<Dept> findAll() {
        return deptOneMapper.selectList();
    }
    @Override
    public int deleteId(Integer id) {
        return deptPostSelectMapper.deleteById( id );
    }


    @Override
    @Transactional
    public int addDeptPost(DeptPostOne deptPostOne) {
        return deptPostOneMapper.insert(deptPostOne);
    }

    @Override
    public int updatePost(DeptPostOne deptPostOne) {
        return deptPostOneMapper.updateById(deptPostOne);
    }

}
