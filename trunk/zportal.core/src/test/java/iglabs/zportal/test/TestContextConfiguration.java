package iglabs.zportal.test;

import java.util.Properties;

import org.springframework.context.annotation.Configuration;

import iglabs.zportal.DefaultAppContextConfiguration;
import iglabs.zportal.test.configuration.ConfigurationTestHelper;


@Configuration
public class TestContextConfiguration extends DefaultAppContextConfiguration {
    
    @Override
    protected Properties getProperties() {
        return ConfigurationTestHelper.createProperties();
    }    
}
