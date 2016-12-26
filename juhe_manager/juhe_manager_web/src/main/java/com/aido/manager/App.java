/*package com.aido.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aido.manager.service.HistoryTodayService;

*//**
 * ClassName: App  
 * (TODO:简述该类作用)
 * @author DOUBLE
 * @version
 *//*
@SpringBootApplication
@ImportResource("classpath:spring-dubbo.xml")
public class App {

	public static void main(String[] args){
    	SpringApplication.run(App.class, args);
       ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"classpath:spring-dubbo.xml"});
        HistoryTodayService historyTodayService = (HistoryTodayService) ctx.getBean("historyTodayService");
        try {
			System.out.println(historyTodayService.getHistoryTodayEventList("http://api.juheapi.com/japi/toh", "5441f38932f99138892ff6dd4b76eb5d", "1.0", "12", "26"));
		} catch (Exception e) {
			e.printStackTrace();
		}
    	while(true);
    }
}
*/