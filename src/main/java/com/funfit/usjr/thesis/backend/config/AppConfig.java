package com.funfit.usjr.thesis.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "com.funfit.usjr.thesis.backend")
public class AppConfig extends WebMvcConfigurerAdapter{

	    @Override
	    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	        configurer.enable();
	    }

	    @Bean
	    public InternalResourceViewResolver getInternalResourceViewResolver() {
	        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	        resolver.setPrefix("/WEB-INF/pages/");
	        resolver.setSuffix(".jsp");
	        return resolver;
	    }

		 @Override
		    public void addResourceHandlers(ResourceHandlerRegistry registry) {
			 	registry.addResourceHandler("/main/webapp/js/**").addResourceLocations("/main/webapp/js/*");
		        registry.addResourceHandler("/main/webapp/css/**").addResourceLocations("/main/webapp/css/*");
		        registry.addResourceHandler("/main/webapp/images/**").addResourceLocations("/main/webapp/images/*");
		        registry.addResourceHandler("/main/webapp/fonts/**").addResourceLocations("/main/webapp/fonts/*");
		 }

}