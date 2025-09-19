package jp.co.sss.crud.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class configFilter implements WebMvcConfigurer {
	@Bean
	public FilterRegistrationBean<LoginCheckFilter> ConfigLoginCheckFilter(){
		FilterRegistrationBean<LoginCheckFilter> bean = new FilterRegistrationBean<LoginCheckFilter>();

		bean.setFilter(new LoginCheckFilter());
		bean.setOrder(1);
		return bean;
	}
	
	@Bean
	public FilterRegistrationBean<AccountCheckFilter> ConfigAccountCheckFilter(){
		FilterRegistrationBean<AccountCheckFilter> bean = new FilterRegistrationBean<AccountCheckFilter>();

		bean.setFilter(new AccountCheckFilter());
		bean.setOrder(2);
		return bean;
	}
	

}
