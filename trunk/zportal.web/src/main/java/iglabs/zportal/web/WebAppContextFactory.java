package iglabs.zportal.web;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import iglabs.zportal.AppContextFactory;


public class WebAppContextFactory implements AppContextFactory {

    private final ServletContext servletContext;
    
    
    public WebAppContextFactory(ServletContext sc) {
        this.servletContext = sc;
    }
    
    @Override
    public ApplicationContext create() {
        AnnotationConfigWebApplicationContext result =
            new AnnotationConfigWebApplicationContext();
        
        result.setServletContext(servletContext);
        
        return result;
    }
    
}
