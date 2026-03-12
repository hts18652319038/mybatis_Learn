package com.xzit.mapper;

import com.xzit.model.Team;

import java.util.List;

public interface TeamMapper {
    List<Team> selectList();
    void delete(int tid);
}
