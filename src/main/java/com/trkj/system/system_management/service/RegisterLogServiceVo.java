package com.trkj.system.system_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.system.system_management.entity.RegisterLogVO;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 登录日志表 服务类
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-12
 */
public interface RegisterLogServiceVo  {
    /**
     * 分页查询
     * @param registerLogVO
     * @return
     */
    IPage<RegisterLogVO> selectPage(RegisterLogVO registerLogVO);
    /**
     * 批量删除
     */
    Integer deletRegisterLog(List id);

}
