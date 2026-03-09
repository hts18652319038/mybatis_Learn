package com.xzit.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XMLParser {
    public static DbProfile parseXML(InputStream in){
        // 最后要封装进去的一个类
        DbProfile profile = new DbProfile();
        // 使用demo4j读取xml文件，进行解析
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read(in);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
        Element root = document.getRootElement();
        List<Node> properties = root.selectNodes("//property");
        for (Node element : properties) {
            if ("driver".equals(element.getParent().attributeValue("name"))) {
                profile.setDriver(element.getParent().attributeValue("value"));
            }
            if ("url".equals(element.getParent().attributeValue("name"))) {
                profile.setUrl(element.getParent().attributeValue("value"));
            }
            if ("username".equals(element.getParent().attributeValue("name"))) {
                profile.setUsername(element.getParent().attributeValue("value"));
            }
            if ("password".equals(element.getParent().attributeValue("name"))) {
                profile.setPassword(element.getParent().attributeValue("value"));
            }
        }
        // 读取mappers资源
        List<Node> mapperList = root.selectNodes("//mappers/mapper");
        for (Node element : mapperList) {
            String path = element.getParent().attributeValue("resource");
            if (path != null) {
                Map<String,Mapper> mappers = new HashMap<>();
                profile.setMappers(mappers);
            }else{
                String daoPath = element.getParent().attributeValue("class");
                Map<String,Mapper> mappers = null;
                try {
                    mappers = getMapperAnnotations(daoPath);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                profile.setMappers(mappers);
            }
        }
        return profile;
    }

    private static Map<String,Mapper> getMapperAnnotations(String daoPath) throws ClassNotFoundException {
        Map<String,Mapper> mappers = new HashMap<>();
        Class<?> clazz = Class.forName(daoPath);
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            boolean b = method.isAnnotationPresent(Select.class);
            if (b) {
                Mapper mapper = new Mapper();
                Select select = method.getAnnotation(Select.class);
                String sql = select.value();
                mapper.setSqlStatement(sql);
                // 方法返回一个Type对象，对象表示当前method返回类型
                Type type = method.getGenericReturnType();
                if (type instanceof ParameterizedType){
                    ParameterizedType parameterizedType = (ParameterizedType) type;
                    //获取运行时的泛型类型
                    Type[] types = parameterizedType.getActualTypeArguments();
                    Class pojoClass = (Class) types[0];
                    String className = pojoClass.getName();
                    mapper.setClassName(className);
                }
                String methodName = method.getName();
                String className = method.getDeclaringClass().getName();
                String key = className + "." + methodName;
                mappers.put(key,mapper);
            }
        }
        return mappers;
    }

    private static Map<String,Mapper> getMapper(String path) throws DocumentException {
        Map<String , Mapper> mappers = new HashMap<>();
        SAXReader reader = new SAXReader();
        Document document = reader.read(Resources.getResourceAsStream(path));
        Element root = document.getRootElement();
        String nameSpace = root.attributeValue("namespace");
        List<Node> selectList = root.selectNodes("//select");
        for (Node element : selectList) {
            String id = element.getParent().attributeValue("id");
            String resultType = element.getParent().attributeValue("resultType");
            String sql = element.getText();
            Mapper mapper = new Mapper();
            mapper.setClassName(resultType).setSqlStatement(sql);
            String key = nameSpace + "." + id;
            mappers.put(key, mapper);
        }
        return mappers;
    }
}
