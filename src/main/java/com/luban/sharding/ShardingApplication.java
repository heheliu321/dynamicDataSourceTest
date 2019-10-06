package com.luban.sharding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(proxyTargetClass = true)
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ShardingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShardingApplication.class, args);
	}

}
