package iglabs.zportal.data.test;

import iglabs.zportal.module.BaseModule;

public class DataTestModule extends BaseModule {

    @Override
    public String getName() {
        return "Data test module";
    }

    @Override
    public String getModuleId() {
        return "zportal.data.test";
    }

    @Override
    public String[] getDependencyModuleIds() {
        return new String[] { iglabs.zportal.data.Module.MODULE_ID };
    }
    
    @Override
    public Class[] getContextConfigurationTypes() {
        return new Class[] { DataTestModuleContextConfiguration.class };
    }
}
