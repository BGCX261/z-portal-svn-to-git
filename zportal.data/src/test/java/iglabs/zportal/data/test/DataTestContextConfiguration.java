package iglabs.zportal.data.test;

import java.util.Properties;

import org.springframework.context.annotation.Configuration;

import iglabs.zportal.DefaultAppContextConfiguration;
import iglabs.zportal.data.ConfigurationKeys;


@Configuration
public class DataTestContextConfiguration extends DefaultAppContextConfiguration {
    
    @Override
    protected Properties getProperties() {
        Properties p = new Properties();
        
        p.setProperty("module-data", "iglabs.zportal.data.Module");
        p.setProperty("module-data-test", "iglabs.zportal.data.test.DataTestModule");

        p.setProperty(ConfigurationKeys.JDBC_DBTYPE_KEY, "mysql");
        p.setProperty(ConfigurationKeys.JDBC_DRIVER_KEY, "com.mysql.jdbc.Driver");
        p.setProperty(ConfigurationKeys.JDBC_URL_KEY, "jdbc:mysql://localhost/zportal");
        p.setProperty(ConfigurationKeys.JDBC_USERNAME_KEY, "root");
        p.setProperty(ConfigurationKeys.JDBC_PASSWORD_KEY, "123qwe");
        p.setProperty(ConfigurationKeys.JDBC_SCHEMA_KEY, "zportal");
        
        return p;
    }
}
