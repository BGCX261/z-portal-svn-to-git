package iglabs.zportal.web.platformui2;

import iglabs.zportal.module.BaseModule;


public class Module extends BaseModule {

    public static final String NAME = "PlatformUI-2 support module";
    public static final String MODULE_ID = "iglabs.zportal.web.platformui2";
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
    public String[] getInitializedAfterModules() {
        return new String[] {
            iglabs.zportal.web.Module.MODULE_ID
        };
    }
    
    @Override
    public Class[] getContextConfigurationTypes() {
        return new Class[] { ModuleContextConfiguration.class };
    }
    
}
