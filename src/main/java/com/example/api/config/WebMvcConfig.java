package com.example.api.config;

import com.example.api.common.interceptor.LoggerInterceptor;
import com.example.api.common.util.HTMLCharacterEscapes;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	private final long MAX_AGE_SECS = 3600;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoggerInterceptor());
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	@Override
	public void addCorsMappings(CorsRegistry registry){
		registry.addMapping("/**")
				.allowedOrigins("http://localhost:3000")
				.allowedMethods("GET","POST", "PUT", "PATCH", "DELETE", "OPTIONS")
				.allowedHeaders("*")
				.allowCredentials(true)
				.maxAge(MAX_AGE_SECS);
	}

	@Bean
	public MappingJackson2HttpMessageConverter jsonEscapeConverter() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.getFactory().setCharacterEscapes(new HTMLCharacterEscapes());
		return new MappingJackson2HttpMessageConverter(objectMapper);
	}
}
