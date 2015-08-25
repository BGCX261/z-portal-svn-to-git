package iglabs.zportal.security;

public interface AuthenticationProvider {
    boolean checkCredentials(String userName, String password);
}
