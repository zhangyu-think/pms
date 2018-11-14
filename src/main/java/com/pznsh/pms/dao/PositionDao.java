package com.pznsh.pms.dao;

import com.pznsh.pms.domain.Position;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * 职位Dao
 */
@Mapper
public interface PositionDao {
    //查询所有职位
    @Select("select * from Position")
    List<Position> getAllPosition();
    //根据id查询职位
    @Select("select * from Position where id =#{id}")
    Position getPositionById(Integer id);
    //根据名称查询职位
    @Select("select * from Position where posName =#{posName}")
    List<Position> getPositionByPosName(String posName);
}
