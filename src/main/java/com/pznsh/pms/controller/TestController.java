package com.pznsh.pms.controller;

import com.pznsh.pms.dao.PeopleProvider;
import com.pznsh.pms.domain.People;
import com.pznsh.pms.util.ReflectHander;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {
    @RequestMapping("/test1")
    public String test1() throws Exception {
        People people=new People();
        PeopleProvider peopleProvider=new PeopleProvider();
        log.info(peopleProvider.getPeopleByKV("id","1"));
        log.info(peopleProvider.insertPeople(people));
        log.info(peopleProvider.updatePeople(people));
        return "1";
    }
}
