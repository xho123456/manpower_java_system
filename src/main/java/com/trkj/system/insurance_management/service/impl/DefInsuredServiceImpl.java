package com.trkj.system.insurance_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.system.insurance_management.entity.DefInsured;
import com.trkj.system.insurance_management.mapper.DefInsuredMapper;
import com.trkj.system.insurance_management.service.DefInsuredService;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

@Service
public class DefInsuredServiceImpl implements DefInsuredService {

    @Autowired
    private DefInsuredMapper defInsuredMapper;

    /**
     * 分页条件构造器查询参保方案表
     * @param defInsured
     * @return
     */
    @Override
    public IPage<DefInsured> selectPaer(DefInsured defInsured) {
        Page<DefInsured> page = new Page<>(defInsured.getCurrentPage(),defInsured.getPagesize());
        QueryWrapper<DefInsured> queryWrapper = new QueryWrapper<>();
        if(defInsured.getDefInsuredState() != null && !defInsured.getDefInsuredState().equals("")){
            //公告标题模糊查询
            queryWrapper.like("DEF_INSURED_STATE",defInsured.getDefInsuredState());
        }
        //分页查询条件
        queryWrapper.eq("IS_DELETED",0);

        return defInsuredMapper.selectPaer(page,queryWrapper);
    }
}
