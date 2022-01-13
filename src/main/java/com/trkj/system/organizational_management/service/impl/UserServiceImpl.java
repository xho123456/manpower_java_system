package com.trkj.system.organizational_management.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.organizational_management.entity.Dept;
import com.trkj.system.organizational_management.entity.User;
import com.trkj.system.organizational_management.mapper.Usermapper;
import com.trkj.system.organizational_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
//@Transactional//事务管理
public class UserServiceImpl implements UserService {
    @Autowired
    private Usermapper usermapper;

/*    @Override
    public List<User> selectUser(HashMap<String, Object> map) {
        return usermapper.selectByMap(map);
    }

    @Override
    public Page<User> selectPaer(Page<User> user) {
        return (Page<User>) usermapper.selectPage(user,null);
    }

    @Override
    public IPage<User> pageUser(Page<User> userPage) {
        return usermapper.selectPage(userPage,null);
    }
*/
    @Override
    public int deleteId(Integer id) {
        return usermapper.deleteById( id );
    }

    @Override
    public int updateDept(Dept dept) {
        System.out.println("111111111111111");
        return usermapper.updateById(dept);
    }

   /* @Override
    public Integer deleteList(List id) {
        return usermapper.deleteBatchIds(id);
    }*/
/*
    @Override
    @Transactional
    public int addUser(Dept dept) {
        return usermapper.insert(dept);
    }

    @Override
    @Transactional//事务注解 解决前台 修改成功 但是后台没数据
    public int updateUser(Dept dept) {
        return usermapper.updateById(dept);
    }*/



}
