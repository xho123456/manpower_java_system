package com.trkj.system.system_management.service.impl;

import com.trkj.system.system_management.entity.Depts;
import com.trkj.system.system_management.mapper.DeptsMapper;
import com.trkj.system.system_management.service.DeptsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-04
 */
@Service
public class DeptsServiceImpl  implements DeptsService {

    @Autowired
    private DeptsMapper deptsMapper;

    @Override
    public List<Depts> selectDepts() {
        return deptsMapper.selectDepts();
    }
}
