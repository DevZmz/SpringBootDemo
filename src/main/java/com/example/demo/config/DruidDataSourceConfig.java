package com.example.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Druid的DataResource配置类
 * Created by zhangmz on 2017/6/15.
 */
@Configuration
@EnableTransactionManagement
public class DruidDataSourceConfig implements EnvironmentAware {
    private RelaxedPropertyResolver relaxedPropertyResolver;

    @Override
    public void setEnvironment(Environment environment) {
        this.relaxedPropertyResolver = new RelaxedPropertyResolver(environment, "spring.datasource.");
    }

    @Bean
    public DataSource dataSource(){
        System.out.println("注入druid!!!");
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(relaxedPropertyResolver.getProperty("url"));
        datasource.setDriverClassName(relaxedPropertyResolver.getProperty("driver-class-name"));
        datasource.setUsername(relaxedPropertyResolver.getProperty("username"));
        datasource.setPassword(relaxedPropertyResolver.getProperty("password"));
        datasource.setInitialSize(Integer.valueOf(relaxedPropertyResolver.getProperty("druid.initial-size")));
        datasource.setMinIdle(Integer.valueOf(relaxedPropertyResolver.getProperty("druid.min-idle")));
        datasource.setMaxWait(Long.valueOf(relaxedPropertyResolver.getProperty("druid.max-wait")));
        datasource.setMaxActive(Integer.valueOf(relaxedPropertyResolver.getProperty("druid.max-active")));
        datasource.setMinEvictableIdleTimeMillis(Long.valueOf(relaxedPropertyResolver.getProperty("druid.min-evictable-idle-time-millis")));
        try {
            datasource.setFilters("stat,wall");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datasource;
    }

}
