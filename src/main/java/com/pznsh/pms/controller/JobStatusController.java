package com.pznsh.pms.controller;

import com.alibaba.fastjson.JSONObject;
import com.pznsh.pms.service.JobStatusService;
import com.pznsh.pms.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobstatus")
@Slf4j
public class JobStatusController {
    @Autowired
    private JobStatusService jobStatusService;
    @RequestMapping("/getalljobstatus")
    public Result getAllJobStatus() throws InterruptedException {
        log.info("接收到请求：查询所有在职状态");
//        Thread.currentThread().sleep(10000);//毫秒
        return jobStatusService.getAllJobStatus();
    }
    @RequestMapping("/getjobstatusbykv")
    public Result getJobStatusByKV(@RequestBody JSONObject jsonParam){
        log.info("接收到在职状态请求：key=" + jsonParam.getString("key") +"&value="+jsonParam.getString("value"));
        return jobStatusService.getJobStatusByKV(jsonParam.getString("key"),jsonParam.getString("value"));
    }
}
