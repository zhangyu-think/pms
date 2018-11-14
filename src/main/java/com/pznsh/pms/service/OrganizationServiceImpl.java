package com.pznsh.pms.service;

import com.pznsh.pms.dao.OrganizationDao;
import com.pznsh.pms.domain.Organization;
import com.pznsh.pms.util.Result;
import com.pznsh.pms.util.ReturnResult;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@MapperScan("com.pznsh.pms.dao")
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private OrganizationDao organizationDao;
    @Override
    public Result getAllOrganization() {
        Result result=null;
        try{
            List<Organization> organizationList=organizationDao.getAllOrganization();
            result= ReturnResult.success(organizationList);
        }catch (Exception ex){
            result=ReturnResult.failed(-1,"查询失败");
        }
        return result;
    }

    @Override
    public Result getOrganizationByKV(String key, String value) {
        Result result=null;
        //检验键值对
        if (key==null||key.equalsIgnoreCase("")||value==null||value.equalsIgnoreCase("")){
            result=ReturnResult.failed(-1,"KV键值对不全");
        }else{
            //如果键值对合法
            List<Organization> organizationList=null;
            switch(key) {
                case "id":
                    int tmpInt= -1;
                    try {
                        //尝试转化value
                        tmpInt = Integer.parseInt(value);
                    } catch (NumberFormatException e) {
                        result=ReturnResult.failed(-1,"K为id，V值非法");
                        e.printStackTrace();
                        return result;
                    }
                    organizationList=organizationDao.getOrganizationById(tmpInt);
                    break;
                case "orgNo":
                    organizationList=organizationDao.getOrganizationByOrgNo(value);
                    break;
                case "orgName":
                    organizationList=organizationDao.getOrganizationByOrgName(value);
                    break;
                case "higherOrgId":
                    organizationList=organizationDao.getOrganizationByHigherOrgId(value);
                    break;
                case "orgHeaderId":
                    organizationList=organizationDao.getOrganizationByOrgHeaderId(value);
                    break;
                default:
                    result=ReturnResult.failed(-1,"K键值非法");
                    break;
            }
            result=ReturnResult.success(organizationList);
        }
        return result;
    }
}
