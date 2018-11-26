package com.pznsh.pms.service;

import com.pznsh.pms.dao.JobStatusDao;
import com.pznsh.pms.domain.JobStatus;
import com.pznsh.pms.util.Result;
import com.pznsh.pms.util.ReturnResult;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@MapperScan("com.pznsh.pms.dao")
public class JobStatusServiceImpl implements JobStatusService {
    @Autowired
    private JobStatusDao jobStatusDao;
    //设置允许查询的key值
    String[] allowKey = {"id", "jsName", "sortID"};
    @Override
    public Result getAllJobStatus() {
        return ReturnResult.success(jobStatusDao.getAllJobStatus());
    }

    @Override
    public Result getJobStatusByKV(String key, String value) {
        if (key == null || key.equalsIgnoreCase("") || value == null || value.equalsIgnoreCase("")) {
            return ReturnResult.failed(-1, "KV键值对不全");
        } else if (!Arrays.asList(allowKey).contains(key)) {
            return ReturnResult.failed(-1, "K值非法或不被允许");
        } else {
            return ReturnResult.success(jobStatusDao.getJobStatusByKV(key, value));
        }
    }
}
