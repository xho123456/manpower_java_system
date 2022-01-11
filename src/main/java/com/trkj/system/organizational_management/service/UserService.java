package com.trkj.system.organizational_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.organizational_management.entity.Dept;
import com.trkj.system.organizational_management.entity.User;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface UserService {

   /* List<User> selectUser(HashMap<String, Object> amp);
   //分页查询
    Page<User> selectPaer(Page<User> user);
    public IPage<User> pageUser(Page<User> userPage);*/


    int deleteId(Integer id);

    int updateDept(Dept dept);

  /*  *//*批量删除*//*
    Integer deleteList( List id );*/
//添加
/*    int addUser(User user);
    int updateUser(User user);*/
}
