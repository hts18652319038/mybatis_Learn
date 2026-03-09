package com.xzit.util;

import lombok.AllArgsConstructor;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

@AllArgsConstructor
public class CustomSqlSession implements SqlSession {

    private DbProfile profile;
    private Connection connection;

    public CustomSqlSession(DbProfile profile) {
        this.profile = profile;
        connection = DBUtil.getConnection(profile);
    }

    @Override
    public <T> T getMapper(Class<T> mapperClass) {
        return (T)Proxy.newProxyInstance(mapperClass.getClassLoader(),
                new Class[]{mapperClass},new ProxyImpl (profile.getMappers(),connection));
    }

    @Override
    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
