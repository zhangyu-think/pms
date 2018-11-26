package com.pznsh.pms.dao;

import com.pznsh.pms.domain.People;
import com.pznsh.pms.util.ReflectHander;
import com.pznsh.pms.util.StringHader;

import java.lang.reflect.Field;

public class PeopleProvider {
    public String getAllPeople() {
        String result = "select * from people";
        return result;
    }
    public String getAllPeopleWithDes() {
//        String result = "select t1.id,t1.idNumber,t1.workNumber1,t1.workNumber2,\n" +
//                "t1.`name`,t1.age,t1.sex,t1.phone1,t1.shortPhone1,\n" +
//                "t1.phone2,t1.shortPhone2,t1.email1,t1.email2,t2.orgName,\n" +
//                "t3.posName,t1.editTime,t1.sortId,t4.jsName\n" +
//                "from people t1, organization t2,position t3, jobstatus t4\n" +
//                "where t1.orgID=t2.id\n" +
//                "and t1.posId=t3.id\n" +
//                "and t1.jsId=t4.id";
        String result = "SELECT t1.id,t1.idNumber,t1.workNumber1,t1.workNumber2,\n" +
                "t1.`name`,t1.age,t1.sex,t1.phone1,t1.shortPhone1,\n" +
                "t1.phone2,t1.shortPhone2,t1.email1,t1.email2,t1.orgId,t2.orgName,\n" +
                "t1.posId,t3.posName,t1.editTime,t1.sortId,t1.jsId,t4.jsName\n" +
                "from people t1\n" +
                "LEFT JOIN organization t2\n" +
                "ON t1.orgId=t2.id\n" +
                "LEFT JOIN position t3\n" +
                "ON t1.posId=t3.id\n" +
                "LEFT JOIN jobstatus t4\n" +
                "on t1.jsId=t4.id";
        return result;
    }
    public String getPeopleByKV(String key, String value) {
        String result = "select * from people where " + key + " like '%" + value + "%'";
        return result;
    }
    public String getPeopleWithDesByKV(String key, String value) {
//        String result = "select t1.id,t1.idNumber,t1.workNumber1,t1.workNumber2,\n" +
//                "t1.`name`,t1.age,t1.sex,t1.phone1,t1.shortPhone1,\n" +
//                "t1.phone2,t1.shortPhone2,t1.email1,t1.email2,t2.orgName,\n" +
//                "t3.posName,t1.editTime,t1.sortId,t4.jsName\n" +
//                "from people t1, organization t2,position t3, jobstatus t4\n" +
//                "where t1.orgID=t2.id\n" +
//                "and t1.posId=t3.id\n" +
//                "and t1.jsId=t4.id\n" +
//                "and t1." + key + " like '%" +value + "%'";
        String result = "SELECT t1.id,t1.idNumber,t1.workNumber1,t1.workNumber2,\n" +
                "t1.`name`,t1.age,t1.sex,t1.phone1,t1.shortPhone1,\n" +
                "t1.phone2,t1.shortPhone2,t1.email1,t1.email2,t1.orgId,t2.orgName,\n" +
                "t1.posId,t3.posName,t1.editTime,t1.sortId,t1.jsId,t4.jsName\n" +
                "from people t1\n" +
                "LEFT JOIN organization t2\n" +
                "ON t1.orgId=t2.id\n" +
                "LEFT JOIN position t3\n" +
                "ON t1.posId=t3.id\n" +
                "LEFT JOIN jobstatus t4\n" +
                "on t1.jsId=t4.id\n" +
                "and t1.\" + key + \" like '%\" +value + \"%'\"";
        return result;
    }

    // 获取类的所有字段，拼接出insert语句
    public String insertPeople(People people) {
        String result = null;
        String sql1 = "insert into people(";
        String sql2 = "values(";
        // 获取所有字段
        Field[] fields = ReflectHander.getField(people);
        for (Field f : fields) {
            if (StringHader.isValueEqual(f.getName(), "id") == false) {
                sql1 = sql1 + f.getName() + ",";
                sql2 = sql2 + "#{" + f.getName() + "},";
            }
        }
        sql1 = sql1.substring(0, sql1.length() - 1);
        sql2 = sql2.substring(0, sql2.length() - 1);
        result = sql1 + ") " + sql2 + ")";
        return result;
    }

    // 获取类的所有字段，拼接出update语句
    public String updatePeople(People people) {
        String result = "update people set ";
        // 获取所有字段
        Field[] fields = ReflectHander.getField(people);
        for (Field f : fields) {
            if (StringHader.isValueEqual(f.getName(), "id") == false) {
                result = result + f.getName() + "=#{" + f.getName() + "},";
            }
        }
        result = result.substring(0, result.length() - 1);
        result = result + " where id=#{id}";
        return result;
    }
}