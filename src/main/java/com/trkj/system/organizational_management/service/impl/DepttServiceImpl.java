package com.trkj.system.organizational_management.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.trkj.system.organizational_management.entity.Depta;
import com.trkj.system.organizational_management.mapper.DepttMapper;
import com.trkj.system.organizational_management.service.DepttServicel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author 晚风
 * @since 2022-01-12
 */
@Service
public class DepttServiceImpl extends ServiceImpl<DepttMapper, Depta>implements DepttServicel {
    @Autowired
    public DepttMapper deptMapper;


    /**
     * 获取所有分类
     * @return
     */
    @Override
    public List<Depta> queryList() {



        // 用boot获取分类数据   selectAll在springboot中是获取数据表里的所有数据
        List<Depta> data = deptMapper.queryList();
        //定义新的list
        List<Depta> deptpList = new ArrayList<>();
        //先找到所有的一级分类
        for(Depta dept : data){
            // 一级菜单的parentId是0
            if(dept.getMenuPid()+""!="" && dept.getMenuPid()!=null && dept.getMenuPid() == 0){
                deptpList.add(dept);
            }
        }
        // 为一级菜单设置子菜单，getChild是递归调用的
        for(Depta dept : deptpList){
            dept.setChildren(getChilde(dept.getDeptId(), data));
        }
        return deptpList;
    }


    /**
     * 递归查找子菜单
     *
     * @param id 当前菜单id
     * @param rootList 要查找的列表
     * @return
     */
    private List<Depta> getChilde(Long id, List<Depta> rootList){
        //子级
        List<Depta> childList = new ArrayList<>();
        for(Depta dept : rootList){
            // 遍历所有节点，将父级id与传过来的id比较
            if(dept.getMenuPid()+""!="" && dept.getMenuPid()!=null && dept.getMenuPid().equals(id)){
                childList.add(dept);
            }
        }
        // 把子级的子级再循环一遍
        for(Depta dept : childList){
            if(dept.getMenuPid()+""!="" && dept.getMenuPid()!=null ){
                dept.setChildren(getChilde(dept.getDeptId(), rootList));
            }

        }
        // 递归退出条件
        if (childList.size() == 0){
            return null;
        }
        return childList;
    }





}
