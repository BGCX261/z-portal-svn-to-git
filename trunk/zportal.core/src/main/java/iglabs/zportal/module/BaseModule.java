package iglabs.zportal.module;

public abstract class BaseModule implements Module {
    
    @Override
    public String[] getInitializedBeforeModules() {
        return new String[] {};
    }
    
    @Override
    public String[] getInitializedAfterModules() {
        return new String[] {};
    }
    
    @Override
    public Class[] getContextConfigurationTypes() {
        return new Class[] {};
    }
    
    @Override
    public String[] getContextConfigurationPackages() {
        return new String[] {};
    }
}
