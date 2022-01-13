package com.trkj.system.recruit_modular.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.system.recruit_modular.entity.DeptPost;
import com.trkj.system.recruit_modular.mapper.DeptPostsumeMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.system.recruit_modular.service.DeptPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 部门职位表 服务实现类
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-08
 */
@Service
public class DeptPostsServiceImpl implements DeptPostsService {

    @Autowired
    private DeptPostsumeMapper deptPostsumeMapper;
    //通过部门id 查询所属部门职位名称
    @Override
    public List<DeptPost> selectBydeptid(DeptPost deptPost) {
        QueryWrapper<DeptPost> wrapper = new QueryWrapper<>();
        //部门编号
        wrapper.eq("DEPT_ID",deptPost.getDeptId());
        //逻辑删除
        wrapper.eq("IS_DELETED",0);
        return deptPostsumeMapper.selectByiddepts(wrapper);
    }
}
