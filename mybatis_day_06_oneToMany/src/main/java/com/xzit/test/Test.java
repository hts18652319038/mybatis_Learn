package com.xzit.test;

import com.xzit.mapper.TeamMapper;
import com.xzit.model.Player;
import com.xzit.model.Team;
import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession();
        TeamMapper teamMapper = session.getMapper(TeamMapper.class);
        List<Team> teams = teamMapper.selectList();
        for (Team team : teams) {
            System.out.println(team.getTname());
        }
        session.close();
    }
}
