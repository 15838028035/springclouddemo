package com.zhongkexinli.cloud.secrity.constant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhongkexinli.cloud.secrity.service.KafkaSender;


@RestController
public class HelloController {
	
	@Autowired
    private KafkaSender kafkaSender;
	
	@RequestMapping(value="/sendMessage")  
	public void  sendMessage(String key) throws Exception{  
		kafkaSender.sendMessage("hello  ");
	} 
}
