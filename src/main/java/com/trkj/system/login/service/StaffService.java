package com.trkj.system.login.service;

import com.trkj.system.login.entity.Staff;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 员工表 服务类
 * </p>
 *
 * @author 谢海欧
 * @since 2021-12-24
 */

public interface StaffService extends IService<Staff> {
        Staff selectstaff(Long id);
}
