package com.example.themleaf_product_management.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

@Configuration
@EnableWebMvc
@ComponentScan("com.example.themleaf_product_management")
public class AppConfiguration extends WebMvcConfigurerAdapter implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
    // View jsp
//    @Bean
//    public ViewResolver internalResourceViewResolver() {
//        InternalResourceViewResolver bean = new InternalResourceViewResolver();
//        bean.setPrefix("/WEB-INF/view/");
//        bean.setSuffix(".jsp");
//        return bean;
//    }
    // View Thymeleaf
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/view/product");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }

    @Bean
    public TemplateEngine templateEngine() {
        TemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine((ISpringTemplateEngine) templateEngine());
        viewResolver.setCharacterEncoding("UTF-8");
        return viewResolver;
    }


    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("message");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
//    @Bean
//    public StudentRepository getStudentRepository() {
//        return new StudentRepositoryImpl();
//    }
//
//    @Bean
//    public StudentService getStudentService() {
//        StudentServiceImpl service = new StudentServiceImpl();
//        service.setStudentRepository(this.applicationContext.getBean(StudentRepository.class));
//        return service;
//    }
}
