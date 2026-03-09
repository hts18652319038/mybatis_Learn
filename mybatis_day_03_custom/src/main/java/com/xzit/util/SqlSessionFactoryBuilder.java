package com.xzit.util;

import org.dom4j.DocumentException;

import java.io.InputStream;

public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(InputStream inputStream){
        DbProfile profile = XMLParser.parseXML(inputStream);
        return new CustomSqlSessionFactory(profile);
    }
}
