package com.microservice.springmicroservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringMicroserviceApplication {
	
	@Value("${server.port}")
	String serverPort;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMicroserviceApplication.class, args);
	}
	@GetMapping("/getServerInfo")
	public String getServerInfo() {
		return "The server is up and running on port :"+ serverPort;
	}

}
