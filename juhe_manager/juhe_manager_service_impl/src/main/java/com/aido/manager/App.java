package com.aido.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.concurrent.CountDownLatch;

/**
 * ClassName: App  
 * dubbo接口发布
 * @author DOUBLE
 * @version
 */
@SpringBootApplication
@ImportResource({"classpath:spring-dubbo.xml"})
@EnableTransactionManagement
public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);
    @Bean
    public CountDownLatch closeLatch() {
        return new CountDownLatch(1);
    }
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ctx = new SpringApplicationBuilder().sources(App.class).web(false).run(args);
        logger.info("项目启动!");
        CountDownLatch closeLatch = ctx.getBean(CountDownLatch.class);
        closeLatch.await();
    }
    @Bean
    public Object testBean(PlatformTransactionManager platformTransactionManager){
        System.out.println(">>>>>>>>>>" + platformTransactionManager.getClass().getName());
        return new Object();
    }
}
