package com.trkj.system.organizational_management.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.system.organizational_management.entity.StaffWag;

import java.util.List;
import java.util.Map;

public interface StaffWagService extends IService<StaffWag> {
    int insertStaffWag(List<Integer> ids);

    List<Map<String, Object>> selecbynogz();
}
