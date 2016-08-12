package com.ai.bss.webui.configuration;

import javax.servlet.Filter;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;

@Configuration
@EnableWebMvc
public class MVCConfigure extends WebMvcConfigurerAdapter{
	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
	
	 @Override
	 public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/home").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login").setViewName("login");
    }
	
	@Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
	
	@Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames( "classpath:messages/fields", "classpath:messages/validation" );
        // if true, the key of the message will be displayed if the key is not
        // found, instead of throwing a NoSuchMessageException
        messageSource.setUseCodeAsDefaultMessage( true );
        messageSource.setDefaultEncoding( "UTF-8" );
        // # -1 : never reload, 0 always reload
        messageSource.setCacheSeconds( 0 );
        return messageSource;
    }
	
	@Bean
	public LocalValidatorFactoryBean validator(){
		LocalValidatorFactoryBean validatorFactoryBean=new LocalValidatorFactoryBean();
		validatorFactoryBean.setValidationMessageSource(messageSource());
		return validatorFactoryBean;
	}
	
	@Bean
	public FilterRegistrationBean siteMeshFilterRegistration() {
	    FilterRegistrationBean filter = new FilterRegistrationBean();
	    filter.setFilter(siteMeshFilter());
	    filter.addUrlPatterns("/*");
	    filter.setName("siteMeshFilter");
	    return filter;
	} 
	
	@Bean
	public Filter siteMeshFilter() {
		return new SiteMeshFilter();
	}
}
