package iglabs.zportal.security;

import java.lang.reflect.Method;

public interface PermissionHelper {
    boolean checkPermission(Class klass, UserIdentity identity);
    boolean checkPermission(Method method, UserIdentity identity);
}
