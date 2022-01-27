package com.trkj.system.system_management.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.system.system_management.entity.RegisterLogVO;
import com.trkj.system.system_management.service.RegisterLogServiceVo;
import com.trkj.system.vo.AjaxResponse;
import oracle.ucp.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * <p>
 * 登录日志表 前端控制器
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-12
 */
@RestController
public class RegisterLogVoController {
    @Autowired
    private RegisterLogServiceVo registerLogServiceVo;

    /**
     * 分页查询
     * @param registerLogVO
     * @return
     */
    @PostMapping("/registerLog/log")
    public AjaxResponse selectPage(@RequestBody RegisterLogVO registerLogVO){
        return AjaxResponse.success(registerLogServiceVo.selectPage(registerLogVO));
    }

    /**
     * 批量删除
     * @param id
     * @return
     */
    @DeleteMapping("/registerLog/delete")
    public AjaxResponse deleteregisterLog(@RequestBody ArrayList<Integer> id){
        System.out.println(id);
        if(registerLogServiceVo.deletRegisterLog(id)>0){
            return AjaxResponse.success("删除成功");
        }else {
            return AjaxResponse.success("删除失败");
        }
    }
}

