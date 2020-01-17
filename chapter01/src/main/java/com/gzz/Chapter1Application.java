package com.gzz;

import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 我的第一个SpringBoot程序 其中 @RestController 等同于 （@Controller 与 @ResponseBody）
 */
@RestController
@SpringBootApplication
public class Chapter1Application {
	private static Logger log = LoggerFactory.getLogger(Chapter1Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Chapter1Application.class, args);
	}

	@GetMapping("/demo1")
	public String demo1() {
		return "Hello gzz";
	}

	@Bean
	public CommandLineRunner getBeans(ApplicationContext ctx) {
		return args -> {
			log.info("来看看 SpringBoot 默认为我们提供的 Bean：");
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			Arrays.stream(beanNames).forEach(log::info);
		};
	}
}
