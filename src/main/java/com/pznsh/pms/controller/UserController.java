package com.pznsh.pms.controller;

import com.alibaba.fastjson.JSONObject;
import com.pznsh.pms.util.Result;
import com.pznsh.pms.util.ReturnResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    // 登录
    @RequestMapping("/login")
    public Result login(@RequestBody JSONObject jsonParam){
        log.info("接收到登录请求：username="+jsonParam.getString("username")+";password="+jsonParam.getString("password"));
        Map<String,String> re =new LinkedHashMap<String,String>();
        re.put("token","admin");
        return ReturnResult.success(re);
    }
    @RequestMapping("/getinfo")
    public Result getInfo(String token){
        log.info("接收到查询用户信息请求：token="+token);
        Map<String,String> re =new LinkedHashMap<String,String>();
        re.put("roles","['admin']");
        re.put("token","admin");
        re.put("name","admin");
        re.put("introduction","超级管理员");
        re.put("avatar","/avatar/tx.gif");
        return ReturnResult.success(re);
    }
    @RequestMapping("/logout")
    public Result logout(){
        return ReturnResult.success("success");
    }
}
