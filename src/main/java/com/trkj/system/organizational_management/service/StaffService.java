package com.trkj.system.organizational_management.service;

import com.trkj.system.organizational_management.entity.Staff;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 员工表 服务类
 * </p>
 *
 * @author 谢海欧
 * @since 2021-12-24
 */

public interface StaffService {
        Staff selectstaff(Long id);

        List<Map<String, Object>> selectSex();
        List<Map<String, Object>> selecthy();
        List<Map<String, Object>> selectgl1();
        List<Map<String, Object>> selectgl11();
        List<Map<String, Object>> selectgl2();
        List<Map<String, Object>> selectgl3();
        List<Map<String, Object>> selectgl4();
        List<Map<String, Object>> selectgl5();
        List<Map<String, Object>> selectxl();
        List<Map<String, Object>> selectnl();
        List<Map<String, Object>> selectxz();
        List<Map<String, Object>> selectygzt();
        List<Map<String, Object>> selectnd();
        List<Map<String, Object>> selectrz();
        List<Map<String, Object>> selectyglz();
        List<Map<String, Object>> selectygzz();
        List<Map<String, Object>> selectdepttop();
        List<Map<String, Object>> selectdylz();
        List<Map<String, Object>> selectsylz();
        List<Map<String, Object>> selectbyrz();
        List<Map<String, Object>> selectsyrz();
        List<Map<String, Object>> selectbyygzz();
        List<Map<String, Object>> selectsyygzz();
        List<Map<String, Object>> selectygxj();
        List<Map<String, Object>> selectyglz1();
        List<Map<String, Object>> selectqjrs();
        List<Map<String, Object>> selectdyqjrs();
        List<Map<String, Object>> selectccrs();
        List<Map<String, Object>> selectdyccrs();
        List<Map<String, Object>> selectjbtime();
        List<Map<String, Object>> selectStaffrs();
        List<Map<String, Object>> selectbyjbtime();
        List<Map<String, Object>> selectjxrs();
        List<Map<String, Object>> selectbyjxrs();
        List<Map<String, Object>> selectrlcb();
        List<Map<String, Object>> selectbyrlcb();
        List<Map<String, Object>> selectbxrs();
        List<Map<String, Object>> selectbybxrs();
        List<Map<String, Object>> selectygsbje();
        List<Map<String, Object>> selectbyygsbje();
        List<Map<String, Object>> selectgssbje();
        List<Map<String, Object>> selectbygssbje();
        List<Map<String, Object>> selectbysyjbgz();
        List<Map<String, Object>> selectbyzsjbgz();
        List<Map<String, Object>> selectbyzsjbgzz();
        List<Map<String, Object>> selectbygrgjj();
        List<Map<String, Object>> selectbygrsb();
        List<Map<String, Object>> selectbygssb();
        List<Map<String, Object>> selectbygsgjj();
        List<Map<String, Object>> selectbmgztop();
        List<Map<String, Object>> selectbmgzpj();
        List<Map<String, Object>>selectyglz11();
}
