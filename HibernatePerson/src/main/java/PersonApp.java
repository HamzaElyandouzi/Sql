import be.intecbrussel.Entitys.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersonApp {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("datasource");
        EntityManager em = emf.createEntityManager();
        Person Amy =  new Person();

        try {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(new Person());
            tx.commit();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
