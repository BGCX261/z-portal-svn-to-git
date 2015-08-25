package iglabs.zportal.web;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import iglabs.zportal.DefaultAppContextConfiguration;
import iglabs.zportal.web.configuration.WebAppConfiguration;


@Configuration
public class DefaultWebAppContextConfiguration
    extends DefaultAppContextConfiguration {

    @Autowired
    private ServletContext servletContext;
    
    
    @Bean
    @Override
    public iglabs.zportal.configuration.Configuration configuration() {
        
        WebAppConfiguration configuration =
            new WebAppConfiguration(servletContext);
        
        return configuration;
    }    
}
