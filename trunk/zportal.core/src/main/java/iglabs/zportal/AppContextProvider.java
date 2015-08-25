package iglabs.zportal;

import org.springframework.context.ApplicationContext;


public class AppContextProvider {
    
    private static ApplicationContext context;
    
    public static void setCurrentInstance(ApplicationContext context) {
        AppContextProvider.context = context;
    }
    
    public static ApplicationContext current() {
        return context;
    }
}
