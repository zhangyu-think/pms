package com.pznsh.pms.dao;

import com.pznsh.pms.domain.Position;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 职位Dao
 */
@Mapper
public interface PositionDao {
    //查询所有职位
    @Select("select * from Position")
    List<Position> getAllPosition();

    //使用PositionProvider类的getHouseRentByKV方法来生成sql
    @SelectProvider(type = PositionProvider.class, method = "getPositionByKV")
    List<Position> getPositionByKV(String key, String value);

    @InsertProvider(type = PositionProvider.class, method = "insertPosition")
    int insertPosition(Position position);

    @UpdateProvider(type = PositionProvider.class, method = "updatePosition")
    int updatePosition(Position position);

    @Delete("delete from Position where id=#{id}")
    int deletePosition(String id);
}
