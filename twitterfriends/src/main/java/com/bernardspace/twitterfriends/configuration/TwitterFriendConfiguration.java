package com.bernardspace.twitterfriends.configuration;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resources;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Configuration
@EnableWebMvc
@ComponentScan("com.bernardspace.twitterfriends")
@PropertySource({ "classpath:securitytokens.properties" })
public class TwitterFriendConfiguration implements WebMvcConfigurer {

	@Autowired
	private Environment env;
	
	
	@Bean
	public ViewResolver internalResourceViewResolver() {
	    InternalResourceViewResolver bean = new InternalResourceViewResolver();
	    bean.setViewClass(JstlView.class);
	    bean.setPrefix("/");
	    bean.setSuffix(".jsp");
	    return bean;
	}
	 	
	@Bean
	public twitter4j.conf.Configuration buildconfiguration() {
		
		ConfigurationBuilder confiBuilder = new ConfigurationBuilder();
		confiBuilder.setDebugEnabled(true).setOAuthConsumerKey(env.getProperty("twitter.consumerkey")).
											setOAuthConsumerSecret(env.getProperty("twitter.consumersecret")).
											setOAuthAccessToken(env.getProperty("twitter.accesstoken")).
											setOAuthAccessTokenSecret(env.getProperty("twitter.tokensecret"));
		
		return confiBuilder.build();
	}
	
	 @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry
	          .addResourceHandler("/css/**")
	          .addResourceLocations("/css/"); 
	    }
	 
	 @Bean
	 public TwitterFactory twitterFactory() {
		 
		 return new TwitterFactory(buildconfiguration());
	 }
	
	
}
