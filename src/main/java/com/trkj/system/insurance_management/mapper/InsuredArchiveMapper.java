package com.trkj.system.insurance_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.insurance_management.entity.DefScheme;
import com.trkj.system.insurance_management.entity.DefinsuredDefSchemeVo;
import com.trkj.system.insurance_management.entity.InsuredArchive;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 参保归档表 Mapper 接口
 * </p>
 *
 * @author 谢海欧
 * @since 2022-02-27
 */
@Mapper
public interface InsuredArchiveMapper extends BaseMapper<InsuredArchive> {
    /**
     * 分页查询归档记录
     * @param defInsured
     * @param queryWrapper
     * @return
     */
    @Select("select * from INSURED_ARCHIVE ${ew.customSqlSegment}")
    IPage<InsuredArchive> pageRecord(Page<InsuredArchive> defInsured, @Param(Constants.WRAPPER) QueryWrapper<InsuredArchive> queryWrapper);


    /**
     * 分组查询所有月份
     */
    @Select("select to_char(CREATED_TIME,'YYYY-MM') as dates,count(to_char(CREATED_TIME,'YYYY-MM')) as quantity " +
            ",sum(INS_ARCHIVE_SOCIAL_PERSON_PAY) as a,sum(INS_ARCHIVE_SOCIAL_FIRM_PAY)as b " +
            ",sum(INS_ARCHIVE_FUND_PERSON_PAY) as c,sum(INS_ARCHIVE_FUND_FIRM_PAY)as d" +
            " from INSURED_ARCHIVE GROUP  by to_char(CREATED_TIME,'YYYY-MM') ${ew.customSqlSegment}")
    IPage<InsuredArchive> monthlyReport(Page<InsuredArchive> defInsured, @Param(Constants.WRAPPER) QueryWrapper<InsuredArchive> queryWrapper);

    /**
     * 根据年份查询归档数据
     */
    @Select("select * FroM INSURED_ARCHIVE  ${ew.customSqlSegment}")
    List<InsuredArchive> selectList( @Param(Constants.WRAPPER) QueryWrapper<InsuredArchive> queryWrapper);

    /**
     * 分页查询归档缴纳详细数据
     */
    @Select("select * from INSURED_ARCHIVE ${ew.customSqlSegment}")
    IPage<InsuredArchive> pageInsuredArchive(Page<InsuredArchive> defInsured, @Param(Constants.WRAPPER) QueryWrapper<InsuredArchive> queryWrapper);

    /**
     * 查询归档缴纳详细数据计算
     */
    @Select("select * from INSURED_ARCHIVE ${ew.customSqlSegment}")
    List<InsuredArchive> insuredArchiveCalculate( @Param(Constants.WRAPPER) QueryWrapper<InsuredArchive> queryWrapper);
    /**
     * 根据归档id查询改员工数据
     */
    @Select("select * from INSURED_ARCHIVE ${ew.customSqlSegment}")
    InsuredArchive selectId(@Param(Constants.WRAPPER) QueryWrapper<InsuredArchive> queryWrapper);
}
