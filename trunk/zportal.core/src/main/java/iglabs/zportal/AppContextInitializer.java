package iglabs.zportal;

import java.util.ArrayList;

import iglabs.zportal.configuration.Configuration;
import iglabs.zportal.module.DefaultModuleRegistry;
import iglabs.zportal.module.Module;
import iglabs.zportal.module.ModuleRegistry;
import iglabs.zportal.util.Sequences;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigRegistry;


public final class AppContextInitializer {
    
    static final String MODULE_CONF_KEY = "module";
    
    
    private AppContextInitializer() {
    }
    
    public static ApplicationContext createContext() {
        return createContext(new DefaultAppContextFactory(),
                DefaultAppContextConfiguration.class);
    }
    
    public static ApplicationContext createContext(
        AppContextFactory factory, Class configType) {
        
        // Core context.
        ApplicationContext coreContext = factory.create();
        ((AnnotationConfigRegistry)coreContext).register(configType);
        ((ConfigurableApplicationContext)coreContext).refresh();
        
        // Module context.
        ModuleRegistry moduleRegistry = coreContext.getBean(ModuleRegistry.class);
        
        ApplicationContext appContext = factory.create();
        
        ((ConfigurableApplicationContext)appContext).setParent(coreContext);
        registerModules(moduleRegistry, ((AnnotationConfigRegistry)appContext));
        ((ConfigurableApplicationContext)appContext).refresh();
        
        return appContext;
    }
    
    public static void registerModules(
        ModuleRegistry moduleRegistry,
        AnnotationConfigRegistry registry) {

        for (Module module: moduleRegistry.getModuleSequence()) {
            Class[] configTypes = module.getContextConfigurationTypes();
            if (configTypes.length > 0) {
                registry.register(configTypes);
            }
            
            String[] configPackages = module.getContextConfigurationPackages();
            if (configPackages.length > 0) {
                registry.scan(configPackages);
            }
        }
    }
    
    public static DefaultModuleRegistry createDefaultModuleRegistry(Configuration configuration) {
        String[] moduleClassNames = configuration.getValues(MODULE_CONF_KEY);
        
        ArrayList<Module> modules = new ArrayList<Module>();
        
        try {
            for (String moduleClassName: moduleClassNames) {
                Module module = (Module)Class.forName(moduleClassName).newInstance();
                modules.add(module);
            }
        }
        catch (Exception ex) {
            throw new RuntimeException("Unable to load module class", ex);
        }
        
        DefaultModuleRegistry moduleRegistry = new DefaultModuleRegistry(
            Sequences.toArray(Module.class, modules));
        
        return moduleRegistry;
    }
}
