package iglabs.zportal.module;

public interface ModuleRegistry {
    Iterable<Module> getModuleSequence();
    Module getModule(String moduleId);
}
