package com.pznsh.pms.controller;

import com.alibaba.fastjson.JSONObject;
import com.pznsh.pms.domain.Position;
import com.pznsh.pms.service.PositionService;
import com.pznsh.pms.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 职位控制类
 */
@RestController
@RequestMapping("/position")
@Slf4j
public class PositionController {
    @Autowired
    private PositionService positionService;

    @RequestMapping("/getallposition")
    public Result getAllPosition() {
        log.info("接收到请求：查询所有职位");
        return positionService.getAllPosition();
    }

    @RequestMapping("/getpositionbykv")
    public Result getPositionByKV(@RequestBody JSONObject jsonParam) {
        log.info("接收到查询职位请求：key=" + jsonParam.getString("key") + "&value=" + jsonParam.getString("value"));
        return positionService.getPositionByKV(jsonParam.getString("key"), jsonParam.getString("value"));
    }

    @RequestMapping("/insertposition")
    public Result insertPosition(@RequestBody Position position) {
        log.info("接收到新增职位请求：" + position.toString());
        return positionService.insertPosition(position);
    }

    @RequestMapping("/updateposition")
    public Result updatePosition(@RequestBody Position position) {
        log.info("接收到更新职位请求：" + position.toString());
        return positionService.updatePosition(position);
    }

    @RequestMapping("/deleteposition")
    public Result deletePosition(@RequestBody JSONObject jsonParam) {
        log.info("接收到删除职位请求：id=" + jsonParam.getString("id"));
        return positionService.deletePosition(jsonParam.getString("id"));
    }
}
