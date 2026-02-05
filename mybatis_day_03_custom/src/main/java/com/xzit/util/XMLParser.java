package com.xzit.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XMLParser {
    public static DbProfile parseXML(InputStream in) throws DocumentException {
        // 最后要封装进去的一个类
        DbProfile profile = new DbProfile();
        // 使用demo4j读取xml文件，进行解析
        SAXReader reader = new SAXReader();
        Document document = reader.read(in);
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
            }
        }
        return   profile;
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
