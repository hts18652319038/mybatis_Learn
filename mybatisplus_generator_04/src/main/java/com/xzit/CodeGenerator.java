package com.xzit;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class CodeGenerator {
    public static void main(String[] args) {
        // 1. 初始化生成器
        AutoGenerator autoGenerator = new AutoGenerator();

        // 2. 数据源配置
        DataSourceConfig dataSource = new DataSourceConfig();
        dataSource.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mybatis?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8");
        dataSource.setUsername("root");
        dataSource.setPassword("88888888");
        autoGenerator.setDataSource(dataSource);

        // 3. 全局配置（用绝对路径，彻底解决环境不一致问题）
        GlobalConfig globalConfig = new GlobalConfig();
        String absolutePath = "D:/Program Files/java_workspace/mybatisplus_generator_04/src/main/java";
        globalConfig.setOutputDir(absolutePath);
        globalConfig.setOpen(false);
        globalConfig.setAuthor("Tongshun Huang");
        globalConfig.setFileOverride(true);
        globalConfig.setMapperName("%sDao"); // Mapper接口名：UserDao
        globalConfig.setIdType(IdType.AUTO);
        autoGenerator.setGlobalConfig(globalConfig);

        // 4. 设置包相关配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.xzit");
        pc.setEntity("domain");   // 实体类：com.xzit.domain.User
        pc.setMapper("dao");       // Mapper：com.xzit.dao.UserDao
        autoGenerator.setPackageInfo(pc);

        // 5. 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("user");
        strategy.setRestControllerStyle(true);
        strategy.setEntityLombokModel(true); // 开启Lombok（你的pom已引入）
        strategy.setVersionFieldName("version"); // 乐观锁字段（你的表有version）
        strategy.setLogicDeleteFieldName("deleted"); // 逻辑删除字段（你的表有deleted）
        autoGenerator.setStrategy(strategy);

        // 6. 执行生成（启动开关！）
        autoGenerator.execute();
    }
}
