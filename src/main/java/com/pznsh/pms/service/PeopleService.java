package com.pznsh.pms.service;

import com.pznsh.pms.util.Result;


public interface PeopleService {
    /**
     * 根据指定的KV进行查询人员，比如where key=value
     * @param key  比如id，idNumber等查询条件
     * @param value 比如1,2等查询值
     * @return
     */
    Result getPeopleByKV(String key,String value);
    Result getAllPeople();
//    Result getPeopleById(Integer id);
//    Result getPeopleByIdNumber(String idNumber);
//    Result getPeopleByWorkNumber1(String workNumber1);
//    Result getPeopleByWorkNumber2(String workNumber2);
//    Result getPeopleByName(String name);
}
