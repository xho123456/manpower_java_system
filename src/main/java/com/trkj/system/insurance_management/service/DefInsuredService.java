package com.trkj.system.insurance_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.system.insurance_management.entity.DefInsured;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.system.insurance_management.entity.DefInsureds;
import com.trkj.system.vo.AjaxResponse;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 默认参保方案表 服务类
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-19
 */
public interface DefInsuredService {
    /**
     * 分页条件构造器查询参保方案表
     */
    IPage<DefInsured> selectPaer(DefInsured defInsured);

    /**
     * 添加默认参保方案表方法
     */
    int insertDefInsured(Map<String, Object> map);

    /**
     * 查询参保方案名称是否唯一
     */
    DefInsured selectDefInsuredName(Map<String, Object> map);

    /**
     * 根据默认参保方案表id查询
     * 默认参保方案名称数据
     * 参保方案表数据
     */
    AjaxResponse selectDefInsuredname(DefInsured defInsured);

    /**
     * 参保方案修改
     */
    int updateDefInsured(Map<String, Object> map);

    /**
     * 默认参保方案删除
     */
    int deleteDefInsured(DefInsured defInsured);

    /**
     * 修改方案状态
     */
    int updatedefInsuredState(DefInsureds defInsured);

    /**
     * 查询方案名称
     */
    List<DefInsureds> selectName();
}
