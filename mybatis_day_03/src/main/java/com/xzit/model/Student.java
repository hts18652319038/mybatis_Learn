package com.xzit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
//链式编程
@Accessors(chain=true)
//全部参数构造方法
@AllArgsConstructor
//无参构造方法
@NoArgsConstructor
public class Student {
    private int id;
    private String name;
    private int age;
    private String gender;
}
