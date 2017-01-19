package com.aido.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
@SpringBootApplication
@ImportResource({"classpath:spring-dubbo.xml"})
public class Application implements EmbeddedServletContainerCustomizer  {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@Override  
	public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {  
	    configurableEmbeddedServletContainer.setPort(8090);  
	}  
   @Bean
   public FilterRegistrationBean registerOpenEntityManagerInViewFilterBean() {
       FilterRegistrationBean registrationBean = new FilterRegistrationBean();
       OpenEntityManagerInViewFilter filter = new OpenEntityManagerInViewFilter();
       registrationBean.setFilter(filter);
       registrationBean.setOrder(5);
       return registrationBean;
   }
}