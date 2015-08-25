package iglabs.zportal.data;

import iglabs.zportal.module.BaseModule;

public class Module extends BaseModule {

    public static final String NAME = "Data access module";
    public static final String MODULE_ID = "iglabs.zportal.data";
    public static final String VERSION = "1.0";
    
    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getModuleId() {
        return MODULE_ID;
    }
    
    @Override
    public String getVersion() {
        return VERSION;
    }
    
    @Override
    public Class[] getContextConfigurationTypes() {
        return new Class[] { ModuleContextConfiguration.class };
    }
}
