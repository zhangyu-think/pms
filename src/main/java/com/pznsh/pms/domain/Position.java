package com.pznsh.pms.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 职位实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Position {
    //唯一标识
    private Integer id;
    //职位名称
    private String posName;
    //排序Id
    private Integer sortId;
}
