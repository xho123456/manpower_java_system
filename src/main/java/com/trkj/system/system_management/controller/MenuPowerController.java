package com.trkj.system.system_management.controller;


import com.trkj.system.system_management.service.MenuPowerService;
import com.trkj.system.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 菜单权限表 前端控制器
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-17
 */
@RestController
@RequestMapping("/menuPower")
public class MenuPowerController {
@Autowired
    private MenuPowerService service;

//    @GetMapping("/list")
//    public Result<?> list(){
//        List<Navigation> list=iNavigationService.list();
//        List<Navigation> navigations=new ArrayList<>();
//        for (Navigation navigation : list) {
//            for (Navigation e : list) {
//                if (e.getNavigationPid()==navigation.getNavigationId()){
//                    navigation.getChild().add(e);
//                }
//            }
//            if (navigation.getNavigationPid()==0){
//                navigations.add(navigation);
//            }
//        }
//        return Result.success(navigations);
//    }
    @GetMapping("/list/phone")
    public AjaxResponse list(@RequestParam(defaultValue = "15526008044") String phone){
        System.out.println(phone);
        return AjaxResponse.success(service.selectMenuPower(phone));
    }
}

