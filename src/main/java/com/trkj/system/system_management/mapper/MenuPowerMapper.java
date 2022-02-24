package com.trkj.system.system_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.system.system_management.entity.Depts;
import com.trkj.system.system_management.entity.MenuPower;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 菜单权限表 Mapper 接口
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-17
 */

@Mapper
public interface MenuPowerMapper extends BaseMapper<MenuPower> {
    @Select("select t5.MENU_POWER_ID,t5.MENU_POWER_PID,t5.MENU_POWER_LEAF,t5.MENU_POWER_TYPE,t5.MENU_STATE,t5.PICTURE_ADDRESS,t5.MENU_POWER_NAME,\n" +
            "t5.MENU_POWER_ROUTE,t5.MENU_POWER_MODULE,t5.CREATED_TIME,t5.UPDATED_TIME,t5.REVISION,t5.IS_DELETED \n" +
            "from staff t1 LEFT JOIN ROLE_STAFF t2\n" +
            "on t1.STAFF_ID = t2.STAFF_ID LEFT JOIN ROLE t3\n" +
            "on t2.ROLE_ID = t3.ROLE_ID LEFT JOIN ROLE_MENU_POWER t4\n" +
            "on t3.ROLE_ID = t4.ROLE_ID LEFT JOIN MENU_POWER t5\n" +
            "on t4.MENU_POWER_ID = t5.MENU_POWER_ID ${ew.customSqlSegment}")
    List<MenuPower> selectMenuPower(@Param(Constants.WRAPPER) QueryWrapper<MenuPower> queryWrapper);

}
