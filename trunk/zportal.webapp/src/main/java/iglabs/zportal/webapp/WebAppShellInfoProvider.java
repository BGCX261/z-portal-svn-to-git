package iglabs.zportal.webapp;

import iglabs.zportal.web.shell.ShellInfoProvider;
import iglabs.zportal.web.shell.menu.Menu;

public class WebAppShellInfoProvider implements ShellInfoProvider {

    public static final String CONTAINER_NAME = "webapp";
    public static final String TITLE = "Test application";
    
    
    @Override
    public String getContainerName() {
        return CONTAINER_NAME;
    }
    
    @Override
    public String getTitle() {
        return "Test Application";
    }

    @Override
    public Menu createMenu() {
        return null;
    }
}
