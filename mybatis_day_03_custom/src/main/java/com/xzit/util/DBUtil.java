package com.xzit.util;

import lombok.extern.slf4j.Slf4j;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j(topic = "c.DBUtil")
public class DBUtil {
    public static Connection getConnection(DbProfile profile){
        try {
            Class.forName(profile.getDriver());
            log.debug("load jdbc driver");
            return DriverManager.getConnection(profile.getUrl(), profile.getUsername(), profile.getPassword());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public <E> List<E> selectList(Mapper mapper,Connection connection){
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = mapper.getSqlStatement();
        String className =  mapper.getClassName();
        try {
            Class clazz = Class.forName(className);
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            log.debug("execute query sql ==> "+sql);
            List<E> list = new ArrayList<>();
            while (rs.next()) {
                E obj = (E)clazz.getConstructor().newInstance(null);
                // 结果集元数据
                ResultSetMetaData meta = rs.getMetaData();
                // 获取一共有多少字段
                int columnCount = meta.getColumnCount();
                for ( int i = 1; i <= columnCount; i++ ) {
                    String columnName = meta.getColumnName(i);
                    Object columnValue = rs.getObject(i);
                    PropertyDescriptor descriptor = new PropertyDescriptor(columnName, clazz);
                    Method method = descriptor.getWriteMethod();
                    method.invoke(obj, columnValue);
                }
                list.add(obj);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void close(ResultSet result, Statement statement){
        if (result != null) {
            try {
                result.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if (statement!=null){
            try {
                statement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
