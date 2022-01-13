package com.trkj.system.recruit_modular.controller;


import com.trkj.system.recruit_modular.entity.InterviewVo;
import com.trkj.system.recruit_modular.entity.ResumeVo;
import com.trkj.system.recruit_modular.service.InterviewServiceVo;
import com.trkj.system.vo.AjaxResponse;
import oracle.ucp.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 面试表 前端控制器
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-12
 */
@RestController
public class InterviewController {

    @Autowired
    private InterviewServiceVo interviewServiceVo;
    /**
     * 简历列表分页查询：已邀约
     */
    @PostMapping("/resume/findselectAllyy")
    public AjaxResponse findselectAllyy(@RequestBody InterviewVo interviewVo){
        return AjaxResponse.success(interviewServiceVo.findAllInvite(interviewVo));
    }
    /**
     * 分页查询出面试中的所有应聘人员信息
     * @return
     */
    @PostMapping("/intersss")
    public AjaxResponse findffd(@RequestBody InterviewVo interviewVo){
       return AjaxResponse.success(interviewServiceVo.findall(interviewVo));
    }

    /**
     * 分页查询出面试中的所有应聘人员信息
     * @return
     */
    @PostMapping("/interfus")
    public AjaxResponse interfus(@RequestBody InterviewVo interviewVo){
        return AjaxResponse.success(interviewServiceVo.findallfs(interviewVo));
    }

    /**
     * 分页查询出面试通过的所有应聘人员信息
     * @return
     */
    @PostMapping("/interadopt")
    public AjaxResponse interadopt(@RequestBody InterviewVo interviewVo){
        return AjaxResponse.success(interviewServiceVo.selectAlladopt(interviewVo));
    }

}

