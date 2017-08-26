package com.spring.core;

import com.spring.core.config.RepositoryConfiguration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

@Configuration
@EnableAutoConfiguration(exclude = { AopAutoConfiguration.class })
@ComponentScan("com.spring")
@EnableLoadTimeWeaving
@EnableSpringConfigured
@Import(RepositoryConfiguration.class)
public class CoreApplication implements CommandLineRunner {

	@Override
	public void run(String... args) {
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CoreApplication.class, args);
	}
}
