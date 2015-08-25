package iglabs.zportal.data;

import java.util.ArrayList;
import java.util.Properties;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import iglabs.zportal.util.Sequences;


@Configuration
@EnableTransactionManagement
public class ModuleContextConfiguration {
    
    @Autowired
    private iglabs.zportal.configuration.Configuration configuration;
    
    
    @Bean
    @Lazy
    @Autowired
    public Repository repository(SessionFactory sessionFactory) {
        HibernateRepository repository = new HibernateRepository();
        repository.setSessionFactory(sessionFactory);
        
        return repository;
    }
    
    @Bean
    @Lazy
    @Autowired
    public LocalSessionFactoryBean sessionFactory(EntityRegistry[] entityRegistries) {
        
        ArrayList<Class> annotatedClasses = new ArrayList<Class>();
        for (EntityRegistry entityRegistry: entityRegistries) {
            Sequences.addAll(annotatedClasses, entityRegistry.getEntityTypes());
        }
        
        LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
        sf.setDataSource(dataSource());
        sf.setAnnotatedClasses(Sequences.toArray(Class.class, annotatedClasses));
        sf.setHibernateProperties(getHibernateProperties());
        
        return sf;
    }
    
    @Bean
    @Autowired
    public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);
        txManager.setNestedTransactionAllowed(true);
 
        return txManager;
    }
    
    @Bean
    @Lazy
    public DataSource dataSource() {
        
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(configuration.getValue(ConfigurationKeys.JDBC_DRIVER_KEY));
        dataSource.setUrl(configuration.getValue(ConfigurationKeys.JDBC_URL_KEY));
        dataSource.setUsername(configuration.getValue(ConfigurationKeys.JDBC_USERNAME_KEY));
        dataSource.setPassword(configuration.getValue(ConfigurationKeys.JDBC_PASSWORD_KEY));
 
        return dataSource;
    }
    
    Properties getHibernateProperties() {
        
        Properties result = new Properties();
        
        String dialect = getHibernateDialect(
            configuration.getValue(ConfigurationKeys.JDBC_DBTYPE_KEY));
        result.setProperty("hibernate.dialect", dialect);
        result.setProperty("hibernate.show_sql", "true");
        result.setProperty("hibernate.hbm2ddl.auto", "create");
        
        return result;
    }
    
    String getHibernateDialect(String dbType) {
        if (dbType != null) {
            String dbTypeLower = dbType.toLowerCase();
            
            switch (dbTypeLower) {
                case "mysql":
                    return "org.hibernate.dialect.MySQLDialect";
            }
        }
        
        throw new RuntimeException("Unknown dbType");
    }
}
