package iglabs.zportal.web.shell.menu;

import java.util.HashMap;


public class DefaultMenuRegistry implements MenuRegistry {

    public DefaultMenuRegistry() {
        index = new HashMap<String, Menu>();
    }
    
    public Menu getMenu(String containerName) {
        return index.get(containerName);
    }

    public void register(String containerName, Menu menu) {
        index.put(containerName, menu);
    }
    
    
    private final HashMap<String, Menu> index;
}
