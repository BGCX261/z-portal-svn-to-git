package iglabs.zportal.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import org.springframework.context.ApplicationContext;

import iglabs.zportal.AppContextInitializer;
import iglabs.zportal.DefaultAppContextFactory;
import iglabs.zportal.configuration.Configuration;
import iglabs.zportal.module.ModuleRegistry;
import iglabs.zportal.test.configuration.ConfigurationTestHelper;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContextTest {
    
    private ApplicationContext appContext;
    
    @Before
    public void setUp() {
        appContext = AppContextInitializer.createContext(
            new DefaultAppContextFactory(), TestContextConfiguration.class);
    }
    
    @After
    public void tearDown() {
        appContext = null;
    }
    
    @Test
    public void defaultBeans() {
        Assert.assertNotNull(appContext.getBean(Configuration.class));
        Assert.assertNotNull(appContext.getBean(ModuleRegistry.class));
        
        ConfigurationTestHelper.assertGetValue(appContext.getBean(Configuration.class));
        ConfigurationTestHelper.assertGetValuesModules(appContext.getBean(Configuration.class));
    }
}
