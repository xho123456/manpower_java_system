package com.trkj.system.recruit_modular.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.system.recruit_modular.entity.EmploymentTable;
import com.trkj.system.recruit_modular.entity.EmploymentTableVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.system.recruit_modular.entity.Resume;

/**
 * <p>
 * 录用表 服务类
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-13
 */
public interface EmploymentTableServiceVo {
    /**
     * 查询 以录用待接受信息
     */
    IPage<EmploymentTableVo> findAllemployment(EmploymentTableVo employmentTableVo);
    /**
     * 录用放弃原因
     */
    int updatefq(EmploymentTable employmentTable);

    /**
     * 面试通过新增录用人员
     */
    int addEmploy(EmploymentTable employmentTable);
    /**
     * 通过简历id查询录用表数据
     */
    EmploymentTable findbyresumeid(EmploymentTable employmentTable);


}
