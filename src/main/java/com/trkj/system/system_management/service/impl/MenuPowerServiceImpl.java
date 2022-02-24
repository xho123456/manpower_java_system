package com.trkj.system.system_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.system.system_management.entity.MenuPower;
import com.trkj.system.system_management.mapper.MenuPowerMapper;
import com.trkj.system.system_management.service.MenuPowerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-17
 */
@Service
public class MenuPowerServiceImpl implements MenuPowerService {

    @Autowired
    private MenuPowerMapper mapper;

    @Override
    public List<MenuPower> selectMenuPower(String phone) {
        List<MenuPower> menuPowers = mapper.selectMenuPower(new QueryWrapper<MenuPower>().eq("t1.staff_phone", phone));
        for (MenuPower menuPower : menuPowers) {
            for (MenuPower power : menuPowers) {
                if(menuPower.getMenuPowerId()==power.getMenuPowerPid()){
                    System.out.println(1);
                    menuPower.getMenuPower().add(power);
                }
            }
            menuPowers.add(menuPower);
        }
        return menuPowers;
    }
}
