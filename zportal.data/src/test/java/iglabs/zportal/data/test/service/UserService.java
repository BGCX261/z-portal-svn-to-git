package iglabs.zportal.data.test.service;

import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

import iglabs.zportal.data.Repository;
import iglabs.zportal.data.test.entity.User;


public class UserService {
    
    private Repository repository;
    
    @Autowired
    public void setRepository(Repository repository) {
        this.repository = repository;
    }
    
    private User createUserInternal() {
        User user = new User();
        user.setName("Iakov Gnusin");
        
        repository.create(user);
        
        return user;
    }
    
    @Transactional
    public User createUser() {
        return createUserInternal();
    }
    
    @Transactional
    public void updateUser()
    {
        User user = createUserInternal();
        user.setName("Modified user");
        repository.update(user);
    }
    
    @Transactional
    public void deleteUser() {
        User user = createUserInternal();
        repository.delete(user);
    }
}
