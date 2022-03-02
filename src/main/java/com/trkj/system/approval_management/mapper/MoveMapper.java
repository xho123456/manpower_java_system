package com.trkj.system.approval_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.approval_management.entity.LeaveEntity;
import com.trkj.system.approval_management.entity.MoveEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MoveMapper extends BaseMapper<MoveEntity> {

    /**
     * 查看我的异动审批
     * @param page
     * @return
     */
    @Select("SELECT tr.AUDITFLOW_ID,tr.CREATED_TIME,tr.TRANSFER_TYPE,tr.CREATED_DEPT_NAME,tr.UPDATED_DEPT_NAME," +
            "tr.transfer_rawpost_NAME,tr.transfer_afterpost_NAME,tr.TAKE_EFFECT_DATE,au.AUDITFLOW_STATE,au.AUDITFLOW_TYPE,au.AUDITFLOW_TITLE," +
            "s.STAFF_NAME as STAFFNAME,ae.STAFF_NAME as STAFFNAME2,ae.AUDITFLOWDETAI_DATE,ae.AUDITFLOWDETAI_STATE" +
            " FROM TRANSFER tr LEFT JOIN AUDITFLOW au on tr.AUDITFLOW_ID=au.AUDITFLOW_ID LEFT JOIN STAFF s on au.STAFF_ID=s.STAFF_ID " +
            " LEFT JOIN AUDITFLOWDETAIL ae on ae.AUDITFLOW_ID=au.AUDITFLOW_ID ${ew.customSqlSegment} ")
    IPage<MoveEntity> Moveapperme(Page<MoveEntity> moveEntityPage, @Param(Constants.WRAPPER) QueryWrapper<MoveEntity> queryWrapper);

    /**
     * 查看当前用户的部门名称
     */
    @Select("select d.dept_name from staff s left join dept d on s.dept_id = d.dept_id where s.staff_id = #{id}")
    MoveEntity MoveDeptName (Integer id);

    /**
     * 查看所有部门名称
     */
    @Select("select dept_id,dept_name from dept")
    List<MoveEntity> allDeptName ();
}
