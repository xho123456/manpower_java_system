package com.trkj.system.organizational_management.service;

import com.trkj.system.organizational_management.entity.Dept;
import com.trkj.system.organizational_management.entity.DeptStaff;
import com.trkj.system.organizational_management.entity.Depta;

import java.util.List;

public interface DepttServicel {
    //上下级查询
    List<Depta> queryList();
}
