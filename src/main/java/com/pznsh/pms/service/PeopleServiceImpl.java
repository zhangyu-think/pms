package com.pznsh.pms.service;

import com.pznsh.pms.dao.PeopleDao;
import com.pznsh.pms.domain.People;
import com.pznsh.pms.util.Result;
import com.pznsh.pms.util.ReturnResult;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
@MapperScan("com.pznsh.pms.dao")
public class PeopleServiceImpl implements PeopleService {
    @Autowired
    private PeopleDao peopleDao;
    //设置允许查询的key值
    String[] allowKey = {"id","idNumber","workNumber1","workNumber2","name"
            ,"age","sex","phone1","shortPhone1","phone2","shortPhone2"
            ,"email1","email2","orgId","positionId","jsId"};
    @Override
    public Result getAllPeople(){
        return ReturnResult.success(peopleDao.getAllPeople());
    }
    @Override
    public Result getPeopleByKV(String key, String value) {
        if (key==null||key.equalsIgnoreCase("")||value==null||value.equalsIgnoreCase("")){
            return ReturnResult.failed(-1,"KV键值对不全");
        }else if (!Arrays.asList(allowKey).contains(key)) {
            return ReturnResult.failed(-1, "K值非法或不被允许");
        }else{
            return ReturnResult.success(peopleDao.getPeopleByKV(key,value));
        }
    }
    @Override
    public Result insertPeople(People people) {
        if (peopleDao.getPeopleByKV("id",people.getId().toString()).size()>0){
            return ReturnResult.failed(-1,"该id已存在，不允许重复");
        }
        if (peopleDao.insertPeople(people)>0){
            return ReturnResult.success("插入成功");
        }else{
            return ReturnResult.failed(-1,"插入失败");
        }
    }
    @Override
    public Result updatePeople(People people) {
        if (peopleDao.getPeopleByKV("id",people.getId().toString()).size()<=0){
            return ReturnResult.failed(-1,"该id对应的记录不存在，无法更新");
        }
        if (peopleDao.updatePeople(people)>0){
            return ReturnResult.success("更新成功");
        }else{
            return ReturnResult.failed(-1,"更新失败");
        }
    }
    @Override
    public Result deletePeople(String id) {
        int count = peopleDao.deletePeople(id);
        if (count == 1) {
            return ReturnResult.success("删除" + count + "条记录成功");
        } else if (count == 0) {
            return ReturnResult.failed(-1, "删除失败或记录不存在");
        }
        return null;
    }
}
