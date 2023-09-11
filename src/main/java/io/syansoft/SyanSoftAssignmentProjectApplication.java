package io.syansoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SyanSoftAssignmentProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SyanSoftAssignmentProjectApplication.class, args);
	}

	@Configuration
	public class WebMvcConfig implements WebMvcConfigurer {
		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
			registry.addResourceHandler("swagger-ui.html")
					.addResourceLocations("classpath:/META-INF/resources/");
			registry.addResourceHandler("/webjars/**")
					.addResourceLocations("classpath:/META-INF/resources/webjars/");
		}
	}
}
