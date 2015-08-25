package iglabs.zportal.web.configuration;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletContext;

import org.springframework.util.Assert;

import iglabs.zportal.configuration.Configuration;


public class WebAppConfiguration implements Configuration {
    
    private final ServletContext servletContext;
    
    
    public WebAppConfiguration(ServletContext servletContext) {
        Assert.notNull(servletContext);
        this.servletContext = servletContext;
    }
    
    public ServletContext getServletContext() {
        return servletContext;
    }
    
    @Override
    public String getValue(String key) {
        return servletContext.getInitParameter(key);
    }
    
    @Override
    public String[] getValues(String key) {
        String prefix = key + "-";
        Enumeration<String> paramNames = servletContext.getInitParameterNames();
        
        ArrayList<String> result = new ArrayList<String>();
        
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
        
            if (paramName.startsWith(prefix)) {
                result.add(servletContext.getInitParameter(paramName));
            }
        }
        
        return result.toArray(new String[result.size()]);
    }
}
