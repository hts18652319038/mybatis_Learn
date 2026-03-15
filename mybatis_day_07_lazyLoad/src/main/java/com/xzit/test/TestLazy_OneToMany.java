package com.xzit.test;

import com.xzit.mapper.TeamMapper;
import com.xzit.model.Player;
import com.xzit.model.Team;
import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TestLazy_OneToMany {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession();
        TeamMapper mapper = session.getMapper(TeamMapper.class);
        List<Team> teams = mapper.selectList();
        for (Team team : teams) {
            System.out.println(team);
            List<Player> players = team.getPlayers();
            for (Player player : players) {
                System.out.println(player);
            }
        }
        session.close();
    }
}
