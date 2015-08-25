package iglabs.zportal.test.module;

import iglabs.zportal.module.BaseModule;


public class ModuleA extends BaseModule {

    public static final String MODULE_ID = "test.moduleA";
    public static final String VERSION = "1.0";
    
    
    @Override
    public String getName() {
        return "ModuleA";
    }

    @Override
    public String getModuleId() {
        return MODULE_ID;
    }

    @Override
    public String[] getInitializedAfterModules() {
        return new String[] { ModuleAB.MODULE_ID };
    }
    
    @Override
    public String getVersion() {
        return VERSION;
    }
}
