package com.ssocial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class CubeSummationApplication extends SpringBootServletInitializer {

	private static final Class<CubeSummationApplication> application = CubeSummationApplication.class;

	public static void main(String[] args) {
		SpringApplication.run(CubeSummationApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
		return applicationBuilder.sources(application);
	}
}
