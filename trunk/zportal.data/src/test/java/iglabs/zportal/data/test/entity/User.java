package iglabs.zportal.data.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import iglabs.zportal.data.BaseEntity;

@Entity
@Table(name = "users", catalog = "")
public class User extends BaseEntity {
    
    @Column(name = "name", nullable = false)
    public String getName() { 
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    
    private String name;
}
