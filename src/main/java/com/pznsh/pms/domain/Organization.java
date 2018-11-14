package com.pznsh.pms.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 机构实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organization {
    //唯一标识
    private Integer id;
    //机构编号
    private String orgNo;
    //机构名称
    private String orgName;
    //上级机构编号
    private Integer higherOrgId;
    //机构负责人编号
    private Integer orgHeaderId;
    //排序Id
    private Integer sortId;
}
