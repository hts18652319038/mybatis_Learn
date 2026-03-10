package com.xzit.model;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    private int id;
    private String name;
    private int age;
    private String gender;
    private List<Integer> ids;
}
