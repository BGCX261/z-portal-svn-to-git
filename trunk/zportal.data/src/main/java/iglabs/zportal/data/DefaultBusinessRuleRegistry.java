package iglabs.zportal.data;

import java.util.ArrayList;
import java.util.HashMap;


public class DefaultBusinessRuleRegistry implements DomainRuleRegistry {

    private final HashMap<Class, ArrayList<DomainRule<? extends BaseEntity>>> ruleMap;
    
    
    public DefaultBusinessRuleRegistry() {
        ruleMap = new HashMap<Class, ArrayList<DomainRule<? extends BaseEntity>>>();
    }
    
    @Override
    public <T extends BaseEntity, U extends DomainRule<T>>
        void register(Class<T> entityType, U businessRule) {
        
        if (entityType == null) {
            throw new IllegalArgumentException("entityType");
        }
        
        if (businessRule == null) {
            throw new IllegalArgumentException("businessRule");
        }
        
        synchronized (this) {
            ArrayList<U> rules = (ArrayList<U>)ruleMap.get(entityType);
            
            if (rules == null) {
                rules = new ArrayList<U>();
                ruleMap.put(entityType,
                    (ArrayList<DomainRule<? extends BaseEntity>>)rules);
            }
            
            rules.add(businessRule);
        }
    }

    @Override
    public <T extends BaseEntity, U extends DomainRule<T>> Iterable<U>
        list(Class<T> entityType) {
        
            ArrayList<U> rules = (ArrayList<U>)ruleMap.get(entityType);
            
            return rules;
    }
    
}
