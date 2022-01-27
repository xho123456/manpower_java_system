package com.trkj.system.recruit_modular.controller;


import com.trkj.system.recruit_modular.entity.Evaluate;
import com.trkj.system.recruit_modular.entity.InterviewVo;
import com.trkj.system.recruit_modular.entity.Resume;
import com.trkj.system.recruit_modular.entity.ResumeVo;
import com.trkj.system.recruit_modular.service.InterviewServiceVo;
import com.trkj.system.vo.AjaxResponse;
import oracle.ucp.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * 分页查询出面试中的所有淘汰/放弃的应聘人员信息
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

    /**
     * 添加面试评论
     */
    @PostMapping("/Interview/addmianspl")
    public AjaxResponse addMinaspl(@RequestBody Evaluate evaluate){
        if (interviewServiceVo.addmianspl(evaluate)>=1){
            return AjaxResponse.success("成功");
        }else {
            return AjaxResponse.success("失败");
        }

    }

    /**
     * 查询面试评论
     */
    @PostMapping("/resumes/findbymspl")
    public AjaxResponse findbymspl(@RequestBody Evaluate evaluate){
        return AjaxResponse.success(interviewServiceVo.findallpl(evaluate));
    }

    //评论信息修改修改：通用
    @PostMapping("/resume/updatemspl")
    public AjaxResponse updatemspl(@RequestBody Evaluate evaluate) {
        if (interviewServiceVo.updatemapl(evaluate)>=1){
            return AjaxResponse.success("成功");
        }else{
            return AjaxResponse.success("失败");
        }
    }
    //评论信息修改删除
    @GetMapping("/resume/deletedmspl")
    public AjaxResponse deletedmspl(@RequestParam("id") Integer id) {
        if (interviewServiceVo.deletemapl(id)>=1){
            return AjaxResponse.success("成功");
        }else{
            return AjaxResponse.success("失败");
        }
    }

}

