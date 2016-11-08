package io.crowdcode.scrumr.jpa;

import io.crowdcode.scrumr.domain.Customer;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class JpaTest {

    @Test
    public void testJPA() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scrumr");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("TEST");

        em.persist(customer);

        em.getTransaction().commit();
    }
}
