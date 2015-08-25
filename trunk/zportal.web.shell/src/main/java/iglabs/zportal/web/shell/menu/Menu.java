package iglabs.zportal.web.shell.menu;

import java.util.ArrayList;

import iglabs.zportal.util.Sequences;


public class Menu {
    
    public Menu() {
        items = new ArrayList<MenuItem>();
    }
    
    public Iterable<MenuItem> getItems() {
        return Sequences.readOnlyIterable(items);
    }
    
    public void add(MenuItem item) {
        items.add(item);
    }
    
    public void remove(String title) {
        for (MenuItem item: items) {
            if (item.getTitle().equals(title)) {
                items.remove(item);
                break;
            }
        }
    }
    
    public void remove(MenuItem item) {
        items.remove(item);
    }
    
    
    private final ArrayList<MenuItem> items;
}
