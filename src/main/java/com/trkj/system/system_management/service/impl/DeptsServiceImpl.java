package com.trkj.system.system_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.system.system_management.entity.Depts;
import com.trkj.system.system_management.entity.NoticeVo;
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

    /**
     * 对话框查询所有部门名称
     * @return
     */
    @Override
    public List<Depts> selectDepts() {
        QueryWrapper<NoticeVo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("DEPT_STATE",0).eq("IS_DELETED",0);
        return deptsMapper.selectDepts(queryWrapper);
    }
}
