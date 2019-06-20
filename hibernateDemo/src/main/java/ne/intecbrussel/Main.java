package ne.intecbrussel;

import javax.persistence.*;

public class Main {
    public static void main(String[] args) {

        //creates the factory for Entity's
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("datasource");

        //create's the manager that will handle the Entity's that the factory will handel/create.
        EntityManager em = emf.createEntityManager();

        //the transaction manager
        EntityTransaction tx = em.getTransaction();

        //will start the transaction
        tx.begin();

        //create's a instance of the Entity
        Message message = new Message().setId(1).setMessage("hello nurse");

        //will push the Entity to database
        em.persist(message);

        //will commit the Entity to the database
        tx.commit();

        //will close the factory connection
        emf.close();

        System.out.println("Message saved");
    }
}
