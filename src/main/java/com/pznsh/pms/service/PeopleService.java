package com.pznsh.pms.service;

import com.pznsh.pms.dao.PeopleProvider;
import com.pznsh.pms.domain.People;
import com.pznsh.pms.util.Result;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.UpdateProvider;

public interface PeopleService {
    // 获取所有人员
    Result getAllPeople();
    /**
     * 根据指定的KV进行查询人员，比如where key=value
     * @param key  比如id，idNumber等查询条件
     * @param value 比如1,2等查询值
     * @return
     */
    Result getPeopleByKV(String key,String value);
    Result getAllPeopleWithDes();
    Result getPeopleWithDesByKV(String key,String value);
    Result insertPeople(People people);
    Result updatePeople(People people);
    Result deletePeople(String id);
}
