package com.pznsh.pms.dao;

import com.pznsh.pms.domain.JobStatus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * 在职状态Dao
 */
@Mapper
public interface JobStatusDao {
    //查询所有在职状态
    @Select("select * from JobStatus")
    List<JobStatus> getAllJobStatus();
}
