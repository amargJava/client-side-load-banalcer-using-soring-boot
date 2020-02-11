package com.microservice.loadbalancer.springmicroserviceloadbalancer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;

public class RibbonConfiguration {
	
	@Autowired
	IClientConfig ribbanClient;
	
	@Bean
	public IPing ping(IClientConfig ribbanClient) {
		return new PingUrl();
	}
	
	@Bean
	public IRule rule(IClientConfig ribbanClient) {
		return new AvailabilityFilteringRule();
	}
}
