package com.trkj.system.recruit_modular.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.system.recruit_modular.entity.Dept;
import com.trkj.system.recruit_modular.mapper.DeptsumMapper;
import com.trkj.system.recruit_modular.service.DeptsumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        wrapper.eq("DEPT_STATE",0);
        wrapper.eq("IS_DELETED",0);
        List<Dept> lssts1 = new ArrayList<>(); //存放所有子部门信息
        List<Dept> listAll = deptsumMapper.selectAll(wrapper); //存放所有部门信息
        for ( Dept depts : listAll) {
            if (depts.getMenuPid()==0){
                lssts1.add(depts);
            }
        }
        //遍历所有父部门
        for (Dept deptf : lssts1){
            List<Dept> list3 =oo(Math.toIntExact(deptf.getDeptId()),listAll);
            deptf.setDeptlist(list3);
        }

        return lssts1;
    }

    public List<Dept> oo(int id,List<Dept> allMenu){
        /* &#x5B50;&#x83DC;&#x5355; */
        List<Dept> childList = new ArrayList<Dept>();
        for (Dept nav : allMenu) {
            // 遍历所有节点，将所有菜单的父id与传过来的根节点的id比较
            //相等说明：为该根节点的子节点。
            //如果父级菜单为0 菜单类型为菜单 状态为启用
            if (nav.getMenuPid() == id) {
                childList.add(nav);
            }
        }
        //递归
        for (Dept nav : childList) {
            nav.setDeptlist(oo(Math.toIntExact(nav.getDeptId()), allMenu));
        }
        //如果节点下没有子节点，返回一个空List（递归退出）
        if (childList.size() == 0) {
            return new ArrayList<Dept>();
        }
        return childList;
    }


}
