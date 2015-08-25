package iglabs.zportal.security;

public interface AuthorizationProvider {
    boolean checkPermission(String permission, UserIdentity userIdentity);
}
