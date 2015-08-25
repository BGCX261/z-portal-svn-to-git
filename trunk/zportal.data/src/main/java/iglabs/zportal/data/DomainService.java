package iglabs.zportal.data;

import org.hibernate.Criteria;

public interface DomainService<T extends BaseEntity> {
    Criteria getCriteria();
    T get(long id);
    
    void create(T entity);
    void update(T entity);
    void delete(T entity);
}
