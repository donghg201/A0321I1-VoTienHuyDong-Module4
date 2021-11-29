package com.example.customer_manager.config;

import com.example.customer_manager.formatter.ProvinceFormatter;
import com.example.customer_manager.model.Province;
import com.example.customer_manager.service.CustomerService;
import com.example.customer_manager.service.CustomerServiceImpl;
import com.example.customer_manager.service.ProvinceService;
import com.example.customer_manager.service.ProvinceServiceImpl;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@EnableJpaRepositories("com.example.customer_manager.repository")
@ComponentScan("com.example.customer_manager")
public class ApplicationConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter((Formatter<Province>) new ProvinceFormatter(applicationContext.getBean(ProvinceService.class)));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Bean
    public CustomerService customerService() {
        return new CustomerServiceImpl();
    }

    @Bean
    public ProvinceService provinceService() {
        return new ProvinceServiceImpl();
    }
}
