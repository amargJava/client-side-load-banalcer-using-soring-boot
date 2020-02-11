package com.microservice.loadbalancer.springmicroserviceloadbalancer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RibbonClient(name = "testMicro", configuration = RibbonConfiguration.class)
public class SpringMicroserviceLoadBalancerApplication {

	@Autowired
	public RestTemplate template;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMicroserviceLoadBalancerApplication.class, args);
	}
	@GetMapping("/getLoadDetails")
	public String getLoadDetails() {
		String url="http://testMicro/getServerInfo";
		String response =this.template.getForObject(url, String.class);
		return response;
		
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate template() {
		return new RestTemplate();
	}

}
