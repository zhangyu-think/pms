package com.pznsh.pms.controller;

import com.pznsh.pms.service.PositionService;
import com.pznsh.pms.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 职位控制类
 */
@RestController
@RequestMapping("/Position")
@Slf4j
public class PositionController {
    @Autowired
    private PositionService positionService;
    @RequestMapping("/getAllPosition")
    public Result getAllPosition(){
        log.info("接收到请求：查询所有职位");
        return positionService.getAllPosition();
    }
    @RequestMapping("/getPositionById")
    public Result getPositionById(Integer id){
        log.info("接收到请求：根据id查询职位。id="+id);
        return positionService.getPositionById(id);
    }
    @RequestMapping("/getPositionByPosName")
    public Result getPositionByPosName(String posName){
        log.info("接收到请求：根据posName查询职位。posName="+posName);
        return positionService.getPositionByPosName(posName);
    }
}
