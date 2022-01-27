package com.trkj.system.system_management.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.system_management.entity.NoticeDept;
import com.trkj.system.system_management.entity.RegisterLogVO;
import com.trkj.system.system_management.mapper.RegisterLogVoMapper;
import com.trkj.system.system_management.service.RegisterLogServiceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 登录日志表 服务实现类
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-12
 */
@Service
public class RegisterLogServiceVoImpl implements RegisterLogServiceVo {


    @Autowired
    private RegisterLogVoMapper registerLogVoMapper;
    @Override
    public IPage<RegisterLogVO> selectPage(RegisterLogVO registerLogVO) {
        Page<RegisterLogVO> page=new Page<>(registerLogVO.getCurrentPage(),registerLogVO.getPagesize());
        QueryWrapper<RegisterLogVO> queryWrapper = new QueryWrapper<>();
        System.out.println("327846728364872");
        //IP地址查询
        if(registerLogVO.getRegisterLogIp()!=null && !registerLogVO.getRegisterLogIp().equals("")){
            queryWrapper.like("t1.REGISTER_LOG_IP",registerLogVO.getRegisterLogIp());
            System.out.println("eurioqweuior");
        }
        //员工名称查询
        if(registerLogVO.getStaffId()!=null&& !registerLogVO.getStaffName().equals("")){
            queryWrapper.like("t2.STAFF_NAME",registerLogVO.getStaffName());
        }
        //登录状态查询
        if(registerLogVO.getRegisterLogState()!=null&& !registerLogVO.getRegisterLogState().equals("")){
            queryWrapper.eq("t1.REGISTER_LOG_STATE",registerLogVO.getRegisterLogState());
        }
        //登录时间段查询
        if(registerLogVO.getStartTime()!=null&& registerLogVO.getEndTime()!=null){
            queryWrapper.between("t1.CREATED_TIME",registerLogVO.getStartTime(),registerLogVO.getEndTime());
        }
        queryWrapper.eq("t1.IS_DELETED",0);
        return registerLogVoMapper.selectPage(page,queryWrapper);
    }

    @Override
    public Integer deletRegisterLog(List id) {
        QueryWrapper<RegisterLogVO> wrapper=new QueryWrapper<>();
        for(int i=0 ; i<id.size();i++){
            wrapper.eq("REGISTER_LOG_ID",id.get(i));
        }
        return registerLogVoMapper.deletRegisterLog(wrapper);
    }
}
