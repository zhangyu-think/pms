package com.pznsh.pms.service;

import com.pznsh.pms.domain.Position;
import com.pznsh.pms.util.Result;

public interface PositionService {
    Result getAllPosition();

    Result getPositionByKV(String key, String value);

    Result insertPosition(Position position);

    Result updatePosition(Position position);

    Result deletePosition(String id);
}
