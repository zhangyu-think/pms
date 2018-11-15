package com.pznsh.pms.dao;

import com.pznsh.pms.domain.People;
import com.pznsh.pms.util.ReflectHander;
import com.pznsh.pms.util.StringHader;

import java.lang.reflect.Field;

public class PeopleProvider {
    public String getPeopleByKV(String key, String value) {
        String result = "select * from People where " + key + " like '%" + value + "%'";
        return result;
    }

    // 获取类的所有字段，拼接出insert语句
    public String insertPeople(People people) {
        String result = null;
        String sql1 = "insert into People(";
        String sql2 = "values(";
        // 获取所有字段
        Field[] fields = ReflectHander.getField(people);
        for (Field f : fields) {
            sql1 = sql1 + f.getName() + ",";
            sql2 = sql2 + "#{" + f.getName() + "},";
        }
        sql1 = sql1.substring(0, sql1.length() - 1);
        sql2 = sql2.substring(0, sql2.length() - 1);
        result = sql1 + ") " + sql2 + ")";
        return result;
    }

    // 获取类的所有字段，拼接出update语句
    public String updatePeople(People people) {
        String result = "update People set ";
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