package com.dbs.order.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.dbs.order.item.exception.bean.ErrorDetails;

@SpringBootApplication
@EnableEurekaClient
public class OrderItemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderItemServiceApplication.class, args);
	}

	@Bean
	public ErrorDetails errorDetails() {
		return new ErrorDetails();
	}
}
