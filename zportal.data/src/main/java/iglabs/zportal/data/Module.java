package iglabs.zportal.data;

import iglabs.zportal.module.BaseModule;

public class Module extends BaseModule {

    public static final String NAME = "Data access module";
    public static final String MODULE_ID = "iglabs.zportal.data";
    
    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getModuleId() {
        return MODULE_ID;
    }

    @Override
    public String[] getDependencyModuleIds() {
        return new String[] {};
    }
    
    @Override
    public Class[] getContextConfigurationTypes() {
        return new Class[] { ModuleContextConfiguration.class };
    }
    
}
