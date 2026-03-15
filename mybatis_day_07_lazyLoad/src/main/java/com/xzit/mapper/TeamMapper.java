package com.xzit.mapper;

import com.xzit.model.Team;

import java.util.List;

public interface TeamMapper {
    Team selectById(int tid);
    List<Team> selectList();
}
