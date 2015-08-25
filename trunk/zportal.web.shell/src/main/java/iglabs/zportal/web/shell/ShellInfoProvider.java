package iglabs.zportal.web.shell;

import iglabs.zportal.web.shell.menu.Menu;


public interface ShellInfoProvider {
    String getContainerName();
    String getTitle();
    Menu createMenu();
}
