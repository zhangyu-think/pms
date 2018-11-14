package com.pznsh.pms.service;

import com.pznsh.pms.dao.PeopleDao;
import com.pznsh.pms.domain.People;
import com.pznsh.pms.util.Result;
import com.pznsh.pms.util.ReturnResult;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@MapperScan("com.pznsh.pms.dao")
public class PeopleServiceImpl implements PeopleService {
    @Autowired
    private PeopleDao peopleDao;

    @Override
    public Result getPeopleByKV(String key, String value) {
        Result result=null;
        //检验键值对
        if (key==null||key.equalsIgnoreCase("")||value==null||value.equalsIgnoreCase("")){
            result=ReturnResult.failed(-1,"KV键值对不全");
        }else{
            //如果键值对合法
            List<People> peopleList=null;
            switch(key) {
                case "id":
                    int tmpInt=-1;
                    try {
                        //尝试转化value
                        tmpInt = Integer.parseInt(value);
                    } catch (NumberFormatException e) {
                        result=ReturnResult.failed(-1,"K为id，V值非法");
                        e.printStackTrace();
                        return result;
                    }
                    peopleList=peopleDao.getPeopleById(tmpInt);
                    break;
                case "idNumber":
                    peopleList=peopleDao.getPeopleByIdNumber(value);
                    break;
                case "workNumber1":
                    peopleList=peopleDao.getPeopleByWorkNumber1(value);
                    break;
                case "workNumber2":
                    peopleList=peopleDao.getPeopleByWorkNumber2(value);
                    break;
                case "name":
                    peopleList=peopleDao.getPeopleByName(value);
                    break;
                default:
                    result=ReturnResult.failed(-1,"K键值非法");
                    break;
            }
            result=ReturnResult.success(peopleList);
        }
        return result;
    }

    @Override
    public Result getAllPeople(){
        Result result=null;
        try{
            List<People> peopleList=peopleDao.getAllPeople();
            result=ReturnResult.success(peopleList);
        }catch (Exception ex){
            result=ReturnResult.failed(-1,"查询失败");
        }
        return result;
    }
//    @Override
//    public Result getPeopleById(Integer id) {
//        Result result=null;
//        return result;
//    }
//
//    @Override
//    public Result getPeopleByIdNumber(String idNumber) {
//        Result result=null;
//        if (idNumber==null||idNumber.equalsIgnoreCase("")){
//            result=ReturnResult.failed(-1,"未找到参数idNumber或idNumber为空");
//        }else{
//            List<People> peopleList=peopleDao.getPeopleByIdNumber(idNumber);
//            if (peopleList.size()<=0){
//                result=ReturnResult.failed(-1,"查无此人员");
//            }else{
//                result=ReturnResult.success(peopleList);
//            }
//        }
//        return result;
//    }
//
//    @Override
//    public Result getPeopleByWorkNumber1(String workNumber1) {
//        return null;
//    }
//
//    @Override
//    public Result getPeopleByWorkNumber2(String workNumber2) {
//        return null;
//    }
//
//    @Override
//    public Result getPeopleByName(String name) {
//        return null;
//    }
}
