package be.intecbrussel.music_demo.Entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;

public class MusicApp {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("datasource");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        Album bibo = new Album();

        bibo.setAuthor("Igorr");
        bibo.setTitle("Cheval");

        ArrayList<String> Cheval = new ArrayList<>();

        Cheval.add("Cheval");
        Cheval.add("Viande");
        Cheval.add("ieuD");
        Cheval.add("Opus Brian");
        bibo.setArrayList(Cheval);

        try {

            tx.begin();
            em.persist(bibo);
            tx.commit();
            emf.close();

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
