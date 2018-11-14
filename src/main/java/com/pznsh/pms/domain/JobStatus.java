package com.pznsh.pms.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 在职状态实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobStatus {
    //唯一标识
    private Integer id;
    //在职状态名称
    private String jsName;
    //排序Id
    private Integer sortId;
}
