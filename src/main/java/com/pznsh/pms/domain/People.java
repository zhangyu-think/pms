package com.pznsh.pms.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 人员实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class People {
    //唯一标识
    private Integer id;
    //身份证号
    private String idNumber;
    //工号1，邳州农商行4位工号
    private String workNumber1;
    //工号2，省联社7位工号
    private String workNumber2;
    //姓名
    private String name;
    //年龄
    private Integer age;
    //性别
    private String sex;
    //手机长号1
    private String phone1;
    //手机短号1
    private String shortPhone1;
    //手机长号2
    private String phone2;
    //手机短号2
    private String shortPhone2;
    //邮箱
    private String email1;
    //备用邮箱
    private String email2;
    //机构编号
    private Integer orgId;
    //职位编号
    private Integer positionId;
    //最后编辑时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String editTime;
    //排序Id
    private Integer sortId;
    //在职状态Id
    private Integer jsId;
}
