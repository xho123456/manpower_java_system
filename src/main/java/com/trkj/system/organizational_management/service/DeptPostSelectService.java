package com.trkj.system.organizational_management.service;

import com.trkj.system.organizational_management.entity.Dept;
import com.trkj.system.organizational_management.entity.DeptPost;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

public interface DeptPostSelectService {
    List<Dept> findAll();

    int deleteId(Integer id);
    int addDeptPost(DeptPost deptPost);
}
