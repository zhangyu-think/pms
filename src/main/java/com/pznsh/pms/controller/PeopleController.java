package com.pznsh.pms.controller;

import com.alibaba.fastjson.JSONObject;
import com.pznsh.pms.domain.People;
import com.pznsh.pms.service.PeopleService;
import com.pznsh.pms.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 人员控制类
 */
@RestController
@RequestMapping("/people")
@Slf4j
public class PeopleController {
    @Autowired
    private PeopleService peopleService;

    @RequestMapping("/getallpeople")
    public Result getAllPeople() {
        log.info("接收到查询人员请求：查询所有用户");
        return peopleService.getAllPeople();
    }

    @RequestMapping("/getpeoplebykv")
    public Result getPeopleByKV(@RequestBody JSONObject jsonParam) {
        log.info("接收到查询人员请求：key=" + jsonParam.getString("key") + "&value=" + jsonParam.getString("value"));
        return peopleService.getPeopleByKV(jsonParam.getString("key"), jsonParam.getString("value"));
    }

    @RequestMapping("/insertpeople")
    public Result insertPeople(@RequestBody People people) {
        log.info("接收到新增人员请求：" + people.toString());
        return peopleService.insertPeople(people);
    }

    @RequestMapping("/updatepeople")
    public Result updatePeople(@RequestBody People people) {
        log.info("接收到更新人员请求：" + people.toString());
        return peopleService.updatePeople(people);
    }

    @RequestMapping("/deletepeople")
    public Result deletePeople(@RequestBody JSONObject jsonParam) {
        log.info("接收到删除人员请求：id=" + jsonParam.getString("id"));
        return peopleService.deletePeople(jsonParam.getString("id"));
    }
}