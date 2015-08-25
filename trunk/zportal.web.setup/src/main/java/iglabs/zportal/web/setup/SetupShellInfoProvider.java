package iglabs.zportal.web.setup;

import iglabs.zportal.web.shell.ShellInfoProvider;
import iglabs.zportal.web.shell.menu.Menu;
import iglabs.zportal.web.shell.menu.MenuItem;


public class SetupShellInfoProvider implements ShellInfoProvider {
    
    public static final String TITLE = "Настройки";
    public static final String CONTAINER_NAME = "setup";
    
    @Override
    public String getContainerName() {
        return CONTAINER_NAME;
    }
    
    @Override
    public String getTitle() {
        return "Настройки";
    }
    
    @Override
    public Menu createMenu() {
        Menu menu = new Menu();
        menu.add(new MenuItem("Модули", "setup/modules"));
        
        return menu;
    }
}
