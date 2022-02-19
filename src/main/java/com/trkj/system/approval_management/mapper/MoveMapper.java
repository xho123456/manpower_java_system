package com.trkj.system.approval_management.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.approval_management.entity.MoveEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MoveMapper extends BaseMapper<MoveEntity> {
    /**
     * 查看所有异动待办审批
     * @param page
     * @return
     */
    @Select("SELECT tr.AUDITFLOW_ID,tr.CREATED_TIME,tr.TRANSFER_TYPE,tr.CREATED_DEPT_NAME,tr.UPDATED_DEPT_NAME," +
            "tr.transfer_rawpost_NAME,tr.transfer_afterpost_NAME,tr.TAKE_EFFECT_DATE,au.AUDITFLOW_TYPE," +
            "s.STAFF_NAME as STAFFNAME1,ae.STAFF_NAME as STAFFNAME2,ae.AUDITFLOWDETAI_DATE,ae.AUDITFLOWDETAI_STATE" +
            " FROM TRANSFER tr LEFT JOIN AUDITFLOW au on tr.AUDITFLOW_ID=au.AUDITFLOW_ID LEFT JOIN STAFF s on au.STAFF_ID=s.STAFF_ID" +
            " LEFT JOIN AUDITFLOWDETAIL ae on ae.AUDITFLOW_ID=au.AUDITFLOW_ID where ae.AUDITFLOWDETAI_STATE=1 ")
    IPage<MoveEntity> Moveapperme(Page<MoveEntity> page);

    /**
     * 查看所有异动已办审批
     * @param page
     * @return
     */
    @Select("SELECT tr.AUDITFLOW_ID,tr.CREATED_TIME,tr.TRANSFER_TYPE,tr.CREATED_DEPT_NAME,tr.UPDATED_DEPT_NAME," +
            "tr.transfer_rawpost_NAME,tr.transfer_afterpost_NAME,tr.TAKE_EFFECT_DATE,au.AUDITFLOW_TYPE," +
            "s.STAFF_NAME as STAFFNAME1,ae.STAFF_NAME as STAFFNAME2,ae.AUDITFLOWDETAI_DATE,ae.AUDITFLOWDETAI_STATE" +
            " FROM TRANSFER tr LEFT JOIN AUDITFLOW au on tr.AUDITFLOW_ID=au.AUDITFLOW_ID LEFT JOIN STAFF s on au.STAFF_ID=s.STAFF_ID" +
            " LEFT JOIN AUDITFLOWDETAIL ae on ae.AUDITFLOW_ID=au.AUDITFLOW_ID where ae.AUDITFLOWDETAI_STATE=2 ")
    IPage<MoveEntity> Moveappered(Page<MoveEntity> page);
}
