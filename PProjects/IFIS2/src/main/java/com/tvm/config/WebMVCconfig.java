package com.tvm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc //<mvc:annotation-driven/>
@ComponentScan(basePackages={"com.tvm.controller"})
public class WebMVCconfig extends WebMvcConfigurerAdapter {


@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver vr=new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/");
		vr.setSuffix(".jsp");
return vr;
	}

@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
	// TODO Auto-generated method stub
	 registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
}

}
