package iglabs.zportal.data;

import org.hibernate.Criteria;

public interface Repository {
    Criteria getCriteria(Class type);
    BaseEntity get(Class type, long id);
    
    void create(BaseEntity entity);
    void update(BaseEntity entity);
    void delete(BaseEntity entity);
}
