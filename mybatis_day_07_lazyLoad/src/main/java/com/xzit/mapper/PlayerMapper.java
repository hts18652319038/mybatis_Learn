package com.xzit.mapper;

import com.xzit.model.Player;

import java.util.List;

public interface PlayerMapper {
    Player selectId(int pid);
    List<Player> selectList();
    List<Player> selectByTid(int tid);
}
