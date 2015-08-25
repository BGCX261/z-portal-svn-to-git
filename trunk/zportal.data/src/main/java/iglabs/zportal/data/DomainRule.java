package iglabs.zportal.data;

import org.hibernate.Criteria;

public interface DomainRule<T extends BaseEntity> {
    
    void beforeCreate(T entity);
    void afterCreate(T entity);
    
    void beforeUpdate(T entity);
    void afterUpdate(T entity);
    
    void beforeDelete(T entity);
    void afterDelete(T entity);
    
    Criteria interceptGetCriteria(Criteria criteria);
    T interceptGet(T entity);
}
