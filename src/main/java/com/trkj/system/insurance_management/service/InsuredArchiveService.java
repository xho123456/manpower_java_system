package com.trkj.system.insurance_management.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.system.insurance_management.entity.DefinsuredDefSchemeVo;
import com.trkj.system.insurance_management.entity.InsuredArchive;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.text.ParseException;
import java.util.List;

/**
 * <p>
 * 参保归档表 服务类
 * </p>
 *
 * @author 谢海欧
 * @since 2022-02-27
 */

public interface InsuredArchiveService {

    /**
     * 归档操作
     */
    int pigeonhole(InsuredArchive insuredArchive) throws ParseException;

    /**
     * 分页查询个人社保记录
     */
    IPage<InsuredArchive> pageRecord(InsuredArchive insuredArchive);
    /**
     * 月度报表分页
     */
    IPage<InsuredArchive> monthlyReport(InsuredArchive insuredArchive);
    /**
     * 根据年月查询归档数据
     */
    List<InsuredArchive> selectList(InsuredArchive insuredArchive) throws ParseException;
    /**
     * 分页查询归档缴纳详细数据
     */
    IPage<InsuredArchive> pageInsuredArchive(InsuredArchive insuredArchive) throws ParseException;
    /**
     * 查询归档缴纳详细数据计算
     */
    @Select("select * from INSURED_ARCHIVE ${ew.customSqlSegment}")
    List<InsuredArchive> insuredArchiveCalculate(InsuredArchive insuredArchive) throws ParseException;

    /**
     * 根据归档id查询改员工数据
     */
    InsuredArchive selectId(InsuredArchive insuredArchive);
}
