package com.pznsh.pms.controller;

import com.pznsh.pms.domain.People;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/Test")
public class TestController {
    @RequestMapping("/test1")
    public String test1(){
        People p1=new People();
        return p1.toString();
    }
}
