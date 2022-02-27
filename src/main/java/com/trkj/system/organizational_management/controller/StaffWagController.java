package com.trkj.system.organizational_management.controller;

import com.trkj.system.organizational_management.service.StaffWagService;
import com.trkj.system.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class StaffWagController {
    @Autowired
    private StaffWagService staffWagService;

    @PostMapping("/insert/StaffWag")
    public AjaxResponse insertStaffWag(@RequestBody List<Integer> ids){
        if(staffWagService.insertStaffWag(ids)>0){
            return AjaxResponse.success("成功");
        }else{
            return AjaxResponse.success("失败");
        }
    }
    @GetMapping("/chabynogz")
    public List<Map<String, Object>> selectCount1111(){
        return staffWagService.selecbynogz();
    }
}
