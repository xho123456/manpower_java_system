package com.trkj.system.system_management.service;

import com.trkj.system.system_management.entity.MenuPower;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单权限表 服务类
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-17
 */
public interface MenuPowerService {
List<MenuPower> selectMenuPower(String phonr);
}
