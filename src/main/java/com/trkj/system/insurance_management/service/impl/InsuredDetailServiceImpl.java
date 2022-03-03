package com.trkj.system.insurance_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.insurance_management.entity.*;
import com.trkj.system.insurance_management.mapper.*;
import com.trkj.system.insurance_management.service.InsuredDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
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
    @Transactional
    public IPage<DefinsuredDefSchemeVo> selectPaers(DefinsuredDefSchemeVo definsuredDefSchemeVo) {
        Page<DefinsuredDefSchemeVo> page = new Page<>(definsuredDefSchemeVo.getCurrentPage(),definsuredDefSchemeVo.getPagesize());
        QueryWrapper<DefinsuredDefSchemeVo> queryWrapper = new QueryWrapper<>();
        if(definsuredDefSchemeVo.getDeptId() != null && !definsuredDefSchemeVo.getDeptId().equals("")){
            //公告标题模糊查询
            queryWrapper.eq("c.DEPT_ID",definsuredDefSchemeVo.getDeptId());
        }else {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }

        if(definsuredDefSchemeVo.getStaffName() != null && !definsuredDefSchemeVo.getStaffName().equals("")){
            queryWrapper.like("b.STAFF_NAME",definsuredDefSchemeVo.getStaffName());
        }else {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }

        if(definsuredDefSchemeVo.getStaffState()!= null  && !definsuredDefSchemeVo.getStaffState().equals("")){
            queryWrapper.eq("b.STAFF_STATE",definsuredDefSchemeVo.getStaffState());
        }else {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }

        // 当前日期转格式
        Date now = new Date();
        LocalDate localDate = now.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Date newDate = java.sql.Date.valueOf(localDate);
        // 再转成string型
        java.text.SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
        String date = formatter.format(newDate);

        //分页查询条件

        queryWrapper.eq("b.IS_DELETED",0);
        queryWrapper.eq("c.IS_DELETED",0);

        queryWrapper.apply("TO_CHAR(a.INS_DETAIL_INSURED_MONTH,'yyyy-MM') like {0}", date).orderByDesc("a.CREATED_TIME");

        return definsuredDefSchemeVoMapper.selectPaer(page,queryWrapper);

    }

    /**
     * 参保明细数据
     */
    @Override
    public List<DefinsuredDefSchemeVo> selectPaerzsj(DefinsuredDefSchemeVo definsuredDefSchemeVo) {
        QueryWrapper<DefinsuredDefSchemeVo> queryWrapper = new QueryWrapper<>();
        // 当前日期转格式
        Date now = new Date();
        LocalDate localDate = now.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Date newDate = java.sql.Date.valueOf(localDate);
        // 再转成string型
        java.text.SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
        String date = formatter.format(newDate);

        //分页查询条件
        queryWrapper.isNotNull("t5.INSURED_PAYMENT_ID");
        queryWrapper.apply("TO_CHAR(t5.INSURED_PAYMENT_INSURED_MONTH,'yyyy-MM') like {0}", date);
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
