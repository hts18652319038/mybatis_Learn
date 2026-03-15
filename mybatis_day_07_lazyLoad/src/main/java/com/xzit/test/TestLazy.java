package com.xzit.test;

import com.xzit.mapper.PlayerMapper;
import com.xzit.model.Player;
import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TestLazy {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession();
        PlayerMapper mapper = session.getMapper(PlayerMapper.class);
        List<Player> players = mapper.selectList();
        players.forEach(System.out::println);
        session.close();
    }
}
