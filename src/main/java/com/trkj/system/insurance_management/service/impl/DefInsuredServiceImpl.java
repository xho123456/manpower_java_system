package com.trkj.system.insurance_management.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.system.insurance_management.entity.DefInsured;
import com.trkj.system.insurance_management.entity.DefInsureds;
import com.trkj.system.insurance_management.entity.DefScheme;
import com.trkj.system.insurance_management.mapper.DefInsuredMapper;
import com.trkj.system.insurance_management.mapper.DefInsuredsMapper;
import com.trkj.system.insurance_management.mapper.DefSchemeMapper;
import com.trkj.system.insurance_management.service.DefInsuredService;
import com.trkj.system.vo.AjaxResponse;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
import java.util.Map;

@Service
public class DefInsuredServiceImpl implements DefInsuredService {

    @Autowired
    private DefInsuredMapper defInsuredMapper;
    @Autowired
    private DefInsuredsMapper defInsuredsMapper;
    @Autowired
    private DefSchemeMapper defSchemeMapper;

    /**
     * 分页条件构造器查询参保方案表
     * @param defInsured
     * @return
     */
    @Override
    @Transactional
    public IPage<DefInsured> selectPaer(DefInsured defInsured) {
        Page<DefInsured> page = new Page<>(defInsured.getCurrentPage(),defInsured.getPagesize());
        QueryWrapper<DefInsured> queryWrapper = new QueryWrapper<>();
        if(defInsured.getDefInsuredState() != null && !defInsured.getDefInsuredState().equals("")){
            //公告标题模糊查询
            queryWrapper.like("DEF_INSURED_STATE",defInsured.getDefInsuredState());
        }
        else {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        //分页查询条件
        queryWrapper.eq("IS_DELETED",0).orderByDesc("DEF_INSURED_ID");

        return defInsuredMapper.selectPaer(page,queryWrapper);
    }

    /**
     * 添加默认参保方案表方法
     * @param map
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertDefInsured(Map<String, Object> map) {
        int a=0;

        String defInsureds=map.get("defInsuredName").toString();
        int defSchemeMin = Integer.parseInt(map.get("defSchemeMin").toString());
        int defSchemeMax = Integer.parseInt(map.get("defSchemeMax").toString());
        List<DefScheme> defSchemeList = JSONObject.parseArray(JSONObject.toJSONString(map.get("social_tableData")), DefScheme.class);
        List<DefScheme> accumulation_tableData=JSONObject.parseArray(JSONObject.toJSONString(map.get("accumulation_tableData")),DefScheme.class);
        //添加默认参保方案表数据
        DefInsureds defInsureds1=new DefInsureds();
        defInsureds1.setDefInsuredName(defInsureds);
        if (defInsuredsMapper.insert(defInsureds1)>0){
            //查询默认参保方案表ID
            DefInsureds defInsureds2=defInsuredsMapper.selectDefInsureds(new QueryWrapper<DefInsureds>().eq("DEF_INSURED_NAME",defInsureds).eq("IS_DELETED",0));
            for (int i = 0;i<defSchemeList.size();i++){
                String defSchemeType=defSchemeList.get(i).getDefSchemeType();
                int defSchemeFloor= Math.toIntExact(defSchemeList.get(i).getDefSchemeFloor());
                int defSchemeUpper=Math.toIntExact(defSchemeList.get(i).getDefSchemeUpper());
                Double defSchemeFirmProp=defSchemeList.get(i).getDefSchemeFirmProp();
                Double defSchemePersonProp = defSchemeList.get(i).getDefSchemePersonProp();
                Double defSchemeFirmSum=defSchemeList.get(i).getDefSchemeFirmSum();
                Double defSchemePersonSum=defSchemeList.get(i).getDefSchemePersonSum();
                //添加默认方案表社保数据
                DefScheme defScheme1=new DefScheme();
                defScheme1.setDefSchemeMin((long) defSchemeMin);
                defScheme1.setDefSchemeMax((long) defSchemeMax);
                defScheme1.setDefSchemeType(defSchemeType);
                defScheme1.setDefSchemeFloor((long) defSchemeFloor);
                defScheme1.setDefSchemeUpper((long) defSchemeUpper);
                defScheme1.setDefSchemeFirmProp(defSchemeFirmProp);
                defScheme1.setDefSchemePersonProp(defSchemePersonProp);
                defScheme1.setDefSchemeFirmSum(defSchemeFirmSum);
                defScheme1.setDefSchemePersonSum(defSchemePersonSum);
                defScheme1.setDefInsuredId(defInsureds2.getDefInsuredId());
                int inserts = defSchemeMapper.insert(defScheme1);
            }

            for (int i = 0;i<accumulation_tableData.size();i++){
                String defSchemeType=accumulation_tableData.get(i).getDefSchemeType();
                int defSchemeFloor= Math.toIntExact(accumulation_tableData.get(i).getDefSchemeFloor());
                int defSchemeUpper=Math.toIntExact(accumulation_tableData.get(i).getDefSchemeUpper());
                Double defSchemeFirmProp=accumulation_tableData.get(i).getDefSchemeFirmProp();
                Double defSchemePersonProp = accumulation_tableData.get(i).getDefSchemePersonProp();
                Double defSchemeFirmSum=accumulation_tableData.get(i).getDefSchemeFirmSum();
                Double defSchemePersonSum=accumulation_tableData.get(i).getDefSchemePersonSum();
                //添加默认方案表公积金数据
                DefScheme defScheme2=new DefScheme();
                defScheme2.setDefSchemeMin((long) defSchemeMin);
                defScheme2.setDefSchemeMax((long) defSchemeMax);
                defScheme2.setDefSchemeType(defSchemeType);
                defScheme2.setDefSchemeFloor((long) defSchemeFloor);
                defScheme2.setDefSchemeUpper((long) defSchemeUpper);
                defScheme2.setDefSchemeFirmProp(defSchemeFirmProp);
                defScheme2.setDefSchemePersonProp(defSchemePersonProp);
                defScheme2.setDefSchemeFirmSum(defSchemeFirmSum);
                defScheme2.setDefSchemePersonSum(defSchemePersonSum);
                defScheme2.setDefInsuredId(defInsureds2.getDefInsuredId());
                if(defSchemeMapper.insert(defScheme2)>0){
                    a=1;
                }else {
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                }
             }

        }else {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }

        return a;
    }

    /**
     * 查询参保方案名称是否唯一
     */
    @Override
    public DefInsured selectDefInsuredName(Map<String, Object> map) {
        String defInsuredName=map.get("defInsuredName").toString();
       return defInsuredMapper.selectDefInsuredName(new QueryWrapper<DefInsured>().eq("DEF_INSURED_NAME",defInsuredName).eq("IS_DELETED",0));
    }
    /**
     * 根据默认参保方案表id查询
     * 默认参保方案名称数据
     * 参保方案表数据
     */
    @Override
    @Transactional
    public AjaxResponse selectDefInsuredname(DefInsured defInsured) {

        DefInsureds defInsureds=defInsuredsMapper.selectDefInsuredname(new QueryWrapper<DefInsureds>().eq("DEF_INSURED_ID",defInsured.getDefInsuredId())
                .and(i->i.eq("IS_DELETED",0)));

        List<DefScheme> defSchemeList=defSchemeMapper.selectDefScheme(new QueryWrapper<DefScheme>()
                .eq("DEF_INSURED_ID",defInsured.getDefInsuredId())
                .eq("IS_DELETED",0));
        defSchemeList.forEach(e->{
            if (defInsureds.getDefInsuredId()==e.getDefInsuredId()){
                defInsureds.getDefSchemes().add(e);
            }else {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        });
        return AjaxResponse.success(defInsureds);
    }

    /**
     * 参保方案修改
     */
    @Override
    @Transactional
    public int updateDefInsured(Map<String, Object> map) {
        int a=0;
        int defInsuredId = Integer.parseInt(map.get("defInsuredId").toString());
        String defInsuredsName=map.get("defInsuredName").toString();
        int defSchemeMin = Integer.parseInt(map.get("defSchemeMin").toString());
        int defSchemeMax = Integer.parseInt(map.get("defSchemeMax").toString());
        List<DefScheme> defSchemeList = JSONObject.parseArray(JSONObject.toJSONString(map.get("social_tableData")), DefScheme.class);
        List<DefScheme> accumulation_tableData=JSONObject.parseArray(JSONObject.toJSONString(map.get("accumulation_tableData")),DefScheme.class);

        //修改默认参保方案表数据
        DefInsureds defInsureds1=new DefInsureds();
        defInsureds1.setDefInsuredName(defInsuredsName);
        defInsureds1.setDefInsuredId(defInsuredId);
       final val update= defInsuredsMapper.updateById(defInsureds1);

       if (update>0){
           //循环默认方案表社保数据
           for (int i = 0;i<defSchemeList.size();i++){
               int defSchemeId=Math.toIntExact(defSchemeList.get(i).getDefSchemeId());
               String defSchemeType=defSchemeList.get(i).getDefSchemeType();
               int defSchemeFloor= Math.toIntExact(defSchemeList.get(i).getDefSchemeFloor());
               int defSchemeUpper=Math.toIntExact(defSchemeList.get(i).getDefSchemeUpper());
               Double defSchemeFirmProp=defSchemeList.get(i).getDefSchemeFirmProp();
               Double defSchemePersonProp = defSchemeList.get(i).getDefSchemePersonProp();
               Double defSchemeFirmSum=defSchemeList.get(i).getDefSchemeFirmSum();
               Double defSchemePersonSum=defSchemeList.get(i).getDefSchemePersonSum();
               //修改默认方案表社保数据
               DefScheme defScheme=new DefScheme();
               defScheme.setDefSchemeId(defSchemeId);
               defScheme.setDefSchemeMin((long) defSchemeMin);
               defScheme.setDefSchemeMax((long) defSchemeMax);
               defScheme.setDefSchemeType(defSchemeType);
               defScheme.setDefSchemeFloor((long) defSchemeFloor);
               defScheme.setDefSchemeUpper((long) defSchemeUpper);
               defScheme.setDefSchemeFirmProp(defSchemeFirmProp);
               defScheme.setDefSchemePersonProp(defSchemePersonProp);
               defScheme.setDefSchemeFirmSum(defSchemeFirmSum);
               defScheme.setDefSchemePersonSum(defSchemePersonSum);
               defScheme.setDefInsuredId(defInsuredId);
               final val updates = defSchemeMapper.updateById(defScheme);

           }
           //循环默认方案表公积金数据
           for (int i = 0;i<accumulation_tableData.size();i++) {
               int defSchemeId = Math.toIntExact(accumulation_tableData.get(i).getDefSchemeId());
               String defSchemeType = accumulation_tableData.get(i).getDefSchemeType();
               int defSchemeFloor = Math.toIntExact(accumulation_tableData.get(i).getDefSchemeFloor());
               int defSchemeUpper = Math.toIntExact(accumulation_tableData.get(i).getDefSchemeUpper());
               Double defSchemeFirmProp = accumulation_tableData.get(i).getDefSchemeFirmProp();
               Double defSchemePersonProp = accumulation_tableData.get(i).getDefSchemePersonProp();
               Double defSchemeFirmSum = accumulation_tableData.get(i).getDefSchemeFirmSum();
               Double defSchemePersonSum = accumulation_tableData.get(i).getDefSchemePersonSum();
               //修改默认方案表公积金数据
               DefScheme defScheme1 = new DefScheme();
               defScheme1.setDefSchemeId(defSchemeId);
               defScheme1.setDefSchemeMin((long) defSchemeMin);
               defScheme1.setDefSchemeMax((long) defSchemeMax);
               defScheme1.setDefSchemeType(defSchemeType);
               defScheme1.setDefSchemeFloor((long) defSchemeFloor);
               defScheme1.setDefSchemeUpper((long) defSchemeUpper);
               defScheme1.setDefSchemeFirmProp(defSchemeFirmProp);
               defScheme1.setDefSchemePersonProp(defSchemePersonProp);
               defScheme1.setDefSchemeFirmSum(defSchemeFirmSum);
               defScheme1.setDefSchemePersonSum(defSchemePersonSum);
               defScheme1.setDefInsuredId(defInsuredId);
               final val updatess = defSchemeMapper.updateById(defScheme1);
               if(updatess>0){
                   a=1;

               }else {
                   TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
               }
           }

       }else {
           TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
       }
        return a;
    }

    /**
     * 默认参保方案删除
     */
    @Override
    @Transactional
    public int deleteDefInsured(DefInsured defInsured) {
        int a=0;
        if(defInsuredMapper.deleteById(defInsured.getDefInsuredId())>0){
            List<DefScheme> list=defSchemeMapper.selectDefSchemeID(new QueryWrapper<DefScheme>().eq("DEF_INSURED_ID",defInsured.getDefInsuredId()).eq("IS_DELETED",0));
            for(int i=0;i<list.size();i++){
                int delete = defInsuredMapper.deleteById(list.get(i).getDefSchemeId());
               if(delete>0){
                   a=1;
               }else {
                   TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
               }
            }
        }else {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return a;
    }

    /**
     * 修改方案状态
     */
    @Override
    @Transactional
    public int updatedefInsuredState(DefInsureds defInsured) {
        int a=0;
      DefInsureds defInsuredss=new DefInsureds();
      defInsuredss.setDefInsuredId(defInsured.getDefInsuredId());
      defInsuredss.setDefInsuredState(defInsured.getDefInsuredState());
      final val updatedeID=defInsuredsMapper.updateById(defInsuredss);
      if(updatedeID>0){
          a=1;
      }else {
          TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
      }
      return a;
    }





    /**
     * 查询方案名称
     */
    @Override
    public List<DefInsureds> selectName() {
        QueryWrapper<DefInsureds> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("DEF_INSURED_STATE",0).eq("IS_DELETED",0);
        List<DefInsureds> list = defInsuredsMapper.selectName(queryWrapper);

        return list;
    }


}
