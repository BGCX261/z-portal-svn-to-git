package iglabs.zportal.security;

public class DefaultAuthorizationProvider implements AuthorizationProvider {

    public boolean checkPermission(String permission, UserIdentity userIdentity) {
        if (PermissionConstants.ROOT_USERNAME.equals(userIdentity.getUserName())) {
            return true;
        }
        
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
}
