package com.pznsh.pms.service;

import com.pznsh.pms.domain.Organization;
import com.pznsh.pms.util.Result;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrganizationService {
    //查询所有机构
    Result getAllOrganization();
    /**
     * 根据指定的KV进行查询机构，比如where key=value
     * @param key  比如id，idNumber等查询条件
     * @param value 比如1,2等查询值
     * @return
     */
    Result getOrganizationByKV(String key,String value);
}
