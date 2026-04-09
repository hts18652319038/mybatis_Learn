package com.xzit.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User {
    private Integer id;
    private String name;
    private String password;
    private Integer age;
    private String tel;
}
