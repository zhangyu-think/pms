package com.pznsh.pms.service;

import com.pznsh.pms.dao.PositionDao;
import com.pznsh.pms.domain.Position;
import com.pznsh.pms.util.Result;
import com.pznsh.pms.util.ReturnResult;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@MapperScan("com.pznsh.pms.dao")
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionDao positionDao;
    @Override
    public Result getAllPosition() {
        Result result=null;
        try{
            List<Position> positionList=positionDao.getAllPosition();
            result=ReturnResult.success(positionList);
        }catch (Exception ex){
            result=ReturnResult.failed(-1,"查询失败");
        }
        return result;
    }

    @Override
    public Result getPositionById(Integer id) {
        Result result=null;
        if (id==null){
            result=ReturnResult.failed(-1,"未找到参数id或id为空");
        }else{
            Position position=positionDao.getPositionById(id);
            if (position==null){
                result=ReturnResult.failed(-1,"查无此职位");
            }else{
                result=ReturnResult.success(position);
            }
        }
        return result;
    }

    @Override
    public Result getPositionByPosName(String posName) {
        Result result=null;
        if (posName==null||posName.equalsIgnoreCase("")){
            result=ReturnResult.failed(-1,"未找到参数posName或posName为空");
        }else{
            List<Position> positionList=positionDao.getPositionByPosName(posName);
            if (positionList.size()<=0){
                result=ReturnResult.failed(-1,"查无此职位");
            }else{
                result=ReturnResult.success(positionList);
            }
        }
        return result;
    }
}
