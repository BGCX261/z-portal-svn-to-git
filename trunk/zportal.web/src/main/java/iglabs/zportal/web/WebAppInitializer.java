package iglabs.zportal.web;

import java.util.EnumSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.SessionTrackingMode;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import iglabs.zportal.AppContextInitializer;
import iglabs.zportal.AppContextProvider;


public class WebAppInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext sc) throws ServletException {
        
        WebApplicationContext context = (WebApplicationContext)AppContextInitializer
            .createContext(new WebAppContextFactory(sc), DefaultWebAppContextConfiguration.class);
        
        sc.setSessionTrackingModes(EnumSet.of(SessionTrackingMode.COOKIE));
        
        ServletRegistration.Dynamic appServlet = sc.addServlet(
            "dispatcherServlet", new DispatcherServlet(context));
        appServlet.setLoadOnStartup(1);
        
        appServlet.addMapping("/");
        
        
        AppContextProvider.setCurrentInstance(context);
    }
}
