package io.crowdcode.scrumr.jpa;

import io.crowdcode.scrumr.domain.Customer;
import org.junit.*;
import org.junit.runners.MethodSorters;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JpaTest {

    private static EntityManagerFactory emf;

    private EntityManager em;

    @BeforeClass
    public static void setUpClass() throws Exception {
        emf = Persistence.createEntityManagerFactory("scrumr");
    }

    @Before
    public void setUp() throws Exception {
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() throws Exception {
        em.close();
    }

    @Test
    public void test_1_Create() throws Exception {
        em.getTransaction().begin();

        Customer customer = new Customer();
//        customer.setId(1L);
        customer.setName("TEST");
        customer.setCity("Münster");

        em.persist(customer);
        assertThat(customer.getId(), is(notNullValue()));

        em.getTransaction().commit();
    }

    @Test
    public void test_2_Find() throws Exception {
        Customer customer = em.find(Customer.class, 1l);
        System.out.println(customer.toString());
    }

    @Test
    public void test_3_Update() throws Exception {
        em.getTransaction().begin();
        Customer customer = em.find(Customer.class, 1l);
        customer.setName("Ingo");
        em.getTransaction().commit();
    }

    @Test
    public void test_4_Merge() throws Exception {
        Customer customer = new Customer();
        customer.setId(1l);
        customer.setName("Gedoplan");
        em.getTransaction().begin();

        Customer merge = em.merge(customer);

        System.out.println(merge);

        em.getTransaction().commit();
    }

    @Test
    public void test_5_refresh() throws Exception {
        Customer customer = new Customer();
        customer.setId(1l);
        customer.setName("Ingo");
        em.getTransaction().begin();

        Customer merge = em.merge(customer);

        List<Customer> customers = em.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();

        em.refresh(merge);
        System.out.println(customer);

        em.getTransaction().commit();
    }

    @Test
    public void test_6_remove() throws Exception {
        em.getTransaction().begin();

        Customer customer = em.find(Customer.class, 1l);
        em.remove(customer);

        em.getTransaction().commit();

    }
}
