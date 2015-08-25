package iglabs.zportal.data;

import org.hibernate.Criteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


public abstract class DefaultDomainService<T extends BaseEntity> implements DomainService<T> {

    private Repository<T> repository;
    private DomainRuleRegistry ruleRegistry;
    
    
    @Autowired
    public void setRepository(Repository repository) {
        this.repository = repository;
    }
    
    public Repository getRepository() {
        return repository;
    }
    
    
    @Autowired
    public void setBusinessRuleRegistry(DomainRuleRegistry ruleRegistry) {
        this.ruleRegistry = ruleRegistry;
    }
    
    public DomainRuleRegistry getBusinessRuleRegistry() {
        return ruleRegistry;
    }
    
    
    protected abstract Class<T> getEntityType();
    
    
    @Override
    @Transactional
    public Criteria getCriteria() {
        Criteria criteria = repository.getCriteria();
        
        for (DomainRule<T> rule: ruleRegistry.list(getEntityType())) {
            criteria = rule.interceptGetCriteria(criteria);
        }
        
        return criteria;
    }

    @Override
    @Transactional
    public T get(long id) {
        T entity = repository.get(id);
        
        for (DomainRule<T> rule: ruleRegistry.list(getEntityType())) {
            entity = rule.interceptGet(entity);
        }
        
        return entity;
    }

    @Override
    @Transactional
    public void create(T entity) {
        Iterable<DomainRule<T>> rules = ruleRegistry.list(getEntityType());
        
        for (DomainRule<T> rule: rules) {
            rule.beforeCreate(entity);
        }
        
        repository.create(entity);
        
        for (DomainRule<T> rule: rules) {
            rule.afterCreate(entity);
        }
    }

    @Override
    @Transactional
    public void update(T entity) {
        Iterable<DomainRule<T>> rules = ruleRegistry.list(getEntityType());
        
        for (DomainRule<T> rule: rules) {
            rule.beforeUpdate(entity);
        }
        
        repository.update(entity);
        
        for (DomainRule<T> rule: rules) {
            rule.afterUpdate(entity);
        }
    }

    @Override
    @Transactional
    public void delete(T entity) {
        Iterable<DomainRule<T>> rules = ruleRegistry.list(getEntityType());
        
        for (DomainRule<T> rule: rules) {
            rule.beforeDelete(entity);
        }
        
        repository.delete(entity);
        
        for (DomainRule<T> rule: rules) {
            rule.afterDelete(entity);
        }
    }
}
