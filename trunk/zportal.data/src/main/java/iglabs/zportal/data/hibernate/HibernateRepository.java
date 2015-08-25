package iglabs.zportal.data.hibernate;

import iglabs.zportal.data.BaseEntity;
import iglabs.zportal.data.Repository;
import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public abstract class HibernateRepository<T extends BaseEntity> implements Repository<T> {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    private Session getCurrentSession() {
        Session session = sessionFactory.getCurrentSession();
        session.setFlushMode(FlushMode.COMMIT);
        
        return session;
    }
    
    protected abstract Class<T> getEntityType();
    
    
    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Criteria getCriteria() {
        return getCurrentSession().createCriteria(getEntityType());
    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public T get(long id) {
        return (T)getCurrentSession().get(getEntityType(), id);
    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public void create(T entity) {
        getCurrentSession().save(entity);
    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public void update(T entity) {
        getCurrentSession().update(entity);
    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public void delete(T entity) {
        getCurrentSession().delete(entity);
    }
    
}
