package iglabs.zportal.configuration;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;

import iglabs.zportal.util.Assert;


public class PropertiesConfiguration implements Configuration {
    
    private final Properties properties;
    
    
    public PropertiesConfiguration(Properties properties) {
        Assert.isNotNull(properties);
        this.properties = properties;
    }
    
    public Properties getProperties() {
        return properties;
    }
    
    @Override
    public String getValue(String key) {
        return properties.getProperty(key);
    }
    
    @Override
    public String[] getValues(String key) {
        String prefix = key + "-";
        Enumeration<Object> paramNames = properties.keys();
        
        ArrayList<String> result = new ArrayList<String>();
        
        while (paramNames.hasMoreElements()) {
            String paramName = (String)paramNames.nextElement();
            
            if (paramName.startsWith(prefix)) {
                result.add(properties.getProperty(paramName));
            }
        }
        
        return result.toArray(new String[result.size()]);
    }
}
