package com.trkj.system.insurance_management.controller;


import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.trkj.system.insurance_management.entity.InsuredArchive;
import com.trkj.system.insurance_management.service.InsuredArchiveService;
import com.trkj.system.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 * <p>
 * 参保归档表 前端控制器
 * </p>
 *
 * @author 谢海欧
 * @since 2022-02-27
 */
@RestController
@RequestMapping("/insuredArchive")
public class InsuredArchiveController {
    @Autowired
    private InsuredArchiveService insuredArchiveService;

    /**
     * 归档操作
     */
    @GetMapping("/pigeonhole")
    public AjaxResponse pigeonhole(InsuredArchive insuredArchive) throws ParseException {
        if(insuredArchiveService.pigeonhole(insuredArchive)>0){
            return AjaxResponse.success("归档成功");
        }else {
            return AjaxResponse.success("归档失败");
        }
    }

    /**
     * 分页查询个人社保记录
     */
    @PostMapping("/record")
    public AjaxResponse pageRecord(@RequestBody InsuredArchive insuredArchive) throws ParseException {
      return AjaxResponse.success(insuredArchiveService.pageRecord(insuredArchive));
    }

    /**
     * 月度报表分页
     */
    @PostMapping("/monthlyReport")
    public AjaxResponse monthlyReport(@RequestBody InsuredArchive insuredArchive) throws ParseException {
        return AjaxResponse.success(insuredArchiveService.monthlyReport(insuredArchive));
    }

    /**
     * 根据年月查询归档数据
     */
    @PostMapping("/insuredArchiveList")
    public AjaxResponse insuredArchiveList(@RequestBody InsuredArchive insuredArchive) throws ParseException {
        return AjaxResponse.success(insuredArchiveService.selectList(insuredArchive));
    }


    /**
     * 分页查询归档缴纳详细数据
     */
    @PostMapping("/pageInsuredArchive")
    public AjaxResponse pageInsuredArchive(@RequestBody InsuredArchive insuredArchive) throws ParseException {
        return AjaxResponse.success(insuredArchiveService.pageInsuredArchive(insuredArchive));
    }
    /**
     * 查询归档缴纳详细数据计算
     */
    @PostMapping("/insuredArchiveCalculate")
    public AjaxResponse insuredArchiveCalculate(@RequestBody InsuredArchive insuredArchive) throws ParseException {
        return AjaxResponse.success(insuredArchiveService.insuredArchiveCalculate(insuredArchive));
    }
    /**
     * 根据归档id查询改员工数据
     */
    @PostMapping("/selectId")
    public AjaxResponse selectId(@RequestBody InsuredArchive insuredArchive) {
        return AjaxResponse.success(insuredArchiveService.selectId(insuredArchive));
    }

}

