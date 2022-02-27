package com.trkj.system.insurance_management.controller;
import com.trkj.system.insurance_management.entity.DefInsured;
import com.trkj.system.insurance_management.entity.DefInsureds;
import com.trkj.system.insurance_management.service.DefInsuredService;
import com.trkj.system.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * <p>
 * 默认参保方案表 前端控制器
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-19
 */
@RestController
public class DefInsuredController {

    @Autowired
    private DefInsuredService defInsuredService;

    /**
     * 分页查询
     * @param defInsured
     * @return
     */
    @PostMapping("/defInsured/page")
    public AjaxResponse selectPage(@RequestBody DefInsured defInsured){
        return AjaxResponse.success(defInsuredService.selectPaer(defInsured));
    }

    /**
     * 新增添加默认参保方案表方法
     */
    @PostMapping("/defInsured/insert")
    public AjaxResponse insertDefInsured(@RequestBody Map<String, Object> map){
        if(defInsuredService.insertDefInsured(map)>0){
            return AjaxResponse.success("新增成功");
        }else {
            return AjaxResponse.success("新增失败");
        }

    }

    /**
     * 查询参保方案名称是否唯一
     * @return
     */
    @PostMapping("/defInsured/name")
    public AjaxResponse selectDefInsuredName(@RequestBody Map<String, Object> map){

        if(defInsuredService.selectDefInsuredName(map)!=null){
            return AjaxResponse.success("该参保名称已存在");
        }else{
            return AjaxResponse.success("请使用");
        }

    }
    /**
     * 根据默认参保方案表id查询
     * 默认参保方案名称数据
     * 参保方案表数据
     */
    @PostMapping("/defInsured/list")
    public AjaxResponse list(@RequestBody DefInsured defInsured){
       return defInsuredService.selectDefInsuredname(defInsured);
    }

    /**
     * 参保方案修改
     */
    @PostMapping("/defInsured/amend")
    public AjaxResponse updateDefInsured(@RequestBody Map<String, Object> map){
        if(defInsuredService.updateDefInsured(map)>0){
            return AjaxResponse.success("修改成功");
        }else {
            return AjaxResponse.success("修改失败");
        }
    }

    /**
     * 默认参保方案删除
     */
    @PostMapping("/defInsured/delete")
    public AjaxResponse deleteDefInsured(@RequestBody DefInsured defInsured){
        System.out.println(defInsured);
        if(defInsuredService.deleteDefInsured(defInsured)>0) {
            return AjaxResponse.success("删除成功");
        }else {
            return AjaxResponse.success("删除失败");
        }
    }

    /**
     * 修改方案状态
     */
    @PostMapping("/defInsured/state")
    public AjaxResponse updatedefInsuredState(@RequestBody DefInsureds defInsured){
        if(defInsuredService.updatedefInsuredState(defInsured)>0) {
            return AjaxResponse.success("编辑成功");
        }else {
            return AjaxResponse.success("编辑失败");
        }
    }

    /**
     * 查询方案名称
     */
    @PostMapping("/defInsured/scheme")
    public AjaxResponse selectName(){
        return AjaxResponse.success(defInsuredService.selectName());
    }
}

