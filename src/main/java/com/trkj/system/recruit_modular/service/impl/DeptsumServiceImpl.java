package com.trkj.system.recruit_modular.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.system.recruit_modular.entity.Dept;
import com.trkj.system.recruit_modular.mapper.DeptsumMapper;
import com.trkj.system.recruit_modular.service.DeptsumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-08
 */
@Service
public class DeptsumServiceImpl implements DeptsumService {
    @Autowired
    private DeptsumMapper deptsumMapper;


    @Override
    public List<Dept> findAlldept() {
        QueryWrapper<Dept> wrapper = new QueryWrapper<>();
        wrapper.eq("IS_DELETED",0);
        return deptsumMapper.selectAll(wrapper);
    }
}
