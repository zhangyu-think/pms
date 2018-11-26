package com.pznsh.pms.dao;

public class JobStatusProvider {
    public String getJobStatusByKV(String key,String value) {
        String result = "select * from jobstatus where " + key + " like '%" + value + "%'";
        return result;
    }
}
