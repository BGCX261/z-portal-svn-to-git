package iglabs.zportal.web.setup;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import iglabs.zportal.web.WebResourceRegistry;
import iglabs.zportal.web.shell.ShellInfoProvider;


@Configuration(value = "setupModuleContextConfiguration")
public class ModuleContextConfiguration {

    public static final String RESOURCE_MAPPING = "/static/setup/**";
    public static final String RESOURCE_PATH = "classpath:/META-INF/static/setup/";
    
    
    @Bean(name = "setupResourceRegistry")
    public WebResourceRegistry resourceRegistry() {
        return new WebResourceRegistry() {

            @Override
            public String getMapping() {
                return RESOURCE_MAPPING;
            }

            @Override
            public String[] getPaths() {
                return new String[] { RESOURCE_PATH };
            }
        };
    }
    
    @Bean(name = "setupShellInfoProvider")
    public ShellInfoProvider setupShellInfoProvider() {
        return new SetupShellInfoProvider();
    }
    
}
