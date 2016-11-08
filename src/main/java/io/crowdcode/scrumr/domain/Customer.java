package io.crowdcode.scrumr.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Entity
public class Customer {

    @Id
    private Long id;

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
