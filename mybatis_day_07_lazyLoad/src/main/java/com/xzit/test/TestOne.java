package com.xzit.test;

import com.xzit.mapper.PlayerMapper;
import com.xzit.model.Player;
import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

public class TestOne {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession();
        PlayerMapper mapper = session.getMapper(PlayerMapper.class);
        Player player = mapper.selectId(1);
        System.out.println(player);
        session.close();
    }
}
