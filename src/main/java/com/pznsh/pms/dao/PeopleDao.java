package com.pznsh.pms.dao;

import com.pznsh.pms.domain.People;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
/**
 * 人员dao
 */
@Mapper
public interface PeopleDao {
    //查询所有人员
    @Select("select * from People")
    List<People> getAllPeople();
    //根据id查询人员
    @Select("select * from People where id =#{id}")
    List<People> getPeopleById(Integer id);
    //根据身份证号查询人员
    @Select("select * from People where idNumber =#{idNumber}")
    List<People> getPeopleByIdNumber(String idNumber);
    //根据邳州农商行4位工号查询人员
    @Select("select * from People where workNumber1 =#{workNumber1}")
    List<People> getPeopleByWorkNumber1(String workNumber1);
    //根据省联社工号查询人员
    @Select("select * from People where workNumber2 =#{workNumber2}")
    List<People> getPeopleByWorkNumber2(String workNumber2);
    //根据姓名查询人员
    @Select("select * from People where name =#{name}")
    List<People> getPeopleByName(String name);
}
