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
    public String getVersion() {
        return "1.0";
    }

    @Override
    public String[] getInitializedBeforeModules() {
        return new String[] { iglabs.zportal.data.Module.MODULE_ID };
    }
    
    @Override
    public String[] getInitializedAfterModules() {
        return new String[] { iglabs.zportal.data.hibernate.Module.MODULE_ID };
    }
    
    @Override
    public Class[] getContextConfigurationTypes() {
        return new Class[] { DataTestModuleContextConfiguration.class };
    }
}
