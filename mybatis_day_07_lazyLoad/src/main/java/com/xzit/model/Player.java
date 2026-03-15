package com.xzit.model;

import lombok.Data;

@Data
public class Player {
    private int pid;
    private String pname;
    private int tid;
    private Team team;
}
