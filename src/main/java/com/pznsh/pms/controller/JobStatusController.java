package com.pznsh.pms.controller;

import com.pznsh.pms.service.JobStatusService;
import com.pznsh.pms.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobstatus")
@Slf4j
public class JobStatusController {
    @Autowired
    private JobStatusService jobStatusService;
    @RequestMapping("/getalljobstatus")
    public Result getAllJobStatus(){
        log.info("接收到请求：查询所有在职状态");
        return jobStatusService.getAllJobStatus();
    }
    @RequestMapping("/getjobstatusbykv")
    public Result getJobStatusByKV(String key, String value){
        return jobStatusService.getAllJobStatus();

    }
}
