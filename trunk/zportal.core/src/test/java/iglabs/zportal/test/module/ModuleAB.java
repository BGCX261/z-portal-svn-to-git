package iglabs.zportal.test.module;

import iglabs.zportal.module.BaseModule;


public class ModuleAB extends BaseModule {
    
    public static final String MODULE_ID = "test.moduleB";
    public static final String VERSION = "1.0";
    
    
    @Override
    public String getName() {
        return "ModuleB";
    }

    @Override
    public String getModuleId() {
        return MODULE_ID;
    }
    
    @Override
    public String getVersion() {
        return VERSION;
    }
    
}
