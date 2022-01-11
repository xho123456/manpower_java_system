package com.trkj.system.recruit_modular.service;

import com.trkj.system.recruit_modular.entity.Educationss;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 受教育经历表 服务类
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-06
 */
public interface EducationssService {
    List<Educationss> selectByidEd(Educationss educationss);
}
