package iglabs.zportal.web.test.configuration;

import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import iglabs.zportal.web.configuration.WebAppConfiguration;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WebAppConfigurationTest {  
       
    private static Properties properties;
    
    private WebAppConfiguration configuration;
    
   
    @BeforeClass
    public static void setUpClass() {
        properties = ConfigurationTestHelper.createProperties();
    }   
    
    @Before
    public void setUp() {
        configuration = new WebAppConfiguration(new ServletContextImpl(properties));
    }
    
    @After
    public void tearDown() {
        configuration = null;
    }
    
    @Test
    public void getValue() {
        ConfigurationTestHelper.assertGetValue(configuration);
    }
}
