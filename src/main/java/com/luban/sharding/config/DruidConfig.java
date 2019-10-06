package com.luban.sharding.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.luban.sharding.factorybean.DbFactoryBean;
import com.luban.sharding.utils.DbUtil;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

//@Import(DbConfig.class)
@Configuration
@MapperScan("com.luban.sharding.mapper")
public class DruidConfig {

    @ConfigurationProperties(prefix = "master.datasource")
    @Bean
    public DataSource masterDataSource(){
        return  new DruidDataSource();
    }


    @Bean
    public PlatformTransactionManager txManager(DynamicDataSource dynamicDataSource) {
        return new DataSourceTransactionManager(dynamicDataSource);
    }


    @ConfigurationProperties(prefix = "slave.datasource")
    @Bean
    public DataSource slaveDataSource(){
        return  new DruidDataSource();
    }


    @Bean
    public DynamicDataSource dynamicDataSource(){
        DynamicDataSource dynamicDataSource=new DynamicDataSource();
        Map<Object,Object> map=new HashMap<>();
        map.put(DbUtil.master,masterDataSource());
        map.put(DbUtil.slave,slaveDataSource());
        dynamicDataSource.setDefaultTargetDataSource(masterDataSource());
        dynamicDataSource.setTargetDataSources(map);
        return dynamicDataSource;
    }




    @Bean
   public SqlSessionFactoryBean sqlSessionFactoryBean(DynamicDataSource dynamicDataSource){
       SqlSessionFactoryBean sqlSessionFactory=new SqlSessionFactoryBean();
       sqlSessionFactory.setDataSource(dynamicDataSource);
       return sqlSessionFactory;
   }

   @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception {
       SqlSessionTemplate sqlSessionTemplate=new SqlSessionTemplate(sqlSessionFactoryBean.getObject());
       return sqlSessionTemplate;
   }
}
