package com.pznsh.pms.controller;

import com.pznsh.pms.service.OrganizationService;
import com.pznsh.pms.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 机构控制类
 */
@RestController
@RequestMapping("/Organization")
@Slf4j
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;
    @RequestMapping("/getAllOrganization")
    public Result getAllOrganization(){
        log.info("接收到请求：查询所有机构");
        return organizationService.getAllOrganization();
    }
    @RequestMapping("/getOrganizationById")
    public Result getOrganizationById(String id){
        log.info("接收到请求：根据id查询机构。id="+id);
        return organizationService.getOrganizationByKV("id",id);
    }
    @RequestMapping("/getOrganizationByOrgNo")
    public Result getOrganizationByOrgNo(String orgNo){
        log.info("接收到请求：根据orgNo查询机构。orgNo="+orgNo);
        return organizationService.getOrganizationByKV("orgNo",orgNo);
    }
    @RequestMapping("/getOrganizationByOrgName")
    public Result getOrganizationByOrgName(String orgName){
        log.info("接收到请求：根据orgName查询机构。orgName="+orgName);
        return organizationService.getOrganizationByKV("orgName",orgName);
    }
    @RequestMapping("/getOrganizationByHigherOrgId")
    public Result getOrganizationByHigherOrgId(String higherOrgId){
        log.info("接收到请求：根据higherOrgId查询机构。higherOrgId="+higherOrgId);
        return organizationService.getOrganizationByKV("higherOrgId",higherOrgId);
    }
    @RequestMapping("/getOrganizationByOrgHeaderId")
    public Result getOrganizationByOrgHeaderId(String orgHeaderId){
        log.info("接收到请求：根据orgHeaderId查询机构。orgHeaderId="+orgHeaderId);
        return organizationService.getOrganizationByKV("orgHeaderId",orgHeaderId);
    }
}
