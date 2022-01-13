package com.trkj.system.recruit_modular.controller;


import com.trkj.system.recruit_modular.entity.DeptPost;
import com.trkj.system.recruit_modular.service.DeptPostsService;
import com.trkj.system.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 部门职位表 前端控制器
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-08
 */
@RestController
public class DeptPostController {

    @Autowired
    private DeptPostsService deptPostsService;

    /**
     * 根据部门 id 查询所属部门的所有职位名称
     */
    @PostMapping("deptpost/yyxdeptpost")
    public AjaxResponse yyxdeptpost(@RequestBody DeptPost deptPost){
        return AjaxResponse.success(deptPostsService.selectBydeptid(deptPost));
    }
}

