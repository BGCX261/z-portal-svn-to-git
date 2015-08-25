package iglabs.zportal;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import iglabs.zportal.configuration.PropertiesConfiguration;
import iglabs.zportal.module.ModuleRegistry;


@Configuration
public class DefaultAppContextConfiguration {
    
    static final String DEFAULT_CONFIG_NAME = "zportal.config";
    
    
    protected Properties getProperties() {
        Properties properties = new Properties();
        
        try (InputStreamReader reader = new InputStreamReader(
                new FileInputStream(DEFAULT_CONFIG_NAME))) {
            properties.load(reader);
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        
        return properties;
    }
    
    @Bean
    public iglabs.zportal.configuration.Configuration configuration() {
        PropertiesConfiguration configuration =
            new PropertiesConfiguration(getProperties());
        
        return configuration;
    }
    
    @Bean
    public ModuleRegistry moduleRegistry() {
        return AppContextInitializer.createDefaultModuleRegistry(configuration());
    }
}
