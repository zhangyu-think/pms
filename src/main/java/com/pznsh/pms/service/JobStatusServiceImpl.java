package com.pznsh.pms.service;

import com.pznsh.pms.dao.JobStatusDao;
import com.pznsh.pms.domain.JobStatus;
import com.pznsh.pms.util.Result;
import com.pznsh.pms.util.ReturnResult;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@MapperScan("com.pznsh.pms.dao")
public class JobStatusServiceImpl implements JobStatusService {
    @Autowired
    private JobStatusDao jobStatusDao;
    @Override
    public Result getAllJobStatus() {
        Result result=null;
        try{
            List<JobStatus> jobStatusList=jobStatusDao.getAllJobStatus();
            result= ReturnResult.success(jobStatusList);
        }catch (Exception ex){
            result=ReturnResult.failed(-1,"查询失败");
        }
        return result;
    }
}
