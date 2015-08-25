package iglabs.zportal.security;

import org.springframework.beans.factory.annotation.Autowired;

import iglabs.zportal.configuration.Configuration;
import iglabs.zportal.util.Strings;


public class DefaultAuthenticationProvider implements AuthenticationProvider {
    
    public static final String ROOT_PASSWORD_KEY = "rootPassword";
    
    
    private Configuration configuration;
    
    @Autowired
    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
    
    public boolean checkCredentials(String userName, String password) {
        if (PermissionConstants.ROOT_USERNAME.equals(userName)) {
            String rootPassword = configuration.getValue(ROOT_PASSWORD_KEY);
            
            return Strings.equals(password, rootPassword);
        }
        
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
}
