package com.pznsh.pms.service;

import com.pznsh.pms.domain.JobStatus;
import com.pznsh.pms.util.Result;

import java.util.List;

public interface JobStatusService {
    //查询所有在职状态
    Result getAllJobStatus();

    Result getJobStatusByKV(String key, String value);
}
