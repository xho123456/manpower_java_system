package com.trkj.system.insurance_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.insurance_management.entity.DefInsured;
import com.trkj.system.insurance_management.entity.DefinsuredDefSchemeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DefinsuredDefSchemeVoMapper extends BaseMapper<DefinsuredDefSchemeVo> {
    /**
     * 参保明细分页
     * @param defInsured
     * @param queryWrapper
     * @return
     */
    @Select("SELECT * FROM INSURED_PAYMENT t1\n" +
            "             LEFT JOIN STAFF t2\n" +
            "            ON t1.STAFF_ID = t2.STAFF_ID\n" +
            "             LEFT JOIN INSURED_DETAIL t3\n" +
            "             ON t1.INS_DETAIL_ID = t3.INS_DETAIL_ID\n" +
            "             LEFT JOIN DEF_INSURED t5 \n" +
            "             ON t1.DEF_INSURED_ID = t5.DEF_INSURED_ID ${ew.customSqlSegment}")
    IPage<DefinsuredDefSchemeVo> selectPaer(Page<DefinsuredDefSchemeVo> defInsured, @Param(Constants.WRAPPER) QueryWrapper<DefinsuredDefSchemeVo> queryWrapper);

    /**
     * 参保人员管理
     * @param defInsured
     * @param queryWrapper
     * @return
     */
    @Select("select * from \n" +
            "STAFF t1 LEFT JOIN DEPT t2 \n" +
            "on t1.DEPT_ID=t2.DEPT_ID\n" +
            "LEFT JOIN DEPT_POST t3 \n" +
            "on t1.DEPT_POST_ID=t3.DEPT_POST_ID\n" +
            "LEFT JOIN WORKER t4\n" +
            "on t1.STAFF_ID=t4.STAFF_ID\n" +
            "LEFT JOIN INSURED_PAYMENT t5\n" +
            "on t1.STAFF_ID= t5.STAFF_ID  ${ew.customSqlSegment}")
    IPage<DefinsuredDefSchemeVo> selectPaerss(Page<DefinsuredDefSchemeVo> defInsured, @Param(Constants.WRAPPER) QueryWrapper<DefinsuredDefSchemeVo> queryWrapper);

    /**
     * 参保明细数据
     * @param
     * @param queryWrapper
     * @return
     */
    @Select(" SELECT * FROM INSURED_PAYMENT t1\n" +
            " LEFT JOIN STAFF t2 \n" +
            " ON t1.STAFF_ID = t2.STAFF_ID\n" +
            " LEFT JOIN INSURED_DETAIL t3\n" +
            " ON t1.INS_DETAIL_ID = t3.INS_DETAIL_ID\n" +
            " LEFT JOIN DEF_INSURED t5 \n" +
            " ON t1.DEF_INSURED_ID = t5.DEF_INSURED_ID  ${ew.customSqlSegment}")
    List<DefinsuredDefSchemeVo> selectPaerzsj( @Param(Constants.WRAPPER) QueryWrapper<DefinsuredDefSchemeVo> queryWrapper);

    /**
     * 参保明细页面数据查询
     */
    @Select("select * from STAFF t1 LEFT JOIN DEPT t2\n" +
            "on t1.DEPT_ID = t2.DEPT_ID \n" +
            "LEFT JOIN DEPT_POST t3\n" +
            "on t1.DEPT_POST_ID=t3.DEPT_POST_ID\n" +
            "LEFT JOIN INSURED_PAYMENT t4\n" +
            "on t1.STAFF_ID=t4.STAFF_ID\n" +
            "LEFT JOIN DEF_INSURED t5\n" +
            "on t4.DEF_INSURED_ID=t5.DEF_INSURED_ID\n" +
            "LEFT JOIN INSURED_DETAIL t7\n" +
            "on t4.INS_DETAIL_ID = t7.INS_DETAIL_ID\n" +
            "LEFT JOIN WORKER t8\n" +
            "on t1.STAFF_ID=t8.STAFF_ID  ${ew.customSqlSegment}")
     DefinsuredDefSchemeVo selectDatas( @Param(Constants.WRAPPER) QueryWrapper<DefinsuredDefSchemeVo> queryWrapper);

    /**
     * 查询个人参保明细页面的默认方案数据数据
     */
    @Select("select * from STAFF t1 LEFT JOIN INSURED_PAYMENT t2\n" +
            "on t1.STAFF_ID=t2.STAFF_ID\n" +
            "LEFT JOIN DEF_INSURED t3\n" +
            "on t3.DEF_INSURED_ID=t2.DEF_INSURED_ID\n" +
            "LEFT JOIN DEF_SCHEME t4\n" +
            "on t4.DEF_INSURED_ID=t3.DEF_INSURED_ID ${ew.customSqlSegment}")
    List<DefinsuredDefSchemeVo> selectScheme( @Param(Constants.WRAPPER) QueryWrapper<DefinsuredDefSchemeVo> queryWrapper);


    /**
     * 修改默认方案的人数
     */
    @Select("select * from INSURED_PAYMENT t1 LEFT JOIN DEF_INSURED t2\n" +
            "    on t1.DEF_INSURED_ID=t2.DEF_INSURED_ID ${ew.customSqlSegment}")
    DefinsuredDefSchemeVo selectquantity( @Param(Constants.WRAPPER) QueryWrapper<DefinsuredDefSchemeVo> queryWrapper);

}
