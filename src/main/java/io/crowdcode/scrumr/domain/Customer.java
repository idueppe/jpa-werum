package io.crowdcode.scrumr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Entity
public class Customer extends AbstractEntity {

    @Column(length = 400)
    private String name;

    private String city;

    @Transient
    private String firlefanz;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", firlefanz='" + firlefanz + '\'' +
                "} " + super.toString();
    }
}
