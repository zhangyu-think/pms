package com.pznsh.pms.dao;

import com.pznsh.pms.domain.JobStatus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * 在职状态Dao
 */
@Mapper
public interface JobStatusDao {
    //查询所有在职状态
    @Select("select * from jobstatus")
    List<JobStatus> getAllJobStatus();

    @SelectProvider(type = JobStatusProvider.class, method = "getJobStatusByKV")
    List<JobStatus> getJobStatusByKV(String key,String value);
}
