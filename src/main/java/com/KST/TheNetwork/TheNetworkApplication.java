package com.KST.TheNetwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class TheNetworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheNetworkApplication.class, args);
	}

}
