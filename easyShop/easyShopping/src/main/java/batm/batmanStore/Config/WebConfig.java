/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batm.batmanStore.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

/**
 *
 * @author USER
 */
@Configuration
public class WebConfig implements WebMvcConfigurer{
    
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/registration").setViewName("registration");
        registry.addViewController("/Home").setViewName("Home");
    }
    
    @Bean
	public SpringSecurityDialect securityDialect() {
	    return new SpringSecurityDialect();
	}
}
