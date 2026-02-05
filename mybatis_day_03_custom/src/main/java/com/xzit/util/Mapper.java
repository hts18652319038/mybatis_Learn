package com.xzit.util;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
public class Mapper {
    // 封装 xml 文件中的sql
    private String sqlStatement;
    // 封装 xml 文件中返回值类型
    private String className;
}
