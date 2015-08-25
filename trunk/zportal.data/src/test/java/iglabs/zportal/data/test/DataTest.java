package iglabs.zportal.data.test;

import java.util.Collection;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import org.hibernate.SessionFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;

import iglabs.zportal.AppContextInitializer;
import iglabs.zportal.DefaultAppContextFactory;
import iglabs.zportal.data.EntityRegistry;
import iglabs.zportal.data.Repository;

import iglabs.zportal.data.test.entity.User;
import iglabs.zportal.data.test.service.UserService;


public class DataTest {
    
    static ApplicationContext context;
    
    @BeforeClass
    public static void setUpClass() {
        context = AppContextInitializer.createContext(
            new DefaultAppContextFactory(), DataTestContextConfiguration.class);
    }
    
    @AfterClass
    public static void tearDownClass() {
        context = null;
    }
    
    @Test
    public void entityRegistries() {
        Map<String, EntityRegistry> beanMap =
                context.getBeansOfType(EntityRegistry.class);
        Collection<EntityRegistry> ers = beanMap.values();
        
        Assert.assertTrue(ers.size() == 1);
        
        EntityRegistry[] era = new EntityRegistry[ers.size()];
        ers.toArray(era);
        
        Class[] ets = era[0].getEntityTypes();
        Assert.assertTrue(ets.length == 1);
        Assert.assertTrue(ets[0] == User.class);
    }
    
    @Test
    public void dataSourceRegistered() {
        DataSource ds = context.getBean(DataSource.class);
        Assert.assertNotNull(ds);
    }
    
    @Test
    public void sessionFactoryRegistered() {
        SessionFactory sf = context.getBean(SessionFactory.class);
        Assert.assertNotNull(sf);
    }
    
    @Test
    public void repositoryRegistered() {
        Repository rp = context.getBean(Repository.class);
        Assert.assertNotNull(rp);
    }
    
    @Test
    public void transactionManagerRegistered() {
        PlatformTransactionManager txm = context.getBean(PlatformTransactionManager.class);
        Assert.assertNotNull(txm);
    }
    
    @Test
    public void addUser() {
        UserService userService = context.getBean(UserService.class);
        userService.createUser();
    }
    
    @Test
    public void updateUser() {
        UserService userService = context.getBean(UserService.class);
        userService.updateUser();
    }
    
    @Test
    public void deleteUser() {
        UserService userService = context.getBean(UserService.class);
        userService.deleteUser();
    }
}
