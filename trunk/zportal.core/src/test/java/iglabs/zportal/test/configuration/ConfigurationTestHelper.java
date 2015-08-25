package iglabs.zportal.test.configuration;

import java.util.Properties;

import org.junit.Assert;

import iglabs.zportal.configuration.Configuration;


public class ConfigurationTestHelper {
    
    public static final String JDBC_DBTYPE_KEY     = "jdbc-dbtype";
    public static final String JDBC_DRIVER_KEY     = "jdbc-driver";
    public static final String JDBC_URL_KEY        = "jdbc-url";
    public static final String JDBC_USERNAME_KEY   = "jdbc-username";
    public static final String JDBC_PASSWORD_KEY   = "jdbc-password";
    
    public static final String JDBC_DBTYPE_VALUE = "mysql";
    public static final String JDBC_DRIVER_VALUE = "com.mysql.jdbc.Driver";
    public static final String JDBC_URL_VALUE = "jdbc:mysql://localhost/zportal";
    public static final String JDBC_USERNAME_VALUE = "root";
    public static final String JDBC_PASSWORD_VALUE = "123qwe";
    
    public static final String MODULE_A_CLASS_NAME = "iglabs.zportal.test.module.ModuleA";
    public static final String MODULE_B_CLASS_NAME = "iglabs.zportal.test.module.ModuleAB";
    public static final String MODULE_C_CLASS_NAME = "iglabs.zportal.test.module.ModuleABC";
    
    
    public static Properties createProperties() {
        Properties props = new Properties();
        
        props.setProperty(ConfigurationTestHelper.JDBC_DBTYPE_KEY, ConfigurationTestHelper.JDBC_DBTYPE_VALUE);
        props.setProperty(ConfigurationTestHelper.JDBC_DRIVER_KEY, ConfigurationTestHelper.JDBC_DRIVER_VALUE);
        props.setProperty(ConfigurationTestHelper.JDBC_URL_KEY, ConfigurationTestHelper.JDBC_URL_VALUE);
        props.setProperty(ConfigurationTestHelper.JDBC_USERNAME_KEY, ConfigurationTestHelper.JDBC_USERNAME_VALUE);
        props.setProperty(ConfigurationTestHelper.JDBC_PASSWORD_KEY, ConfigurationTestHelper.JDBC_PASSWORD_VALUE);
        
        props.setProperty("module-A", MODULE_A_CLASS_NAME);
        props.setProperty("module-B", MODULE_B_CLASS_NAME);
        props.setProperty("module-C", MODULE_C_CLASS_NAME);
        
        return props;
    }
    
    public static void assertGetValue(Configuration configuration) {
        Assert.assertEquals(ConfigurationTestHelper.JDBC_DBTYPE_VALUE, configuration.getValue(ConfigurationTestHelper.JDBC_DBTYPE_KEY));
        Assert.assertEquals(ConfigurationTestHelper.JDBC_DRIVER_VALUE, configuration.getValue(ConfigurationTestHelper.JDBC_DRIVER_KEY));
        Assert.assertEquals(ConfigurationTestHelper.JDBC_URL_VALUE, configuration.getValue(ConfigurationTestHelper.JDBC_URL_KEY));
        Assert.assertEquals(ConfigurationTestHelper.JDBC_USERNAME_VALUE, configuration.getValue(ConfigurationTestHelper.JDBC_USERNAME_KEY));
        Assert.assertEquals(ConfigurationTestHelper.JDBC_PASSWORD_VALUE, configuration.getValue(ConfigurationTestHelper.JDBC_PASSWORD_KEY));        
    }
    
    public static void assertGetValuesModules(Configuration configuration) {
        String[] values = configuration.getValues("module");
        
        Assert.assertTrue(values.length == 3);        
        Assert.assertTrue(arrayContains(values, MODULE_A_CLASS_NAME));
        Assert.assertTrue(arrayContains(values, MODULE_B_CLASS_NAME));
        Assert.assertTrue(arrayContains(values, MODULE_C_CLASS_NAME));
    }
    
    private static boolean arrayContains(String[] array, String value) {
        for (String s: array) {
            if (value.equals(s)) {
                return true;
            }
        }
        
        return false;
    }
    
    protected ConfigurationTestHelper() {
    }
}
