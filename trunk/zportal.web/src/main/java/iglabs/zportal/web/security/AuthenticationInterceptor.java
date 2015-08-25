package iglabs.zportal.web.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import iglabs.zportal.security.PermissionHelper;
import iglabs.zportal.security.UserIdentity;


public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private PermissionHelper permissionHelper;
    
    private String redirectURI;
    
    
    private static class ServletUserIdentity implements UserIdentity {

        private final HttpServletRequest request;
        
        
        public ServletUserIdentity(HttpServletRequest request) {
            this.request = request;
        }
        
        @Override
        public String getUserName() {
            return request.getRemoteUser();
        }
    }
    
    
    @Override
    public boolean preHandle(HttpServletRequest request,
        HttpServletResponse response, Object handler) throws Exception {
        
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        boolean allowed = permissionHelper
            .checkPermission(handlerMethod.getMethod(), createUserIdentity(request));
        
        if (!allowed) {
            // TODO: redirect here.
            return false;
        }
        
        return true;
    }
    
    public void setRedirectURI(String redirectURI) {
        this.redirectURI = redirectURI;
    }
    
    private UserIdentity createUserIdentity(HttpServletRequest request) {
        return new ServletUserIdentity(request);
    }
}
