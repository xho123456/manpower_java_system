package com.trkj.system.insurance_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.insurance_management.entity.*;
import com.trkj.system.insurance_management.mapper.*;
import com.trkj.system.insurance_management.service.InsuredDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 参保明细表 服务实现类
 * </p>
 *
 * @author 谢海欧
 * @since 2022-02-23
 */
@Service
public class InsuredDetailServiceImpl implements InsuredDetailService {
    @Autowired
    private DefinsuredDefSchemeVoMapper definsuredDefSchemeVoMapper;



     /**
     * 参保明细分页
     */
    @Override
    public IPage<DefinsuredDefSchemeVo> selectPaers(DefinsuredDefSchemeVo definsuredDefSchemeVo) {
        Page<DefinsuredDefSchemeVo> page = new Page<>(definsuredDefSchemeVo.getCurrentPage(),definsuredDefSchemeVo.getPagesize());
        QueryWrapper<DefinsuredDefSchemeVo> queryWrapper = new QueryWrapper<>();
        if(definsuredDefSchemeVo.getDeptId() != null && !definsuredDefSchemeVo.getDeptId().equals("")){
            //公告标题模糊查询
            queryWrapper.like("t2.DEPT_ID",definsuredDefSchemeVo.getDeptId());
        }
        if(definsuredDefSchemeVo.getStaffName() != null && !definsuredDefSchemeVo.getStaffName().equals("")){
            queryWrapper.like("t2.STAFF_NAME",definsuredDefSchemeVo.getStaffName());
        }
        if(definsuredDefSchemeVo.getStaffState()!= null  && !definsuredDefSchemeVo.getStaffState().equals("")){
            queryWrapper.like("t2.STAFF_STATE",definsuredDefSchemeVo.getStaffState());
        }
        //分页查询条件
        queryWrapper.eq("t5.DEF_INSURED_STATE",0);
        queryWrapper.eq("t5.IS_DELETED",0);
        return definsuredDefSchemeVoMapper.selectPaer(page,queryWrapper);

    }

    /**
     * 参保明细数据
     */
    @Override
    public List<DefinsuredDefSchemeVo> selectPaerzsj(DefinsuredDefSchemeVo definsuredDefSchemeVo) {
        QueryWrapper<DefinsuredDefSchemeVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("t5.DEF_INSURED_STATE",0);
        queryWrapper.eq("t5.IS_DELETED",0);
        return definsuredDefSchemeVoMapper.selectPaerzsj(queryWrapper);

    }

    /**
     * 参保明细页面数据源
     * @param definsuredDefSchemeVo
     * @return
     */
    @Override
    public DefinsuredDefSchemeVo selectDatas(DefinsuredDefSchemeVo definsuredDefSchemeVo) {
        QueryWrapper queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("t1.STAFF_ID",definsuredDefSchemeVo.getStaffId() );
        queryWrapper.eq("t1.IS_DELETED",0);
        return definsuredDefSchemeVoMapper.selectDatas(queryWrapper);
    }

    /**
     * 查询个人参保明细页面的默认方案数据数据
     */
    @Override
    public List<DefinsuredDefSchemeVo> selectScheme(DefinsuredDefSchemeVo definsuredDefSchemeVo) {
            List<DefinsuredDefSchemeVo> defSchemeList=definsuredDefSchemeVoMapper.selectScheme(new QueryWrapper<DefinsuredDefSchemeVo>()
                    .eq("t1.STAFF_ID",definsuredDefSchemeVo.getStaffId())
                    .eq("t1.IS_DELETED",0));
            return defSchemeList;
    }




}
