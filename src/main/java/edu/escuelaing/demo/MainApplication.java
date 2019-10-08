package edu.escuelaing.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import edu.escuelaing.demo.config.*;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.escuelaing.demo"})
public class MainApplication {
    public FilterRegistrationBean jwtFilter()
	{
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter( new JwtFilter() );
		registrationBean.addUrlPatterns( "/api/*" );

		return registrationBean;
	}
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

}
