package io.krunal.springRest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan
@EnableWebMvc  
public class Webconfig extends WebMvcConfigurerAdapter {
	public void addresourcehandlers(ResourceHandlerRegistry regirsty)
	{
		regirsty.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		regirsty.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	
	
	

}
