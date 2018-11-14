package com.pznsh.pms.dao;

import com.pznsh.pms.domain.Organization;
import com.pznsh.pms.domain.Position;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 机构Dao
 */
@Mapper
public interface OrganizationDao {
    //查询所有机构
    @Select("select * from Organization")
    List<Organization> getAllOrganization();
    //根据id查询机构
    @Select("select * from Organization where id =#{id}")
    List<Organization> getOrganizationById(Integer id);
    //根据机构编号查询机构
    @Select("select * from Organization where orgNo =#{orgNo}")
    List<Organization> getOrganizationByOrgNo(String orgNo);
    //根据名称查询机构
    @Select("select * from Organization where orgName =#{orgName}")
    List<Organization> getOrganizationByOrgName(String orgName);
    //根据上级机构编号查询机构
    @Select("select * from Organization where higherOrgId =#{higherOrgId}")
    List<Organization> getOrganizationByHigherOrgId(String higherOrgId);
    //根据负责人人员编号查询机构
    @Select("select * from Organization where orgHeaderId =#{orgHeaderId}")
    List<Organization> getOrganizationByOrgHeaderId(String orgHeaderId);
}
