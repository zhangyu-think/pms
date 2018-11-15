package com.pznsh.pms.dao;

import com.pznsh.pms.domain.Organization;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 机构Dao
 */
@Mapper
public interface OrganizationDao {
    //查询所有人员
    @Select("select * from Organization")
    List<Organization> getAllOrganization();
    //使用OrganizationProvider类的getHouseRentByKV方法来生成sql
    @SelectProvider(type = OrganizationProvider.class, method = "getOrganizationByKV")
    List<Organization> getOrganizationByKV(String key,String value);
    @InsertProvider(type = OrganizationProvider.class, method = "insertOrganization")
    int insertOrganization(Organization Organization);
    @UpdateProvider(type = OrganizationProvider.class, method="updateOrganization")
    int updateOrganization(Organization Organization);
    @Delete("delete from Organization where id=#{id}")
    int deleteOrganization(String id);
}
