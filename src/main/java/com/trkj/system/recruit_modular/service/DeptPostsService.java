package com.trkj.system.recruit_modular.service;

import com.trkj.system.recruit_modular.entity.DeptPost;

import java.util.List;

/**
 * <p>
 * 部门职位表 服务类
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-08
 */
public interface DeptPostsService{
    //通过部门id 查询所属部门职位名称
    List<DeptPost> selectBydeptid(DeptPost deptPost);
}
