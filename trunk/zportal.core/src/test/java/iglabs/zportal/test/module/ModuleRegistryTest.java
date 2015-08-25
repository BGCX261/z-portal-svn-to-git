package iglabs.zportal.test.module;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import iglabs.zportal.AppContextInitializer;
import iglabs.zportal.configuration.Configuration;
import iglabs.zportal.configuration.PropertiesConfiguration;
import iglabs.zportal.module.Module;
import iglabs.zportal.module.DefaultModuleRegistry;
import iglabs.zportal.util.Sequences;

import iglabs.zportal.test.configuration.ConfigurationTestHelper;


public class ModuleRegistryTest {

    private Configuration configuration;
    
    @Before
    public void setUp() {
        configuration = new PropertiesConfiguration(
            ConfigurationTestHelper.createProperties());
    }
    
    @Test
    public void sequenceOrder() {        
        DefaultModuleRegistry moduleRegistry = AppContextInitializer
                .createDefaultModuleRegistry(configuration);
        
        Module[] moduleSeq = Sequences.toArray(Module.class, moduleRegistry.getModuleSequence());
        
        Assert.assertTrue(moduleSeq.length == 3);
        Assert.assertTrue(ModuleA.MODULE_ID.equals(moduleSeq[0].getModuleId()));
        Assert.assertTrue(ModuleAB.MODULE_ID.equals(moduleSeq[1].getModuleId()));
        Assert.assertTrue(ModuleABC.MODULE_ID.equals(moduleSeq[2].getModuleId()));
        
        Assert.assertTrue(ModuleA.MODULE_ID.equals(moduleRegistry.getModule(ModuleA.MODULE_ID).getModuleId()));
        Assert.assertTrue(ModuleAB.MODULE_ID.equals(moduleRegistry.getModule(ModuleAB.MODULE_ID).getModuleId()));
        Assert.assertTrue(ModuleABC.MODULE_ID.equals(moduleRegistry.getModule(ModuleABC.MODULE_ID).getModuleId()));
    }
}
