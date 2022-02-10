package com.trkj.system.recruit_modular.controller;

import com.trkj.system.recruit_modular.entity.EmploymentTable;
import com.trkj.system.recruit_modular.entity.EmploymentTableVo;
import com.trkj.system.recruit_modular.entity.Resume;
import com.trkj.system.recruit_modular.entity.ResumeVo;
import com.trkj.system.recruit_modular.service.EmploymentTableServiceVo;
import com.trkj.system.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 录用表 前端控制器
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-13
 */
@RestController
public class EmploymentTableController {

    @Autowired
    private EmploymentTableServiceVo serviceVo;

    /**
     * 查询 以录用待接受信息
     */
    @PostMapping("/employment/selectdjs")
    public AjaxResponse findalldjs(@RequestBody EmploymentTableVo employmentTableVo){
        return AjaxResponse.success(serviceVo.findAllemployment(employmentTableVo));
    }

    /**
     * 通用：录用放弃原因
     */
    @PostMapping("/employment/updatelvy")
    public AjaxResponse updatehz(@RequestBody EmploymentTable employmentTable) {
        if (serviceVo.updatefq(employmentTable)>=1){
            return AjaxResponse.success("成功");
        }else{
            return AjaxResponse.success("失败");
        }
    }

    /**
     * 添加简历
     */
    @PostMapping("/employment/addemployment")
    public AjaxResponse addResumed(@RequestBody EmploymentTable employmentTable){
        if (serviceVo.addEmploy(employmentTable)>=1){
            return AjaxResponse.success("成功");
        }else {
            return AjaxResponse.success("失败");
        }

    }

    /**
     * 通过简历id查询录用表数据
     */
    @PostMapping("/employment/findByresumesAll")
    public AjaxResponse findByresumesAll(@RequestBody EmploymentTable employmentTable){
        return AjaxResponse.success(serviceVo.findbyresumeid(employmentTable));
    }

}

