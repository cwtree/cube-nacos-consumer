package com.cube;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * 
 * @author phoenix
 * @date 2021年2月10日
 * @EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
 */
@SpringBootApplication
@Slf4j
@EnableDiscoveryClient
@EnableFeignClients
public class CubeBootApplication {
	
	@LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

	public static void main(String[] args) {
		SpringApplication.run(CubeBootApplication.class, args);
		if (log.isInfoEnabled()) {
			log.info("\n----------------------------------------------------------\n\t"
					+ "Application is running! Access URLs:\n\t"
					+ "swagger-ui: \thttp://ip:port/${context-path}/swagger/index.html\n\t"
					+ "----------------------------------------------------------");
		}
	}

}
