package iglabs.zportal.web.shell;

import iglabs.zportal.module.BaseModule;


public class Module extends BaseModule {

    public static final String NAME = "PlatformUI-2 based shell module";
    public static final String MODULE_ID = "iglabs.zportal.web.shell";
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
    public String[] getInitializedBeforeModules() {
        return new String[] {
            iglabs.zportal.web.platformui2.Module.MODULE_ID
        };
    }
    
    @Override
    public String[] getInitializedAfterModules() {
        return new String[] {
            iglabs.zportal.web.Module.MODULE_ID
        };
    }
    
    @Override
    public Class[] getContextConfigurationTypes() {
        return new Class[] {
            ModuleContextConfiguration.class
        };
    }
    
    @Override
    public String[] getContextConfigurationPackages() {
        return new String[] { "iglabs.zportal.web.shell.controller" };
    }
}
