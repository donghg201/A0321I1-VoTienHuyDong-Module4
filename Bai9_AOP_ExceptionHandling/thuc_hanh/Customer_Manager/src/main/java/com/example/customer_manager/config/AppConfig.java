//package com.example.customer_manager.config;
//
//import com.example.customer_manager.aspect.Logger;
//import com.example.customer_manager.formatter.ProvinceFormatter;
//import com.example.customer_manager.service.ProvinceService;
//import org.springframework.beans.BeansException;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.EnableAspectJAutoProxy;
//import org.springframework.format.Formatter;
//import org.springframework.format.FormatterRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//@Configuration
//@EnableAspectJAutoProxy
//public class AppConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {
//
//    private ApplicationContext appContext;
//
//    @Bean
//    public Logger logger() {
//        return new Logger();
//    }
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        appContext = applicationContext;
//    }
//
//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        ProvinceService provinceService = appContext.getBean(ProvinceService.class);
//        Formatter provinceFormatter = new ProvinceFormatter(provinceService);
//        registry.addFormatter(provinceFormatter);
//    }
//}
