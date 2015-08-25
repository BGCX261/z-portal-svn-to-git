package iglabs.zportal.data.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import iglabs.zportal.data.EntityRegistry;
import iglabs.zportal.data.test.entity.User;
import iglabs.zportal.data.test.service.UserService;


@Configuration
@EnableTransactionManagement
public class DataTestModuleContextConfiguration {

    @Bean(name = "dataTestEntityRegistry")
    public EntityRegistry entityRegistry() {
        return new EntityRegistry() {
            @Override
            public Class[] getEntityTypes() {
                return new Class[] { User.class };
            }
        };
    }
    
    @Bean
    public UserService userService() {
        return new UserService();
    }
}
