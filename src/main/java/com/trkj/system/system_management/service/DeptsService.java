package com.trkj.system.system_management.service;

import com.trkj.system.system_management.entity.Depts;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-04
 */
public interface DeptsService {
    List<Depts> selectDepts();
}
