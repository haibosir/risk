/*
package com.cpiaoju.db;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

*/
/**
 * @ClassName DruidConfig
 * @Description //DruidConfig配置类
 **//*

@Configuration
public class DruidConfig {

    */
/**
     * master数据源
     * *//*

    @Bean(name="masterDataSource")
    @ConfigurationProperties("spring.datasource.druid.first")
    public DataSource masterDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    */
/**
     * slave数据源
     * *//*

    @Bean(name = "slaveDataSource")
    @ConfigurationProperties("spring.datasource.druid.second")
    public DataSource slaveDataSource()
    {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "dynamicDataSource")
    @Primary
    public DynamicDataSource dataSource() {

        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        // 设置默认数据源为first数据源
        dynamicDataSource.setDefaultTargetDataSource(masterDataSource());
        // 配置多数据源,
        // 添加数据源标识和DataSource引用到目标源映射
        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put(DataSourceNames.FIRST, masterDataSource());
        dataSourceMap.put(DataSourceNames.SECOND, slaveDataSource());
        dynamicDataSource.setTargetDataSources(dataSourceMap);
        return dynamicDataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

}*/
