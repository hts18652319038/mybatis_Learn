package com.xzit.mapper;

import com.xzit.model.DriverInfo;
import com.xzit.model.DriverQuery;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface DriverInfoMapper {
    @Insert("insert into driverinfo values (null,#{dtype},#{pid})")
    void insert(DriverInfo info);

    List<DriverQuery> selectList();
}
