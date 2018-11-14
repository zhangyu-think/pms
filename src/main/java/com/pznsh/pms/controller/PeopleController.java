package com.pznsh.pms.controller;

import com.pznsh.pms.service.PeopleService;
import com.pznsh.pms.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 人员控制类
 */
@RestController
@RequestMapping("/People")
@Slf4j
public class PeopleController {
    @Autowired
    private PeopleService peopleService;
    @RequestMapping("/getAllPeople")
    public Result getAllPeople(){
        log.info("接收到请求：查询所有用户");
        return peopleService.getAllPeople();
    }
    @RequestMapping("/getPeopleByKV")
    public Result getPeopleByKV(String key, String value){
        log.info("接收到查询人员请求：key=" + key +"&value=" + value);
        return peopleService.getPeopleByKV(key,value);
    }
    @RequestMapping("/getPeopleById")
    public Result getPeopleById(String id){
        log.info("接收到请求：根据id查询人员。id="+id);
        return peopleService.getPeopleByKV("id",id);
    }
    @RequestMapping("/getPeopleByIdNumber")
    public Result getPeopleByIdNumber(String idNumber){
        log.info("接收到请求：根据idNumber查询人员。idNumber="+idNumber);
        return peopleService.getPeopleByKV("idNumber",idNumber);
    }
    @RequestMapping("/getPeopleByWorkNumber1")
    public Result getPeopleByWorkNumber1(String workNumber1){
        log.info("接收到请求：根据workNumber1查询人员。workNumber1="+workNumber1);
        return peopleService.getPeopleByKV("workNumber1",workNumber1);
    }
    @RequestMapping("/getPeopleByWorkNumber2")
    public Result getPeopleByWorkNumber2(String workNumber2){
        log.info("接收到请求：根据workNumber2查询人员。workNumber2="+workNumber2);
        return peopleService.getPeopleByKV("workNumber2",workNumber2);
    }
    @RequestMapping("/getPeopleByName")
    public Result getPeopleByName(String name){
        log.info("接收到请求：根据name查询人员。name="+name);
        return peopleService.getPeopleByKV("name",name);
    }

}
