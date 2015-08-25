package iglabs.zportal.data;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public class HibernateRepository implements Repository {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    
    @Override
    public Criteria getCriteria(Class type) {
        return sessionFactory.getCurrentSession().createCriteria(type);
    }

    @Override
    public BaseEntity get(Class type, long id) {
        return (BaseEntity)sessionFactory.getCurrentSession().get(type, id);
    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public void create(BaseEntity entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public void update(BaseEntity entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public void delete(BaseEntity entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }
    
}
