package com.demo.springbootcrud.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author webwerks
 * 
 * This class contains common beans used in the application
 *
 */
@Configuration
public class AppConfig {

	/**
	 * Bean of Modelmapper
	 */
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
