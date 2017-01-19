package com.aido.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@SpringBootApplication
@ImportResource({"classpath:spring-dubbo.xml"})
@EnableTransactionManagement
public class Application implements EmbeddedServletContainerCustomizer  {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@Override  
	public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {  
	    configurableEmbeddedServletContainer.setPort(8090);  
	    configurableEmbeddedServletContainer.setContextPath("/juhe_manager_web");
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