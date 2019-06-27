package be.intecbrussel;

import be.intecbrussel.Entitys.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GetPerson {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("datasource");
        EntityManager em = emf.createEntityManager();

        Person Amy = em.find(Person.class, 1);
        System.out.println(Amy.getAge());

        System.out.println(Amy);
    }
}
