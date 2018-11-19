package com.lj.cloud.weixin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RestController;

/**
 * 使用@EnableFeignClients开启Feign
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@RestController
public class MicroServiceFrontAppApplication {
  public static void main(String[] args) {
    SpringApplication.run(MicroServiceFrontAppApplication.class, args);
  }
	
}
