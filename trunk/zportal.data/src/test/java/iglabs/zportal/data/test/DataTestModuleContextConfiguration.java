package iglabs.zportal.data.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import org.hibernate.SessionFactory;

import iglabs.zportal.data.DefaultDomainService;
import iglabs.zportal.data.DomainService;
import iglabs.zportal.data.EntityRegistry;
import iglabs.zportal.data.hibernate.HibernateRepository;
import iglabs.zportal.data.Repository;

import iglabs.zportal.data.test.entity.User;
import iglabs.zportal.data.test.service.UserService;


@Configuration
@EnableTransactionManagement
public class DataTestModuleContextConfiguration {

    private static class UserRepository extends HibernateRepository<User> {
        @Override
        protected Class<User> getEntityType() {
            return User.class;
        }
    }
    
    private static class UserDomainService extends DefaultDomainService<User> {
        @Override
        protected Class<User> getEntityType() {
            return User.class;
        }
    }
    
    
    @Bean
    @Lazy
    @Autowired
    public Repository<User> userRepository(SessionFactory sessionFactory) {
        UserRepository repository = new UserRepository();
        repository.setSessionFactory(sessionFactory);
        
        return repository;
    }
    
    @Bean
    @Lazy
    public DomainService<User> businessRuleService() {
        return new UserDomainService();
    }
    
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
