package com.spring.api.controller;

import com.spring.core.CoreApplication;
import com.spring.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class SampleController {

	@RequestMapping("/hello")
	@ResponseBody String hello() {
		return "Hello World!";
	}

	public static void main(String[] args) throws Exception {
		new SpringApplicationBuilder()
				.sources(CoreApplication.class)
				.child(SampleController.class)
				.run(args);
	}
}