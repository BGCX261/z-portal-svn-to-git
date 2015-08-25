package iglabs.zportal.test.configuration;

import java.util.Properties;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import iglabs.zportal.configuration.PropertiesConfiguration;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PropertiesConfigurationTest {  
       
    private static Properties properties;
    
    private PropertiesConfiguration configuration;
    
   
    @BeforeClass
    public static void setUpClass() {
        properties = ConfigurationTestHelper.createProperties();
    }   
    
    @Before
    public void setUp() {
        configuration = new PropertiesConfiguration(properties);
    }
    
    @After
    public void tearDown() {
        configuration = null;
    }
    
    @Test
    public void getProperties() {        
        Assert.assertTrue(configuration.getProperties() == properties);
    }
    
    @Test
    public void getValue() {
        ConfigurationTestHelper.assertGetValue(configuration);
    }
    
    @Test
    public void getValues() {
        ConfigurationTestHelper.assertGetValuesModules(configuration);
    }
}
