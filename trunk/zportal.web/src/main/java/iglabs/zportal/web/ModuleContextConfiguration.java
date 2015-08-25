package iglabs.zportal.web;

import iglabs.zportal.util.Sequences;
import java.util.HashMap;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration(value = "webModuleContextConfiguration")
@EnableWebMvc
public class ModuleContextConfiguration extends WebMvcConfigurerAdapter {
    
    @Autowired(required = false)
    private WebResourceRegistry[] webResourceRegistries;

    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        
        super.addResourceHandlers(registry);
        
        if (webResourceRegistries != null) {
            HashMap<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();
            
            for (WebResourceRegistry reg: webResourceRegistries) {
                String mapping = reg.getMapping();
                HashSet<String> paths = map.get(mapping);
                
                if (paths == null) {
                    paths = new HashSet<String>();
                    map.put(mapping, paths);
                }
                
                for (String path: reg.getPaths()) {
                    paths.add(path);
                }
            }
            
            for (String mapping: map.keySet()) {
                ResourceHandlerRegistration reg = registry.addResourceHandler(mapping);
                reg.addResourceLocations(Sequences.toArray(String.class, map.get(mapping)));
            }
        }
    }
    
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        
        super.configureViewResolvers(registry);
        registry.jsp();
    }
}
