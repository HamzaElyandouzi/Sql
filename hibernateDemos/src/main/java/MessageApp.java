import be.IntecBrussel.hibernate.Demos.entities.Message;

import javax.persistence.*;

public class MessageApp {



    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("datasource");

        EntityManager em = emf.createEntityManager();

        try{
            EntityTransaction tx = em.getTransaction();

            Message message = new Message("hallo daar");

            tx.begin();

            em.persist(message);

            tx.commit();

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
