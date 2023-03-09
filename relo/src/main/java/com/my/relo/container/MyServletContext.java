package com.my.relo.container;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@ComponentScan(basePackages = {"com.my.customer.control",
//		"com.my.product.control",
//		"com.my.cart.control",
//		"com.my.order.control",
//		"com.my.board.control",
//		"com.my.advice"
//		})
//Adding this annotation to an 
//@Configuration class 
//imports the Spring MVCconfiguration 
//from WebMvcConfigurationSupport
@EnableWebMvc  //WebApplicationContext컨테이너용 설정클래스이다
public class MyServletContext 
        implements WebMvcConfigurer{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		    .allowedOrigins("http://192.168.0.42:5500")
//		    .allowedOrigins("http://192.168.123.108:5500")
		    .allowCredentials(true)
		    .allowedMethods("GET", "POST", "PUT", "DELETE");
	}

	@Bean 
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver cmr = new CommonsMultipartResolver();
		cmr.setDefaultEncoding("UTF-8");
		cmr.setMaxUploadSize(1000 * 1024);
		cmr.setMaxUploadSizePerFile(1000*1024);
		return cmr;
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
}