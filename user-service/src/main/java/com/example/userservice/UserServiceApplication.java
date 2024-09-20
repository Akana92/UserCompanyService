package com.example.userservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	// Вывод всех зарегистрированных маршрутов в консоль при запуске
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			RequestMappingHandlerMapping requestMappingHandlerMapping = ctx.getBean(RequestMappingHandlerMapping.class);
			requestMappingHandlerMapping.getHandlerMethods().forEach((key, value) -> {
				System.out.println(key + " : " + value);
			});
		};
	}

}
