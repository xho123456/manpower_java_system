package com.trkj.system.workbench.mapper;

import com.trkj.system.workbench.entity.AdclockRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 打卡记录表 Mapper 接口
 * </p>
 *
 * @author 鄧琪
 * @since 2022-02-20
 */
@Mapper
public interface AdclockRecordMapper extends BaseMapper<AdclockRecord> {

    //查询当前用户当天的打卡记录
    @Select("select * from CLOCK_RECORD where STAFF_ID= #{id} and TO_CHAR(DAY_DATE,'yyyy-MM-dd')=TO_CHAR(sysdate,'yyyy-MM-dd')")
    AdclockRecord querybyidday(Integer id);

}
