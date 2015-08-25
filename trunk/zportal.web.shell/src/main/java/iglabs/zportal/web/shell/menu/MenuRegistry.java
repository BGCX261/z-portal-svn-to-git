package iglabs.zportal.web.shell.menu;

public interface MenuRegistry {
    Menu getMenu(String containerName);
    void register(String containerName, Menu menu);
}
