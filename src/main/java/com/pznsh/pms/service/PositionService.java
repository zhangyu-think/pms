package com.pznsh.pms.service;

import com.pznsh.pms.util.Result;

public interface PositionService {
    Result getAllPosition();
    Result getPositionById(Integer id);
    Result getPositionByPosName(String posName);
}
