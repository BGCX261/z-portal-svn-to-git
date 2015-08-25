package iglabs.zportal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DefaultAppContextFactory implements AppContextFactory {
    
    @Override
    public ApplicationContext create() {
        return new AnnotationConfigApplicationContext();
    }
}
