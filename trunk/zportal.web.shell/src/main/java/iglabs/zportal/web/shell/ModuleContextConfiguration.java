package iglabs.zportal.web.shell;

import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import iglabs.zportal.web.WebResourceRegistry;
import iglabs.zportal.web.shell.menu.DefaultMenuRegistry;
import iglabs.zportal.web.shell.menu.Menu;
import iglabs.zportal.web.shell.menu.MenuRegistry;


@Configuration(value = "shellModuleContextConfiguration")
public class ModuleContextConfiguration {
    
    public static final String RESOURCE_MAPPING = "/static/**";
    public static final String RESOURCE_PATH = "classpath:/META-INF/static/";
    
    
    @Bean(name = "shellResourceRegistry")
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
    
    @Bean
    public ShellHelper shellHelper() {
        return new ShellHelper();
    }
    
    @Bean
    @Autowired
    public MenuRegistry menuRegistry(ShellInfoProvider[] providers) {
        DefaultMenuRegistry menuRegistry = new DefaultMenuRegistry();
        
        for (ShellInfoProvider provider: providers) {
            Menu menu = provider.createMenu();
            if (menu != null) {
                menuRegistry.register(provider.getContainerName(), menu);
            }
        }
        
        return menuRegistry;
    }
}
