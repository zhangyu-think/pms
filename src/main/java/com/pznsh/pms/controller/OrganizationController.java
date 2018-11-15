package com.pznsh.pms.controller;

import com.alibaba.fastjson.JSONObject;
import com.pznsh.pms.domain.Organization;
import com.pznsh.pms.service.OrganizationService;
import com.pznsh.pms.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 机构控制类
 */
@RestController
@RequestMapping("/organization")
@Slf4j
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;
    @RequestMapping("/getallorganization")
    public Result getAllOrganization(){
        log.info("接收到请求：查询所有机构");
        return organizationService.getAllOrganization();
    }

    @RequestMapping("/getorganizationbykv")
    public Result getOrganizationByKV(@RequestBody JSONObject jsonParam) {
        log.info("接收到查询机构请求：key=" + jsonParam.getString("key") + "&value=" + jsonParam.getString("value"));
        return organizationService.getOrganizationByKV(jsonParam.getString("key"), jsonParam.getString("value"));
    }

    @RequestMapping("/insertorganization")
    public Result insertOrganization(@RequestBody Organization organization) {
        log.info("接收到新增机构请求：" + organization.toString());
        return organizationService.insertOrganization(organization);
    }

    @RequestMapping("/updateorganization")
    public Result updateOrganization(@RequestBody Organization organization) {
        log.info("接收到更新机构请求：" + organization.toString());
        return organizationService.updateOrganization(organization);
    }

    @RequestMapping("/deleteorganization")
    public Result deleteOrganization(@RequestBody JSONObject jsonParam) {
        log.info("接收到删除机构请求：id=" + jsonParam.getString("id"));
        return organizationService.deleteOrganization(jsonParam.getString("id"));
    }
}
