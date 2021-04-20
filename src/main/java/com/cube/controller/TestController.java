package com.cube.controller;

import javax.annotation.Resource;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cube.dubbo.MyService;
import com.cube.rpc.TestFeign;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * 
 * @author phoenix
 * @date 2021年4月19日
 */
@RestController
@Slf4j
public class TestController {

	@Resource
	private RestTemplate restTemplate;

	@Resource
	private TestFeign testFeign;
	
	@DubboReference()
	private MyService myService;

	/**
	 * 
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param string
	 * @return
	 */
	@GetMapping(value = "/consumer/{string}")
	public String consumer(@PathVariable String string) {
		log.info("nacos consumer restTemplate test controller ...");
		return restTemplate.getForObject("http://provider-test/cube/provider/" + string, String.class);
	}

	@GetMapping(value = "/feign/{string}")
	public String feign(@PathVariable String string) {
		log.info("nacos consumer feign test controller ...");
		return testFeign.provider("abc");
	}
	
	@GetMapping(value = "/dubbo/{string}")
	public String dubbo(@PathVariable String string) {
		log.info("nacos consumer dubbo test controller ...");
		return myService.dubbo(string);
	}

}
