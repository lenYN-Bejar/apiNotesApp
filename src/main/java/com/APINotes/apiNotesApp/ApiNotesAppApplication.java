package com.APINotes.apiNotesApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.Collections;

@SpringBootApplication
public class ApiNotesAppApplication {

	public static void main(String[] args) {
//		SpringApplication.run(ApiNotesAppApplication.class, args);
		SpringApplication app = new SpringApplication(ApiNotesAppApplication.class);
		String port = System.getenv("PORT");
		app.setDefaultProperties(Collections.singletonMap("server.port", port == null ? "8080" : port));
		app.run(args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.
						addMapping("/**").
						allowedOrigins("http://localhost:5173").
						allowedMethods("*").
						allowedHeaders("*");
			}
		};
	}

}
