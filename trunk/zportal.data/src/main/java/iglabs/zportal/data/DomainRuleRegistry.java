package iglabs.zportal.data;

public interface DomainRuleRegistry {

    <T extends BaseEntity, U extends DomainRule<T>> 
        void register(Class<T> entityType, U businessRule);
    
    <T extends BaseEntity, U extends DomainRule<T>>
        Iterable<U> list(Class<T> entityType);
}
