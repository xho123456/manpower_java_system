package com.trkj.system.login.service.impl;

import com.trkj.system.login.entity.Staff;
import com.trkj.system.login.mapper.StaffMapper;
import com.trkj.system.login.service.StaffService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 员工表 服务实现类
 * </p>
 *
 * @author 谢海欧
 * @since 2021-12-24
 */
@Service
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff> implements StaffService {
    @Autowired
    private StaffMapper mapper;


    @Override
    public Staff selectstaff(Long id) {
        return mapper.selectById(id);
    }
}
