package com.trkj.system.salary_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.system.salary_management.mapper.entity.Moneypigeonhole;
import com.trkj.system.salary_management.mapper.entity.StaffSalary;

import java.util.List;
import java.util.Map;

public interface MoneypigeonholeService {
    int guidanwag(Moneypigeonhole moneypigeonhole);
    List<Map<String, Object>> selectbyid();
    List<Map<String, Object>> selectbyyf();
    IPage<Moneypigeonhole> selectPaer(Moneypigeonhole moneypigeonhole);
}
