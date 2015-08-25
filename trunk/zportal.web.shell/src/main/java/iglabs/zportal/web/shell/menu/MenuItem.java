package iglabs.zportal.web.shell.menu;

public class MenuItem {
    public MenuItem(String title, String module) {
        this.title = title;
        this.module = module;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getModule() {
        return module;
    }
    
    
    private final String title;
    private final String module;
}
