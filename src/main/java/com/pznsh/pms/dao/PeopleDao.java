package com.pznsh.pms.dao;

import com.pznsh.pms.domain.People;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 人员dao
 */
@Mapper
public interface PeopleDao {
    //查询所有人员
    @Select("select * from People")
    List<People> getAllPeople();

    //使用PeopleProvider类的getHouseRentByKV方法来生成sql
    @SelectProvider(type = PeopleProvider.class, method = "getPeopleByKV")
    List<People> getPeopleByKV(String key, String value);

    @InsertProvider(type = PeopleProvider.class, method = "insertPeople")
    int insertPeople(People people);

    @UpdateProvider(type = PeopleProvider.class, method = "updatePeople")
    int updatePeople(People people);

    @Delete("delete from People where id=#{id}")
    int deletePeople(String id);
}