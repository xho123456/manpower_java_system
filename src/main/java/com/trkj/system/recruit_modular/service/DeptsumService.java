package com.trkj.system.recruit_modular.service;

import com.trkj.system.recruit_modular.entity.Dept;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-08
 */
public interface DeptsumService {

    List<Dept> findAlldept();


}
