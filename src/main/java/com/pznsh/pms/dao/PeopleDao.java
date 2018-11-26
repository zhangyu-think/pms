package com.pznsh.pms.dao;

import com.pznsh.pms.domain.People;
import com.pznsh.pms.domain.PeopleWithDes;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 人员dao
 */
@Mapper
public interface PeopleDao {
    //查询所有人员
    @SelectProvider(type = PeopleProvider.class, method = "getAllPeople")
    List<People> getAllPeople();
    //查询所有人员，带描述的，即将机构id，职位id，在职状态id换成名称
    @SelectProvider(type = PeopleProvider.class, method = "getAllPeopleWithDes")
    List<PeopleWithDes> getAllPeopleWithDes();

    //使用PeopleProvider类的getHouseRentByKV方法来生成sql
    @SelectProvider(type = PeopleProvider.class, method = "getPeopleByKV")
    List<People> getPeopleByKV(String key, String value);

    //使用PeopleProvider类的getHouseRentByKV方法来生成sql
    @SelectProvider(type = PeopleProvider.class, method = "getPeopleWithDesByKV")
    List<PeopleWithDes> getPeopleWithDesByKV(String key, String value);

    @InsertProvider(type = PeopleProvider.class, method = "insertPeople")
    int insertPeople(People people);

    @UpdateProvider(type = PeopleProvider.class, method = "updatePeople")
    int updatePeople(People people);

    @Delete("delete from People where id=#{id}")
    int deletePeople(String id);
}