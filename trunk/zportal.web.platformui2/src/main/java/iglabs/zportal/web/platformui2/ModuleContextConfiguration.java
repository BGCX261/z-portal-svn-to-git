package iglabs.zportal.web.platformui2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import iglabs.zportal.web.WebResourceRegistry;


@Configuration(value = "platformui2ModuleContextConfiguration")
public class ModuleContextConfiguration {
    
    public static final String JQUERY_RESOURCE_MAPPING = "/static/**";
    public static final String JQUERY_RESOURCE_PATH = "classpath:/META-INF/static/";
    
    public static final String PLATFORMUI2_RESOURCE_MAPPING = "/static/platformui2/**";
    public static final String PLATFORMUI2_RESOURCE_PATH = "classpath:/META-INF/static/platformui-2/";
    
    
    @Bean(name = "jqueryResourceRegistry")
    public WebResourceRegistry jqueryResourceRegistry() {
        return new WebResourceRegistry() {
            @Override
            public String getMapping() {
                return JQUERY_RESOURCE_MAPPING;
            }
            
            @Override
            public String[] getPaths() {
                return new String[] { JQUERY_RESOURCE_PATH };
            }
        };
    }
    
    @Bean(name = "platformUI2ResourceRegistry")
    public WebResourceRegistry platformUI2ResourceRegistry() {
        return new WebResourceRegistry() {

            @Override
            public String getMapping() {
                return PLATFORMUI2_RESOURCE_MAPPING;
            }

            @Override
            public String[] getPaths() {
                return new String[] { PLATFORMUI2_RESOURCE_PATH };
            }
        };
    }
}
