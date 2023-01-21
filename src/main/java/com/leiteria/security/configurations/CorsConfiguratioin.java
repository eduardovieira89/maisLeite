package com.leiteria.security.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfiguratioin implements WebMvcConfigurer{

	@Override
    public void addCorsMappings(CorsRegistry registry) {
        /**
		registry.addMapping("/**")
        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");;
        **/
		//Esta classe não está funcionando
		
        registry.addMapping("/usuario/**")
		.allowedOrigins("http://localhost:4200")
		.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT")
		.allowedHeaders("*")
		.exposedHeaders("*")
		.allowCredentials(true);
            
    }
}
