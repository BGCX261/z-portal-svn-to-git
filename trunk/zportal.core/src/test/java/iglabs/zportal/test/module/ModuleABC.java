package iglabs.zportal.test.module;

import iglabs.zportal.module.BaseModule;


public class ModuleABC extends BaseModule {
    
    public static final String MODULE_ID = "test.moduleC";
    public static final String VERSION = "1.0";
    
    
    @Override
    public String getName() {
        return "ModuleC";
    }

    @Override
    public String getModuleId() {
        return MODULE_ID;
    }

    @Override
    public String[] getInitializedBeforeModules() {
        return new String[] { ModuleAB.MODULE_ID };
    }
    
    @Override
    public String getVersion() {
        return VERSION;
    }
    
}
