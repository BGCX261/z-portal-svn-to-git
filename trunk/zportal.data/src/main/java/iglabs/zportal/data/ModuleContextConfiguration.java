package iglabs.zportal.data;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration(value = "dataModuleContextConfiguration")
public class ModuleContextConfiguration { 
    
    @Bean
    public DomainRuleRegistry businessRuleRegistry() {
        return new DefaultBusinessRuleRegistry();
    }
}
