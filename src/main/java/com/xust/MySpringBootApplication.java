package com.xust;

import com.xust.utils.TenMessageAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.core.Ordered;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Timer;

/**
 * Created by lenovo on 2018/5/9.
 */
@RestController
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}/*,scanBasePackages = {"com.xust.controller"}*/)
@RequestMapping(value = "/indexs")
@ServletComponentScan(basePackages = "com.xust.dao")
public class MySpringBootApplication extends WebMvcConfigurerAdapter implements EmbeddedServletContainerCustomizer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class, args);
        new Timer().schedule(new TenMessageAPI(), 60 * 1000, 60 * 1000);
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
        configurableEmbeddedServletContainer.setPort(8081);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/zhuce.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }
}
