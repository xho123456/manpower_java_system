package com.trkj.system.insurance_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.system.insurance_management.entity.*;
import com.trkj.system.insurance_management.mapper.*;
import com.trkj.system.insurance_management.service.InsuredArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 参保归档表 服务实现类
 * </p>
 *
 * @author 谢海欧
 * @since 2022-02-27
 */
@Service
public class InsuredArchiveServiceImpl implements InsuredArchiveService {
    @Autowired
    private DefinsuredDefSchemeVoMapper definsuredDefSchemeVoMapper;
    @Autowired
    private InsuredArchiveMapper insuredArchiveMapper;
    @Autowired
    private DefSchemeMapper defSchemeMapper;
    @Autowired
    private InsuredDetailMapper insuredDetailMapper;
    @Autowired
    private InsuredPaymentMapper insuredPaymentMapper;

    /**
     * 归档操作
     * @param insuredArchive
     * @return
     */
    @Override
    public int pigeonhole(InsuredArchive insuredArchive) throws ParseException {
        int a=0;
        // 当前日期转格式
        Date now = new Date();
        LocalDate localDate = now.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Date newDate = java.sql.Date.valueOf(localDate);
        // 再转成string型
        java.text.SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
        String date = formatter.format(newDate);

        //查询除社保数据
        List<DefinsuredDefSchemeVo> record=definsuredDefSchemeVoMapper.pigeonhole(new QueryWrapper<DefinsuredDefSchemeVo>()
                .isNotNull("t4.INSURED_PAYMENT_ID")
                .apply("TO_CHAR(t4.INSURED_PAYMENT_INSURED_MONTH,'yyyy-MM') like {0}", date));


        for(int i=0;i< record.size();i++){

            //查询默认方案数据
            List<DefScheme> defSchemeList=defSchemeMapper.selectDefSchemeshuju(new QueryWrapper<DefScheme>()
                    .eq("DEF_INSURED_ID", record.get(i).getDefInsuredId()));

            //养老保险
            //养老保险基数
            int insArchivePrNumber=0;
            //养老保险个人缴纳比例
            Double insArchivePrPersonProp =0.0;
            //养老保险个人固定缴纳
            Double insArchivePrPersonSum =0.0;
            //养老保险企业缴纳比例
            Double insArchivePrFirmProp =0.0;
            //养老保险企业固定缴纳
            Double insArchivePrFirmSum=0.0;

            //医疗保险
            //医疗保险基数
            int insArchiveMdNumber=0;
            //医疗保险个人缴纳比例
            Double insArchiveMdPersonProp =0.0;
            //医疗保险个人固定缴纳
            Double insArchiveMdPersonSum =0.0;
            //医疗保险企业缴纳比例
            Double insArchiveMdFirmProp =0.0;
            //医疗保险企业固定缴纳
            Double  insArchiveMdFirmSum =0.0;
            //失业保险
            //失业保险基数
            int insArchiveUnNumber=0;
            //失业保险个人缴纳比例
            Double insArchiveUnPersonProp =0.0;
            //失业保险个人固定缴纳
            Double insArchiveUnPersonSum =0.0;
            //失业保险企业缴纳比例
            Double insArchiveUnFirmProp =0.0;
            //失业保险企业固定缴纳
            Double insArchiveUnFirmSum =0.0;
            //工伤保险
            //工伤保险基数
            int insArchiveOcNumber=0;
            //工伤保险个人缴纳比例
            Double insArchiveOcPersonProp =0.0;
            //工伤保险个人固定缴纳
            Double insArchiveOcPersonSum =0.0;
            //工伤保险企业缴纳比例
            Double insArchiveOcFirmProp =0.0;
            //工伤保险企业固定缴纳
            Double insArchiveOcFirmSum =0.0;
            //生育保险
            //生育保险基数
            int insArchiveGiNumber=0;
            //生育保险个人缴纳比例
            Double insArchiveGiPersonProp =0.0;
            //生育保险个人固定缴纳
            Double insArchiveGiPersonSum =0.0;
            //生育保险企业缴纳比例
            Double insArchiveGiFirmProp =0.0;
            //生育保险企业固定缴纳
            Double insArchiveGiFirmSum =0.0;
            //积金
            //积金基数
            int insArchiveFuNumber=0;
            //积金个人缴纳比例
            Double insArchiveFuPersonProp =0.0;
            //积金个人固定缴纳
            Double insArchiveFuPersonSum =0.0;
            //积金企业缴纳比例
            Double insArchiveFuFirmProp =0.0;
            //积金企业固定缴纳
            Double insArchiveFuFirmSum =0.0;
            //循环默认方案数据
            for(int j=0;j<defSchemeList.size();j++){
                //判断默认方案类型
                if(defSchemeList.get(j).getDefSchemeType().equals("养老保险")){
                    //养老保险个人缴纳比例
                    insArchivePrPersonProp =defSchemeList.get(j).getDefSchemePersonProp();
                    //养老保险个人固定缴纳
                     insArchivePrPersonSum =defSchemeList.get(j).getDefSchemePersonSum();
                    //养老保险企业缴纳比例
                     insArchivePrFirmProp =defSchemeList.get(j).getDefSchemeFirmProp();
                    //养老保险企业固定缴纳
                     insArchivePrFirmSum=defSchemeList.get(j).getDefSchemeFirmSum();
                    //判断最多最少基数
                    if( record.get(i).getInsuredPaymentNumber()<=defSchemeList.get(j).getDefSchemeMin()){
                        //判断基数上下限
                        if(defSchemeList.get(j).getDefSchemeMin()<=defSchemeList.get(j).getDefSchemeFloor()){

                            insArchivePrNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeFloor());

                        }else if(defSchemeList.get(j).getDefSchemeMin()>=defSchemeList.get(j).getDefSchemeUpper()){

                            insArchivePrNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeUpper());

                        }else{

                            insArchivePrNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeMin());

                        }
                    }else if(record.get(i).getInsuredPaymentNumber()>=defSchemeList.get(j).getDefSchemeMax()){

                        if(defSchemeList.get(j).getDefSchemeMax()<=defSchemeList.get(j).getDefSchemeFloor()){

                            insArchivePrNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeFloor());

                        }else if(defSchemeList.get(j).getDefSchemeMax()>=defSchemeList.get(j).getDefSchemeUpper()){

                            insArchivePrNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeUpper());

                        }else {
                            insArchivePrNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeMax());
                        }
                    }else{
                        if(record.get(i).getInsuredPaymentNumber()<=defSchemeList.get(j).getDefSchemeFloor()){

                            insArchivePrNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeFloor());

                        }else if(record.get(i).getInsuredPaymentNumber()>=defSchemeList.get(j).getDefSchemeUpper()){

                            insArchivePrNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeUpper());

                        }else {
                            insArchivePrNumber= Math.toIntExact(record.get(i).getInsuredPaymentNumber());
                        }

                    }

                }else if(defSchemeList.get(j).getDefSchemeType().equals("医疗保险")){
                    //医疗保险个人缴纳比例
                     insArchiveMdPersonProp =defSchemeList.get(j).getDefSchemePersonProp();
                    //医疗保险个人固定缴纳
                     insArchiveMdPersonSum =defSchemeList.get(j).getDefSchemePersonSum();
                    //医疗保险企业缴纳比例
                     insArchiveMdFirmProp =defSchemeList.get(j).getDefSchemeFirmProp();
                    //医疗保险企业固定缴纳
                      insArchiveMdFirmSum =defSchemeList.get(j).getDefSchemeFirmSum();

                    if( record.get(i).getInsuredPaymentNumber()<=defSchemeList.get(j).getDefSchemeMin()){
                        //判断基数上下限
                        if(defSchemeList.get(j).getDefSchemeMin()<=defSchemeList.get(j).getDefSchemeFloor()){

                            insArchiveMdNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeFloor());

                        }else if(defSchemeList.get(j).getDefSchemeMin()>=defSchemeList.get(j).getDefSchemeUpper()){

                            insArchiveMdNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeUpper());

                        }else{

                            insArchiveMdNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeMin());

                        }
                    }else if(record.get(i).getInsuredPaymentNumber()>=defSchemeList.get(j).getDefSchemeMax()){

                        if(defSchemeList.get(j).getDefSchemeMax()<=defSchemeList.get(j).getDefSchemeFloor()){

                            insArchiveMdNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeFloor());

                        }else if(defSchemeList.get(j).getDefSchemeMax()>=defSchemeList.get(j).getDefSchemeUpper()){

                            insArchiveMdNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeUpper());

                        }else {
                            insArchiveMdNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeMax());
                        }
                    }else{
                        if(record.get(i).getInsuredPaymentNumber()<=defSchemeList.get(j).getDefSchemeFloor()){

                            insArchiveMdNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeFloor());

                        }else if(record.get(i).getInsuredPaymentNumber()>=defSchemeList.get(j).getDefSchemeUpper()){

                            insArchiveMdNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeUpper());

                        }else {
                            insArchiveMdNumber= Math.toIntExact(record.get(i).getInsuredPaymentNumber());
                        }

                    }
                }else if(defSchemeList.get(j).getDefSchemeType().equals("失业保险")){

                     insArchiveUnPersonProp =defSchemeList.get(j).getDefSchemePersonProp();
                    //失业保险个人固定缴纳
                     insArchiveUnPersonSum =defSchemeList.get(j).getDefSchemePersonSum();
                    //失业保险企业缴纳比例
                     insArchiveUnFirmProp =defSchemeList.get(j).getDefSchemeFirmProp();
                    //失业保险企业固定缴纳
                     insArchiveUnFirmSum =defSchemeList.get(j).getDefSchemeFirmSum();

                    if( record.get(i).getInsuredPaymentNumber()<=defSchemeList.get(j).getDefSchemeMin()){
                        //判断基数上下限
                        if(defSchemeList.get(j).getDefSchemeMin()<=defSchemeList.get(j).getDefSchemeFloor()){

                            insArchiveUnNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeFloor());

                        }else if(defSchemeList.get(j).getDefSchemeMin()>=defSchemeList.get(j).getDefSchemeUpper()){

                            insArchiveUnNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeUpper());

                        }else{

                            insArchiveUnNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeMin());

                        }
                    }else if(record.get(i).getInsuredPaymentNumber()>=defSchemeList.get(j).getDefSchemeMax()){

                        if(defSchemeList.get(j).getDefSchemeMax()<=defSchemeList.get(j).getDefSchemeFloor()){

                            insArchiveUnNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeFloor());

                        }else if(defSchemeList.get(j).getDefSchemeMax()>=defSchemeList.get(j).getDefSchemeUpper()){

                            insArchiveUnNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeUpper());

                        }else {
                            insArchiveUnNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeMax());
                        }
                    }else{
                        if(record.get(i).getInsuredPaymentNumber()<=defSchemeList.get(j).getDefSchemeFloor()){

                            insArchiveUnNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeFloor());

                        }else if(record.get(i).getInsuredPaymentNumber()>=defSchemeList.get(j).getDefSchemeUpper()){

                            insArchiveUnNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeUpper());

                        }else {
                            insArchiveUnNumber= Math.toIntExact(record.get(i).getInsuredPaymentNumber());
                        }

                    }
                }else if(defSchemeList.get(j).getDefSchemeType().equals("工伤保险")){
                    insArchiveOcPersonProp =defSchemeList.get(j).getDefSchemePersonProp();
                    //工伤保险个人固定缴纳
                    insArchiveOcPersonSum =defSchemeList.get(j).getDefSchemePersonSum();
                    //工伤保险企业缴纳比例
                    insArchiveOcFirmProp =defSchemeList.get(j).getDefSchemeFirmProp();
                    //工伤保险企业固定缴纳
                    insArchiveOcFirmSum =defSchemeList.get(j).getDefSchemeFirmSum();
                    if( record.get(i).getInsuredPaymentNumber()<=defSchemeList.get(j).getDefSchemeMin()){
                        //判断基数上下限
                        if(defSchemeList.get(j).getDefSchemeMin()<=defSchemeList.get(j).getDefSchemeFloor()){

                            insArchiveOcNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeFloor());

                        }else if(defSchemeList.get(j).getDefSchemeMin()>=defSchemeList.get(j).getDefSchemeUpper()){

                            insArchiveOcNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeUpper());

                        }else{

                            insArchiveOcNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeMin());

                        }
                    }else if(record.get(i).getInsuredPaymentNumber()>=defSchemeList.get(j).getDefSchemeMax()){

                        if(defSchemeList.get(j).getDefSchemeMax()<=defSchemeList.get(j).getDefSchemeFloor()){

                            insArchiveOcNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeFloor());

                        }else if(defSchemeList.get(j).getDefSchemeMax()>=defSchemeList.get(j).getDefSchemeUpper()){

                            insArchiveOcNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeUpper());

                        }else {
                            insArchiveOcNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeMax());
                        }
                    }else{
                        if(record.get(i).getInsuredPaymentNumber()<=defSchemeList.get(j).getDefSchemeFloor()){

                            insArchiveOcNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeFloor());

                        }else if(record.get(i).getInsuredPaymentNumber()>=defSchemeList.get(j).getDefSchemeUpper()){

                            insArchiveOcNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeUpper());

                        }else {
                            insArchiveOcNumber= Math.toIntExact(record.get(i).getInsuredPaymentNumber());
                        }

                    }

                }else if(defSchemeList.get(j).getDefSchemeType().equals("生育保险")){
                     insArchiveGiPersonProp =defSchemeList.get(j).getDefSchemePersonProp();
                    //生育保险个人固定缴纳
                     insArchiveGiPersonSum =defSchemeList.get(j).getDefSchemePersonSum();
                    //生育保险企业缴纳比例
                     insArchiveGiFirmProp =defSchemeList.get(j).getDefSchemeFirmProp();
                    //生育保险企业固定缴纳
                     insArchiveGiFirmSum =defSchemeList.get(j).getDefSchemeFirmSum();
                    if( record.get(i).getInsuredPaymentNumber()<=defSchemeList.get(j).getDefSchemeMin()){
                        //判断基数上下限
                        if(defSchemeList.get(j).getDefSchemeMin()<=defSchemeList.get(j).getDefSchemeFloor()){

                            insArchiveGiNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeFloor());

                        }else if(defSchemeList.get(j).getDefSchemeMin()>=defSchemeList.get(j).getDefSchemeUpper()){

                            insArchiveGiNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeUpper());

                        }else{

                            insArchiveGiNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeMin());

                        }
                    }else if(record.get(i).getInsuredPaymentNumber()>=defSchemeList.get(j).getDefSchemeMax()){

                        if(defSchemeList.get(j).getDefSchemeMax()<=defSchemeList.get(j).getDefSchemeFloor()){

                            insArchiveGiNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeFloor());

                        }else if(defSchemeList.get(j).getDefSchemeMax()>=defSchemeList.get(j).getDefSchemeUpper()){

                            insArchiveGiNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeUpper());

                        }else {
                            insArchiveGiNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeMax());
                        }
                    }else{
                        if(record.get(i).getInsuredPaymentNumber()<=defSchemeList.get(j).getDefSchemeFloor()){

                            insArchiveGiNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeFloor());

                        }else if(record.get(i).getInsuredPaymentNumber()>=defSchemeList.get(j).getDefSchemeUpper()){

                            insArchiveGiNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeUpper());

                        }else {
                            insArchiveGiNumber= Math.toIntExact(record.get(i).getInsuredPaymentNumber());
                        }

                    }
                }else{
                     insArchiveFuPersonProp =defSchemeList.get(j).getDefSchemePersonProp();
                    //积金个人固定缴纳
                     insArchiveFuPersonSum =defSchemeList.get(j).getDefSchemePersonSum();
                    //积金企业缴纳比例
                     insArchiveFuFirmProp =defSchemeList.get(j).getDefSchemeFirmProp();
                    //积金企业固定缴纳
                     insArchiveFuFirmSum =defSchemeList.get(j).getDefSchemeFirmSum();
                    if( record.get(i).getInsuredPaymentFund()<=defSchemeList.get(j).getDefSchemeMin()){
                        //判断基数上下限
                        if(defSchemeList.get(j).getDefSchemeMin()<=defSchemeList.get(j).getDefSchemeFloor()){

                            insArchiveFuNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeFloor());

                        }else if(defSchemeList.get(j).getDefSchemeMin()<=defSchemeList.get(j).getDefSchemeUpper()){

                            insArchiveFuNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeUpper());

                        }else{

                            insArchiveFuNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeMin());

                        }
                    }else if(record.get(i).getInsuredPaymentFund()>=defSchemeList.get(j).getDefSchemeMax()){

                        if(defSchemeList.get(j).getDefSchemeMax()<=defSchemeList.get(j).getDefSchemeFloor()){

                            insArchiveFuNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeFloor());

                        }else if(defSchemeList.get(j).getDefSchemeMax()>=defSchemeList.get(j).getDefSchemeUpper()){

                            insArchiveFuNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeUpper());

                        }else {
                            insArchiveFuNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeMax());
                        }
                    }else{
                        if(record.get(i).getInsuredPaymentFund()<=defSchemeList.get(j).getDefSchemeFloor()){

                            insArchiveFuNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeFloor());

                        }else if(record.get(i).getInsuredPaymentFund()>=defSchemeList.get(j).getDefSchemeUpper()){

                            insArchiveFuNumber= Math.toIntExact(defSchemeList.get(j).getDefSchemeUpper());

                        }else {
                            insArchiveFuNumber= Math.toIntExact(record.get(i).getInsuredPaymentFund());
                        }

                    }
                }
            }

            InsuredArchive insuredArchive1=new InsuredArchive();
            insuredArchive1.setInsArchiveSocialNumber(record.get(i).getInsuredPaymentNumber());
            insuredArchive1.setInsArchiveFundNumber(record.get(i).getInsuredPaymentFund());

            insuredArchive1.setInsArchivePrNumber((long) insArchivePrNumber);
            insuredArchive1.setInsArchivePrPersonProp(insArchivePrPersonProp);
            insuredArchive1.setInsArchivePrPersonSum(insArchivePrPersonSum);
            insuredArchive1.setInsArchivePrFirmProp(insArchivePrFirmProp);
            insuredArchive1.setInsArchivePrFirmSum(insArchivePrFirmSum);

            insuredArchive1.setInsArchiveMdNumber((long) insArchiveMdNumber);
            insuredArchive1.setInsArchiveMdPersonProp(insArchiveMdPersonProp);
            insuredArchive1.setInsArchiveMdPersonSum(insArchiveMdPersonSum);
            insuredArchive1.setInsArchiveMdFirmProp(insArchiveMdFirmProp);
            insuredArchive1.setInsArchiveMdFirmSum(insArchiveMdFirmSum);

            insuredArchive1.setInsArchiveUnNumber((long) insArchiveUnNumber);
            insuredArchive1.setInsArchiveUnPersonProp(insArchiveUnPersonProp);
            insuredArchive1.setInsArchiveUnPersonSum(insArchiveUnPersonSum);
            insuredArchive1.setInsArchiveUnFirmProp(insArchiveUnFirmProp);
            insuredArchive1.setInsArchiveUnFirmSum(insArchiveUnFirmSum);

            insuredArchive1.setInsArchiveOcNumber((long) insArchiveOcNumber);
            insuredArchive1.setInsArchiveOcPersonProp(insArchiveOcPersonProp);
            insuredArchive1.setInsArchiveOcPersonSum(insArchiveOcPersonSum);
            insuredArchive1.setInsArchiveOcFirmProp(insArchiveOcFirmProp);
            insuredArchive1.setInsArchiveOcFirmSum(insArchiveOcFirmSum);

            insuredArchive1.setInsArchiveGiNumber((long) insArchiveGiNumber);
            insuredArchive1.setInsArchiveGiPersonProp(insArchiveGiPersonProp);
            insuredArchive1.setInsArchiveGiPersonSum(insArchiveGiPersonSum);
            insuredArchive1.setInsArchiveGiFirmProp(insArchiveGiFirmProp);
            insuredArchive1.setInsArchiveGiFirmSum(insArchiveGiFirmSum);

            insuredArchive1.setInsArchiveGiNumber((long) insArchiveFuNumber);
            insuredArchive1.setInsArchiveGiPersonProp(insArchiveFuPersonProp);
            insuredArchive1.setInsArchiveGiPersonSum(insArchiveFuPersonSum);
            insuredArchive1.setInsArchiveGiFirmProp(insArchiveFuFirmProp);
            insuredArchive1.setInsArchiveGiFirmSum(insArchiveFuFirmSum);

            insuredArchive1.setInsArchiveStaffName(record.get(i).getStaffName());
            insuredArchive1.setInsArchiveDeptName(record.get(i).getDeptName());
            insuredArchive1.setInsArchivePostName(record.get(i).getPostName());
            insuredArchive1.setInsArchiveInsuredName(record.get(i).getDefInsuredName());
            insuredArchive1.setInsArchiveInsuredMonth(record.get(i).getInsDetailInsuredMonth());
            insuredArchive1.setInsArchiveSalaryMonth(record.get(i).getInsDetailSalaryMonth());
            insuredArchive1.setInsArchiveSocialPersonPay(record.get(i).getInsDetailSocialPersonPay());
            insuredArchive1.setInsArchiveSocialFirmPay(record.get(i).getInsDetailSocialFirmPay());
            insuredArchive1.setInsArchiveFundPersonPay(record.get(i).getInsDetailFundPersonPay());
            insuredArchive1.setInsArchiveFundFirmPay(record.get(i).getInsDetailFundFirmPay());

            if(insuredArchiveMapper.insert(insuredArchive1)>0){
                //删除缴纳表
                if(insuredPaymentMapper.deleteById(record.get(i).getInsuredPaymentId())>0){
                    //删除明细表对应数据
                    if(insuredDetailMapper.deleteById(record.get(i).getInsDetailId())>0){
                        //获取下个月时间

                        Calendar calendar = Calendar.getInstance();

                        calendar.setTime(new Date());

                        calendar.add(Calendar.MONTH, 1);//增加一个月
                        System.out.println(calendar.getTime());

                        //添加明细表数据
                        InsuredDetail insuredDetail=new InsuredDetail();
                        insuredDetail.setInsDetailStaffName(record.get(i).getStaffName());
                        insuredDetail.setInsDetailInsuredName(record.get(i).getDefInsuredName());
                        insuredDetail.setInsDetailInsuredMonth(calendar.getTime());
                        insuredDetail.setInsDetailSalaryMonth(calendar.getTime());
                        insuredDetail.setInsDetailSocialPersonPay(record.get(i).getInsDetailSocialPersonPay());
                        insuredDetail.setInsDetailSocialFirmPay(record.get(i).getInsDetailSocialFirmPay());
                        insuredDetail.setInsDetailFundPersonPay(record.get(i).getInsDetailFundPersonPay());
                        insuredDetail.setInsDetailFundFirmPay(record.get(i).getInsDetailFundFirmPay());
                        //判断添加是否成功

                        if(insuredDetailMapper.insert(insuredDetail)>0){
                            InsuredPayment insuredPayment=new InsuredPayment();
                            insuredPayment.setStaffId(record.get(i).getStaffId());
                            insuredPayment.setDefInsuredId(Long.parseLong(record.get(i).getDefInsuredId().toString()));
                            insuredPayment.setInsDetailId(Long.parseLong(insuredDetail.getInsDetailId().toString()));
                            insuredPayment.setInsuredPaymentNumber(record.get(i).getInsuredPaymentNumber());
                            insuredPayment.setInsuredPaymentFund(record.get(i).getInsuredPaymentFund());
                            insuredPayment.setInsuredPaymentInsuredMonth(calendar.getTime());
                            insuredPayment.setInsuredPaymentSalaryMonth(calendar.getTime());

                            if(insuredPaymentMapper.insert(insuredPayment)>0){
                                a=1;
                            }
                        }
                    }
                }
            }


        }

        return a;
    }

    /**
     * 分页查询个人社保记录
     */
    @Override
    public IPage<InsuredArchive> pageRecord(InsuredArchive insuredArchive) {
        Page<InsuredArchive> page=new Page<>(insuredArchive.getCurrentPage(),insuredArchive.getPagesize());
        QueryWrapper<InsuredArchive> queryWrapper = new QueryWrapper<>();

        //登录时间段查询
        if(insuredArchive.getStartTime()!=null&& insuredArchive.getEndTime()!=null){
            queryWrapper.between("INS_ARCHIVE_INSURED_MONTH",insuredArchive.getStartTime(),insuredArchive.getEndTime());
        }

        queryWrapper.eq("IS_DELETED",0);
        queryWrapper.eq("INS_ARCHIVE_STAFF_NAME",insuredArchive.getInsArchiveStaffName());
        return insuredArchiveMapper.pageRecord(page,queryWrapper);
    }



    /**
     * 月度报表分页
     */
    @Override
    public IPage<InsuredArchive> monthlyReport(InsuredArchive insuredArchive) {
        Page<InsuredArchive> page=new Page<>(insuredArchive.getCurrentPage(),insuredArchive.getPagesize());


        QueryWrapper<InsuredArchive> queryWrapper = new QueryWrapper<>();
        IPage<InsuredArchive> insuredArchiveIPage = insuredArchiveMapper.monthlyReport(new Page<>(insuredArchive.getCurrentPage(), insuredArchive.getPagesize()), queryWrapper);
        System.err.println("===================="+insuredArchiveIPage.getRecords());
        //        queryWrapper.eq("IS_DELETED",0);
        return insuredArchiveMapper.monthlyReport(page,queryWrapper);
    }

    /**
     * 根据年月查询归档数据
     * @param insuredArchive
     * @return
     */
    @Override
    public List<InsuredArchive> selectList(InsuredArchive insuredArchive) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
            Date parse = sdf.parse(insuredArchive.getTime());
            String format = sdf.format(parse);
        List<InsuredArchive> insuredArchiveList=insuredArchiveMapper.selectList(new QueryWrapper<InsuredArchive>()
                .eq("to_char(CREATED_TIME,'yyyy-MM')",format));
        return insuredArchiveList;
    }

    /**
     * 分页查询归档缴纳详细数据
     */
    @Override
    public IPage<InsuredArchive> pageInsuredArchive(InsuredArchive insuredArchive) throws ParseException {
        Page<InsuredArchive> page=new Page<>(insuredArchive.getCurrentPage(),insuredArchive.getPagesize());
        QueryWrapper<InsuredArchive> queryWrapper = new QueryWrapper<>();

        if(insuredArchive.getInsArchiveDeptName() != null && !insuredArchive.getInsArchiveDeptName().equals("")){
            //部门名称模糊查询
            queryWrapper.like("INS_ARCHIVE_DEPT_NAME",insuredArchive.getInsArchiveDeptName());
        }
        //员工名称模糊查询
        if(insuredArchive.getInsArchiveStaffName() != null && !insuredArchive.getInsArchiveStaffName().equals("")){
            queryWrapper.like("INS_ARCHIVE_STAFF_NAME",insuredArchive.getInsArchiveStaffName());
        }

        //字符串类型转换日期类型
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
        Date parse = sdf.parse(insuredArchive.getTime());
        String format = sdf.format(parse);
        //分页查询条件
        queryWrapper.eq("to_char(CREATED_TIME,'yyyy-MM')",format);

        return insuredArchiveMapper.pageInsuredArchive(page,queryWrapper);
    }

    /**
     * 查询归档缴纳详细数据计算
     */
    @Override
    public List<InsuredArchive> insuredArchiveCalculate(InsuredArchive insuredArchive) throws ParseException {

        //字符串类型转换日期类型
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
        Date parse = sdf.parse(insuredArchive.getTime());
        String format = sdf.format(parse);
        //分页查询条件
        List<InsuredArchive> insuredArchiveList=insuredArchiveMapper.insuredArchiveCalculate(new QueryWrapper<InsuredArchive>()
                .eq("to_char(CREATED_TIME,'yyyy-MM')",format));
        return insuredArchiveList;
    }

    /**
     * 根据归档id查询改员工数据
     */
    @Override
    public InsuredArchive selectId(InsuredArchive insuredArchive) {
        InsuredArchive insuredArchive1=insuredArchiveMapper.selectId(new QueryWrapper<InsuredArchive>()
                .eq("INS_ARCHIVE_ID",insuredArchive.getInsArchiveId()));
        return insuredArchive1;
    }


}
