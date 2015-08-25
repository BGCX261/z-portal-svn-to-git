package iglabs.zportal.web.setup.dto;

import iglabs.zportal.module.Module;

public class ModuleResponseDTO {
    public ModuleResponseDTO(Module module) {
        this.moduleId = module.getModuleId();
        this.name = module.getName();
    }
    
    public String getModuleId() {
        return moduleId;
    }
    
    public String getName() {
        return name;
    }
    
    
    private final String moduleId;
    private final String name;
}
