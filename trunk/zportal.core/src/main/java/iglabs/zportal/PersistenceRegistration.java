// TODO: move to separate module.
/*
package iglabs.zportal;

import java.util.Properties;

import iglabs.zportal.configuration.Configuration;
import iglabs.zportal.configuration.ConfigurationKeys;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;


class PersistenceRegistration {
    
    private static final String SESSION_FACTORY_KEY = "sessionFactory";
        
    
    public void register(GenericApplicationContext context) {
        registerSessionFactory(context);
    }
    
    private void registerSessionFactory(GenericApplicationContext context) {
        
        GenericBeanDefinition sessFactoryBeanDef = new GenericBeanDefinition();
        sessFactoryBeanDef.setBeanClass(LocalSessionFactoryBean.class);
        
        MutablePropertyValues sessFactoryProps = new MutablePropertyValues();
        sessFactoryProps.addPropertyValue("hibernateProperties",
            getHibernateProperties(context.getBean(Configuration.class)));
        
        sessFactoryBeanDef.setPropertyValues(sessFactoryProps);
        sessFactoryBeanDef.setScope(BeanDefinition.SCOPE_SINGLETON);
        
        context.registerBeanDefinition(
            SESSION_FACTORY_KEY,
            sessFactoryBeanDef
            );
    }
    
    private Properties getHibernateProperties(Configuration config) {
        Properties result = new Properties();
        
        result.setProperty(
            "hibernate.connection.driver_class",
            config.getValue(ConfigurationKeys.JDBC_DRIVER_KEY));
        
        result.setProperty(
            "hibernate.connection.url",
            config.getValue(ConfigurationKeys.JDBC_URL_KEY));
        
        result.setProperty(
            "hibernate.connection.username",
            config.getValue(ConfigurationKeys.JDBC_USERNAME_KEY));
        
        result.setProperty(
            "hibernate.connection.password",
            config.getValue(ConfigurationKeys.JDBC_PASSWORD_KEY));

        result.setProperty(
            "hibernate.connection.password",
            getDialect(config.getValue(ConfigurationKeys.JDBC_DBTYPE_KEY)));       
        
        return result;
    }
    
    private String getDialect(String dbType) {
        if (dbType != null) {
            String dbTypeLower = dbType.toLowerCase();
            
            switch (dbTypeLower) {
                case "mysql":
                    return "org.hibernate.dialect.MySQLDialect";
                case "pgsql":
                    return "org.hibernate.dialect.PostgreSQL9Dialect";
            }
        }
        
        throw new RuntimeException("Unknown dbType.");
    }
}
*/