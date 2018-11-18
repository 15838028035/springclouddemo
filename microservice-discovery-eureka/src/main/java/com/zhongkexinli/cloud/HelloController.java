package com.zhongkexinli.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@RequestMapping("/hello")
	public String hello(){
		ServiceInstance serviceInstance = discoveryClient.getInstances("eureka-server").get(0);
		String infoMsg = String.format("/hello host:{0} ,serviceId:{1} ,port:{2}",serviceInstance.getHost(),serviceInstance.getServiceId(),serviceInstance.getPort());
		logger.info(infoMsg);
		return infoMsg;
	}
}
