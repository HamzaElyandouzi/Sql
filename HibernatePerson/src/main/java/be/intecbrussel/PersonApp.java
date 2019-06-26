package be.intecbrussel;

import be.intecbrussel.DAO.Person;
import javax.persistence.*;

public class PersonApp {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("datasource");
        EntityManager em = emf.createEntityManager();

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
