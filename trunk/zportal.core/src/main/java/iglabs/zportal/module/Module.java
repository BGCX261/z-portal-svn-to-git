package iglabs.zportal.module;

public interface Module {
    String getName();
    String getModuleId();
    String getVersion();

    String[] getInitializedBeforeModules();
    String[] getInitializedAfterModules();
    
    Class[] getContextConfigurationTypes();
    String[] getContextConfigurationPackages();
}
