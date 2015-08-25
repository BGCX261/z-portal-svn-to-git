package iglabs.zportal.module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import iglabs.zportal.util.Assert;


public class DefaultModuleRegistry implements ModuleRegistry {
    
    private ArrayList<Module> sequence;
    private HashMap<String, Module> moduleIndex;
       
    
    public DefaultModuleRegistry(Module[] modules) {
        registerModules(modules);
    }
    
    private void registerModules(Module[] modules) {
        // Fill sequences.
        ArrayList<Module> seq = createSequence(modules);
                
        int totalSize = seq.size();
        
        Assert.isTrue(totalSize == modules.length,
            "Invalid module dependency tree");
        
        
        // Fill index.
        HashMap<String, Module> index = new HashMap<String, Module>();
        
        for (Module module: modules) {
            index.put(module.getModuleId(), module);
        }

        
        // Set instance variables.
        this.sequence = seq;
        this.moduleIndex = index;
    }
    
    private ArrayList<Module> createSequence(Module[] modules) {
        
        // Module dependency hierarchy.
        HashMap<String, HashSet<String>> hierarchy =
            new HashMap<String, HashSet<String>>();
        
        for (Module module: modules) {
            String[] initializedBefore = module.getInitializedBeforeModules();
            for (String beforeModuleId: initializedBefore) {
                addHierarchyItem(hierarchy, module.getModuleId(), beforeModuleId);
            }
            
            String[] initializedAfter = module.getInitializedAfterModules();
            for (String afterModuleId: initializedAfter) {
                addHierarchyItem(hierarchy, afterModuleId, module.getModuleId());
            }
        }
        
        // Added modules to sequence.
        HashSet<String> addedModuleIds = new HashSet<String>();
        
        // Fill initial queue.
        LinkedList<Module> queue = new LinkedList<Module>();
        
        for (Module module: modules) {
            if (checkAllDepenciesAdded(addedModuleIds,
                    hierarchy.get(module.getModuleId()))) {
                
                queue.addLast(module);
            }
        }
        
        // Fill module sequence for setupMode.
        ArrayList<Module> result = new ArrayList<Module>();
        
        while (queue.size() > 0) {
            while (queue.size() > 0) {
                Module module = queue.removeFirst();
                result.add(module);
            
                addedModuleIds.add(module.getModuleId());
            }
            
            for (Module depModule: modules) {
                if (addedModuleIds.contains(depModule.getModuleId())) {
                    continue;
                }
                
                if (checkAllDepenciesAdded(addedModuleIds,
                        hierarchy.get(depModule.getModuleId()))) {
                    queue.addLast(depModule);
                }
            }
        }
        
        return result;
    }
    
    private void addHierarchyItem(HashMap<String, HashSet<String>> hierarchy,
            String dependent, String dependency) {
        
        HashSet<String> dependencies = hierarchy.get(dependent);
        if (dependencies == null) {
            dependencies = new HashSet<String>();
            hierarchy.put(dependent, dependencies);
        }
        
        dependencies.add(dependency);
    }
    
    private boolean checkAllDepenciesAdded(
        HashSet<String> addedIds, HashSet<String> dependencies) {

        if (dependencies == null) {
            return true;
        }
        
        boolean all = true;
        for (String depModuleId: dependencies) {
            if (!addedIds.contains(depModuleId)) {
                all = false;
                break;
            }
        }
        
        return all;
    }
    
    @Override
    public Iterable<Module> getModuleSequence() {
        return sequence;
    }
    
    @Override
    public Module getModule(String moduleId) {
        return moduleIndex.get(moduleId);
    }
}
