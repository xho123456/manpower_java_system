package com.trkj.system.insurance_management.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.trkj.system.insurance_management.entity.*;
import com.trkj.system.insurance_management.mapper.*;
import com.trkj.system.insurance_management.service.InsuredPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 参保方案表 服务实现类
 * </p>
 *
 * @author 谢海欧
 * @since 2022-02-22
 */
@Service
@Slf4j
public class InsuredPaymentServiceImpl implements InsuredPaymentService {

    @Autowired
    private DefinsuredDefSchemeVoMapper definsuredDefSchemeVoMapper;
    @Autowired
    private DefSchemeMapper defSchemeMapper;
    @Autowired
    private StaffssMapper staffssMapper;
    @Autowired
    private DefInsuredsMapper defInsuredsMapper;
    @Autowired
    private InsuredDetailMapper insuredDetailMapper;
    @Autowired
    private InsuredPaymentMapper insuredPaymentMapper;

    /**
     * 参保人员管理分页查询
     * @param definsuredDefSchemeVo
     * @return
     */
    @Override
    public IPage<DefinsuredDefSchemeVo> selectPaerss(DefinsuredDefSchemeVo definsuredDefSchemeVo) {
            Page<DefinsuredDefSchemeVo> page = new Page<>(definsuredDefSchemeVo.getCurrentPage(),definsuredDefSchemeVo.getPagesize());
            QueryWrapper<DefinsuredDefSchemeVo> queryWrapper = new QueryWrapper<>();
            if(definsuredDefSchemeVo.getDeptId() != null && !definsuredDefSchemeVo.getDeptId().equals("")){
                //公告标题模糊查询
                queryWrapper.eq("DEPT_ID",definsuredDefSchemeVo.getDeptId());
            }
            if(definsuredDefSchemeVo.getStaffName() != null && !definsuredDefSchemeVo.getStaffName().equals("")){
                queryWrapper.like("STAFF_NAME",definsuredDefSchemeVo.getStaffName());
            }

//        // 当前日期转格式
//        Date now = new Date();
//        LocalDate localDate = now.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//        Date newDate = java.sql.Date.valueOf(localDate);
////      再转成string型
//        java.text.SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        String date = formatter.format(newDate);
            //分页查询条件
//            queryWrapper.isNull("t5.INSURED_PAYMENT_ID");

            return definsuredDefSchemeVoMapper.selectPaerss(page,queryWrapper);

    }



    /**
     * 社保缴纳添加
     */
    @Override
    public int insertInsuredPaymentss(Map<String, Object> map) {

        int a=0;
        int defInsuredId = Integer.parseInt(map.get("defInsuredName").toString());
        //社保基数
        int insured = Integer.parseInt(map.get("insured").toString());
        //参保日期
        String insuredPaymentSalaryMonth=map.get("insuredPaymentSalaryMonth").toString();
        //积金基数
        int insuredPaymentNumber = Integer.parseInt(map.get("insuredPaymentNumber").toString());
        //员工id
        List<String> staffsses= JSONObject.parseArray(JSONObject.toJSONString(map.get("staffName")),String.class);
        //根据方案id查询默认方案数据
        List<DefScheme> defSchemeList = defSchemeMapper.selectDefScheme(new QueryWrapper<DefScheme>().eq("DEF_INSURED_ID",defInsuredId).eq("IS_DELETED",0));


        for(int j=0;j<staffsses.size();j++){
            //社保个人缴纳
            Double individualPays=0.00;
            //社保企业缴纳
            Double companiesPays=0.00;
            //积金个人缴纳
            Double gjindividualPays=0.00;
            //积金企业缴纳
            Double gjcompaniesPays=0.00;

            for (int i=0;i<defSchemeList.size();i++){
                int amount=0;
                //参保项目名称
                String defSchemeType=defSchemeList.get(i).getDefSchemeType();
                //最少基数
                int defSchemeMin= Math.toIntExact(defSchemeList.get(i).getDefSchemeMin());
                //最多基数
                int defSchemeMax = Math.toIntExact(defSchemeList.get(i).getDefSchemeMax());
                //基数上限
                int defSchemeUpper=Math.toIntExact(defSchemeList.get(i).getDefSchemeUpper());
                //基数下限
                int defSchemeFloor=Math.toIntExact(defSchemeList.get(i).getDefSchemeFloor());
                //个人缴纳比例
                Double defSchemePersonProp=defSchemeList.get(i).getDefSchemePersonProp();
                //公司缴纳比列
                Double defSchemeFirmProp=defSchemeList.get(i).getDefSchemeFirmProp();
                //个人固定积金
                Double defSchemePersonSum=defSchemeList.get(i).getDefSchemePersonSum();
                //公司固定金额
                Double defSchemeFirmSum=defSchemeList.get(i).getDefSchemeFirmSum();
                //比较基数大小
                if(defSchemeType.equals("公积金")){
                    //公积金
                    if(insuredPaymentNumber<=defSchemeMin){
                        //比较基数
                        if(defSchemeMin<=defSchemeFloor){
                            //社保
                            //个人缴纳金额
                            Double person=defSchemeFloor * defSchemePersonProp * 0.01;
                            //个人缴纳
                            Double individualPay= defSchemePersonSum + person;
                            //个人总社保金额
                            gjindividualPays=gjindividualPays+individualPay;

                            //企业缴纳金额
                            Double enterprise=defSchemeFloor * defSchemeFirmProp *0.01;
                            //企业缴纳
                            Double companiesPay=enterprise+defSchemeFirmSum;
                            //企业总社保金额
                            gjcompaniesPays=gjcompaniesPays+companiesPay;

                            amount=defSchemeFloor;

                        }else if(defSchemeMin>=defSchemeUpper){
                            //社保
                            //个人缴纳金额
                            Double person=defSchemeUpper * defSchemePersonProp * 0.01;
                            //个人缴纳
                            Double individualPay= defSchemePersonSum + person;
                            //个人总社保金额
                            gjindividualPays=gjindividualPays+individualPay;

                            //企业缴纳金额
                            Double enterprise=defSchemeUpper * defSchemeFirmProp *0.01;
                            //企业缴纳
                            Double companiesPay=enterprise+defSchemeFirmSum;
                            //企业总社保金额
                            gjcompaniesPays=gjcompaniesPays+companiesPay;

                        }else {
                            //社保
                            //个人缴纳金额
                            Double person=defSchemeMin * defSchemePersonProp * 0.01;
                            //个人缴纳
                            Double individualPay= defSchemePersonSum + person;
                            //个人总社保金额
                            gjindividualPays=gjindividualPays+individualPay;

                            //企业缴纳金额
                            Double enterprise=defSchemeMin * defSchemeFirmProp *0.01;
                            //企业缴纳
                            Double companiesPay=enterprise+defSchemeFirmSum;
                            //企业总社保金额
                            gjcompaniesPays=gjcompaniesPays+companiesPay;

                        }
                    }else if(insuredPaymentNumber>=defSchemeMax){
                        //比较基数
                        if(defSchemeMax<=defSchemeFloor){
                            //社保
                            //个人缴纳金额
                            Double person=defSchemeFloor * defSchemePersonProp * 0.01;
                            //个人缴纳
                            Double individualPay= defSchemePersonSum + person;
                            //个人总社保金额
                            gjindividualPays=gjindividualPays+individualPay;

                            //企业缴纳金额
                            Double enterprise=defSchemeFloor * defSchemeFirmProp *0.01;
                            //企业缴纳
                            Double companiesPay=enterprise+defSchemeFirmSum;
                            //企业总社保金额
                            gjcompaniesPays=gjcompaniesPays+companiesPay;

                        }else if(defSchemeMax>=defSchemeUpper){
                            //社保
                            //个人缴纳金额
                            Double person=defSchemeUpper * defSchemePersonProp * 0.01;
                            //个人缴纳
                            Double individualPay= defSchemePersonSum + person;
                            //个人总社保金额
                            gjindividualPays=gjindividualPays+individualPay;

                            //企业缴纳金额
                            Double enterprise=defSchemeUpper * defSchemeFirmProp *0.01;
                            //企业缴纳
                            Double companiesPay=enterprise+defSchemeFirmSum;
                            //企业总社保金额
                            gjcompaniesPays=gjcompaniesPays+companiesPay;
                        }else {
                            //社保
                            //个人缴纳金额
                            Double person=defSchemeMax * defSchemePersonProp * 0.01;
                            //个人缴纳
                            Double individualPay= defSchemePersonSum + person;
                            //个人总社保金额
                            gjindividualPays=gjindividualPays+individualPay;

                            //企业缴纳金额
                            Double enterprise=defSchemeMax * defSchemeFirmProp *0.01;
                            //企业缴纳
                            Double companiesPay=enterprise+defSchemeFirmSum;
                            //企业总社保金额
                            gjcompaniesPays=gjcompaniesPays+companiesPay;
                        }
                    }else {
                        //比较基数
                        if(insuredPaymentNumber<=defSchemeFloor){
                            //社保
                            //个人缴纳金额
                            Double person=defSchemeFloor * defSchemePersonProp * 0.01;
                            //个人缴纳
                            Double individualPay= defSchemePersonSum + person;
                            //个人总社保金额
                            gjindividualPays=gjindividualPays+individualPay;

                            //企业缴纳金额
                            Double enterprise=defSchemeFloor * defSchemeFirmProp *0.01;
                            //企业缴纳
                            Double companiesPay=enterprise+defSchemeFirmSum;
                            //企业总社保金额
                            gjcompaniesPays=gjcompaniesPays+companiesPay;

                        }else if(insuredPaymentNumber>=defSchemeUpper){
                            //社保
                            //个人缴纳金额
                            Double person=defSchemeUpper * defSchemePersonProp * 0.01;
                            //个人缴纳
                            Double individualPay= defSchemePersonSum + person;
                            //个人总社保金额
                            gjindividualPays=gjindividualPays+individualPay;

                            //企业缴纳金额
                            Double enterprise=defSchemeUpper * defSchemeFirmProp *0.01;
                            //企业缴纳
                            Double companiesPay=enterprise+defSchemeFirmSum;
                            //企业总社保金额
                            gjcompaniesPays=gjcompaniesPays+companiesPay;
                        }else {
                            //社保
                            //个人缴纳金额
                            Double person=insuredPaymentNumber * defSchemePersonProp * 0.01;
                            //个人缴纳
                            Double individualPay= defSchemePersonSum + person;
                            //个人总社保金额
                            gjindividualPays=gjindividualPays+individualPay;

                            //企业缴纳金额
                            Double enterprise=insuredPaymentNumber * defSchemeFirmProp *0.01;
                            //企业缴纳
                            Double companiesPay=enterprise+defSchemeFirmSum;
                            //企业总社保金额
                            gjcompaniesPays=gjcompaniesPays+companiesPay;
                        }
                    }
                }else {
                    //社保
                    if(insured<=defSchemeMin){
                        //比较基数
                        if(defSchemeMin<=defSchemeFloor){
                            //社保
                            //个人缴纳金额
                            Double person=defSchemeFloor * defSchemePersonProp * 0.01;
                            //个人缴纳
                            Double individualPay= defSchemePersonSum + person;
                            //个人总社保金额
                            individualPays=individualPays+individualPay;

                            //企业缴纳金额
                            Double enterprise=defSchemeFloor * defSchemeFirmProp *0.01;
                            //企业缴纳
                            Double companiesPay=enterprise+defSchemeFirmSum;
                            //企业总社保金额
                            companiesPays=companiesPays+companiesPay;

                        }else if(defSchemeMin>=defSchemeUpper){
                            //社保
                            //个人缴纳金额
                            Double person=defSchemeUpper * defSchemePersonProp * 0.01;
                            //个人缴纳
                            Double individualPay= defSchemePersonSum + person;
                            //个人总社保金额
                            individualPays=individualPays+individualPay;

                            //企业缴纳金额
                            Double enterprise=defSchemeUpper * defSchemeFirmProp *0.01;
                            //企业缴纳
                            Double companiesPay=enterprise+defSchemeFirmSum;
                            //企业总社保金额
                            companiesPays=companiesPays+companiesPay;
                        }else {
                            //社保
                            //个人缴纳金额
                            Double person=defSchemeMin * defSchemePersonProp * 0.01;
                            //个人缴纳
                            Double individualPay= defSchemePersonSum + person;
                            //个人总社保金额
                            individualPays=individualPays+individualPay;

                            //企业缴纳金额
                            Double enterprise=defSchemeMin * defSchemeFirmProp *0.01;
                            //企业缴纳
                            Double companiesPay=enterprise+defSchemeFirmSum;
                            //企业总社保金额
                            companiesPays=companiesPays+companiesPay;
                        }
                    }else if(insured>=defSchemeMax){
                        //比较基数
                        if(defSchemeMax<=defSchemeFloor){
                            //社保
                            //个人缴纳金额
                            Double person=defSchemeFloor * defSchemePersonProp * 0.01;
                            //个人缴纳
                            Double individualPay= defSchemePersonSum + person;
                            //个人总社保金额
                            individualPays=individualPays+individualPay;

                            //企业缴纳金额
                            Double enterprise=defSchemeFloor * defSchemeFirmProp *0.01;
                            //企业缴纳
                            Double companiesPay=enterprise+defSchemeFirmSum;
                            //企业总社保金额
                            companiesPays=companiesPays+companiesPay;

                        }else if(defSchemeMax>=defSchemeUpper){
                            //社保
                            //个人缴纳金额
                            Double person=defSchemeUpper * defSchemePersonProp * 0.01;
                            //个人缴纳
                            Double individualPay= defSchemePersonSum + person;
                            //个人总社保金额
                            individualPays=individualPays+individualPay;

                            //企业缴纳金额
                            Double enterprise=defSchemeUpper * defSchemeFirmProp *0.01;
                            //企业缴纳
                            Double companiesPay=enterprise+defSchemeFirmSum;
                            //企业总社保金额
                            companiesPays=companiesPays+companiesPay;
                        }else {
                            //社保
                            //个人缴纳金额
                            Double person=defSchemeMax * defSchemePersonProp * 0.01;
                            //个人缴纳
                            Double individualPay= defSchemePersonSum + person;
                            //个人总社保金额
                            individualPays=individualPays+individualPay;

                            //企业缴纳金额
                            Double enterprise=defSchemeMax * defSchemeFirmProp *0.01;
                            //企业缴纳
                            Double companiesPay=enterprise+defSchemeFirmSum;
                            //企业总社保金额
                            companiesPays=companiesPays+companiesPay;
                        }
                    }else {
                        //比较基数
                        if(insured<=defSchemeFloor){
                            //社保
                            //个人缴纳金额
                            Double person=defSchemeFloor * defSchemePersonProp * 0.01;
                            //个人缴纳
                            Double individualPay= defSchemePersonSum + person;
                            //个人总社保金额
                            individualPays=individualPays+individualPay;

                            //企业缴纳金额
                            Double enterprise=defSchemeFloor * defSchemeFirmProp *0.01;
                            //企业缴纳
                            Double companiesPay=enterprise+defSchemeFirmSum;
                            //企业总社保金额
                            companiesPays=companiesPays+companiesPay;

                        }else if(insured>=defSchemeUpper){
                            //社保
                            //个人缴纳金额
                            Double person=defSchemeUpper * defSchemePersonProp * 0.01;
                            //个人缴纳
                            Double individualPay= defSchemePersonSum + person;
                            //个人总社保金额
                            individualPays=individualPays+individualPay;

                            //企业缴纳金额
                            Double enterprise=defSchemeUpper * defSchemeFirmProp *0.01;
                            //企业缴纳
                            Double companiesPay=enterprise+defSchemeFirmSum;
                            //企业总社保金额
                            companiesPays=companiesPays+companiesPay;
                        }else {
                            //社保
                            //个人缴纳金额
                            Double person=insured * defSchemePersonProp * 0.01;
                            //个人缴纳
                            Double individualPay= defSchemePersonSum + person;
                            //个人总社保金额
                            individualPays=individualPays+individualPay;

                            //企业缴纳金额
                            Double enterprise=insured * defSchemeFirmProp *0.01;
                            //企业缴纳
                            Double companiesPay=enterprise+defSchemeFirmSum;
                            //企业总社保金额
                            companiesPays=companiesPays+companiesPay;
                        }
                    }
                }
            }
            //查询方案名称
            DefInsureds defInsureds=defInsuredsMapper.selectNames(new QueryWrapper<DefInsureds>().eq("DEF_INSURED_ID",defInsuredId).eq("IS_DELETED",0));
            //员工名称
            String staffName=staffsses.get(j);

//            //添加缴纳明细表数据
            InsuredDetail insuredDetail=new InsuredDetail();
            insuredDetail.setInsDetailStaffName(staffName);
            insuredDetail.setInsDetailInsuredName(defInsureds.getDefInsuredName());
            insuredDetail.setInsDetailInsuredMonth(new Date(insuredPaymentSalaryMonth+"/1 00:00:00"));
            insuredDetail.setInsDetailSalaryMonth(new Date(insuredPaymentSalaryMonth+"/1 00:00:00"));
            insuredDetail.setInsDetailSocialPersonPay(individualPays);
            System.out.println("个人"+individualPays);
            insuredDetail.setInsDetailSocialFirmPay(companiesPays);
            System.out.println("社保"+companiesPays);
            insuredDetail.setInsDetailFundPersonPay(gjindividualPays);
            insuredDetail.setInsDetailFundFirmPay(gjcompaniesPays);
            int insuredDetailz=insuredDetailMapper.insert(insuredDetail);

            //查询员工编号
            Staffss staffID=staffssMapper.selectStaffID(new QueryWrapper<Staffss>().eq("STAFF_NAME",staffName).eq("IS_DELETED",0));
            //添加缴纳表数据
            InsuredPayment insuredPayment=new InsuredPayment();
            insuredPayment.setStaffId(staffID.getStaffId());
            insuredPayment.setDefInsuredId((long) defInsuredId);
            insuredPayment.setInsDetailId(Long.parseLong(insuredDetail.getInsDetailId().toString()));
            insuredPayment.setInsuredPaymentNumber((long) insured);
            insuredPayment.setInsuredPaymentFund((long) insuredPaymentNumber);
            insuredPayment.setInsuredPaymentInsuredMonth(new Date(insuredPaymentSalaryMonth+"/1 00:00:00"));
            insuredPayment.setInsuredPaymentSalaryMonth(new Date(insuredPaymentSalaryMonth+"/1 00:00:00"));
            if(insuredPaymentMapper.insert(insuredPayment)>0){
                DefInsureds defInsuredss=defInsuredsMapper.selectNames(new QueryWrapper<DefInsureds>().eq("DEF_INSURED_ID",defInsuredId).eq("IS_DELETED",0));
                int defInsuredNumber= Math.toIntExact(defInsuredss.getDefInsuredNumber());
                DefInsureds defInsureds1=new DefInsureds();
                defInsureds1.setDefInsuredId(defInsuredId);
                defInsureds1.setDefInsuredName(defInsureds.getDefInsuredName());
                defInsureds1.setDefInsuredNumber((long) (defInsuredNumber+1));
                if(defInsuredsMapper.updateById(defInsureds1)>0){
                    a=1;
                }
            }
        }
        return a;
    }

    /**
     * 更改方案
     * @param insuredPayment
     * @return
     */
    @Override
    public int deletescheme(InsuredPayment insuredPayment) {
        int a=0;
        InsuredPayment insuredPaymentId=insuredPaymentMapper.deletescheme(new QueryWrapper<InsuredPayment>()
                .eq("INSURED_PAYMENT_ID",insuredPayment.getInsuredPaymentId()));
        DefinsuredDefSchemeVo definsuredDefSchemeVo=definsuredDefSchemeVoMapper.selectquantity(new QueryWrapper<DefinsuredDefSchemeVo>()
                .eq("INSURED_PAYMENT_ID",insuredPayment.getInsuredPaymentId()));
        if(insuredPaymentMapper.deleteById(insuredPayment.getInsuredPaymentId())>0){

            if(insuredDetailMapper.deleteById(insuredPaymentId.getInsDetailId())>0){
               DefInsureds defInsureds=new DefInsureds();
               defInsureds.setDefInsuredId(definsuredDefSchemeVo.getDefInsuredId());
               defInsureds.setDefInsuredName(definsuredDefSchemeVo.getDefInsuredName());
               defInsureds.setDefInsuredNumber(definsuredDefSchemeVo.getDefInsuredNumber()-1);
               if(defInsuredsMapper.updateById(defInsureds)>0){
                   a=1;
               }
            }
        }
        return a;
    }


}
