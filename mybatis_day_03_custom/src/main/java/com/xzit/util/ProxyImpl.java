package com.xzit.util;

import lombok.AllArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

@AllArgsConstructor
public class ProxyImpl implements InvocationHandler {
    private Map<String,Mapper> mappers;
    private Connection connection;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        String className = method.getDeclaringClass().getName();
        String key = className+"."+methodName;
        Mapper mapper = mappers.get(key);
        if (mapper == null) {
            throw new RuntimeException("StatementId is not registry");
        }
        return new DBUtil().selectList(mapper,connection);
    }
}
