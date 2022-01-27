package com.trkj.system.system_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.system.system_management.entity.Depts;
import com.trkj.system.system_management.mapper.DeptsMapper;
import com.trkj.system.system_management.service.DeptsService;
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
        QueryWrapper<Depts> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("DEPT_STATE",0).eq("IS_DELETED",0);
        List<Depts> list1 = new ArrayList<>(); //存放所有子部门
        List<Depts> listAll = deptsMapper.selectDepts(queryWrapper); //存放所有部门信息
        for ( Depts depts : listAll) {
            if (depts.getMenuPid()==0){
                list1.add(depts);
            }
        }
        //遍历所有父部门
        for (Depts deptf : list1){
            List<Depts> list3 =oo(Math.toIntExact(deptf.getDeptId()),listAll);
            deptf.setDeptlist(list3);
        }

        return list1;
    }

    public List<Depts> oo(int id,List<Depts> allMenu){
        /* &#x5B50;&#x83DC;&#x5355; */
        List<Depts> childList = new ArrayList<Depts>();
        for (Depts nav : allMenu) {
            // 遍历所有节点，将所有菜单的父id与传过来的根节点的id比较
            //相等说明：为该根节点的子节点。
            //如果父级菜单为0 菜单类型为菜单 状态为启用
            if (nav.getMenuPid() == id) {
                childList.add(nav);
            }
        }
        //递归
        for (Depts nav : childList) {
            nav.setDeptlist(oo(Math.toIntExact(nav.getDeptId()), allMenu));
        }
        //如果节点下没有子节点，返回一个空List（递归退出）
        if (childList.size() == 0) {
            return new ArrayList<Depts>();
        }
        return childList;
    }

}
