package com.pznsh.pms.service;

import com.pznsh.pms.dao.OrganizationDao;
import com.pznsh.pms.domain.Organization;
import com.pznsh.pms.util.Result;
import com.pznsh.pms.util.ReturnResult;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@MapperScan("com.pznsh.pms.dao")
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private OrganizationDao organizationDao;
    //设置允许查询的key值
    String[] allowKey = {"id", "orgNo", "orgName", "higherOrgId", "orgHeaderId"};

    @Override
    public Result getAllOrganization() {
        return ReturnResult.success(organizationDao.getAllOrganization());
    }

    @Override
    public Result getOrganizationByKV(String key, String value) {
        if (key == null || key.equalsIgnoreCase("") || value == null || value.equalsIgnoreCase("")) {
            return ReturnResult.failed(-1, "KV键值对不全");
        } else if (!Arrays.asList(allowKey).contains(key)) {
            return ReturnResult.failed(-1, "K值非法或不被允许");
        } else {
            return ReturnResult.success(organizationDao.getOrganizationByKV(key, value));
        }
    }

    @Override
    public Result insertOrganization(Organization organization) {
        if (organizationDao.getOrganizationByKV("id", organization.getId().toString()).size() > 0) {
            return ReturnResult.failed(-1, "该id已存在，不允许重复");
        }
        if (organizationDao.insertOrganization(organization) > 0) {
            return ReturnResult.success("插入成功");
        } else {
            return ReturnResult.failed(-1, "插入失败");
        }
    }

    @Override
    public Result updateOrganization(Organization organization) {
        if (organizationDao.getOrganizationByKV("id", organization.getId().toString()).size() <= 0) {
            return ReturnResult.failed(-1, "该id对应的记录不存在，无法更新");
        }
        if (organizationDao.updateOrganization(organization) > 0) {
            return ReturnResult.success("更新成功");
        } else {
            return ReturnResult.failed(-1, "更新失败");
        }
    }

    @Override
    public Result deleteOrganization(String id) {
        int count = organizationDao.deleteOrganization(id);
        if (count == 1) {
            return ReturnResult.success("删除" + count + "条记录成功");
        } else if (count == 0) {
            return ReturnResult.failed(-1, "删除失败或记录不存在");
        }
        return null;
    }
}
