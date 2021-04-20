package com.cube.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 
 * 
 * @author phoenix
 * @date 2021年4月20日
 */
@FeignClient(name = "provider-test")
public interface TestFeign {

	/**
	 * 
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param string
	 * @return
	 */
	@GetMapping(value = "/provider/{string}")
	public String provider(@PathVariable String string);
	
}
