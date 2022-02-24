package com.trkj.system.organizational_management.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.system.organizational_management.entity.StaffWag;
import com.trkj.system.organizational_management.mapper.StaffWagMapper;
import com.trkj.system.organizational_management.service.StaffWagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
public class StaffWagServiceImpl extends ServiceImpl<StaffWagMapper,StaffWag> implements StaffWagService {

@Autowired
private StaffWagMapper staffWagMapper;

//根据传过来的员工id，生成对应多少的员工工资表
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertStaffWag(List<Integer> ids) {
        int insert=0;
        StaffWag staffWag=new StaffWag();
        for (Integer e : ids) {
            staffWag.setStaffId(e);
            insert = staffWagMapper.insert(staffWag);
        }
        return insert;



    }

    @Override
    public List<Map<String, Object>> selecbynogz() {
        return  staffWagMapper.selecbynogz();
    }


}
