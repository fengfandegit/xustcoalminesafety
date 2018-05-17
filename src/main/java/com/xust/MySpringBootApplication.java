package com.xust;

import com.xust.service.Userservice;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by lenovo on 2018/5/9.
 */
@RestController
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
/*@EnableTransactionManagement*/
/*@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})*/
@RequestMapping(value = "/indexs")
/*@Configuration*/

/*@ComponentScan(basePackages = {"com.xust.dao","com.xust.service"})*/
public class MySpringBootApplication extends WebMvcConfigurerAdapter implements EmbeddedServletContainerCustomizer {
  /* @Autowired
    Userservice userservice;

    @RequestMapping(value = "/login")
    public String login(@RequestParam("phonenum")String phonenum,@RequestParam("password")String password) {
        if (userservice.checkLogin(phonenum,password)){
            return "index";
        }else {
            return "login";
        }
    }*/

    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class, args);
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
        configurableEmbeddedServletContainer.setPort(8081);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }



}
