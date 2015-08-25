package iglabs.zportal.security;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;


public class DefaultPermissionHelper implements PermissionHelper {
    
    private AuthorizationProvider authorizationProvider;
    
    @Autowired
    public void setAuthorizationProvider(AuthorizationProvider authorizationProvider) {
        this.authorizationProvider = authorizationProvider;
    }
    
    
    @Override
    public boolean checkPermission(Class klass, UserIdentity identity) {
        RequiredPermission rp = (RequiredPermission)klass
                .getAnnotation(RequiredPermission.class);
        if (rp == null) {
            return true;
        }
        
        boolean result = authorizationProvider
            .checkPermission(rp.permission(), identity);
        
        return result;
    }
    
    @Override
    public boolean checkPermission(Method method, UserIdentity identity) {
        RequiredPermission rp = (RequiredPermission)method
            .getAnnotation(RequiredPermission.class);
        
        if (rp == null) {
            return checkPermission(method.getDeclaringClass(), identity);
        }
        
        boolean result = authorizationProvider
            .checkPermission(rp.permission(), identity);
        
        return result;
    }
}
