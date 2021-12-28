package com.configservice.common;

import com.configservice.common.model.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.sql.Timestamp;
import java.time.Instant;

@SpringBootApplication
public class CommonConfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommonConfigServiceApplication.class, args);
	}

	@Bean
	@Profile("local")
	public static Resource createLocalResource() {
		return new Resource("localResource", Timestamp.from(Instant.now()), "1");
	}

	@Bean
	@Profile("dev")
	public static Resource createDevResource() {
		return new Resource("devResource", Timestamp.from(Instant.now()), "1");
	}

}
