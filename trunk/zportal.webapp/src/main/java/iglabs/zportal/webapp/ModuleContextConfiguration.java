package iglabs.zportal.webapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.MappedInterceptor;

import iglabs.zportal.web.WebResourceRegistry;
import iglabs.zportal.web.security.AuthenticationInterceptor;
import iglabs.zportal.web.shell.ShellInfoProvider;


@Configuration(value = "webAppModuleContextConfiguration")
public class ModuleContextConfiguration {
    
    @Bean(name = "webAppResources")
    public WebResourceRegistry resourceRegistry() {
        return new ResourceRegistry();
    }
    
    @Bean
    public ShellInfoProvider shellInfoProvider() {
        return new WebAppShellInfoProvider();
    }
    
    @Bean
    public MappedInterceptor authenticationInterceptor() {
        AuthenticationInterceptor interceptor = new AuthenticationInterceptor();
        return new MappedInterceptor(new String[] { "/**" }, interceptor);
    }
    
}
